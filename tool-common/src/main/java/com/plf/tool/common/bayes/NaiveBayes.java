package com.plf.tool.common.bayes;

import java.util.HashMap;
import java.util.Map;

/**
 * @author panlf
 * @date 2024/6/11
 */
public class NaiveBayes {
    private Map<String, Map<String, Integer>> featureCounts;
    private Map<String, Integer> labelCounts;
    private int totalExamples;

    public NaiveBayes() {
        featureCounts = new HashMap<>();
        labelCounts = new HashMap<>();
        totalExamples = 0;
    }

    public void train(String label, String[] features) {
        if (!labelCounts.containsKey(label)) {
            labelCounts.put(label, 0);
        }
        labelCounts.put(label, labelCounts.get(label) + 1);
        totalExamples++;

        for (String feature : features) {
            if (!featureCounts.containsKey(feature)) {
                featureCounts.put(feature, new HashMap<>());
            }
            if (!featureCounts.get(feature).containsKey(label)) {
                featureCounts.get(feature).put(label, 0);
            }
            featureCounts.get(feature).put(label, featureCounts.get(feature).get(label) + 1);
        }
    }

    public String predict(String[] features) {
        double maxProbability = Double.NEGATIVE_INFINITY;
        String bestLabel = null;

        for (String label : labelCounts.keySet()) {
            double probability = Math.log((double) labelCounts.get(label) / totalExamples);
            for (String feature : features) {
                if (featureCounts.containsKey(feature) && featureCounts.get(feature).containsKey(label)) {
                    probability += Math.log((double) featureCounts.get(feature).get(label) / labelCounts.get(label));
                } else {
                    probability += Math.log(1e-6); // 避免概率为0的情况
                }
            }

            if (probability > maxProbability) {
                maxProbability = probability;
                bestLabel = label;
            }
        }

        return bestLabel;
    }

    public static void main(String[] args) {
        NaiveBayes naiveBayes = new NaiveBayes();
        naiveBayes.train("A", new String[]{"x1", "x2"});
        naiveBayes.train("A", new String[]{"x1", "x3"});
        naiveBayes.train("B", new String[]{"x2", "x3"});
        naiveBayes.train("B", new String[]{"x1", "x2", "x3"});

        System.out.println(naiveBayes.predict(new String[]{"x1", "x2"})); // 输出：A
        System.out.println(naiveBayes.predict(new String[]{"x2", "x3"})); // 输出：B
    }
}
