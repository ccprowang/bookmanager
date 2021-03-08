package com.wang.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.wang.dao.UserDao;
import com.wang.util.Dbutil;
import com.wang.util.StringUtil;
import javax.swing.JPasswordField;

public class PasswordFrm extends JInternalFrame {
	private Dbutil dbutil=new Dbutil();//数据库连接操作
	private UserDao userdao=new UserDao();//数据库类别操作
	private JPasswordField oldpasswordTxt;
	private JPasswordField newpasswordTxt;
	private JPasswordField certernpasswordTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordFrm frame = new PasswordFrm();
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
	public PasswordFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5BC6\u7801\u4FEE\u6539");
		setBounds(100, 100, 319, 260);
		
		JLabel label = new JLabel("\u65E7\u5BC6\u7801");
		
		JLabel lblNewLabel = new JLabel("\u65B0\u5BC6\u7801");
		
		JLabel label_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		/**
		 * 密码修改确认
		 */
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canclebottonAction(e);
			}
		});
		/*
		 * 取消按钮点击
		 */
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canclebottonpressAction(e);
			}
		});
		
		oldpasswordTxt = new JPasswordField();
		
		newpasswordTxt = new JPasswordField();
		
		certernpasswordTxt = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(146, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(56)
					.addComponent(button_1)
					.addGap(35))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_1)
						.addComponent(lblNewLabel)
						.addComponent(label))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(certernpasswordTxt)
						.addComponent(newpasswordTxt)
						.addComponent(oldpasswordTxt, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(oldpasswordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(newpasswordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(certernpasswordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	/**
	 * 密码修改确认按钮
	 */
	protected void canclebottonAction(ActionEvent e) {
		int result=JOptionPane.showConfirmDialog(null, "是否修改");
		if(result!=0)//如果不是
		{
			return;
		}
		String passwordtxt=new String(this.oldpasswordTxt.getPassword());
		String newpasswordtxt=new String(this.newpasswordTxt.getPassword());
		String canclepasswodtxt=new String(this.certernpasswordTxt.getPassword());
	/*	System.out.println(StringUtil.S_id);
		System.out.println(StringUtil.S_password);
		System.out.println(StringUtil.S_username);*/
		Connection con=null;
		if(!passwordtxt.equals(StringUtil.S_password))
		{
			JOptionPane.showMessageDialog(null, "旧密码错误，请重新输入");
			this.resultvalues();
		}
		else
		{
			if(!newpasswordtxt.equals(canclepasswodtxt))
			{
				JOptionPane.showMessageDialog(null, "新密码与旧密码不一致，请重新输入");
			}
			else
			{
				try {
					con=dbutil.getCon();
					int n=userdao.passwordupdate(con, newpasswordtxt);
					if(n==1)
					{
						JOptionPane.showMessageDialog(null, "修改成功");
						this.resultvalues();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "修改失败");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "修改失败");
				}finally
				{
					try {
						dbutil.closecon(con);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		}
		
	}

	/*
	 * 取消具体实现
	 * 清空数据
	 */
	protected void canclebottonpressAction(ActionEvent e) {
		this.resultvalues();
		
	}
	private void resultvalues()
	{
		oldpasswordTxt.setText("");
		newpasswordTxt.setText("");
		certernpasswordTxt.setText("");
	}
}
