package com.plf.tool.common.coordinate;

/**
 *
 * wgs84ToGcj02(): WGS84转火星坐标系
 *
 * gcj02ToWgs84(): 火星坐标系转WGS84
 *
 * gcj02ToBd09(): 火星坐标系转百度坐标系
 *
 * bd09ToGcj02(): 百度坐标系转火星坐标系
 *
 * wgs84ToBd09(): WGS84转百度坐标系
 *
 * bd09ToWgs84(): 百度坐标系转WGS84
 *
 * @author panlf
 * @date 2025/6/19
 */
import java.awt.geom.Point2D;

public class CoordinateTransform {

    // 圆周率
    private static final double PI = Math.PI;
    // 地球长半轴（WGS84）
    private static final double EARTH_A = 6378137.0;
    // 地球的扁率（WGS84）
    private static final double EE = 0.00669342162296594323;
    // Web墨卡托投影的最大纬度
    private static final double MAX_LATITUDE = 85.05112877980659;

    /**
     * 判断坐标点是否在中国境内
     * @param lng 经度
     * @param lat 纬度
     * @return 是否在中国境内
     */
    public static boolean isInChina(double lng, double lat) {
        if (lng < 72.004 || lng > 137.8347) {
            return false;
        }
        if (lat < 0.8293 || lat > 55.8271) {
            return false;
        }
        return true;
    }

    /**
     * WGS84 转 GCJ02（火星坐标系）
     * @param wgsLng WGS84经度
     * @param wgsLat WGS84纬度
     * @return GCJ02坐标点
     */
    public static Point2D.Double wgs84ToGcj02(double wgsLng, double wgsLat) {
        if (!isInChina(wgsLng, wgsLat)) {
            return new Point2D.Double(wgsLng, wgsLat);
        }
        double[] delta = calculateDelta(wgsLng, wgsLat);
        return new Point2D.Double(wgsLng + delta[0], wgsLat + delta[1]);
    }

    /**
     * GCJ02 转 WGS84
     * @param gcjLng GCJ02经度
     * @param gcjLat GCJ02纬度
     * @return WGS84坐标点
     */
    public static Point2D.Double gcj02ToWgs84(double gcjLng, double gcjLat) {
        if (!isInChina(gcjLng, gcjLat)) {
            return new Point2D.Double(gcjLng, gcjLat);
        }
        double[] delta = calculateDelta(gcjLng, gcjLat);
        return new Point2D.Double(gcjLng - delta[0], gcjLat - delta[1]);
    }

