package com.wang.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutil {
	//localhost   121.36.1.2
		private  String url="jdbc:mysql://localhost/db_book?useUnicode=true&characterEncoding=utf8";//数据库连接地址
		private String dbuserName="root";
		private String dbPassword="123456";//本地123456
		private String jdbcname="com.mysql.jdbc.Driver";//驱动名字
		/**
		 * 获取数据库连接
		 * @return
		 * @throws Exception
		 */
		public Connection getCon()throws Exception
		{
				Class.forName(jdbcname);
				Connection con=DriverManager.getConnection(url,dbuserName,dbPassword);
				return  con;
		}
		/**
		 * 关闭连接
		 */
		public void closecon(Connection con)throws Exception
		{
			if(con == null)
			{
				con.close();
			}
		}
		public static void main(String[] args) throws Exception {
			Dbutil db=new Dbutil();
			db.getCon();
			System.out.println("连接成功");
		}
}
