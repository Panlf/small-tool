package com.plf.tool.common.coordinate;

import java.awt.geom.Point2D;

/**
 * @author panlf
 * @date 2025/6/19
 */
public class VincentyCalculator {

    // WGS84 椭球体参数
    private static final double EQUATORIAL_RADIUS = 6378137.0; // 长半轴 (米)
    private static final double FLATTENING = 1 / 298.257223563; // 扁率
    private static final double POLAR_RADIUS = EQUATORIAL_RADIUS * (1 - FLATTENING); // 短半轴 (米)
    private static final double MAX_ITERATIONS = 1000;
    private static final double CONVERGENCE_TOLERANCE = 1e-12; // 收敛精度

    public static void main(String[] args) {
        // 测试数据
        double lat1 = 30.203253;
        double lon1 = 120.791164;
        double lat2 = 30.203268;
        double lon2 = 120.791375;


        Point2D.Double aDouble = CoordinateTransform.gcj02ToWgs84(lon1, lat1);
        Point2D.Double bDouble = CoordinateTransform.gcj02ToWgs84(lon2, lat2);

        lon1 = aDouble.getX();
        lat1 = aDouble.getY();
        lon2 = bDouble.getX();
        lat2 = bDouble.getY();


        // 计算距离
        double distance = calculateVincentyDistance(lat1, lon1, lat2, lon2);

        // 输出结果
        System.out.printf("坐标点 1: (%.6f, %.6f)%n", lat1, lon1);
        System.out.printf("坐标点 2: (%.6f, %.6f)%n", lat2, lon2);
        System.out.printf("两点间距离 (Vincenty): %.6f 米%n", distance);
        System.out.printf("速度: %.6f 米/秒 (%.6f 公里/小时)%n",
                distance, distance * 3.6);
    }

    /**
     * 使用 Vincenty 公式计算两个经纬度坐标之间的距离
     *
     * @param lat1 第一个点的纬度（度）
     * @param lon1 第一个点的经度（度）
     * @param lat2 第二个点的纬度（度）
     * @param lon2 第二个点的经度（度）
     * @return 两点间的距离（米）
     */
    public static double calculateVincentyDistance(double lat1, double lon1, double lat2, double lon2) {
        // 将角度转换为弧度
        double φ1 = Math.toRadians(lat1);
        double λ1 = Math.toRadians(lon1);
        double φ2 = Math.toRadians(lat2);
        double λ2 = Math.toRadians(lon2);

        // 计算经度差
        double L = λ2 - λ1;

        // 计算辅助参数
        double tanU1 = (1 - FLATTENING) * Math.tan(φ1);
        double cosU1 = 1 / Math.sqrt(1 + tanU1 * tanU1);
        double sinU1 = tanU1 * cosU1;

        double tanU2 = (1 - FLATTENING) * Math.tan(φ2);
        double cosU2 = 1 / Math.sqrt(1 + tanU2 * tanU2);
        double sinU2 = tanU2 * cosU2;

        // 初始化变量
        double λ = L;
        double λPrev;
        double sinλ, cosλ;
        double sinSqσ;
        double sinσ, cosσ;
        double σ;
        double sinα, cosSqα;
        double cos2σM;

        int iterations = 0;

        do {
            // 计算中间变量
            sinλ = Math.sin(λ);
            cosλ = Math.cos(λ);

            sinSqσ = Math.pow(cosU2 * sinλ, 2) +
                    Math.pow(cosU1 * sinU2 - sinU1 * cosU2 * cosλ, 2);

            // 重合点检查
            if (sinSqσ == 0) {
                return 0.0;
            }

            sinσ = Math.sqrt(sinSqσ);
            cosσ = sinU1 * sinU2 + cosU1 * cosU2 * cosλ;
            σ = Math.atan2(sinσ, cosσ);

            sinα = cosU1 * cosU2 * sinλ / sinσ;
            cosSqα = 1 - sinα * sinα;

            // 避免赤道线附近的计算问题
            if (cosSqα == 0) {
                cos2σM = 0;
            } else {
                cos2σM = cosσ - 2 * sinU1 * sinU2 / cosSqα;
            }

            double C = FLATTENING / 16 * cosSqα * (4 + FLATTENING * (4 - 3 * cosSqα));
            λPrev = λ;
            λ = L + (1 - C) * FLATTENING * sinα *
                    (σ + C * sinσ * (cos2σM + C * cosσ * (-1 + 2 * cos2σM * cos2σM)));

            iterations++;

        } while (Math.abs(λ - λPrev) > CONVERGENCE_TOLERANCE && iterations < MAX_ITERATIONS);

        // 检查收敛性
        if (iterations >= MAX_ITERATIONS) {
            // 未收敛，使用Haversine作为后备
            return calculateHaversineDistance(lat1, lon1, lat2, lon2);
        }

        // 计算最终距离
        double uSq = cosSqα * (Math.pow(EQUATORIAL_RADIUS, 2) - Math.pow(POLAR_RADIUS, 2)) / Math.pow(POLAR_RADIUS, 2);
        double A = 1 + uSq / 16384 * (4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
        double B = uSq / 1024 * (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));

        double Δσ = B * sinσ * (cos2σM + B / 4 *
                (cosσ * (-1 + 2 * cos2σM * cos2σM) -
                        B / 6 * cos2σM * (-3 + 4 * sinσ * sinσ) * (-3 + 4 * cos2σM * cos2σM)));

        return POLAR_RADIUS * A * (σ - Δσ);
    }

    /**
     * 后备方法：使用Haversine公式计算距离
     */
    private static double calculateHaversineDistance(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371000; // 地球平均半径（米）
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
