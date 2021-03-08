package com.wang.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.wang.dao.UserDao;
import com.wang.model.User;
import com.wang.util.Dbutil;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

public class UseraddinterFrm extends JInternalFrame {
	private JTextField usernametxt;
	private JPasswordField passwordTxt;
	private JPasswordField rpasswordTxt;
   private JComboBox CBusertypeTxt;
   private JComboBox CBsexTxt;
   private Dbutil dbutil=new Dbutil();//数据库连接操作
   private UserDao userdao=new UserDao();//数据库类别操作
   private JTextField oldusernameTxt;
   private JPasswordField oldpasswordTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UseraddinterFrm frame = new UseraddinterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UseraddinterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u8BFB\u4E66\u8BC1\u7BA1\u7406");
		setBounds(100, 100, 539, 322);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setToolTipText("");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel label_8 = new JLabel("\u6CE8\u518C\u754C\u9762");
		
		JLabel label_9 = new JLabel("\u8BFB\u4E66\u8BC1\u7BA1\u7406\u754C\u9762");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_8)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_9)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_8)
						.addComponent(label_9))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		
		usernametxt = new JTextField();
		usernametxt.setColumns(10);
		
		JLabel label = new JLabel("\u5BC6\u7801");
		
		passwordTxt = new JPasswordField();
		
		JLabel label_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		
		rpasswordTxt = new JPasswordField();
		
		JLabel label_3 = new JLabel("\u6027\u522B");
		
		CBsexTxt = new JComboBox();
		CBsexTxt.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9", "\u7537", "\u5973"}));
		CBsexTxt.setToolTipText("");
		
		JLabel lblNewLabel_1 = new JLabel("\u8BFB\u8005\u7C7B\u578B");
		
		CBusertypeTxt = new JComboBox();
		CBusertypeTxt.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9", "\u5B66\u751F", "\u8001\u5E08"}));
		CBusertypeTxt.setToolTipText("");
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addbuttonAction(e);
			}
		});
		JButton button_1 = new JButton("\u91CD\u7F6E\u754C\u9762");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultbuttonAction(e);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)
								.addComponent(label)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(usernametxt, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
								.addComponent(rpasswordTxt, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
								.addComponent(passwordTxt)
								.addComponent(CBsexTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(CBusertypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button_1)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(rpasswordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(CBsexTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(CBusertypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		JButton button_2 = new JButton("\u89E3\u9664\u6302\u5931");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findbuttonpressedAction(e);
			}
		});
		JButton btnNewButton = new JButton("\u6302\u5931");
		JButton button_3 = new JButton("\u6CE8\u9500");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteuserbuttonpressedAction(e);
			}
		});
		JButton button_4 = new JButton("\u8865\u529E");
		
		JLabel label_4 = new JLabel("\u7528\u6237\u540D");
		
		oldusernameTxt = new JTextField();
		oldusernameTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u5BC6\u7801");
		
		oldpasswordTxt = new JPasswordField();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4)
								.addComponent(label_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(oldpasswordTxt, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
								.addComponent(oldusernameTxt, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(button_3)
								.addComponent(btnNewButton))
							.addGap(38)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(button_2)
								.addComponent(button_4))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(oldusernameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(oldpasswordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_3)
						.addComponent(button_4))
					.addGap(105))
		);
		panel.setLayout(gl_panel);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reissuebuttonpressedAction(e);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lossbuttonpressedAction(e);
			}
		});
		getContentPane().setLayout(groupLayout);

	}
	/*
	 * 补办事件处理
	 */
	protected void reissuebuttonpressedAction(ActionEvent e) {
		int result=JOptionPane.showConfirmDialog(null, "是否补办");
		if(result!=0)//如果不是
		{
			return;
		}
		String oldusername=oldusernameTxt.getText();
		String oldpassword=oldpasswordTxt.getText();
		if(oldusername.equals("")||oldpassword.equals(""))
		{
			JOptionPane.showMessageDialog(null, "用户名密码不能为空");
		    return;
		}
		User user=new User(oldusername,oldpassword);
		Connection con=null;
		Connection con2=null;
		try {
			con=dbutil.getCon();
			ResultSet rs=userdao.list2(con, user);//
			while(rs.next())
			{
				String str3 =rs.getString("status");
				//System.out.println(str3);
				if(str3.equals("有效"))
				{
					JOptionPane.showMessageDialog(null, "读书证未挂失无需补办");
					 return;
				}
				
			}
			
			int n=userdao.usermessageop(con,"有效", user);
			if(n==0)
			{
				JOptionPane.showMessageDialog(null, "用户名不存在或密码错误");
			    return;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "补办成功");
				resultview();
			    return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
	}

	/*
	 * 注销事件处理
	 */
	protected void deleteuserbuttonpressedAction(ActionEvent e) {
		int result=JOptionPane.showConfirmDialog(null, "是否注销");
		if(result!=0)//如果不是
		{
			return;
		}
		String oldusername=oldusernameTxt.getText();
		String oldpassword=oldpasswordTxt.getText();
		if(oldusername.equals("")||oldpassword.equals(""))
		{
			JOptionPane.showMessageDialog(null, "用户名密码不能为空");
		    return;
		}
		User user=new User(oldusername,oldpassword);
		Connection con=null;
		try {
			con=dbutil.getCon();
			int n=userdao.deletemessageop(con, user);
			if(n==0)
			{
				JOptionPane.showMessageDialog(null, "用户名不存在或密码错误");
			    return;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "注销成功");
				resultview();
			    return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}

	/*
	 * 解除挂失事件处理
	 */
	protected void findbuttonpressedAction(ActionEvent e) {
		int result=JOptionPane.showConfirmDialog(null, "是否取消挂失");
		if(result!=0)//如果不是
		{
			return;
		}
		String oldusername=oldusernameTxt.getText();
		String oldpassword=oldpasswordTxt.getText();
		if(oldusername.equals("")||oldpassword.equals(""))
		{
			JOptionPane.showMessageDialog(null, "用户名密码不能为空");
		    return;
		}
		User user=new User(oldusername,oldpassword);
		Connection con=null;
		try {
			con=dbutil.getCon();
			ResultSet rs=userdao.list2(con, user);//
			while(rs.next())
			{
				String str3 =rs.getString("status");
				System.out.println(str3);
				if(str3.equals("有效"))
				{
					JOptionPane.showMessageDialog(null, "读书证未挂失");
					 return;
				}
				
			}
			int n=userdao.usermessageop(con,"有效", user);
			if(n==0)
			{
				JOptionPane.showMessageDialog(null, "用户名不存在或密码错误");
			    return;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "解除挂失成功");
				resultview();
			    return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
	}

	/*
	 * 挂失事件处理
	 */
	protected void lossbuttonpressedAction(ActionEvent e) {
		int result=JOptionPane.showConfirmDialog(null, "是否挂失");
		if(result!=0)//如果不是
		{
			return;
		}
		String oldusername=oldusernameTxt.getText();
		String oldpassword=oldpasswordTxt.getText();
		if(oldusername.equals("")||oldpassword.equals(""))
		{
			JOptionPane.showMessageDialog(null, "用户名密码不能为空");
		    return;
		}
		User user=new User(oldusername,oldpassword);
		Connection con=null;
		try {
			con=dbutil.getCon();
			ResultSet rs=userdao.list2(con, user);//
			while(rs.next())
			{
				String str3 =rs.getString("status");
				System.out.println(str3);
				if(str3.equals("挂失"))
				{
					JOptionPane.showMessageDialog(null, "读书证已挂失请勿重复操作");
					 return;
				}
				
			}
			int n=userdao.usermessageop(con,"挂失", user);
			if(n==0)
			{
				JOptionPane.showMessageDialog(null, "用户名不存在或密码错误");
			    return;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "挂失成功");
				resultview();
			    return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}

	/*
	 * 重置按钮点击
	 */
protected void resultbuttonAction(ActionEvent e) {		
		this.resultview();
	}
/*
 * 重置界面
 */
private void resultview()
{
	usernametxt.setText("");
	passwordTxt.setText("");
	rpasswordTxt.setText("");
	this.CBsexTxt.setSelectedIndex(0);
	this.CBusertypeTxt.setSelectedIndex(0);//设置下拉框默认选项
	oldpasswordTxt.setText("");
	oldusernameTxt.setText("");
}
/*
 * 注册按钮点击
 */
	protected void addbuttonAction(ActionEvent e) {
		
		
		int result=JOptionPane.showConfirmDialog(null, "是否注册");
		if(result!=0)//如果不是
		{
			return;
		}
		String username=usernametxt.getText();
		String userpassword=passwordTxt.getText();
		String ruserpassword=rpasswordTxt.getText();
		//String userstatus=userstatusTxt.getText();
		if(userpassword.equals("")||username.equals(""))
		{
			JOptionPane.showMessageDialog(null, "用户名密码不能为空");
			resultview();
		    return;
		}
		if(!ruserpassword.equals(userpassword))
		{
			JOptionPane.showMessageDialog(null, "密码输入不一致，请重新输入");
		    return;
		}
		String usersex=CBsexTxt.getSelectedItem().toString();
		String usertype=CBusertypeTxt.getSelectedItem().toString();
		if(usersex.equals("请选择"))
		{
			JOptionPane.showMessageDialog(null, "请选择读者性别");
		    return;
		}
		if(usertype.equals("请选择"))
		{
			JOptionPane.showMessageDialog(null, "请选择读者类型");
		    return;
		}
		//出初始化user
		User user=new User(username,userpassword,usersex,usertype);
		Connection con=null;
		try {
				con=dbutil.getCon();
				int n=userdao.add(con, user);
				if(n==1)
				{
					JOptionPane.showMessageDialog(null, "注册成功");
					this.resultview();
				}else
				{
					JOptionPane.showMessageDialog(null, "注册失败");
				}	
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		finally
		{
			try {
				dbutil.closecon(con);
			} catch (Exception e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			}
		}
		
	}
}
