package com.wang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wang.model.Book;
import com.wang.model.Borrow;
import com.wang.util.StringUtil;


		/*
		 * 图书借阅操作
	 	*/
		public class BorrowDao {
		/**
		 * 可借图书类别查询集合
		 * @param con
		 * @param booktype
		 * @return
		 * @throws Exception
		 */
		public  ResultSet listborrow(Connection con,Book book)throws Exception{
				StringBuffer sql=new StringBuffer("select * from t_book");//设置可变的字符集，因为这个查询是动态的
				//if(StringUtil.isnotempty(book.getBookName()))
				if(book.getBookName()!=null)
				{
					sql.append(" and bookName like '%"+book.getBookName()+"%'");
				}
				else if (book.getisbn()!=null)
				{
					sql.append(" and isbn like '%"+book.getisbn()+"%'");
				}
				else
				{
					sql.append(" and author like '%"+book.getAuthor()+"%'");
				}
				PreparedStatement pstmt=con.prepareStatement(sql.toString().replaceFirst("and", "where"));//后面会有and拼接，把第一个and转化为where
				//System.out.println(sql);
				return pstmt.executeQuery();//返回结果集
			
		}
		/**
		 * 已借图书类别查询集合
		 * @param con
		 * @param booktype
		 * @return
		 * @throws Exception
		 */
		public  ResultSet listreturn(Connection con,Borrow borrow)throws Exception{	
				StringBuffer sql=new StringBuffer("select * from t_borrow");//设置可变的字符集，因为这个查询是动态的
				sql.append(" where userid="+borrow.getUserid()+"");
				PreparedStatement pstmt=con.prepareStatement(sql.toString());//后面会有and拼接，把第一个and转化为where
				
				return pstmt.executeQuery();//返回结果集
		}
		
		/*
		 * 已知图书id求图书名
		 */
		public ResultSet serchbookname(Connection con,int str) throws SQLException
		{
			StringBuffer sql=new StringBuffer("select * from t_book");
			if(str!=0)
			{
				sql.append(" where isbn="+str+"");
			}
			PreparedStatement pstmt=con.prepareStatement(sql.toString());//后面会有and拼接，把第一个and转化为where
			return pstmt.executeQuery();//返回结果集
		}
		/*
		 * 借书操作
		 */
		public int borrowbook(Connection con,Borrow borrow) throws SQLException
		{
			String sql="insert into t_borrow values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, StringUtil.S_id);//用户传过来的数据,设置给该sql
			pstmt.setInt(2,StringUtil.B_id);
			pstmt.setDate(3, borrow.getBorrowdate());
			pstmt.setDate(4, borrow.getReturnDate());
			
			String sql2="update t_book set number=number-1 where isbn=?";//更新数据
			PreparedStatement pstmt2=con.prepareStatement(sql2);
			pstmt2.setInt(1,StringUtil.B_id);
			int n=pstmt2.executeUpdate();//这个返回值没有返回
			return pstmt.executeUpdate();//执行
		}
		/*
		 * 还书操作
		 */
		public int returnbook(Connection con,int userid,int bookid) throws SQLException
		{
			String sql1="delete from t_borrow where userid=? and bookid=?";//从borrow表删除
			PreparedStatement pstmt1=con.prepareStatement(sql1);
			pstmt1.setInt(1, userid);
			pstmt1.setInt(2,bookid);
			//System.out.println(sql1);
			String sql2="update t_book set number=number+1 where isbn=?";//更新数据
			PreparedStatement pstmt2=con.prepareStatement(sql2);
			pstmt2.setInt(1, bookid);
			int n=pstmt2.executeUpdate();//这个返回值没有返回
			return pstmt1.executeUpdate();//执行
		}
		/*
		 * 续借操作
		 */
		public int renewbook(Connection con,Borrow borrow) throws SQLException
		{
			String sql="update t_borrow set borrowdata=?,returndata=? where userid=? and bookid=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setDate(1, borrow.getBorrowdate());
			pstmt.setDate(2, borrow.getReturnDate());
			pstmt.setInt(3, StringUtil.S_id);//用户传过来的数据,设置给该sql
			pstmt.setInt(4,StringUtil.B_id);
			return pstmt.executeUpdate();//执行
		}
		
}
