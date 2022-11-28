package com.plf.tool.odps.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.aliyun.odps.*;
import com.aliyun.odps.account.Account;
import com.aliyun.odps.account.AliyunAccount;
import com.aliyun.odps.data.Record;
import com.aliyun.odps.task.SQLTask;
import com.plf.tool.odps.dto.ColumnBaseInfo;
import com.plf.tool.odps.dto.TableInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class OdpsUtils {

    /**
     * 返回Odps连接
     *
     * @param accessId
     * @param accessKey
     * @param endPoint
     * @param project
     * @return
     */
    public static Odps getOdps(String accessId, String accessKey, String endPoint, String project) {
        Account account = new AliyunAccount(accessId, accessKey);
        Odps odps = new Odps(account);
        odps.setEndpoint(endPoint);
        odps.setDefaultProject(project);
        return odps;
    }

    /**
     * 查询非结构化数据
     *
     * @param odps
     * @param sql
     * @return
     * @throws OdpsException
     */
    public static Map<String, String> runSQL(Odps odps, String sql) throws OdpsException {
        Instance i = SQLTask.run(odps, sql);
        i.waitForSuccess();
        return i.getTaskResults();
    }

    public static long countTable(Odps odps, String sql)  {
        long count = 0;
        try {
            Instance i = SQLTask.run(odps, sql);
            i.waitForSuccess();
            List<Record> records = SQLTask.getResult(i);
            Record countRecord = records.get(0);
            count = Long.parseLong(String.valueOf(countRecord.get(0)));
        }catch (Exception e){
            log.error("OdpsUtils countTable error message is {}",e.getMessage());
            return count;
        }
        return count;
    }

    /**
     * 查询数据
     *
     * @param odps
     * @param sql
     * @return
     * @throws OdpsException
     */
    public static List<Map<String, Object>> select(Odps odps, String sql) throws OdpsException {
        List<Map<String, Object>> arr = new ArrayList<>();
        Instance i = SQLTask.run(odps, sql);
        i.waitForSuccess();
        List<Record> records = SQLTask.getResult(i);
        for (Record r : records) {
            Map<String, Object> map = new HashMap<String, Object>();
            Column[] cols = r.getColumns();
            for (Column col : cols) {
                String columnName = col.getName();
                map.put(columnName, r.get(columnName));
            }
            arr.add(map);
        }
        return arr;
    }

    /**
     * 获取表信息
     * @param project
     * @param tableName
     * @param odps
     * @return
     */
    public static List<TableInfo> listTableAllInfo(String project, String tableName, Odps odps) {
        List<TableInfo> list = new ArrayList<>();
        //获取该空间下所有的表
        Tables tables = odps.tables();

        for (Table table : tables) {
            if (StrUtil.isNotEmpty(tableName) && !table.getName().equals(tableName)) {
                continue;
            }
            TableInfo tableInfo = new TableInfo();
            //是否是视图
            if (table.isVirtualView()) {
                tableInfo.setType(1);
            } else {
                tableInfo.setType(0);
            }
            tableInfo.setProject(project);
            tableInfo.setTableName(table.getName());
            tableInfo.setTableComment(table.getComment());
            tableInfo.setColumnBaseInfoList(findAllColumnInfo(table));
            list.add(tableInfo);
        }
        return list;
    }

    private static List<ColumnBaseInfo> findAllColumnInfo(Table table) {
        List<ColumnBaseInfo> list = new ArrayList<>();

        TableSchema tableSchema = table.getSchema();
        List<Column> columnList = tableSchema.getColumns();

        for (Column column : columnList) {
            ColumnBaseInfo columnBaseInfo = new ColumnBaseInfo();
            columnBaseInfo.setColumnName(column.getName());
            columnBaseInfo.setComment(column.getComment());
            columnBaseInfo.setType(column.getTypeInfo().getTypeName());
            list.add(columnBaseInfo);
        }
        return list;
    }


    /**
     * 获取单表的字段信息
     * @param odps
     * @param tableName
     * @return
     */
    public static List<ColumnBaseInfo> getOneTable(Odps odps,String tableName) {
        List<TableInfo>  list =  listTableAllInfo(null,tableName,odps);
        if(CollectionUtil.isNotEmpty(list)){
            return list.get(0).getColumnBaseInfoList();
        }
        return null;
    }

    /**
     * 查询数据
     *
     * @param odps
     * @param sql
     * @return
     * @throws OdpsException
     */
    public static Map<String, Object> selectOne(Odps odps, String sql) throws OdpsException {
        List<Map<String, Object>>  list = select(odps,sql);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }
}
