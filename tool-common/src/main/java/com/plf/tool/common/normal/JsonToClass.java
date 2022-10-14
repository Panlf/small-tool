package com.plf.tool.common.normal;

import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.NotNull;

import java.util.Map;

public class JsonToClass {

    final static Map<String, String> map = MapUtil.<String, String>builder()
            .put("java.lang.Integer","int")
            .put("java.lang.String","String")
            .build();

    public static String jsonToClass(@NotNull JSONObject jsonObject){
        StringBuffer stringBuffer = new StringBuffer();
        jsonObject.forEach((k,v)->{
            String type = "String";
            if(null != v){
                type= map.get(v.getClass().getName());
            }
           stringBuffer.append("private "+type+" "+UnderlineToCamelUtils.underlineToCamel(k,true)+";\n");
        });
        return stringBuffer.toString();
    }


}
