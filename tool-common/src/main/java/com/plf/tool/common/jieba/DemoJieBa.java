package com.plf.tool.common.jieba;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.WordDictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author panlf
 * @date 2023/7/7
 */
public class DemoJieBa {
    public static void main(String[] args) throws IOException {
       /* JiebaSegmenter jiebaSegmenter = new JiebaSegmenter();
        String text = "首先感谢jieba分词原作者fxsjy，没有他的无私贡献，我们也不会结识到结巴 分词，更不会有现在的java版本。";
        jiebaSegmenter.sentenceProcess(text).forEach(System.out::println);
        */
        //WordDictionary.getInstance()
        //String currentWorkingDir = System.getProperty("user.dir");
        //System.out.println("当前工作目录：" + currentWorkingDir);
        //System.out.println(WordDictionary.getInstance().freqs);
        WordDictionary.getInstance().loadUserDict(Paths.get("tool-common/src/main/resources/localDic.txt"));
        //BufferedReader br = Files.newBufferedReader(Paths.get("tool-common/src/main/resources/localDic.txt"), Charset.defaultCharset());
        //System.out.println(br.toString());
        System.out.println(WordDictionary.getInstance().freqs.get("扣你"));
        JiebaSegmenter jiebaSegmenter = new JiebaSegmenter();
        String text = "扣你鸡娃";
       // jiebaSegmenter.sentenceProcess(text).forEach(System.out::println);
        jiebaSegmenter.process(text, JiebaSegmenter.SegMode.INDEX).forEach(System.out::println);
    }
}