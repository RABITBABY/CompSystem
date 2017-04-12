package com.cs.util;

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
	
	
	
	public static void main(String[] args) {
		String ab=null;
		String bb;
		bb=ParamUtil.getStr(ab, "haha");
		System.out.println(bb);
	}
}
