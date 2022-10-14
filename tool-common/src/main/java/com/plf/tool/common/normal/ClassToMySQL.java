package com.plf.tool.common.normal;

import cn.hutool.core.collection.CollectionUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassToMySQL {

    public static Map<String,String> getFiled(Class<?> clazz){
        Map<String,String> map  = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();

        for(Field field:fields) {
            map.put(field.getName(),field.getType().getName());
        }

        return map;
    }

    /*Map k v t*/
    public static String getFieldMysql(List<Map<String, String>> origin){
        StringBuffer stringBuffer = new StringBuffer();
        if(CollectionUtil.isNotEmpty(origin)){
           origin.forEach(x->{
               stringBuffer.append("`"+x.get("k")+"` "+getType(x.get("t"))+" NULL COMMENT '"+x.get("v")+"',\n");
           });
       }
        return stringBuffer.toString();
    }

    public static String getJava(List<Map<String, String>> origin){
        StringBuffer stringBuffer = new StringBuffer();
        if(CollectionUtil.isNotEmpty(origin)){
            origin.forEach(x->{
                stringBuffer.append("private "+x.get("t")+" "+UnderlineToCamelUtils.underlineToCamel(x.get("k"),true)+";\n");
            });
        }
        return stringBuffer.toString();
    }


    public static String getType(String t){
        String result = "varchar(255)";
        if(null!=t){
           if(t.equals("int")){
               result = "int(11)";
           }else if(t.equals("String")){
               result = "varchar(255)";
           }
       }
        return result;
    }

}
