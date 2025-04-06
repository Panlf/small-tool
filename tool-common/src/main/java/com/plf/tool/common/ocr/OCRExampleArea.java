package com.plf.tool.common.ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @author panlf
 * @date 2025/3/18
 */
public class OCRExampleArea {
    public static void main(String[] args) {
        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage("eng"); // 设置语言
        tesseract.setDatapath("D:\\TempData\\Resource\\Tessdata\\tessdata_fast-4.1.0");
        try {
            FileWriter fileWriter = new FileWriter("D:\\TempData\\Video\\output\\speed.txt",true);
            for(int i=1;i<82;i++) {

                // 加载图片文件
                File imageFile = new File("D:\\TempData\\Video\\output\\frame_00"+getFormatNum(i,2)+".png");

                // 定义感兴趣区域（x, y, width, height）
                //Rectangle rect = new Rectangle(150, 425, 60, 40); // x, y, width, height
                //Rectangle rect = new Rectangle(465, 440, 70, 20);
                Rectangle rect = new Rectangle(475, 820, 120, 40);

                // 执行 OCR 识别
                String result = tesseract.doOCR(imageFile, rect);

                // 输出识别结果
                System.out.println("识别结果: " + result);
                fileWriter.append("frame_00").append(getFormatNum(i,2)).append(".png").append("\t").append(result);
                fileWriter.flush();
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (TesseractException e) {
            System.err.println("OCR 识别失败: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFormatNum(int num,int totalNum){
        String numStr = String.valueOf(num);
        if(numStr.length() > totalNum){
            throw new RuntimeException("位数存在问题");
        }else if(numStr.length() == totalNum){
            return numStr;
        }else {
            while(numStr.length()<totalNum){
                numStr = "0" + numStr;
            }
            return numStr;
        }

    }
}
