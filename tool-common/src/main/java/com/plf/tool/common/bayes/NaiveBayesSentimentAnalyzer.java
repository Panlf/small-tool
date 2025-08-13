package com.plf.tool.common.bayes;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author panlf
 * @date 2025/8/13
 */
public class NaiveBayesSentimentAnalyzer {
    // 存储积极和消极词汇的频率
    private Map<String, Integer> positiveWordCounts = new HashMap<>();
    private Map<String, Integer> negativeWordCounts = new HashMap<>();

    // 积极和消极文档的数量
    private int positiveDocCount = 0;
    private int negativeDocCount = 0;

    // 词汇表 - 所有出现过的词
    private Set<String> vocabulary = new HashSet<>();

    // 停用词集合
    private Set<String> stopWords = new HashSet<>(Arrays.asList(
            "的", "了", "在", "是", "我", "有", "和", "就", "不", "人", "都", "一", "一个", "上", "也", "很", "到", "说", "要", "去", "你", "会", "着", "没有", "看", "好", "自己", "这"
    ));

    // 分词模式 - 简单的中文分词（按字分割，实际应用中可替换为更复杂的分词器）
    private Pattern wordPattern = Pattern.compile("[\u4e00-\u9fa5]");

    /**
     * 训练模型
     * @param text 文本内容
     * @param isPositive 是否为积极情感
     */
    public void train(String text, boolean isPositive) {
        // 分词并过滤
        List<String> words = tokenizeAndFilter(text);

        // 更新文档计数
        if (isPositive) {
            positiveDocCount++;
        } else {
            negativeDocCount++;
        }

        // 更新词频
        for (String word : words) {
            vocabulary.add(word);
            if (isPositive) {
                positiveWordCounts.put(word, positiveWordCounts.getOrDefault(word, 0) + 1);
            } else {
                negativeWordCounts.put(word, negativeWordCounts.getOrDefault(word, 0) + 1);
            }
        }
    }

    /**
     * 预测文本情感
     * @param text 待预测文本
     * @return 情感得分，正值为积极，负值为消极
     */
    public double predict(String text) {
        List<String> words = tokenizeAndFilter(text);

        // 计算先验概率 P(positive) 和 P(negative)
        double pPositive = (double) positiveDocCount / (positiveDocCount + negativeDocCount);
        double pNegative = (double) negativeDocCount / (positiveDocCount + negativeDocCount);

        // 计算积极和消极的后验概率（使用对数避免下溢）
        double positiveLogProb = Math.log(pPositive);
        double negativeLogProb = Math.log(pNegative);

        // 计算每个词的条件概率
        for (String word : words) {
            // 拉普拉斯平滑处理
            double pWordGivenPositive = (double) (positiveWordCounts.getOrDefault(word, 0) + 1)
                    / (getTotalWords(positiveWordCounts) + vocabulary.size());

            double pWordGivenNegative = (double) (negativeWordCounts.getOrDefault(word, 0) + 1)
                    / (getTotalWords(negativeWordCounts) + vocabulary.size());

            positiveLogProb += Math.log(pWordGivenPositive);
            negativeLogProb += Math.log(pWordGivenNegative);
        }

        // 返回两个概率的差值，正值表示更可能是积极情感
        return positiveLogProb - negativeLogProb;
    }

    /**
     * 分词并过滤停用词
     */
    private List<String> tokenizeAndFilter(String text) {
        List<String> words = new ArrayList<>();
        if (text == null || text.trim().isEmpty()) {
            return words;
        }

        // 简单分词（实际应用中建议使用IKAnalyzer等专业中文分词器）
        Matcher matcher = wordPattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            // 过滤停用词
            if (!stopWords.contains(word) && word.length() > 0) {
                words.add(word);
            }
        }

        return words;
    }

    /**
     * 获取总词数
     */
    private int getTotalWords(Map<String, Integer> wordCounts) {
        int total = 0;
        for (int count : wordCounts.values()) {
            total += count;
        }
        return total;
    }

    public static void main(String[] args) {
        NaiveBayesSentimentAnalyzer analyzer = new NaiveBayesSentimentAnalyzer();

        // 训练数据 - 积极情感
        analyzer.train("这部电影非常精彩，演员表演出色，剧情紧凑引人入胜", true);
        analyzer.train("今天天气很好，心情非常愉快，一切都很顺利", true);
        analyzer.train("这家餐厅的食物美味可口，服务态度也很好", true);

        // 训练数据 - 消极情感
        analyzer.train("这部电影很糟糕，剧情混乱，演员表演生硬", false);
        analyzer.train("今天天气很差，让人心情烦躁，做什么都不顺利", false);
        analyzer.train("这家餐厅的食物很难吃，服务也很差劲", false);

        // 测试预测
        String[] testTexts = {
                "这部电影太精彩了，我非常喜欢",
                "今天心情很糟糕，什么都不想做",
                "这家餐厅的服务很好，食物也很美味",
                "天气很差，让人很不舒服"
        };

        for (String text : testTexts) {
            double score = analyzer.predict(text);
            String sentiment = score > 0 ? "积极" : "消极";
            System.out.println("文本: " + text);
            System.out.println("情感: " + sentiment + " (得分: " + score + ")\n");
        }
    }
}
