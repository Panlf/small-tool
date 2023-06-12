package com.plf.tool.jdbc.utils;

import com.plf.tool.jdbc.dto.ColumnBaseInfo;
import com.plf.tool.jdbc.dto.TableInfo;
import org.apache.commons.lang.StringUtils;

import java.sql.*;
import java.util.*;

/**
 * @author panlf
 * @date 2023/3/22
 */
public class HiveUtils {

    public static Connection getConnection(String url, String user, String pwd) {
        Connection connection = null;
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static boolean ddlOp(Connection conn, String sql) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            flag = pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, null, pst, null);
        }
        return flag;
    }

    public static TableInfo tableInfo(Connection conn, String dataBaseName, String tableName) {
        Statement stmt = null;
        ResultSet res = null;
        TableInfo tableInfo = new TableInfo();
        List<ColumnBaseInfo> columnBaseInfoList = new LinkedList<ColumnBaseInfo>();
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("DESCRIBE EXTENDED  " + dataBaseName + "." + tableName);
            while (res.next()) {


                if (res.getString(1).trim().equals("Detailed Table Information")) {
                    String content = res.getString(2).trim();
                    tableInfo.setTableName(tableName);
                    tableInfo.setType(getTableType(content));
                    tableInfo.setTableComment(getTableComment(content));
                } else {
                    ColumnBaseInfo columnBaseInfo = new ColumnBaseInfo();

                    if (StringUtils.isNotEmpty(res.getString(1))) {
                        columnBaseInfo.setColumnName(res.getString(1));
                        columnBaseInfo.setType(res.getString(2) == null ? "" : res.getString(2).toUpperCase());
                        columnBaseInfo.setComment(StringUtils.isEmpty(res.getString(3)) ? res.getString(1) : res.getString(3));
                        columnBaseInfoList.add(columnBaseInfo);
                    }
                }
            }

            tableInfo.setColumnBaseInfoList(columnBaseInfoList);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, stmt, null, null);
        }
        return tableInfo;
    }


    private static int getTableType(String content) {
        int result = 1;
        int start = content.lastIndexOf("tableType:");
        if (start == -1) {
            return result;
        }

        String sub = content.substring(start);
        int end = sub.indexOf(",");
        if (end == -1) {
            return result;
        }

        String typeName = sub.substring("tableType:".length(), end).toUpperCase();
        System.out.println("getTableType typeName:" + typeName);
        //真实
        if ("MANAGED_TABLE".equals(typeName)) {
            result = 1;
            //视图
        } else if ("VIRTUAL_VIEW".equals(typeName)) {
            result = 10;
            //外部
        } else if ("EXTERNAL_TABLE".equals(typeName)) {
            result = 2;
        } else {
            result = 3;
        }

        return result;
    }

    private static String getTableComment(String content) {
        String result = "";
        int start = content.lastIndexOf("comment");
        if (start == -1) {
            return result;
        }

        String sub = content.substring(start);

        int endBracket = sub.indexOf("}");
        int endDot = sub.indexOf(",");
        int end = Math.min(endBracket, endDot);
        if (end == -1) {
            return result;
        }

        result = sub.substring("comment=".length(), end);
        if (result.startsWith("null")) {
            result = null;
        }

        return result;
    }

    /**
     * runSelectSql
     *
     * @param conn
     * @param sql
     * @return
     */
    public static List<String> runSelectSql(Connection conn, String sql) {
        PreparedStatement pstmt = null;
        ResultSet res = null;
        List<String> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            res = pstmt.executeQuery();
            int count = res.getMetaData().getColumnCount();
            while (res.next()) {
                StringJoiner stringJoiner = new StringJoiner(":");
                for (int i = 1; i <= count; i++) {
                    if (res.getObject(i) != null && !"null".equals(res.getObject(i))) {
                        stringJoiner.add(res.getObject(i) + "");
                    }
                }
                list.add(stringJoiner.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, null, pstmt, res);
        }
        return list;
    }

    public static long countData(Connection conn, String sql) {
        PreparedStatement pstmt = null;
        ResultSet res = null;
        long count = 0l;
        try {
            pstmt = conn.prepareStatement(sql);
            res = pstmt.executeQuery();

            while (res.next()) {
                count = res.getLong(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, null, pstmt, res);
        }
        return count;
    }


    public static boolean runDDlSql(Connection conn, String sql) {
        PreparedStatement pstmt = null;
        boolean flag = false;
        try {
            pstmt = conn.prepareStatement(sql);
            flag = pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            close(conn, null, pstmt, null);
        }
        return flag;
    }

    public static String getStringWithNoException(ResultSet res, int i) {
        try {
            return res.getString(i);
        } catch (Exception e) {
            return "";
        }
    }

    public static List<Map<String, Object>> selectData(Connection conn, String sql) {
        PreparedStatement pstmt = null;
        ResultSet res = null;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            res = pstmt.executeQuery();
            // 获取结果集的元数据信息
            ResultSetMetaData rsmd = res.getMetaData();

            // 获取列字段的个数
            int colunmCount = rsmd.getColumnCount();

            // 存储列名的数组
            String[] columnNames = new String[colunmCount];

            for (int i = 0; i < colunmCount; i++) {
                // 获取所有的字段名称
                columnNames[i] = rsmd.getColumnLabel(i + 1);
            }

            while (res.next()) {
                Map<String, Object> perMap = new HashMap<String, Object>();
                for (int i = 0; i < colunmCount; i++) {
                    // 获取列名
                    String columnName = columnNames[i];
                    // 获取该列对应的值
                    Object value = res.getObject(columnName);
                    perMap.put(columnName, value);
                }
                list.add(perMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, null, pstmt, res);
        }
        return list;
    }


    public static List<String> listTables(Connection conn, String dataBaseName) {
        Statement stmt = null;
        ResultSet res = null;
        List<String> tables = new LinkedList<String>();
        try {
            stmt = conn.createStatement();
            if (StringUtils.isNotEmpty(dataBaseName)) {
                stmt.execute("USE " + dataBaseName);
            }
            res = stmt.executeQuery("SHOW TABLES");
            while (res.next()) {
                tables.add(res.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, stmt, null, null);
        }
        return tables;
    }

    public static List<String> listDataBases(Connection conn) {
        Statement stmt = null;
        ResultSet res = null;
        List<String> dataBases = new LinkedList<String>();
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("SHOW DATABASES");
            while (res.next()) {
                dataBases.add(res.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, stmt, null, res);
        }
        return dataBases;
    }


    public static void close(Connection connection, Statement stmt, PreparedStatement pst, ResultSet res) {
        try {
            if (stmt != null) {
                stmt.close();
            }

            if (pst != null) {
                pst.close();
            }

            if (res != null) {
                res.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt = null;
            pst = null;
            connection = null;
        }
    }
}

