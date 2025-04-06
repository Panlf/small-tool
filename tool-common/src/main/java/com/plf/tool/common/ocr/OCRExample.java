package com.plf.tool.common.ocr;


import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * 图片识别
 * @author panlf
 * @date 2025/3/18
 */
public class OCRExample {
    public static void main(String[] args) {
        // 创建 Tesseract 实例
        Tesseract tesseract = new Tesseract();
        //https://github.com/tesseract-ocr/tessdata
        // 设置 Tesseract 安装路径（如果未配置环境变量）
         tesseract.setDatapath("D:\\TempData\\Resource\\Tessdata\\tessdata_fast-4.1.0");

        // 设置语言（例如中文）
        //tesseract.setLanguage("chi_sim");

        try {
            // 加载图片文件
            File imageFile = new File("D:\\TempData\\Video\\output\\frame_0011.png");

            // 执行 OCR 识别
            String result = tesseract.doOCR(imageFile);

            // 输出识别结果
            System.out.println("识别结果: " + result);
        } catch (TesseractException e) {
            System.err.println("OCR 识别失败: " + e.getMessage());
        }
    }
}
