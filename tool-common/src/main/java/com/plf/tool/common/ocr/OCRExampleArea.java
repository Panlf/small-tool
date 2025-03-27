package com.plf.tool.common.ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.Rectangle;
import java.io.File;


/**
 * @author panlf
 * @date 2025/3/18
 */
public class OCRExampleArea {
    public static void main(String[] args) {
        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage("eng"); // 设置语言
        tesseract.setDatapath("C:\\Data\\Middleware\\Tess4j\\tessdata_fast-master");
        try {
            // 加载图片文件
            File imageFile = new File("C:\\Users\\Breeze\\Desktop\\11.png");

            // 定义感兴趣区域（x, y, width, height）
            Rectangle rect = new Rectangle(900, 190, 100, 50); // x, y, width, height

            // 执行 OCR 识别
            String result = tesseract.doOCR(imageFile,rect);

            // 输出识别结果
            System.out.println("识别结果: " + result);
        } catch (TesseractException e) {
            System.err.println("OCR 识别失败: " + e.getMessage());
        }
    }
}
