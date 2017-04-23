package com.cs.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParamUtil {

	/**
	 * 如果字符串为空则是默认的值
	 * @param str 目标字符串
	 * @param defaultStr 默认字符串
	 * @return
	 */
	public static String getStr(String str,String defaultStr){
		if(str==null){
			str=defaultStr;
		}
		return str;
	}
	
	public static String DateString(Date date){
		String dateStr="";
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		dateStr=format.format(date);
		return dateStr;
	}
	
	public static void main(String[] args) {
		Date date=new Date();
		String str=ParamUtil.DateString(date);
		System.out.println(str);
	}
}
