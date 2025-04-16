package com.plf.tool.common.template;

import java.text.MessageFormat;

/**
 * 动态参数索引填补使用
 * @author panlf
 * @date 2025/4/16
 */
public class FillMessageTemplate {
    public static void main(String[] args) {
        // 定义模板字符串
        String template = "你好，{0}，很高兴认识你{1}。你的编号是{2}。";
        Object[] objects = new Object[]{"AME","!","001"};

        // 使用 MessageFormat 替换占位符
        String result = MessageFormat.format(template, objects);

        // 输出结果
        System.out.println(result);
    }
}
