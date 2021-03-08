package com.wang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wang.model.BookType;
import com.wang.util.StringUtil;

/**
 * 图书类别操作方法
 * @author yefeng
 *
 */
public class bookTypeDao {
	
	/**
	 * 图书类别添加
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,BookType booktype)throws Exception
	{
		
		String sql="insert into t_booktype values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, booktype.getBookTypeName());//用户传过来的数据
		pstmt.setString(2,booktype.getBookTypeDesc());
		return pstmt.executeUpdate();//执行
	}
	/**
	 * 图书类别查询集合
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public  ResultSet list(Connection con,BookType booktype)throws Exception{
		StringBuffer sql=new StringBuffer("select * from t_booktype");//设置可变的字符集，因为这个查询是动态的
		if(StringUtil.isnotempty(booktype.getBookTypeName()))
		{
			sql.append(" and bookTypeName like '%"+booktype.getBookTypeName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sql.toString().replaceFirst("and", "where"));//后面会有and拼接，把第一个and转化为where
		return pstmt.executeQuery();//返回结果集
	}
	/**
	 * 测试list
	 * @throws SQLException 
	 */
	/*public static void main(String[] args) throws Exception {
		
		bookTypeDao bookdao=new bookTypeDao();
		BookType booktype=new BookType("sads","sad");
		Dbutil dbutil=new Dbutil();
		Connection con=dbutil.getCon();
		ResultSet rest=bookdao.list(con,booktype);
		System.out.println(rest.toString());
	}*/
	/**
	 *图书类别删除
	 * @param con
	 * @param booktype
	 * @return
	 * @throws SQLException
	 */
	public int delete(Connection con,String id) throws SQLException
	{
		String sql="delete from t_booktype where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);//用户传过来的数据
		return pstmt.executeUpdate();//执行
	}

	/**
	 * 图书修改操作
	 * @throws SQLException 
	 */
	public int update(Connection con,BookType booktype) throws SQLException
	{
		String sql="update t_booktype set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, booktype.getBookTypeName());//用户传过来的数据,设置给该sql
		pstmt.setString(2,booktype.getBookTypeDesc());
		pstmt.setInt(3, booktype.getId());
		return pstmt.executeUpdate();//执行
	}
	
	
	
}