    /**
     * GCJ02 转 BD09（百度坐标系）
     * @param gcjLng GCJ02经度
     * @param gcjLat GCJ02纬度
     * @return BD09坐标点
     */
    public static Point2D.Double gcj02ToBd09(double gcjLng, double gcjLat) {
        double x = gcjLng;
        double y = gcjLat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * PI);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * PI);
        double bdLng = z * Math.cos(theta) + 0.0065;
        double bdLat = z * Math.sin(theta) + 0.006;
        return new Point2D.Double(bdLng, bdLat);
    }

    /**
     * BD09 转 GCJ02
     * @param bdLng BD09经度
     * @param bdLat BD09纬度
     * @return GCJ02坐标点
     */
    public static Point2D.Double bd09ToGcj02(double bdLng, double bdLat) {
        double x = bdLng - 0.0065;
        double y = bdLat - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * PI);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * PI);
        double gcjLng = z * Math.cos(theta);
        double gcjLat = z * Math.sin(theta);
        return new Point2D.Double(gcjLng, gcjLat);
    }

    /**
     * WGS84 转 BD09
     * @param wgsLng WGS84经度
     * @param wgsLat WGS84纬度
     * @return BD09坐标点
     */
    public static Point2D.Double wgs84ToBd09(double wgsLng, double wgsLat) {
        Point2D.Double gcj = wgs84ToGcj02(wgsLng, wgsLat);
        return gcj02ToBd09(gcj.x, gcj.y);
    }

    /**
     * BD09 转 WGS84
     * @param bdLng BD09经度
     * @param bdLat BD09纬度
     * @return WGS84坐标点
     */
    public static Point2D.Double bd09ToWgs84(double bdLng, double bdLat) {
        Point2D.Double gcj = bd09ToGcj02(bdLng, bdLat);
        return gcj02ToWgs84(gcj.x, gcj.y);
    }

    /**
     * 计算WGS84坐标与GCJ02坐标的偏移量
     * @param lng 经度
     * @param lat 纬度
     * @return 偏移量数组 [Δlng, Δlat]
     */
    private static double[] calculateDelta(double lng, double lat) {
        double dLat = transformLat(lng - 105.0, lat - 35.0);
        double dLng = transformLng(lng - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * PI;
        double magic = Math.sin(radLat);
        magic = 1 - EE * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((EARTH_A * (1 - EE)) / (magic * sqrtMagic) * PI);
        dLng = (dLng * 180.0) / (EARTH_A / sqrtMagic * Math.cos(radLat) * PI);
        return new double[]{dLng, dLat};
    }

    private static double transformLat(double x, double y) {
        double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * PI) + 20.0 * Math.sin(2.0 * x * PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(y * PI) + 40.0 * Math.sin(y / 3.0 * PI)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(y / 12.0 * PI) + 320 * Math.sin(y * PI / 30.0)) * 2.0 / 3.0;
        return ret;
    }

    private static double transformLng(double x, double y) {
        double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * PI) + 20.0 * Math.sin(2.0 * x * PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(x * PI) + 40.0 * Math.sin(x / 3.0 * PI)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(x / 12.0 * PI) + 300.0 * Math.sin(x / 30.0 * PI)) * 2.0 / 3.0;
        return ret;
    }

    /**
     * 经纬度转Web墨卡托投影坐标
     * @param lng 经度
     * @param lat 纬度
     * @return Web墨卡托投影坐标
     */
    public static Point2D.Double lonLatToMercator(double lng, double lat) {
        // 确保纬度在有效范围内
        if (lat > MAX_LATITUDE) lat = MAX_LATITUDE;
        else if (lat < -MAX_LATITUDE) lat = -MAX_LATITUDE;

        double x = lng * EARTH_A * PI / 180.0;
        double y = Math.log(Math.tan((90.0 + lat) * PI / 360.0)) / (PI / 180.0);
        y = y * EARTH_A * PI / 180.0;
        return new Point2D.Double(x, y);
    }

    /**
     * Web墨卡托投影坐标转经纬度
     * @param x Web墨卡托x坐标
     * @param y Web墨卡托y坐标
     * @return 经纬度坐标
     */
    public static Point2D.Double mercatorToLonLat(double x, double y) {
        double lng = x / (EARTH_A * PI / 180.0);
        double lat = y / (EARTH_A * PI / 180.0);
        lat = 180.0 / PI * (2.0 * Math.atan(Math.exp(lat * PI / 180.0)) - 90.0);
        return new Point2D.Double(lng, lat);
    }

    /**
     * 计算两点间的距离（Vincenty公式）
     * @param lon1 第一点经度
     * @param lat1 第一点纬度
     * @param lon2 第二点经度
     * @param lat2 第二点纬度
     * @return 距离（米）
     */
    public static double calculateDistance(double lon1, double lat1, double lon2, double lat2) {
        double a = EARTH_A;
        double f = 1 / 298.257223563; // WGS84扁率
        double b = a * (1 - f); // 短半轴

        double radLat1 = Math.toRadians(lat1);
        double radLon1 = Math.toRadians(lon1);
        double radLat2 = Math.toRadians(lat2);
        double radLon2 = Math.toRadians(lon2);

        double L = radLon2 - radLon1;
        double U1 = Math.atan((1 - f) * Math.tan(radLat1));
        double U2 = Math.atan((1 - f) * Math.tan(radLat2));

        double sinU1 = Math.sin(U1);
        double cosU1 = Math.cos(U1);
        double sinU2 = Math.sin(U2);
        double cosU2 = Math.cos(U2);

        double lambda = L;
        double lambdaP;
        double sinSigma, cosSigma, sigma, sinAlpha, cosSqAlpha, cos2SigmaM;
        double C;
        int iterLimit = 100;

        do {
            double sinLambda = Math.sin(lambda);
            double cosLambda = Math.cos(lambda);
            sinSigma = Math.sqrt((cosU2 * sinLambda) * (cosU2 * sinLambda) +
                    (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda) *
                            (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda));
            if (sinSigma == 0) return 0; // 重合点

            cosSigma = sinU1 * sinU2 + cosU1 * cosU2 * cosLambda;
            sigma = Math.atan2(sinSigma, cosSigma);
            sinAlpha = cosU1 * cosU2 * sinLambda / sinSigma;
            cosSqAlpha = 1 - sinAlpha * sinAlpha;
            cos2SigmaM = cosSigma - 2 * sinU1 * sinU2 / cosSqAlpha;
            if (Double.isNaN(cos2SigmaM)) cos2SigmaM = 0; // 赤道线

            C = f / 16 * cosSqAlpha * (4 + f * (4 - 3 * cosSqAlpha));
            lambdaP = lambda;
            lambda = L + (1 - C) * f * sinAlpha *
                    (sigma + C * sinSigma * (cos2SigmaM + C * cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM)));
        } while (Math.abs(lambda - lambdaP) > 1e-12 && --iterLimit > 0);

        if (iterLimit == 0) return Double.NaN; // 公式未收敛

        double uSq = cosSqAlpha * (a * a - b * b) / (b * b);
        double A = 1 + uSq / 16384 * (4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
        double B = uSq / 1024 * (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));
        double deltaSigma = B * sinSigma * (cos2SigmaM + B / 4 *
                (cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM) -
                        B / 6 * cos2SigmaM * (-3 + 4 * sinSigma * sinSigma) *
                                (-3 + 4 * cos2SigmaM * cos2SigmaM)));

        return b * A * (sigma - deltaSigma);
    }

    public static void main(String[] args) {
        // 测试点：北京天安门
        double wgsLng = 116.3912;
        double wgsLat = 39.9074;

        System.out.println("原始WGS84坐标: (" + wgsLng + ", " + wgsLat + ")");

        // WGS84转GCJ02
        Point2D.Double gcj = wgs84ToGcj02(wgsLng, wgsLat);
        System.out.println("GCJ02坐标: (" + gcj.x + ", " + gcj.y + ")");

        // GCJ02转BD09
        Point2D.Double bd = gcj02ToBd09(gcj.x, gcj.y);
        System.out.println("BD09坐标: (" + bd.x + ", " + bd.y + ")");

        // BD09转回WGS84
        Point2D.Double wgsBack = bd09ToWgs84(bd.x, bd.y);
        System.out.println("转换回WGS84: (" + wgsBack.x + ", " + wgsBack.y + ")");
        System.out.printf("转换误差: %.6f 米\n",
                calculateDistance(wgsLng, wgsLat, wgsBack.x, wgsBack.y));

        // Web墨卡托投影测试
        System.out.println("\nWeb墨卡托投影测试:");
        Point2D.Double mercator = lonLatToMercator(wgsLng, wgsLat);
        System.out.println("Web墨卡托坐标: (" + mercator.x + ", " + mercator.y + ")");

        Point2D.Double lonLat = mercatorToLonLat(mercator.x, mercator.y);
        System.out.println("转回经纬度: (" + lonLat.x + ", " + lonLat.y + ")");

        // 距离计算测试
        System.out.println("\n距离计算测试:");
        double distance = calculateDistance(116.3912, 39.9074, 116.4074, 39.9040); // 天安门到故宫
        System.out.printf("天安门到故宫距离: %.2f 米\n", distance);

        // 测试不在中国境内的坐标
        System.out.println("\n国际坐标测试（纽约自由女神像）:");
        double nyLng = -74.0445;
        double nyLat = 40.6892;
        Point2D.Double nyGcj = wgs84ToGcj02(nyLng, nyLat);
        System.out.println("WGS84转GCJ02: (" + nyGcj.x + ", " + nyGcj.y + ") - 应保持不变");
    }
}