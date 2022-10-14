package com.plf.tool.common.file;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;
import java.util.Map;

public class ExcelUtils {

    /**
     * 根据sheet读取Excel列表
     * @param filePath
     * @param sheet
     * @return
     */
    public static List<Map<String,Object>> readMap(String filePath,String sheet){
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file(filePath), sheet);
        return reader.readAll();
    }
}
