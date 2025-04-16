package com.plf.tool.common.template;

import java.text.MessageFormat;

/**
 * @author panlf
 * @date 2025/4/16
 */
public class MessageTemplateParser {
    public static void main(String[] args) {
        // 定义模板字符串
        String template = "你好，{0}，很高兴认识你{1}。你的编号是{2}。";

        // 检查占位符数量
        int maxIndex = findMaxPlaceholderIndex(template);

        // 输出结果
        System.out.println("模板中的最大占位符索引：" + maxIndex);
        System.out.println("需要的参数数量：" + (maxIndex + 1));
    }

    public static int findMaxPlaceholderIndex(String template) {
        int maxIndex = -1;

        try {
            // 创建 MessageFormat 对象
            MessageFormat messageFormat = new MessageFormat(template);

            // 获取格式化元素
            Object[] formats = messageFormat.getFormatsByArgumentIndex();

            // 找到最大的索引
            for (int i = 0; i < formats.length; i++) {
                maxIndex = Math.max(maxIndex, i);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("模板解析错误：" + e.getMessage());
        }

        return maxIndex;
    }
}
