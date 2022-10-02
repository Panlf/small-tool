package com.plf.tool.common.file;

import cn.hutool.core.util.StrUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    /**
     * 修改文件名
     * @param filePath
     * @return
     * @throws IOException
     */
    public static boolean renameFile(String filePath) throws IOException {
        File oldFile = new File(filePath);
        if(!oldFile.exists()) {
            return false;
        }
        String rootPath = oldFile.getParent();
        String fileName = oldFile.getName();
        // 具体修改文件名的方法
        String newFileName = fileName.replace("1 (","").replace(")","");

        String newPath = rootPath+"\\"+newFileName;
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

    /**
     * 将输入文件小写化
     * @param fileName
     */
    public void DealFileToLower(String fileName){
        try{
            //定义缓冲区对象
            ByteBuffer readBuff=ByteBuffer.allocate(1024);

            ByteBuffer writeBuff=ByteBuffer.allocate(1024);

            //通过文件输入流获得文件通道对象（读取操作）
            FileChannel readChannel= new FileInputStream(FileUtils.class.getClassLoader().getResource(fileName).getFile()).getChannel();
            //追加写入文件
            FileChannel writeChannel=new FileOutputStream("dealed_"+fileName,true).getChannel();

            int len=0;
            String content = "";

            while((len=readChannel.read(readBuff))!=-1){
                //将当前位置置为limit，然后设置当前位置为0，也就是从0到limit这块，都写入到同道中
                readBuff.flip();

                //处理文本内容
                content = new String(readBuff.array(),0,len);
                content = content.toLowerCase();
                writeBuff=ByteBuffer.wrap(content.getBytes());
                //写数据
                writeChannel.write(writeBuff);
                //将当前位置置为0，然后设置limit为容量，也就是从0到limit（容量）这块，
                //都可以利用，通道读取的数据存储到
                //0到limit这块
                readBuff.clear();
            }

            //关闭资源
            writeChannel.close();
            readChannel.close();

        }catch(Exception e){
            e.printStackTrace();
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

    /**
     * 将输入的字符串转换成小写
     * @param content
     * @return
     */
    public static String toLowerContent(String content){
        if(StrUtil.isEmptyIfStr(content)){
            return "";
        }
        return content.toLowerCase();
    }
}
