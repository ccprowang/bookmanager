package com.wang.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.wang.model.Book;
/**
 * 图书操作类
 * @author yefeng
 *
 */
public class BookDao {
	
	/**
	 * 图书添加类
	 * @param con
	 * @param book
	 * @return
	 * @throws SQLException
	 */
  public int add(Connection con,Book book) throws SQLException
  {
	  	String sql="insert into t_book(id,bookName,author,isbn,price,booktypeid,bookdesc,number) values(null,?,?,?,?,?,?,?)";
	  	System.out.println(book.toString());
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());//用户传过来的数据
		pstmt.setString(2,book.getAuthor());
		pstmt.setString(3,book.getisbn());
		pstmt.setFloat(4,book.getPrice());
		pstmt.setString(5,book.getBookTypeId());
		pstmt.setString(6,book.getBookDesc());
		pstmt.setInt(7,book.getNumber());
		return pstmt.executeUpdate();//执行
  }
  /**
	 * 图书类别查询集合
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public  ResultSet list(Connection con,Book book)throws Exception{
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
	 *图书类别删除
	 * @param con
	 * @param booktype
	 * @return
	 * @throws SQLException
	 */
	public int delete(Connection con,String id) throws SQLException
	{
		String sql="delete from t_book where isbn=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);//用户传过来的数据
		return pstmt.executeUpdate();//执行
	}

	/**
	 * 图书修改操作
	 * @throws SQLException 
	 */
	public int update(Connection con,Book book) throws SQLException
	{
		String sql="update t_book set bookName=?,author=?,price=?,bookTypeId=?,bookDesc=?,number=? where isbn=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());//用户传过来的数据,设置给该sql
		pstmt.setString(2,book.getAuthor());
		pstmt.setFloat(3, book.getPrice());
		pstmt.setString(4, book.getBookTypeId());
		pstmt.setString(5, book.getBookDesc());
		pstmt.setInt(6, book.getNumber());
		pstmt.setString(7, book.getisbn());
		return pstmt.executeUpdate();//执行
	}
	/*
	 *查询图书类别id
	 */
	public  ResultSet searchbooktypeid(Connection con)throws Exception{
		String sql="select bookTypeName from t_booktype";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();//返回结果集
	}
}
