package com.plf.tool.common.coordinate;

import java.awt.geom.Point2D;

/**
 * @author panlf
 * @date 2025/6/19
 */
public class VincentyDistanceCalculator {
    // WGS84 椭球体参数
    private static final double SEMI_MAJOR_AXIS = 6378137.0; // 长半轴（米）
    private static final double FLATTENING = 1 / 298.257223563; // 扁率
    private static final double SEMI_MINOR_AXIS = 6356752.314245; // 短半轴（米）
    private static final double MAX_ITERATIONS = 200;
    private static final double CONVERGENCE_THRESHOLD = 1e-12;

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

        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.printf("距离: %.3f 米\n", distance);
    }

    /**
     * 使用 Vincenty 公式计算两点间的距离
     * @param lat1 第一个点的纬度 (十进制度)
     * @param lon1 第一个点的经度 (十进制度)
     * @param lat2 第二个点的纬度 (十进制度)
     * @param lon2 第二个点的经度 (十进制度)
     * @return 两点间的距离 (米)，如果公式不收敛则返回 Double.NaN
     */
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // 将角度转换为弧度
        double phi1 = Math.toRadians(lat1);
        double phi2 = Math.toRadians(lat2);
        double U1 = Math.atan((1 - FLATTENING) * Math.tan(phi1));
        double U2 = Math.atan((1 - FLATTENING) * Math.tan(phi2));
        double L = Math.toRadians(lon2 - lon1);

        double lambda = L;
        double lambdaPrev = Double.MAX_VALUE;
        double sinSigma = 0;
        double cosSigma = 0;
        double sigma = 0;
        double sinAlpha = 0;
        double cosSqAlpha = 0;
        double cos2SigmaM = 0;

        // 迭代计算
        for (int iter = 0; iter < MAX_ITERATIONS; iter++) {
            if (Math.abs(lambda - lambdaPrev) < CONVERGENCE_THRESHOLD) {
                break;
            }

            double sinLambda = Math.sin(lambda);
            double cosLambda = Math.cos(lambda);
            double sinU1 = Math.sin(U1);
            double cosU1 = Math.cos(U1);
            double sinU2 = Math.sin(U2);
            double cosU2 = Math.cos(U2);

            sinSigma = Math.sqrt(
                    Math.pow(cosU2 * sinLambda, 2) +
                            Math.pow(cosU1 * sinU2 - sinU1 * cosU2 * cosLambda, 2)
            );

            if (sinSigma == 0) {
                return 0; // 两点重合
            }

            cosSigma = sinU1 * sinU2 + cosU1 * cosU2 * cosLambda;
            sigma = Math.atan2(sinSigma, cosSigma);
            sinAlpha = (cosU1 * cosU2 * sinLambda) / sinSigma;
            cosSqAlpha = 1 - Math.pow(sinAlpha, 2);

            if (cosSqAlpha != 0) {
                cos2SigmaM = cosSigma - ((2 * sinU1 * sinU2) / cosSqAlpha);
            } else {
                cos2SigmaM = 0; // 赤道上的特殊情况
            }

            double C = (FLATTENING / 16) * cosSqAlpha * (4 + FLATTENING * (4 - 3 * cosSqAlpha));
            lambdaPrev = lambda;
            lambda = L + (1 - C) * FLATTENING * sinAlpha * (
                    sigma + C * sinSigma * (cos2SigmaM + C * cosSigma * (-1 + 2 * Math.pow(cos2SigmaM, 2)))
            );
        }

        // 如果公式不收敛，返回 NaN
        if (Math.abs(lambda - lambdaPrev) >= CONVERGENCE_THRESHOLD) {
            return Double.NaN;
        }

        // 计算最终距离
        double uSq = cosSqAlpha * ((Math.pow(SEMI_MAJOR_AXIS, 2) - Math.pow(SEMI_MINOR_AXIS, 2)) / Math.pow(SEMI_MINOR_AXIS, 2));
        double A = 1 + (uSq / 16384) * (4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
        double B = (uSq / 1024) * (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));
        double deltaSigma = B * sinSigma * (
                cos2SigmaM + (B / 4) * (
                        cosSigma * (-1 + 2 * Math.pow(cos2SigmaM, 2)) -
                                (B / 6) * cos2SigmaM * (-3 + 4 * Math.pow(sinSigma, 2)) * (-3 + 4 * Math.pow(cos2SigmaM, 2))
                )
        );

        return SEMI_MINOR_AXIS * A * (sigma - deltaSigma);
    }
}