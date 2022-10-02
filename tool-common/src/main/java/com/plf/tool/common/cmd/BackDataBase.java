package com.plf.tool.common.cmd;

/**
 * 备份数据库
 */
public class BackDataBase {

    /**
     * 执行mysqldump命令备份数据库
     * @param database
     * @param ip
     * @param username
     * @param password
     * @param filePath
     */
    public static void executeMySQLDump(String database,String ip,String username,String password,String filePath){
        String pattern = "mysqldump -h%s -u%s -p%s %s > %s";
        String cmd = String.format(pattern,ip,username,password,database,filePath);
        //System.out.println(cmd);
        String result = ExecuteCmdUtils.executeCmd(cmd);
        System.out.println("开始结束===>"+result);
    }
}
