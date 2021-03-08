package com.wang.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.wang.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table=null;//����Ҫ�����������Ȼ����������

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
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
		
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 792);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0.png")));
		menuBar.add(menu);
		
		JMenu mnNewMenu = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		
		
		
		if(StringUtil.readertype.equals("����Ա"))
		{
		
			menu.add(mnNewMenu);
		/*
		 * ͼ���������¼����
		 */
		JMenuItem mntmNewMenuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFrm booktypeadd=new BookTypeAddInterFrm();
				booktypeadd.setVisible(true);//��ʾͼ����ӵĴ���
				table.add(booktypeadd);//��������ʾabout
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		/*
		 * �޸�ͼ�����
		 */
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u4FEE\u6539");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeupdateFrm bookupdate=new BookTypeupdateFrm();
				bookupdate.setVisible(true);//��ʾ�޸�ͼ�����Ĵ���
				table.add(bookupdate);//��������ʾͼ��������
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu.add(mnNewMenu_1);
		/*
		 * ͼ�����
		 */
			JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BookAddinterFrm bookAdd=new BookAddinterFrm();
					bookAdd.setVisible(true);//��ʾ�޸�ͼ�����Ĵ���
					table.add(bookAdd);//��������ʾͼ��������
				}
			});
			mnNewMenu_1.add(mntmNewMenuItem_2);
		
		
		/**
		 * �޸�ͼ��
		 */
	
			JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u56FE\u4E66\u4FE1\u606F\u4FEE\u6539");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BookupdateFrm bookupdate=new BookupdateFrm();
					bookupdate.setVisible(true);//��ʾ�޸�ͼ�����Ĵ���
					table.add(bookupdate);//��������ʾͼ��������
				}
			});
			mnNewMenu_1.add(mntmNewMenuItem_3);
			
		}
		
		/**
		 * �Ƿ��˳�ϵͳ
		 */
		JMenuItem menuItem = new JMenuItem("\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "�Ƿ��˳�ϵͳ");
				if(result==0)//�������
				{
					dispose();
				}
			}
		});
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("\u501F\u9605\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u501F\u9605.png")));
		menuBar.add(menu_1);
		/*
		 * ͼ����ĺ͹黹
		 */
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u501F\u9605\u548C\u5F52\u8FD8");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookborrowFrm bookborrow=new BookborrowFrm();
				bookborrow.setVisible(true);//��ʾ����ϵͳ�Ĵ���
				table.add(bookborrow);//��������ʾabout
			}
		});
		menu_1.add(mntmNewMenuItem_4);
		
		JMenu menu_2 = new JMenu("\u4FE1\u606F\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u53D6\u6D88.png")));
		menuBar.add(menu_2);
		/*
		 * �����޸ĵ��
		 */
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u5BC6\u7801\u4FEE\u6539");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PasswordFrm passwordfrm=new PasswordFrm();
				passwordfrm.setVisible(true);//��ʾ����ϵͳ�Ĵ���
				table.add(passwordfrm);//��������ʾabout
			}
		});
		menu_2.add(mntmNewMenuItem_6);
		/*
		 * �û���Ϣ�޸�
		 */
		JMenuItem menuItem_2 = new JMenuItem("\u7528\u6237\u4FE1\u606F\u4FEE\u6539");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserupdateinterFrm userupdate=new UserupdateinterFrm();
				userupdate.setVisible(true);//��ʾ����ϵͳ�Ĵ���
				table.add(userupdate);//��������ʾabout
			}
		});
		menu_2.add(menuItem_2);
		/*
		 * ����û����
		 */
		if(StringUtil.readertype.equals("����Ա"))
		{
		}	
			JMenuItem menuItem_1 = new JMenuItem("\u8BFB\u4E66\u8BC1\u7BA1\u7406");
			menuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UseraddinterFrm useradd=new UseraddinterFrm();
					useradd.setVisible(true);//��ʾͼ����ӵĴ���
					table.add(useradd);//��������ʾabout
				}
			});
			menu_2.add(menuItem_1);
		
		
		
		
		JMenu mnNewMenu_2 = new JMenu("\u5173\u4E8E");
		mnNewMenu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mnNewMenu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u9A8C\u6536.png")));
		menuBar.add(mnNewMenu_2);
		/**
		 * �������
		 */
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u5173\u4E8E\u7CFB\u7EDF");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutsystem abouts=new aboutsystem();
				abouts.setVisible(true);//��ʾ����ϵͳ�Ĵ���
				table.add(abouts);//��������ʾabout
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		table.setBackground(Color.CYAN);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		//������ʾ
		this.setLocationRelativeTo(null);
	}
}
