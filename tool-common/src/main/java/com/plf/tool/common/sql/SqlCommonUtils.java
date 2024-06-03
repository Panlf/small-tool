package com.plf.tool.common.sql;

/**
 * @author panlf
 * @date 2024/4/12
 */
public class SqlCommonUtils {

    /**
     * 根据数据类型，判断是否需要加单引号，构建SQL使用
     * @param dataType 数据类型
     * @param v 数据值
     * @return
     */
    public static String dealInsertValue(String dataType,Object v){
        if(v==null){
            return "null";
        }else {
            if (dataType.equalsIgnoreCase("varchar") ||
                    dataType.equalsIgnoreCase("text") ||
                    dataType.equalsIgnoreCase("longtext") ||
                    dataType.equalsIgnoreCase("char") ||
                    dataType.equalsIgnoreCase("datetime") ||
                    dataType.equalsIgnoreCase("date") ||
                    dataType.equalsIgnoreCase("time") ||
                    dataType.equalsIgnoreCase("tinytext") ||
                    dataType.equalsIgnoreCase("mediumtext") ||
                    dataType.equalsIgnoreCase("timestamp")) {
                return "'" + v + "'";
            } else {
                return v.toString();
            }
        }
    }
}
