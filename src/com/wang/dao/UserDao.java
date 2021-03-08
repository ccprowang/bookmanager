package com.wang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wang.model.User;
import com.wang.util.StringUtil;
/**
 * �û���¼��֤����
 * @author yefeng
 *
 */
public class UserDao {
	public User login(Connection con,User user)throws Exception
	{
		User resultuser=null;
		String sql="select * from t_user where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUsernamee());//�û����洫����������
		pstmt.setString(2,user.getPwd());
		ResultSet rs=pstmt.executeQuery();//���ؽ����
		if(rs.next())
		{
			resultuser=new User();//���÷��صĽ����
			resultuser.setId(rs.getInt("id"));
			resultuser.setUsernamee(rs.getString("userName"));
			resultuser.setPwd(rs.getString("password"));
			StringUtil.S_id=rs.getInt("id");
			StringUtil.readertype=rs.getString("readertype");
		}
		return resultuser;
	}
	/**
	 * �û���ӣ�����Ҫ����Ȩ�޲�����ӣ�
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,User user)throws Exception
	{
		
		String sql="insert into t_user values(null,?,?,'��Ч',?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,user.getUsernamee());//�û�������������
		pstmt.setString(2,user.getPwd());
		//pstmt.setString(3,user.getStatus());
		pstmt.setString(3,user.getSex());
		pstmt.setString(4,user.getReadertype());
		return pstmt.executeUpdate();//ִ��
	}
	/**
	 * �û�����ѯ����
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public  ResultSet list(Connection con,User user)throws Exception{
		StringBuffer sql=new StringBuffer("select * from t_user");//���ÿɱ���ַ�������Ϊ�����ѯ�Ƕ�̬��
		if(StringUtil.isnotempty(user.getUsernamee()))
		{
			sql.append(" and username like '%"+StringUtil.S_username+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sql.toString().replaceFirst("and", "where"));//�������andƴ�ӣ��ѵ�һ��andת��Ϊwhere
		return pstmt.executeQuery();//���ؽ����
	}
	/**
	 * �û�����ѯ����
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public  ResultSet list2(Connection con,User user)throws Exception{
		String sql="select * from t_user where username=?";//���ÿɱ���ַ�������Ϊ�����ѯ�Ƕ�̬��
		PreparedStatement pstmt=con.prepareStatement(sql);//�������andƴ�ӣ��ѵ�һ��andת��Ϊwhere
		pstmt.setString(1,user.getUsernamee());//�û�������������
		return pstmt.executeQuery();//���ؽ����
	}
	/**
	 *�����޸Ĳ���
	 * @param con
	 * @param booktype
	 * @return
	 * @throws SQLException
	 */
	public int passwordupdate(Connection con,String mypassword) throws SQLException
	{
		String sql="update t_user set password=? where username=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, mypassword);//�û�������������,���ø���sql
		pstmt.setString(2, StringUtil.S_username);
		return pstmt.executeUpdate();//ִ��
	}

	/**
	 * �û���Ϣ�޸Ĳ���
	 * @throws SQLException 
	 */
	public int update(Connection con,User user) throws SQLException
	{
		String sql="update t_user set userName=?,status=?,sex=?,readertype=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUsernamee());//�û�������������,���ø���sql
		pstmt.setString(2,user.getStatus());
		pstmt.setString(3,user.getSex());
		pstmt.setString(4,user.getReadertype());
		pstmt.setInt(5, user.getId());
		return pstmt.executeUpdate();//ִ��
	}
	/*
	 * �û���ʧ��ȡ����ʧ������
	 */
	public int usermessageop(Connection con,String str,User user ) throws SQLException
	{
		String sql="update t_user set status=? where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		//�û�������������,���ø���sql
		pstmt.setString(1,str);
		pstmt.setString(2, user.getUsernamee());
		pstmt.setString(3, user.getPwd());
		return pstmt.executeUpdate();//ִ��
	}
	/*
	 * �û�ע��
	 */
	public int deletemessageop(Connection con,User user ) throws SQLException
	{
		String sql="delete from t_user where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		//�û�������������,���ø���sql
		pstmt.setString(1, user.getUsernamee());
		pstmt.setString(2, user.getPwd());
		return pstmt.executeUpdate();//ִ��
	}
}
