package com.plf.tool.common.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    /**
     * 正则获取括号内的值
     * @param str
     * @return
     */
    public static String getBetweenContent(String str){
        String pattern = "(?<=\\().*?(?=\\))";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if(m.find()){
            return m.group();
        }
        return "";
    }
}
