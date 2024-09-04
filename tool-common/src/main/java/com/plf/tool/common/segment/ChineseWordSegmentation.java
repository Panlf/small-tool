package com.plf.tool.common.segment;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.List;
import java.util.Properties;

/**
 * @author panlf
 * @date 2024/9/3
 */
public class ChineseWordSegmentation {
    public static void main(String[] args) {
        // 创建一个配置对象，用于指定需要哪些注释器
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, coref");
        //props.setProperty("tokenize.language", "zh");
        //props.setProperty("segment.model", "C:\\Data\\Soft\\Maven\\data\\edu\\stanford\\nlp\\stanford-corenlp\\4.2.0\\stanford-corenlp-4.2.0-models-chinese\\edu\\stanford\\nlp\\models\\segmenter\\chinese\\ctb.gz");
        //props.setProperty("segment.sighanCorporaDict", "C:\\Data\\Soft\\Maven\\data\\edu\\stanford\\nlp\\stanford-corenlp\\4.2.0\\stanford-corenlp-4.2.0-models-chinese\\edu\\stanford\\nlp\\models\\segmenter\\chinese");
        //props.setProperty("segment.serDictionary", "C:\\Data\\Soft\\Maven\\data\\edu\\stanford\\nlp\\stanford-corenlp\\4.2.0\\stanford-corenlp-4.2.0-models-chinese\\edu\\stanford\\nlp\\models\\segmenter\\chinese\\dict-chris6.ser.gz");
        props.setProperty("ner.useSUTime", "false");
        props.setProperty("ner.applyNumericClassifiers", "false");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // 示例文本
        String text = "浙江省杭州市西湖区是中国著名的旅游景点所在地。";

        // 创建一个空的注释对象
        Annotation document = new Annotation(text);

        // 执行所有已加载的注释器
        pipeline.annotate(document);

        // 获取句子列表
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);

        // 遍历每个句子
        for (CoreMap sentence : sentences) {
            // 获取句子中的词语
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                // 获取词语的词性和命名实体标签
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                //if (!ne.equals("O")) { // 如果不是非实体
                //    System.out.println(word + ": " + ne);
                //}
                System.out.println("Word: " + word + ", POS: " + pos + ", NE: " + ne);
            }
        }

    }
}
