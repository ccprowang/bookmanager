package com.wang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wang.model.BookType;
import com.wang.util.StringUtil;

/**
 * ͼ������������
 * @author yefeng
 *
 */
public class bookTypeDao {
	
	/**
	 * ͼ��������
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,BookType booktype)throws Exception
	{
		
		String sql="insert into t_booktype values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, booktype.getBookTypeName());//�û�������������
		pstmt.setString(2,booktype.getBookTypeDesc());
		return pstmt.executeUpdate();//ִ��
	}
	/**
	 * ͼ������ѯ����
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public  ResultSet list(Connection con,BookType booktype)throws Exception{
		StringBuffer sql=new StringBuffer("select * from t_booktype");//���ÿɱ���ַ�������Ϊ�����ѯ�Ƕ�̬��
		if(StringUtil.isnotempty(booktype.getBookTypeName()))
		{
			sql.append(" and bookTypeName like '%"+booktype.getBookTypeName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sql.toString().replaceFirst("and", "where"));//�������andƴ�ӣ��ѵ�һ��andת��Ϊwhere
		return pstmt.executeQuery();//���ؽ����
	}
	/**
	 * ����list
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
	 *ͼ�����ɾ��
	 * @param con
	 * @param booktype
	 * @return
	 * @throws SQLException
	 */
	public int delete(Connection con,String id) throws SQLException
	{
		String sql="delete from t_booktype where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);//�û�������������
		return pstmt.executeUpdate();//ִ��
	}

	/**
	 * ͼ���޸Ĳ���
	 * @throws SQLException 
	 */
	public int update(Connection con,BookType booktype) throws SQLException
	{
		String sql="update t_booktype set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, booktype.getBookTypeName());//�û�������������,���ø���sql
		pstmt.setString(2,booktype.getBookTypeDesc());
		pstmt.setInt(3, booktype.getId());
		return pstmt.executeUpdate();//ִ��
	}
	
	
	
}
