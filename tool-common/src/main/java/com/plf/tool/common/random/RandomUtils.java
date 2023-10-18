package com.plf.tool.common.random;

import com.apifan.common.random.RandomSource;

/**
 * @author panlf
 * @date 2023/8/23
 */
public class RandomUtils {
    public static void main(String[] args) {
        System.out.println(RandomSource.personInfoSource().randomChineseName());
    }
}
