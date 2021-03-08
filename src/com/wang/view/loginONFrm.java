package com.wang.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.wang.dao.UserDao;
import com.wang.model.User;
import com.wang.util.Dbutil;
import com.wang.util.StringUtil;



public class loginONFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;

	private Dbutil dbutil=new Dbutil();
	private UserDao userdao=new UserDao();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginONFrm frame = new loginONFrm();
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
	public loginONFrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(loginONFrm.class.getResource("/image/logo.png")));
		//�ı�ϵͳĬ������
		Font font =new Font("Dialog",Font.PLAIN,12);
		java.util.Enumeration keys=UIManager.getDefaults().keys();
		while(keys.hasMoreElements())
		{
			Object key=keys.nextElement();
			Object value=UIManager.get(key);
			if(value instanceof javax.swing.plaf.FontUIResource)
			{
				UIManager.put(key, font);
			}
		}
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage(loginONFrm.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")));
		setResizable(false);
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 19));
		lblNewLabel.setIcon(new ImageIcon(loginONFrm.class.getResource("/image/\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(loginONFrm.class.getResource("/image/\u7528\u6237.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(loginONFrm.class.getResource("/image/\u5BC6\u7801.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setText("ccpro");
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginactionPreFormd(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(loginONFrm.class.getResource("/image/\u767B\u5F55.png")));
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetvalueActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(loginONFrm.class.getResource("/image/\u9000\u51FA.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(45)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_1)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(33)
									.addComponent(btnNewButton)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
									.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnNewButton_1)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(117)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1)))
		);
		contentPane.setLayout(gl_contentPane);
		//������ʾ
		this.setLocationRelativeTo(null);
	}

	/**
	 * ��¼�¼�����
	 * @param e
	 */
protected void loginactionPreFormd(ActionEvent e) {
		//�ӵ�¼�����ȡ��Ϣ
		String username=this.userNameTxt.getText();
		String password=new String(this.passwordTxt.getPassword());//gettext���ã�Ϊ�˰�ȫ
		if(StringUtil.isempty(username))//�ж��û����Ƿ�Ϊ��
		{
			JOptionPane.showMessageDialog(null, "�û�������Ϊ��");//�����Ի���
			return;
		}
		if(StringUtil.isempty(password))//�ж������Ƿ�Ϊ��
		{
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��");//�����Ի���
			return;
		}
		//����һ���û�
		User user=new User(username,password);//�ý������ݳ�ʼ��
		Connection con=null;
		try
		{
			con=dbutil.getCon();
			User currentuser=userdao.login(con, user);
			if(currentuser!=null)
			{
				StringUtil.S_username=username;
				StringUtil.S_password=password;//��ȡ��¼��ȫ����Ϣ���д洢
				//JOptionPane.showMessageDialog(null, "��½�ɹ�");//�����Ի���
				dispose();//���ٵ�ǰ����
				new MainFrm().setVisible(true);//��ʾ������
			}
			else
			{
				JOptionPane.showMessageDialog(null, "�û����������");//�����Ի���
			}
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}finally
		{
			try {
				dbutil.closecon(con);
			} catch (Exception e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		}
		
	}

/**
 * �����¼�������
 * @param e
 */
	protected void resetvalueActionPerformed(ActionEvent e) {
		
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
