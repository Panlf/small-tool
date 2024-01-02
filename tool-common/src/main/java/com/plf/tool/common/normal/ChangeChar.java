package com.plf.tool.common.normal;

import org.apache.commons.lang3.StringUtils;

/**
 * @author panlf
 * @date 2023/11/27
 */
public class ChangeChar {

    /**
     * @param fullWidthStr
     * @return
     */
    public static String fullWidthToHalfWidth(String fullWidthStr) {
        char[] chars = fullWidthStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65281 && chars[i] <= 65374) {
                chars[i] = (char) (chars[i] - 65248);
            } else if (chars[i] == 12288) {
                chars[i] = (char) 32;
            }
        }
        return new String(chars);
    }
}
