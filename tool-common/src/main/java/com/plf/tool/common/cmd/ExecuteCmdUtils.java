package com.plf.tool.common.cmd;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class ExecuteCmdUtils {

    public static String executeCmd(String cmd){
        try {
            //System.out.println("开始执行===>"+cmd);
            String[] cmdA = { "cmd.exe", "/c", cmd };
            Process process = Runtime.getRuntime().exec(cmdA);
            LineNumberReader br = new LineNumberReader(new InputStreamReader(process.getInputStream(),"GBK"));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean executeLinuxCmd(String cmd){
        Runtime run = Runtime.getRuntime();
        boolean result = true;
        try {
            Process process = run.exec(cmd);
            //执行结果 0 表示正常退出
            int exeResult=process.waitFor();
            if(exeResult==0){
                System.out.println("cmd ===>【"+cmd+"】执行成功");
            }else{
                System.out.println("cmd ===>【"+cmd+"】执行失败");
                result = false;
            }
        }
        catch (Exception e) {
            System.out.println("cmd ===>【"+cmd+"】执行错误，错误原因 ===> 【"+e.getMessage()+"】");
            return false;
        }
        return result;
    }
}
