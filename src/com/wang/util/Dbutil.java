package com.wang.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutil {
	//localhost   121.36.1.2
		private  String url="jdbc:mysql://localhost/db_book?useUnicode=true&characterEncoding=utf8";//���ݿ����ӵ�ַ
		private String dbuserName="root";
		private String dbPassword="123456";//����123456
		private String jdbcname="com.mysql.jdbc.Driver";//��������
		/**
		 * ��ȡ���ݿ�����
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
		 * �ر�����
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
			System.out.println("���ӳɹ�");
		}
}
