package com.plf.tool.common.ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @author panlf
 * @date 2025/3/18
 */
public class OnePicOCRExampleArea {
    public static void main(String[] args) {
        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage("eng"); // 设置语言
        tesseract.setDatapath("D:\\TempData\\Resource\\Tessdata\\tessdata_fast-4.1.0");
        try {
            // 加载图片文件
            File imageFile = new File("D:\\TempData\\Video\\output\\frame_0001.png");

            // 定义感兴趣区域（x, y, width, height）
            //Rectangle rect = new Rectangle(150, 425, 60, 40); // x, y, width, height
            Rectangle rect = new Rectangle(475, 820, 120, 40);

            // 执行 OCR 识别
            String result = tesseract.doOCR(imageFile, rect);

            // 输出识别结果
            System.out.println("识别结果: " + result);
        } catch (TesseractException e) {
            System.err.println("OCR 识别失败: " + e.getMessage());
        }
    }
}
