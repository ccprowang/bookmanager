/**
 * �ַ���������,
 * @author yefeng
 *
 */
package com.wang.util;

public class StringUtil {
	public static int S_id;//����ȫ�ֵ�id
	public static String S_username;
	public static String S_password;
	public static String readertype;
	public static int B_id;
	/**
	 * �ж��ַ����Ƿ�Ϊ��
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
	 * �жϲ�Ϊ��
	 */
	public static boolean isnotempty(String str)
	{
		if(str!=null||!"".equals(str))//ȥ��ǰ��ո�.trim()
		{
			return true;
		}else
		{
			return false;
		}
	}
}
