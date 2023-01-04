package com.plf.tool.common.file;

import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

public class CsvUtils {

    public static <T> void createCsv(String path, List<T> list){

        CsvWriter csvWriter = CsvUtil.getWriter(new File(path), Charset.defaultCharset());

        csvWriter.write(list);

        csvWriter.flush();
    }
}
