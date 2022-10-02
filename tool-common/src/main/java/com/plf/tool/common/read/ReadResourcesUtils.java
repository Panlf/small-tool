package com.plf.tool.common.read;

import cn.hutool.core.io.file.FileReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 读取resources下面的文本文件
 */
public class ReadResourcesUtils {

    /**
     * 读取resources下面的txt文本文件
     * @param path 地址
     * @return List 返回列表
     */
    public static List<String> readTxt(String path){
        FileReader fileReader = new FileReader(path);
        StringBuffer sb = new StringBuffer();
        String result = fileReader.readString();
        List<String> tableList = Arrays.asList(result.split("\r"));
        tableList = tableList.stream().map(x->x.trim().replace("\r","")).collect(Collectors.toList());

        return tableList;
    }

    /**
     * 读取resources下面的txt文本文件
     * @param path
     * @return String 返回字符串
     */
    public static String readTxtToString(String path){
        FileReader fileReader = new FileReader(path);
        String result = fileReader.readString();
        return result;
    }

    /**
     * 读取resources下面的Properties文本文件
     * @param path
     * @return
     */
    public static Map<String,String> readProperties(String path){
        Map<String,String> result = new HashMap<>();
        //创建Properties对象
        Properties prop = new Properties();
        try {
            InputStream in = ReadResourcesUtils.class.getResourceAsStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            prop.load(inputStreamReader);
            Iterator<Map.Entry<Object, Object>> iterator = prop.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Object, Object> entry = iterator.next();
                Object key = entry.getKey();
                Object value = entry.getValue();
                result.put(key.toString(),value.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

