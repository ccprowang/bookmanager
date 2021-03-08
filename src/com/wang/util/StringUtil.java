/**
 * 字符串工具类,
 * @author yefeng
 *
 */
package com.wang.util;

public class StringUtil {
	public static int S_id;//定义全局的id
	public static String S_username;
	public static String S_password;
	public static String readertype;
	public static int B_id;
	/**
	 * 判断字符串是否为空
	 * @author yefeng
	 *
	 */
	public static boolean isempty(String str)
	{
		if(str==null||"".equals(str.trim()))
		{
			return true;
		}else
		{
			return false;
		}
	}
	/**
	 * 判断不为空
	 */
	public static boolean isnotempty(String str)
	{
		if(str!=null||!"".equals(str))//去掉前后空格.trim()
		{
			return true;
		}else
		{
			return false;
		}
	}
}
