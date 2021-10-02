package com.tool.dealfile;

import cn.hutool.core.util.StrUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author panlf
 * @date 2021/9/17
 */
public class RenameFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\panlf\\Desktop\\emoji";
        List<String> list= getFileName(path);
        System.out.println(list);
        for (String s:list){
            renameFile(path+"\\"+s);
        }
    }

    public static boolean renameFile(String filePath) throws IOException {

        File oldFile = new File(filePath);
        if(!oldFile.exists()) {
            return false;
        }

        String rootPath = oldFile.getParent();
        //System.out.println("rootPath="+rootPath);
        String fileName = oldFile.getName();
        //System.out.println("fileName="+fileName);
        String newFileName = fileName.replace("1 (","").replace(")","");
        //String newFileName = fileName.replace(".png",".png");
        String newPath = rootPath+"\\"+newFileName;
        System.out.println(newPath);
        File newFile = new File(newPath);
        if (oldFile.renameTo(newFile)) {
            System.out.println("修改成功!");
            return true;
        }
        else{
            System.out.println("修改失败");
            return false;
        }
    }

    public static List<String> getFileName(String path) {
        List<String> resultList = new ArrayList<>();
        if (StrUtil.isNotEmpty(path)) {
            File file = new File(path);
            File[] listFile   = file.listFiles();
            if(listFile!=null){
                for(File f:listFile){
                    resultList.add(f.getName());
                }
            }
        }
        return resultList;
    }
}
