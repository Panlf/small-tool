package com.plf.tool.odps.utils;

import com.aliyun.odps.*;
import com.aliyun.odps.account.Account;
import com.aliyun.odps.account.AliyunAccount;
import com.aliyun.odps.data.Record;
import com.aliyun.odps.task.SQLTask;
import lombok.extern.slf4j.Slf4j;

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
}
