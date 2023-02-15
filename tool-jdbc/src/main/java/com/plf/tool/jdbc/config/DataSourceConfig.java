package com.plf.tool.jdbc.config;

import cn.beecp.BeeDataSource;
import cn.beecp.BeeDataSourceConfig;

import javax.sql.DataSource;

public class DataSourceConfig {

    public static DataSource createDataConfig(String driverClassName,
                                              String jdbcUrl,
                                              String username,
                                              String password,
                                              boolean isNeedAutoCommit){
        BeeDataSourceConfig config = new BeeDataSourceConfig();
        config.setDriverClassName(driverClassName);
        //?serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=convertToNull&useSSL=true&characterEncoding=utf8
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setPrintRuntimeLog(true);
        config.setPrintConfigInfo(true);
        config.setDefaultAutoCommit(isNeedAutoCommit);
        return new BeeDataSource(config);
    }

    public static BeeDataSource createDataConfig(String driverClassName,
                                                 String jdbcUrl,
                                                 String username,
                                                 String password){
        BeeDataSourceConfig config = new BeeDataSourceConfig();
        config.setDriverClassName(driverClassName);
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setPrintRuntimeLog(true);
        config.setPrintConfigInfo(true);
        config.setDefaultAutoCommit(true);
        return new BeeDataSource(config);
    }
}
