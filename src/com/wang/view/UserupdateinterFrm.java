package com.wang.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.wang.dao.UserDao;
import com.wang.model.User;
import com.wang.util.Dbutil;

public class UserupdateinterFrm extends JInternalFrame {
	private Dbutil dbutil=new Dbutil();//数据库连接操作
	private UserDao userdao=new UserDao();//数据库类别操作
	private JTextField useridTxt;
	private JTextField usernameTxt;
	private JTextField usersexTxt;
	private JTextField userageTxt;
	private JComboBox usertypeTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserupdateinterFrm frame = new UserupdateinterFrm();
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
	public UserupdateinterFrm() {
		setTitle("\u8BFB\u8005\u4FE1\u606F\u4FEE\u6539");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 392, 224);
		
		JLabel label = new JLabel("\u8BFB\u4E66\u8BC1\u53F7");
		
		useridTxt = new JTextField();
		useridTxt.setEnabled(false);
		useridTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		
		usernameTxt = new JTextField();
		usernameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		
		JLabel label_3 = new JLabel("\u8BFB\u4E66\u8BC1\u72B6\u6001");
		
		usersexTxt = new JTextField();
		usersexTxt.setColumns(10);
		
		userageTxt = new JTextField();
		userageTxt.setEditable(false);
		userageTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u8BFB\u8005\u7C7B\u522B");
		
		 usertypeTxt = new JComboBox();
		 usertypeTxt.setModel(new DefaultComboBoxModel(new String[] {"\u666E\u901A\u8BFB\u8005", "\u7BA1\u7406\u5458"}));
		/*
		 * 点击修改按钮
		 */
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatabottonAction(e);
			}
		});
		/*
		 * 取消
		 */
		JButton button = new JButton("\u53D6\u6D88");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canclebottouAction(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(useridTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_3)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(usersexTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(userageTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(53, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
									.addComponent(button)
									.addGap(55))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_4)
									.addGap(18)
									.addComponent(usertypeTxt, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(0, Short.MAX_VALUE))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(useridTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(usersexTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(userageTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(usertypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		//填充界面
		this.fileevalues(new User());
		
	}
	/*
	 * 点击取消按钮重新刷新界面
	 */
	protected void canclebottouAction(ActionEvent e) {
		this.fileevalues(new User());
		
	}

	/*
	 * 点击修改按钮 方法
	 */
	private void updatabottonAction(ActionEvent e) {
		int result=JOptionPane.showConfirmDialog(null, "是否修改");
		if(result!=0)//如果不是
		{
			return;
		}
		String userid=useridTxt.getText();
		String username=usernameTxt.getText();
		String userage=userageTxt.getText();
		String usersex=usersexTxt.getText();
		String readertype=usertypeTxt.getSelectedItem().toString();
		User user=new User(Integer.parseInt(userid),username,userage,usersex,readertype);
		Connection con=null;
		try {
				con=dbutil.getCon();
				int n=userdao.update(con, user);
				if(n==1)
				{
					
					JOptionPane.showMessageDialog(null, "修改成功");
					this.fileevalues(new User());
				}else
				{
					JOptionPane.showMessageDialog(null, "修改失败");
				}	
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally
		{
			try {
				dbutil.closecon(con);
			} catch (Exception e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			}
		}
	}
		


	/*
	 * 给界面填充数据方法
	 */
	public void fileevalues(User user) 
	{

		Connection con=null;
		try {
		 	con=dbutil.getCon();
			ResultSet rs=userdao.list(con, user);//
			//System.out.println(rs.toString());
			while(rs.next())
			{
			useridTxt.setText(rs.getString("id"));
			usernameTxt.setText(rs.getString("username"));
			String a=rs.getString("password");
			userageTxt.setText(rs.getString("status"));
			usersexTxt.setText(rs.getString("sex"));
			String typeidtxt1=rs.getString("readertype");
			if(typeidtxt1.equals("管理员"))
			{
				usertypeTxt.setSelectedIndex(1);
				usertypeTxt.setEnabled(true);
			}
			else
			{
				usertypeTxt.setSelectedIndex(0);
				usertypeTxt.setEnabled(false);
			}
			}
				
	} catch (Exception e1) {
			e1.printStackTrace();
	}finally
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
