package com.plf.tool.common.normal;

import java.math.BigDecimal;

/**
 * @author panlf
 * @date 2024/4/12
 */
public class BigDecimalUtils {


    private static BigDecimal calculateRateTemp(String dividend,String divisor,int scale){
        if(dividend==null || divisor == null || divisor.equalsIgnoreCase("0")){
            return null;
        }
        BigDecimal dividendBigDecimal = new BigDecimal(dividend);
        BigDecimal divisorBigDecimal = new BigDecimal(divisor);
        return dividendBigDecimal.divide(divisorBigDecimal,scale,BigDecimal.ROUND_HALF_UP);
    }
    
    /**
     * 计算比例
     * @param dividend 被除数
     * @param divisor 除数
     * @param scale 保留位数
     * @return
     */
    public static Double calculateRate(String dividend,String divisor,int scale){
        BigDecimal decimal = calculateRateTemp(dividend,divisor,scale);
        if(decimal == null){
            return null;
        }
        return decimal.doubleValue();
    }

    /**
     * 计算百分比
     * @param dividend 被除数
     * @param divisor 除数
     * @param scale 保留位数
     * @return
     */
    public static Double calculateRatePercent(String dividend,String divisor,int scale){
        BigDecimal decimal = calculateRateTemp(dividend,divisor,scale);
        BigDecimal multiply = decimal.multiply(new BigDecimal(100));
        return multiply.doubleValue();
    }

    /**
     * 计算百分比(带百分号)
     * @param dividend 被除数
     * @param divisor 除数
     * @param scale 保留位数
     * @return
     */
    public static String calculateRatePercentStr(String dividend,String divisor,int scale){
        BigDecimal decimal = calculateRateTemp(dividend,divisor,scale);
        BigDecimal multiply = decimal.multiply(new BigDecimal(100));
        return multiply.doubleValue()+"%";
    }


}
