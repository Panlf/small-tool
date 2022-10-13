package com.plf.tool.common.normal;

import java.lang.reflect.Field;
import java.util.HashMap;
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

}
