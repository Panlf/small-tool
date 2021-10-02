package com.tool.number;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MakeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入是一号线操作还是二号线操作1）、2）：");
        int line = scanner.nextInt();
        System.out.println("你选择是："+line);
        System.out.println("请输入需要操作的Sheet1）、2）、3）：");
        int type = scanner.nextInt();
        System.out.println("你选择是："+type);

        /*
        List<String> fileNameList = getFileName("D:\\TempData\\3-1 工点或系统提供资料");
        System.out.println(fileNameList);
        List<Map<String,Object>> allInsertInfo = splitFillName(fileNameList);
        System.out.println(allInsertInfo);
        List<Map<String,Object>> isExistInfoList = getExcelRead("D:\\TempData\\全部资料.xlsx","工点或系统提供资料3-1");
        System.out.println(isExistInfoList);
        List<Map<String, Object>> insertData =  getNeedInsert(allInsertInfo,isExistInfoList);
        System.out.println(insertData);
        insertExcelData(insertData,"D:\\TempData\\全部资料.xlsx","工点或系统提供资料3-1");*/
        //writeExcelData(insertData,"C:\\Data\\Temp\\info.xls");
        scanner.close();
    }

    /*public static List<Map<String, Object>> getNeedInsert(List<Map<String,Object>> allInsertInfo,List<Map<String,Object>> isExistInfoList){
        List<Map<String, Object>> result = new ArrayList<>();

        if(CollectionUtil.isNotEmpty(isExistInfoList)){
            result.addAll(isExistInfoList);
        }
        for(Map<String,Object> map:allInsertInfo){
            String number = map.get("编号").toString();
            String fileName = map.get("文件名").toString();

            if(isExist(number,fileName,isExistInfoList)){
                continue;
            }else {
                Map<String,Object> nMap = new LinkedHashMap<>();
                nMap.put("编号",number);
                nMap.put("文件名",fileName);
                result.add(nMap);
            }
        }
        return result;
    }
     */

    public static List<Map<String, Object>> getNeedInsert(List<Map<String,Object>> allInsertInfo,List<Map<String,Object>> isExistInfoList){
        List<Map<String, Object>> result = new ArrayList<>();
        for(Map<String,Object> map:allInsertInfo){
            String number = map.get("编号").toString();
            String fileName = map.get("文件名").toString();

            if(isExist(number,fileName,isExistInfoList)){
                continue;
            }else {
                Map<String,Object> nMap = new HashMap<>();
                nMap.put("编号",number);
                nMap.put("文件名",fileName);
                result.add(nMap);
            }
        }
        return result;
    }

    public static boolean isExist(String number,String fileName,List<Map<String,Object>> isExistInfoList){
        if(CollectionUtil.isEmpty(isExistInfoList)){
            return false;
        }
        for(Map<String,Object> map:isExistInfoList){
            String oNumber = map.get("编号").toString();
            String oFileName = map.get("文件名").toString();
            if(number.equalsIgnoreCase(oNumber) && oFileName.equalsIgnoreCase(fileName)){
                return true;
            }
        }
        return false;
    }

    public static List<Map<String,Object>> getExcelRead(String path,String sheet)  {
        if(!FileUtil.exist(new File(path))){
            return null;
        }else{
            File file = new File(path);
            try {
                InputStream inputStream = new FileInputStream(file);
                ExcelReader reader = ExcelUtil.getReader(inputStream,sheet);
                List<Map<String,Object>> readAll = reader.readAll();
                reader.close();
                return readAll;
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void writeExcelData(List<Map<String,Object>> data,String path){
        if(FileUtil.exist(new File(path))){
           new File(path).delete();
        }
       if(CollectionUtil.isNotEmpty(data)){
           data = data.stream()
                   .filter(x-> (x.get("编号") !=null &&
                           x.get("文件名") != null &&
                           x.get("编号").toString().length()>0 &&
                           x.get("文件名").toString().length()>0))
                   .collect(Collectors.toList());
           ExcelWriter writer = ExcelUtil.getWriter(path);
           writer.write(data, true);
            // 关闭writer，释放内存
           writer.close();
       }
    }

    public static List<Map<String, Object>> splitFillName(List<String> fileNameList) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        if (CollectionUtil.isNotEmpty(fileNameList)) {
            for (String fileName : fileNameList) {
                StringBuffer stringBuffer = new StringBuffer(fileName);
                stringBuffer = stringBuffer.reverse();

                String[] arr = stringBuffer.toString().split("");
                int k = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].equalsIgnoreCase("：") || arr[i].equalsIgnoreCase("-") || arr[i].equalsIgnoreCase(" ")) {
                        k = i;
                        break;
                    }
                }
                //去除分隔符
                String number = fileName.substring(0, fileName.length() - k - 1);
                String file = fileName.substring(fileName.length() - k, fileName.length());

                Map<String,Object> map = new HashMap<>();
                map.put("编号",number);
                map.put("文件名",file);
                resultList.add(map);
            }
        }
        return resultList;
    }


    /**
     * 获取目录下的所有文件
     *
     * @param path
     * @return
     */
    public static List<String> getFileName(String path) {
        List<String> resultList = new ArrayList<>();
        if (StrUtil.isNotEmpty(path)) {
            File file = new File(path);
            File[] listFile   = file.listFiles();
            if(listFile!=null){
                for(File f:listFile){
                    resultList.add(f.getName());
                }
            }
           // resultList=FileUtil.listFileNames(path);
        }
        return resultList;
    }

    public static void insertExcelData(List<Map<String, Object>> list,String path,String writeSheet) {
        File file = new File(path);

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
                sheet = wb.getSheet(writeSheet);
                output = new FileOutputStream(path, false);
                //获取最大行数
                //int rownum = sheet.getPhysicalNumberOfRows();
                int index = sheet.getLastRowNum() + 1;
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
            e.printStackTrace();
        }
    }
}
