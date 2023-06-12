package com.plf.tool.jdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author panlf
 * @date 2023/3/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColumnDto {
    private String columnName;
    private String columnType;
    private String columnComment;
}
