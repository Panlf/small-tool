package com.plf.tool.jdbc.utils;

import cn.hutool.db.sql.SqlExecutor;
import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.hive.ast.HiveInsertStatement;
import com.alibaba.druid.sql.dialect.hive.stmt.HiveCreateTableStatement;

import java.util.List;

/**
 * @author panlf
 * @date 2023/4/25
 */
public class DruidUtils {
    public static void main(String[] args) {
        String sql = "create table test\n" +
                "(\n" +
                "    name   string comment '姓名',\n" +
                "    age    int comment '年龄',\n" +
                "    update_time  timestamp comment '更新时间',\n" +
                ") comment '测试表' partitioned by (dt string) ;";
        SQLStatement sqlStatement = SQLUtils.parseSingleStatement(sql, DbType.hive);
        HiveCreateTableStatement hiveCreateTableStatement  =  (HiveCreateTableStatement)sqlStatement;
        hiveCreateTableStatement.getColumnDefinitions().forEach(v->{
            System.out.println(v.getColumnName()+"-"+v.getDataType().getName()+"-"+v.getComment());
        });
    }
}
