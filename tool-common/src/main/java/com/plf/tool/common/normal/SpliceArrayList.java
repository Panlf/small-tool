package com.plf.tool.common.normal;

import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割数组的工具类
 */
public class SpliceArrayList<T> {

    /**
     * 分割数组
     * @param list 需要分割的列表
     * @param num 分成多少列
     * @return
     */
    public static <T> List<List<T>> spliceArrayList(List<T> list,int num){
        if(CollectionUtil.isEmpty(list)){
            return null;
        }

        List<List<T>> result = new ArrayList<>();

        if(list.size()<=num){
            result.add(list);
        }else{
            int size = list.size()/num;
            for(int i=0;i<num;i++){
                List<T> e = new ArrayList<>();
                if(i<=num-2){
                    e.addAll(list.subList(i*size,(i+1)*size));
                }else{
                    e.addAll(list.subList(i*size,list.size()));
                }
                result.add(e);
            }
        }
        return result;
    }
}
