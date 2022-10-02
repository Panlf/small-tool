package com.plf.tool.common.normal;

import cn.hutool.core.collection.CollectionUtil;

import java.util.List;

/**
 * 检测数据表是否有少的
 */
public class CompareList {

    public static boolean isContain(String s,List<String> list){
        if(CollectionUtil.isNotEmpty(list)){
            for(String l:list){
                if(l.contains(s)){
                    return true;
                }
            }
            return false;
        }
        return false;
    }


    public static boolean isEquals(String s,List<String> list){
        if(CollectionUtil.isNotEmpty(list)){
            for(String l:list){
                if(l.equals(s)){
                    return true;
                }
            }
            return false;
        }
        return false;
    }


    public static boolean isEqualsIgnoreCase(String s,List<String> list){
        if(CollectionUtil.isNotEmpty(list)){
            for(String l:list){
                if(l.equalsIgnoreCase(s)){
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
