package com.plf.tool.jdbc.dto;

import lombok.Data;

import java.util.List;

@Data
public class TableInfo {
    private String tableName;
    private String tableComment;
    private Integer type; // 真实表 1 视图 10
    private String project;
    private List<ColumnBaseInfo> columnBaseInfoList;
}
