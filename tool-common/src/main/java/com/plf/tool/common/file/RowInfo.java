package com.plf.tool.common.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RowInfo<T> {
    private int rowIndex;
    private T data;
}
