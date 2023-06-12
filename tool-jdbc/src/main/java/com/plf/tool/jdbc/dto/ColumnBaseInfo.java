package com.plf.tool.jdbc.dto;

import lombok.Data;

@Data
public class ColumnBaseInfo {
    //字段名称
    private String columnName;
    //字段类型
    private String type;
    //字段注释
    private String comment;
}
