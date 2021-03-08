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
	private Dbutil dbutil=new Dbutil();//���ݿ����Ӳ���
	private UserDao userdao=new UserDao();//���ݿ�������
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
		 * �����޸�ȷ��
		 */
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canclebottonAction(e);
			}
		});
		/*
		 * ȡ����ť���
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
	 * �����޸�ȷ�ϰ�ť
	 */
	protected void canclebottonAction(ActionEvent e) {
		int result=JOptionPane.showConfirmDialog(null, "�Ƿ��޸�");
		if(result!=0)//�������
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
			JOptionPane.showMessageDialog(null, "�������������������");
			this.resultvalues();
		}
		else
		{
			if(!newpasswordtxt.equals(canclepasswodtxt))
			{
				JOptionPane.showMessageDialog(null, "������������벻һ�£�����������");
			}
			else
			{
				try {
					con=dbutil.getCon();
					int n=userdao.passwordupdate(con, newpasswordtxt);
					if(n==1)
					{
						JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
						this.resultvalues();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "�޸�ʧ��");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "�޸�ʧ��");
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
	 * ȡ������ʵ��
	 * �������
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
