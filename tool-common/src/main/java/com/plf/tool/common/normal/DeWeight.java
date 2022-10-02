package com.plf.tool.common.normal;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 去重
 */
public class DeWeight {

    /**
     * 去重
     * @param list 传入重复的列表
     * @return 返回去重后的列表
     */
    public static List<String> delRepeat(List<String> list) {
        //方法二
        List<String> result = new ArrayList<String>(new LinkedHashSet<String>(list));
        return result;
    }
}
