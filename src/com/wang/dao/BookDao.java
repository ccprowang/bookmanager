package com.wang.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.wang.model.Book;
/**
 * ͼ�������
 * @author yefeng
 *
 */
public class BookDao {
	
	/**
	 * ͼ�������
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
		pstmt.setString(1, book.getBookName());//�û�������������
		pstmt.setString(2,book.getAuthor());
		pstmt.setString(3,book.getisbn());
		pstmt.setFloat(4,book.getPrice());
		pstmt.setString(5,book.getBookTypeId());
		pstmt.setString(6,book.getBookDesc());
		pstmt.setInt(7,book.getNumber());
		return pstmt.executeUpdate();//ִ��
  }
  /**
	 * ͼ������ѯ����
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public  ResultSet list(Connection con,Book book)throws Exception{
		StringBuffer sql=new StringBuffer("select * from t_book");//���ÿɱ���ַ�������Ϊ�����ѯ�Ƕ�̬��
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
		PreparedStatement pstmt=con.prepareStatement(sql.toString().replaceFirst("and", "where"));//�������andƴ�ӣ��ѵ�һ��andת��Ϊwhere
		//System.out.println(sql);
		return pstmt.executeQuery();//���ؽ����
	}
	/**
	 *ͼ�����ɾ��
	 * @param con
	 * @param booktype
	 * @return
	 * @throws SQLException
	 */
	public int delete(Connection con,String id) throws SQLException
	{
		String sql="delete from t_book where isbn=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);//�û�������������
		return pstmt.executeUpdate();//ִ��
	}

	/**
	 * ͼ���޸Ĳ���
	 * @throws SQLException 
	 */
	public int update(Connection con,Book book) throws SQLException
	{
		String sql="update t_book set bookName=?,author=?,price=?,bookTypeId=?,bookDesc=?,number=? where isbn=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());//�û�������������,���ø���sql
		pstmt.setString(2,book.getAuthor());
		pstmt.setFloat(3, book.getPrice());
		pstmt.setString(4, book.getBookTypeId());
		pstmt.setString(5, book.getBookDesc());
		pstmt.setInt(6, book.getNumber());
		pstmt.setString(7, book.getisbn());
		return pstmt.executeUpdate();//ִ��
	}
	/*
	 *��ѯͼ�����id
	 */
	public  ResultSet searchbooktypeid(Connection con)throws Exception{
		String sql="select bookTypeName from t_booktype";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();//���ؽ����
	}
}
