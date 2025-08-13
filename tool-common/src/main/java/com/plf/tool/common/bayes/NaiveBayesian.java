package com.plf.tool.common.bayes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author panlf
 * @date 2025/8/13
 */
public class NaiveBayesian {

    private static void train(){
        Map<String,Integer> parameters = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(""))){  //训练集数据
            String sentence;
            while(null!=(sentence=br.readLine())){
                String[] content = sentence.split("\t| "); //以tab或空格分词
                parameters.put(content[0],parameters.getOrDefault(content[0],0)+1);
                for (int i = 1; i < content.length; i++) {
                    parameters.put(content[0]+"-"+content[i],
                            parameters.getOrDefault(content[0]+"-"+content[i], 0)+1);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        saveModel(parameters);
    }


    private static void saveModel(Map<String,Integer> parameters){
        //存储到指定文件
        try(BufferedWriter bw =new BufferedWriter(new FileWriter(""))){
            parameters.keySet().stream().forEach(key->{
                try {
                    bw.append(key+"\t"+parameters.get(key)+"\r\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    private static HashMap<String, Integer> parameters = null;  //用于存放模型
    private static Map<String, Double> catagory=null;
    private static String[] labels = {"好评", "差评", "总数","priorGood","priorBad"};

    private static void loadModel() throws IOException {
        parameters = new HashMap<>();
        List<String> parameterData = Files.readAllLines(Paths.get(""));
        parameterData.stream().forEach(parameter -> {
            String[] split = parameter.split("\t");
            String key = split[0];
            int value = Integer.parseInt(split[1]);
            parameters.put(key, value);
        });

        calculateCatagory(); //分类
    }

    //计算模型中类别的总数
    public static void calculateCatagory() {
        catagory = new HashMap<>();
        double good = 0.0; //好评词频总数
        double bad = 0.0;   //差评的词频总数
        double total;   //总词频

        for (String key : parameters.keySet()) {
            Integer value = parameters.get(key);
            if (key.contains("好评-")) {
                good += value;
            } else if (key.contains("差评-")) {
                bad += value;
            }
        }
        total = good + bad;
        catagory.put(labels[0], good);
        catagory.put(labels[1], bad);
        catagory.put(labels[2], total);
        catagory.put(labels[3],good/total); //好评先验概率
        catagory.put(labels[4],bad/total);	//差评先验概率
    }

    private static void predictAll() {
        double accuracyCount = 0.;//准确个数
        int amount = 0;    //测试集数据总量

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(""))) {
            List<String> testData = Files.readAllLines(Paths.get(""));    //测试集数据
            for (String instance : testData) {
                String conclusion = instance.substring(0, instance.indexOf("\t"));  //已经打好的标签
                String sentence = instance.substring(instance.indexOf("\t") + 1);
                String prediction = predict(sentence);  //预测结果

                bw.append(conclusion + " : " + prediction + "\r\n");
                if (conclusion.equals(prediction)) {
                    accuracyCount += 1.;
                }
                amount += 1;
            }
            //计算准确率
            System.out.println("accuracyCount: " + accuracyCount / amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //{"好评", "差评", "总数","priorGood","priorBad"};
    private static String predict(String sentence) {
        String[] features = sentence.split(" ");
        String prediction;

        //分别预测好评和差评
        double good = likelihoodSum(labels[0], features) + Math.log(catagory.get(labels[3]));
        double bad = likelihoodSum(labels[1], features) + Math.log(catagory.get(labels[4]));
        return good >= bad?labels[0]:labels[1];
    }

    //似然概率的计算
    public static double likelihoodSum(String label, String[] features) {
        double p = 0.0;
        Double total = catagory.get(label) + 1;//分母平滑处理
        for (String word : features) {
            Integer count = parameters.getOrDefault(label + "-" + word, 0) + 1;//分子平滑处理
            //基本似然概率公式
            //计算在该类别的情况下是该词的概率，用该词的词频除以类别的总词频
            p += Math.log(count / total);
        }
        return p;
    }

    public static void main(String[] args) throws IOException {
        train();
        loadModel();
        predictAll();
    }
}
