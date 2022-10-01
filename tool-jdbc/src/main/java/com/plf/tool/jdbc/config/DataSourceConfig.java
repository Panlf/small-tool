package com.plf.tool.jdbc.config;

import cn.beecp.BeeDataSource;
import cn.beecp.BeeDataSourceConfig;

import javax.sql.DataSource;

public class DataSourceConfig {

    public static DataSource createDataConfig(String driverClassName,String jdbcUrl,String username,String password,boolean isNeedAutoCommit){
        BeeDataSourceConfig config = new BeeDataSourceConfig();
        config.setDriverClassName(driverClassName);
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setPrintRuntimeLog(true);
        config.setPrintConfigInfo(true);
        config.setDefaultAutoCommit(isNeedAutoCommit);
        BeeDataSource ds=new BeeDataSource(config);
        return ds;
    }

    public static DataSource createDataConfig(String driverClassName,String jdbcUrl,String username,String password){
        BeeDataSourceConfig config = new BeeDataSourceConfig();
        config.setDriverClassName(driverClassName);
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setPrintRuntimeLog(true);
        config.setPrintConfigInfo(true);
        config.setDefaultAutoCommit(true);
        BeeDataSource ds=new BeeDataSource(config);
        return ds;
    }
}
