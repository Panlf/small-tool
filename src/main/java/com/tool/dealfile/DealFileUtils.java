package com.tool.dealfile;

/**
 * 处理工具类
 * @author plf 2020年3月3日上午11:10:23
 *
 */
public class DealFileUtils {

	/**
	 * 将输入的字符串转换成小写
	 * @param content
	 * @return
	 */
	public static String toLowerContent(String content){
		
		if(content==null || content.trim().equals("")){
			return "";
		}
		
		return content.toLowerCase();
	}
}
