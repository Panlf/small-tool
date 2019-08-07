package com.tool.readfile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;

public class ReadFile {

	public static void main(String[] args) throws Exception {
		/*
		String str=read(0,6);
		System.out.println(str);*/
		//System.out.println(getLineNumber(new File(ReadFile.class.getClassLoader().getResource("number.txt").getFile())));
		System.out.println(getLineNumber(new File("E://db.sql")));
	}

	 public static void Test() throws IOException{
		 RandomAccessFile file = new RandomAccessFile(
					ReadFile.class.getClassLoader().getResource("number.txt").getFile(), "r");
			file.seek(10);
			byte[] bs = new byte[1024];
			int len = file.read(bs);
			System.out.println(new String(bs, 0, len));
			file.close();
	    }
	 
	
	 public static String read(int from ,int to){
	        String result="";	
	        byte[] bytes=new byte[to-from+1];
	        BufferedInputStream bis = null;
	        try{
	            FileInputStream fis=new FileInputStream(ReadFile.class.getClassLoader().getResource("number.txt").getFile());
	            bis=new BufferedInputStream(fis);
	            bis.skip(from-1);
	            bis.read(bytes, 0, to-from+1);
	            result = new String(bytes);
	        }catch(FileNotFoundException e){
	            e.printStackTrace();
	        }catch(IOException e){
	            e.printStackTrace();
	        }finally {
				if(bis!=null) {
					try {
						bis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	        return result;
	    }
	

	public static long getLineNumber(File file) {
	    if (file.exists()) {
	        try {
	            FileReader fileReader = new FileReader(file);
	            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
	            lineNumberReader.skip(Long.MAX_VALUE);
	            long lines = lineNumberReader.getLineNumber() + 1;
	            fileReader.close();
	            lineNumberReader.close();
	            return lines;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return 0;
	}

}
