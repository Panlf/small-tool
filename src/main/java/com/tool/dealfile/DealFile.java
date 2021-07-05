package com.tool.dealfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.tool.readfile.ReadFileLineNumber;
import org.junit.jupiter.api.Test;


public class DealFile {
	
	@Test
	public void test(){
		DealFileToLower("content.txt");
	}
	
	@SuppressWarnings("resource")
	public void DealFileToLower(String fileName){
		try{
			//定义缓冲区对象
			ByteBuffer readbuff=ByteBuffer.allocate(1024);
			
			ByteBuffer writebuff=ByteBuffer.allocate(1024);
			
			//通过文件输入流获得文件通道对象（读取操作）
			FileChannel readChannel= new FileInputStream(ReadFileLineNumber.class.getClassLoader().getResource(fileName).getFile()).getChannel();
			//追加写入文件
			FileChannel writeChannel=new FileOutputStream("dealed_"+fileName,true).getChannel();
		
			
			int len=0;
			String content = "";
			
			while((len=readChannel.read(readbuff))!=-1){
				//将当前位置置为limit，然后设置当前位置为0，也就是从0到limit这块，都写入到同道中
				readbuff.flip();
				
				//处理文本内容
				content = new String(readbuff.array(),0,len);
				content = DealFileUtils.toLowerContent(content);
				writebuff=ByteBuffer.wrap(content.getBytes());
				
				//写数据
				writeChannel.write(writebuff);
				
				//将当前位置置为0，然后设置limit为容量，也就是从0到limit（容量）这块，
				//都可以利用，通道读取的数据存储到
				//0到limit这块
				readbuff.clear();
			}
			
			//关闭资源
			writeChannel.close();
			readChannel.close();
					
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
