package com.plf.tool.jdbc.utils;

import cn.hutool.core.util.StrUtil;

import java.sql.*;
import java.util.*;

/**
 * JDBC操作
 */
public class JdbcUtils {

    /**
     * 获取Connection
     * @param jdbcType
     * @param url
     * @param username
     * @param password
     * @return
     */
    public Connection getConnection(JdbcType jdbcType, String url, String username, String password) {
        Connection connection = null;
        try {
            Class.forName(jdbcType.getType());
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 获取所有的数据库
     * @param connection
     * @return
     * @throws Exception
     */
    public List<String> getAllDataBase(Connection connection) {
        List<String> result = new ArrayList<>();
        ResultSet tables = null;
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            //检索数据库名称列表
            tables = metaData.getCatalogs();
            while (tables.next()) {
                result.add(tables.getString("TABLE_CAT"));
            }
        } catch (Exception e) {
            return result;
        } finally {
            close(tables);
        }
        return result;
    }

    /**
     * 根据SQL获取一个统计值
     * @param connection
     * @param sql
     * @return
     * @throws Exception
     */
    public long getOneLongResult(Connection connection, String sql) {
        long count = 0l;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getLong(1);
            }
        } catch (Exception e) {
            return count;
        } finally {
            close(resultSet, preparedStatement);
        }
        return count;
    }

    /**
     * 执行DDL SQL语句
     * @param connection
     * @param sql
     */
    public void execute(Connection connection, String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement);
        }
    }


    /**
     * 查询数据
     * @param connection
     * @param sql
     * @return
     */
    public List<Map<String, Object>> selectData(Connection connection, String sql) {
        List<Map<String, Object>> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            final ResultSetMetaData metaData = resultSet.getMetaData();
            final int columnCount = metaData.getColumnCount();
            //遍历加入
            while (resultSet.next()) {
                Map<String, Object> map = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    map.put(metaData.getColumnLabel(i), resultSet.getObject(i));
                }
                list.add(map);
            }
        } catch (Exception e) {
            return list;
        } finally {
            close(resultSet, preparedStatement);
        }
        return list;
    }

    /**
     * 查询一行数据
     * @param connection
     * @param sql
     * @return
     */
    public Map<String, Object> selectOneData(Connection connection, String sql) {
        List<Map<String, Object>> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            final ResultSetMetaData metaData = resultSet.getMetaData();
            final int columnCount = metaData.getColumnCount();
            //遍历加入
            while (resultSet.next()) {
                Map<String, Object> map = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    map.put(metaData.getColumnLabel(i), resultSet.getObject(i));
                }
                list.add(map);
            }
        } catch (Exception e) {
            return null;
        } finally {
            close(resultSet, preparedStatement);
        }
        if(list.size()>0){
            Map<String, Object> map = list.get(0);
            return map;
        }
        return null;
    }

    /**
     * 获取所有表名
     * @param connection
     * @param schemaName
     * @return
     */
    public List<String> getAllTable(Connection connection, String schemaName) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> result = new ArrayList<>();
        try {
            String sql = "SELECT TABLE_NAME FROM information_schema.tables WHERE TABLE_SCHEMA = '" + schemaName + "'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getString("TABLE_NAME"));
            }
        } catch (Exception e) {
            return result;
        } finally {
            close(resultSet, preparedStatement);
        }
        return result;
    }


    /**
     * 获取所有的表名和表表名
     * @param connection
     * @return
     */
    public Map<String,String> getAllTableAndComment(Connection connection,String schema) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Map<String,String>  result = new LinkedHashMap<>();
        try {
            String sql = "SELECT TABLE_NAME,TABLE_COMMENT FROM information_schema.tables";

            if(StrUtil.isNotEmpty(schema)){
                sql += " where TABLE_SCHEMA='"+schema+"'";
            }

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.put(resultSet.getString("TABLE_NAME"),resultSet.getString("TABLE_COMMENT"));
            }
        } catch (Exception e) {
            return result;
        } finally {
            close(resultSet, preparedStatement);
        }
        return result;
    }

    /**
     * 获取表的字段和注释
     * @param connection
     * @param table
     * @return
     */
    public Map<String,String> getAllColumnAndComment(Connection connection,String table) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Map<String,String>  result = new LinkedHashMap<>();
        try {
            String sql = "select COLUMN_NAME,DATA_TYPE,COLUMN_COMMENT,COLUMN_TYPE from information_schema.COLUMNS where table_name ='"+table+"'";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.put(resultSet.getString("COLUMN_NAME"),resultSet.getString("COLUMN_COMMENT"));
            }
        } catch (Exception e) {
            return result;
        } finally {
            close(resultSet, preparedStatement);
        }
        return result;
    }

    public void close(AutoCloseable ...autoCloseables) {
        if(autoCloseables!=null && autoCloseables.length>0){
            Arrays.stream(autoCloseables).forEach(autoCloseable -> {
                try {
                    if(autoCloseable!=null){
                        autoCloseable.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

