package com.tool.excel;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author panlf
 * @date 2021/7/5
 */
public class ExcelUtils {


    @Test
    public void insertExcelData() {
        File file = new File("D:\\TempData\\excel\\info.xlsx");
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();

        map1.put("编号", "12-BB-11");
        map1.put("文件名", "测试文档9");
        map2.put("编号", "12-BB-12");
        map2.put("文件名", "测试文档8");
        map3.put("编号", "12-BB-13");
        map3.put("文件名", "测试文档7");
        list.add(map1);
        list.add(map2);
        list.add(map3);

        XSSFWorkbook wb = null;
        XSSFSheet sheet = null;
        InputStream input = null;
        FileOutputStream output = null;
        try {
            wb = new XSSFWorkbook();
            input = new FileInputStream(file);
            wb = (XSSFWorkbook) WorkbookFactory.create(input);
            if (wb != null) {
                //获取文件的指定工作表
                sheet = wb.getSheet("send");
                output = new FileOutputStream("D:\\TempData\\excel\\info.xlsx", false);
                //获取最大行数
                //int rownum = sheet.getPhysicalNumberOfRows();
                int index = sheet.getLastRowNum() + 1;
                String cmdStr = "";
                if (list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {

                        //插入excel
                        XSSFRow row = null;
                        row = sheet.createRow(index + i);
                        XSSFCell number_cell = row.createCell(0);
                        XSSFCell filename_cell = row.createCell(1);
                        number_cell.setCellValue(list.get(i).get("编号").toString());
                        filename_cell.setCellValue(list.get(i).get("文件名").toString());
                    }
                }
                output.flush();
                wb.write(output);
                if (input != null) {
                    input.close();
                }
                output.close();
            }
        } catch (Exception e) {

        }
    }
}
