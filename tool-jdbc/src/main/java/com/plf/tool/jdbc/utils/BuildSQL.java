package com.plf.tool.jdbc.utils;

import cn.hutool.json.JSONObject;
import com.plf.tool.jdbc.dto.ColumnDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author panlf
 * @date 2023/3/6
 */
public class BuildSQL {

    public static String build(String model,
                        String tableName,
                        List<ColumnDto> columnDtoList,
                        JSONObject jsonObject){
       String columnStr =  columnDtoList.stream()
               .map(ColumnDto::getColumnName)
               .collect(Collectors.joining(","));

       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append("insert into ");

       if(model != null){
           stringBuilder.append(model).append(".");
       }
        stringBuilder.append(tableName)
               .append(" (")
               .append(columnStr)
               .append(") values (");


       for(ColumnDto columnDto:columnDtoList){
           stringBuilder.append(isNeedQuotation(columnDto.getColumnType(),
                   jsonObject.get(columnDto.getColumnName().replace("\"",""))))
                   .append(",");
       }
       stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append(")");
       return stringBuilder.toString();
    }

    private static String isNeedQuotation(String columnType, Object o){
        if(null == o){
            return null;
        }
        if(columnType.equalsIgnoreCase("character varying") ||
                columnType.equalsIgnoreCase("date") ||
                columnType.equalsIgnoreCase("character") ||
                columnType.startsWith("timestamp") ||
                columnType.startsWith("text") ){
            return "'"+o+"'";
        }
        return o.toString();
    }
}
