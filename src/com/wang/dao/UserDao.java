package com.wang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wang.model.User;
import com.wang.util.StringUtil;
/**
 * 用户登录验证界面
 * @author yefeng
 *
 */
public class UserDao {
	public User login(Connection con,User user)throws Exception
	{
		User resultuser=null;
		String sql="select * from t_user where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUsernamee());//用户界面传过来的数据
		pstmt.setString(2,user.getPwd());
		ResultSet rs=pstmt.executeQuery();//返回结果集
		if(rs.next())
		{
			resultuser=new User();//设置返回的结果集
			resultuser.setId(rs.getInt("id"));
			resultuser.setUsernamee(rs.getString("userName"));
			resultuser.setPwd(rs.getString("password"));
			StringUtil.S_id=rs.getInt("id");
			StringUtil.readertype=rs.getString("readertype");
		}
		return resultuser;
	}
	/**
	 * 用户添加（必须要具有权限才能添加）
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,User user)throws Exception
	{
		
		String sql="insert into t_user values(null,?,?,'有效',?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,user.getUsernamee());//用户传过来的数据
		pstmt.setString(2,user.getPwd());
		//pstmt.setString(3,user.getStatus());
		pstmt.setString(3,user.getSex());
		pstmt.setString(4,user.getReadertype());
		return pstmt.executeUpdate();//执行
	}
	/**
	 * 用户类别查询集合
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public  ResultSet list(Connection con,User user)throws Exception{
		StringBuffer sql=new StringBuffer("select * from t_user");//设置可变的字符集，因为这个查询是动态的
		if(StringUtil.isnotempty(user.getUsernamee()))
		{
			sql.append(" and username like '%"+StringUtil.S_username+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sql.toString().replaceFirst("and", "where"));//后面会有and拼接，把第一个and转化为where
		return pstmt.executeQuery();//返回结果集
	}
	/**
	 * 用户类别查询集合
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public  ResultSet list2(Connection con,User user)throws Exception{
		String sql="select * from t_user where username=?";//设置可变的字符集，因为这个查询是动态的
		PreparedStatement pstmt=con.prepareStatement(sql);//后面会有and拼接，把第一个and转化为where
		pstmt.setString(1,user.getUsernamee());//用户传过来的数据
		return pstmt.executeQuery();//返回结果集
	}
	/**
	 *密码修改操作
	 * @param con
	 * @param booktype
	 * @return
	 * @throws SQLException
	 */
	public int passwordupdate(Connection con,String mypassword) throws SQLException
	{
		String sql="update t_user set password=? where username=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, mypassword);//用户传过来的数据,设置给该sql
		pstmt.setString(2, StringUtil.S_username);
		return pstmt.executeUpdate();//执行
	}

	/**
	 * 用户信息修改操作
	 * @throws SQLException 
	 */
	public int update(Connection con,User user) throws SQLException
	{
		String sql="update t_user set userName=?,status=?,sex=?,readertype=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUsernamee());//用户传过来的数据,设置给该sql
		pstmt.setString(2,user.getStatus());
		pstmt.setString(3,user.getSex());
		pstmt.setString(4,user.getReadertype());
		pstmt.setInt(5, user.getId());
		return pstmt.executeUpdate();//执行
	}
	/*
	 * 用户挂失、取消挂失、补办
	 */
	public int usermessageop(Connection con,String str,User user ) throws SQLException
	{
		String sql="update t_user set status=? where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		//用户传过来的数据,设置给该sql
		pstmt.setString(1,str);
		pstmt.setString(2, user.getUsernamee());
		pstmt.setString(3, user.getPwd());
		return pstmt.executeUpdate();//执行
	}
	/*
	 * 用户注销
	 */
	public int deletemessageop(Connection con,User user ) throws SQLException
	{
		String sql="delete from t_user where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		//用户传过来的数据,设置给该sql
		pstmt.setString(1, user.getUsernamee());
		pstmt.setString(2, user.getPwd());
		return pstmt.executeUpdate();//执行
	}
}
