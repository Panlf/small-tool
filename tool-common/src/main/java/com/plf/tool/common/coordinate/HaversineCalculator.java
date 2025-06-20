package com.plf.tool.common.coordinate;

/**
 * @author panlf
 * @date 2025/6/19
 */
public class HaversineCalculator {

    // 地球平均半径（单位：米）
    private static final double EARTH_RADIUS = 6371000;

    public static void main(String[] args) {
        // 测试数据
        double lat1 = 30.203253;
        double lon1 = 120.791164;
        double lat2 = 30.203268;
        double lon2 = 120.791375;

        // 计算距离
        double distance = calculateHaversineDistance(lat1, lon1, lat2, lon2);

        // 输出结果
        System.out.printf("坐标点 1: (%.6f, %.6f)%n", lat1, lon1);
        System.out.printf("坐标点 2: (%.6f, %.6f)%n", lat2, lon2);
        System.out.printf("两点间距离: %.3f 米%n", distance);
        System.out.printf("速度: %.2f 米/秒 (%.1f 公里/小时)%n",
                distance, distance * 3.6);
    }

    /**
     * 使用 Haversine 公式计算两个经纬度坐标之间的距离
     *
     * @param lat1 第一个点的纬度（度）
     * @param lon1 第一个点的经度（度）
     * @param lat2 第二个点的纬度（度）
     * @param lon2 第二个点的经度（度）
     * @return 两点间的距离（米）
     */
    public static double calculateHaversineDistance(double lat1, double lon1, double lat2, double lon2) {
        // 将角度转换为弧度
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // 计算纬度和经度的差值
        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        // Haversine 公式计算
        double a = Math.pow(Math.sin(deltaLat / 2), 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.pow(Math.sin(deltaLon / 2), 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // 计算距离
        return EARTH_RADIUS * c;
    }
}
