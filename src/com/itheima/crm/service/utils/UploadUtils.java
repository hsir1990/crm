package com.itheima.crm.service.utils;

import java.util.UUID;

//文件上传的工具类
public class UploadUtils {
	//解决目录下文件名字重复问题
	public static String getUuidFileName(String fileName) {
		int idx = fileName.lastIndexOf(".");
		String extions = fileName.substring(idx);
		return UUID.randomUUID().toString().replace("-", "") + extions;
	}
	
	//目录分离的方法
	public static String getPath(String uuidFileName) {
		int code1 = uuidFileName.hashCode();
		int d1 = code1 & 0xf;
		int code2 = code1 >>> 4;
		int d2 = code2 & 0xf;
		
		return "/" + d1 + "/" + d2;
	}
	
	
	public static void main(String[] args) {
		System.out.println(getUuidFileName("11.txt"));
	}
}
