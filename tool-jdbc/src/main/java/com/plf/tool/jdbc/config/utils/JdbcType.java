package com.plf.tool.jdbc.config.utils;

import lombok.Getter;

/**
 * JDBC的类型
 */
public enum JdbcType {
    MYSQL("com.mysql.cj.jdbc.Driver","MySQL驱动"),POSTGRESQL("org.postgresql.Driver","POSTGRESQL的驱动");

    @Getter
    private String type;
    @Getter
    private String msg;

    JdbcType(String type,String msg) {
        this.type = type;
        this.msg = msg;
    }
}
