package com.plf.tool.common.template;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author panlf
 * @date 2025/4/16
 */
public class TemplateParser {
    public static void main(String[] args) {
        // 定义模板字符串
        String template = "你好，{0}，很高兴认识你{1}。你的编号是{2}。";

        // 使用正则表达式提取占位符
        Set<Integer> placeholders = extractPlaceholders(template);

        // 输出结果
        System.out.println("模板中的占位符索引：" + placeholders);
        System.out.println("占位符数量：" + placeholders.size());
    }

    public static Set<Integer> extractPlaceholders(String template) {
        // 定义正则表达式，匹配 {数字}
        Pattern pattern = Pattern.compile("\\{(\\d+)\\}");
        Matcher matcher = pattern.matcher(template);

        // 存储占位符索引
        Set<Integer> placeholders = new HashSet<>();

        // 遍历匹配到的占位符
        while (matcher.find()) {
            int index = Integer.parseInt(matcher.group(1)); // 提取数字部分
            placeholders.add(index);
        }
        return placeholders;
    }
}
