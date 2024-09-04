package com.plf.tool.common.segment;

import cn.hutool.core.collection.CollectionUtil;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.huaban.analysis.jieba.WordDictionary;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author panlf
 * @date 2023/7/7
 */
public class DemoJieBa {
    public static void main(String[] args) throws IOException {
        System.out.println(participleWord1("我不喜欢你"));

        /*System.out.println(
        cosineSimilarity(
                new double[]{1,1,2,1,1,1,0,0,0}
                ,new double[]{1,1,1,0,1,1,1,1,1}));
         */
        //String s1 = "我有点喜欢你";
        //String s2 = "我不喜欢你";
        //List<String> s1List = participleWord(s1);
        //List<String> s2List = participleWord(s2);
        //List<String> mergeList = mergeList(s1List,s2List);
        //System.out.println(participleWord(s2));
        //System.out.println(mergeList(s1List,s2List));
        //double[] s1Double = termFrequency(mergeList,s1List);
        //double[] s2Double = termFrequency(mergeList,s2List);
        //System.out.println(
        //        cosineSimilarity(s1Double,s2Double));

        //System.out.println(jaccard(s1List,s2List));
    }

    public void filterWord(){
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

    public static List<String> mergeList(List<String> s1List,List<String> s2List){
        return new ArrayList<>(CollectionUtil.union(s1List, s2List));
    }

    public static double[] termFrequency(List<String> merge,List<String> sList){
        double[] result = new double[merge.size()];
        for(int i=0;i<merge.size();i++){
            result[i] = Collections.frequency(sList, merge.get(i));
        }
        return result;
    }

    public static List<String> participleWord(String text){
        JiebaSegmenter jiebaSegmenter = new JiebaSegmenter();
        List<SegToken> process = jiebaSegmenter.process(text, JiebaSegmenter.SegMode.INDEX);
        return process.stream().map(x->x.word).collect(Collectors.toList());
    }

    public static List<String> participleWord1(String text){
        JiebaSegmenter jiebaSegmenter = new JiebaSegmenter();
        return jiebaSegmenter.sentenceProcess(text);
    }

    public static double cosineSimilarity(double[] a,double[] b){
        double m = 0;
        double n = 0;
        double s = 0;
        for(int i=0;i<a.length;i++){
            s += a[i] * b[i];
            m += Math.pow(a[i],2);
            n += Math.pow(b[i],2);
        }
        BigDecimal a1 = new BigDecimal(s);
        BigDecimal a2 = BigDecimal.valueOf(Math.sqrt(m));
        BigDecimal a3 = BigDecimal.valueOf(Math.sqrt(n));

        BigDecimal result = a1.divide(a2.multiply(a3),4,BigDecimal.ROUND_HALF_UP);

        //BigDecimal bd = new BigDecimal(String.valueOf(s/(Math.sqrt(m) * Math.sqrt(n))));
        //BigDecimal result = bd.setScale(4, BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();
    }

    public static double jaccard(List<String> s1List,List<String> s2List){
        int a = CollectionUtil.intersection(s1List,s2List).size();
        int b = CollectionUtil.union(s1List,s2List).size();
        BigDecimal a1 = new BigDecimal(a);
        BigDecimal a2 = new BigDecimal(b);
        BigDecimal db = a1.divide(a2,4, BigDecimal.ROUND_HALF_UP);
        return db.doubleValue();
    }


}