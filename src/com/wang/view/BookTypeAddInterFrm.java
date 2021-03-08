package com.wang.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.wang.dao.bookTypeDao;
import com.wang.model.BookType;
import com.wang.util.Dbutil;
import com.wang.util.StringUtil;

public class BookTypeAddInterFrm extends JInternalFrame {
	private JTextField booknameTxt;
	private JTextArea booktypeDescTxt;

	private Dbutil dbutil=new Dbutil();//数据库连接操作
	private bookTypeDao booktypedao=new bookTypeDao();//数据库类别操作
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
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
	public BookTypeAddInterFrm() {
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 456, 367);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0");
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0");
		
		booknameTxt = new JTextField();
		booknameTxt.setColumns(10);
		
		 booktypeDescTxt = new JTextArea();
		/*
		 * 重置事件点击
		 */
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					resultvaluefild(e);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/image/reset.png")));
		/*
		 * 添加事件点击
		 */
		JButton button_1 = new JButton("\u6DFB\u52A0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent es) {
				try {
					booktypeaddcation(es);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button_1.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/image/add.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(booknameTxt)
						.addComponent(booktypeDescTxt, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
					.addContainerGap(81, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(66)
					.addComponent(button_1)
					.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(55))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(128)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(booktypeDescTxt, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(booknameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(38))
		);
		getContentPane().setLayout(groupLayout);
		
		//设置文本域边框
		booktypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	
	}
	/*
	 * 图书按钮添加事件
	 */
	private void booktypeaddcation(ActionEvent e) throws Exception {
		int result=JOptionPane.showConfirmDialog(null, "是否添加");
		if(result!=0)//如果不是
		{
			return;
		}
		String booktypename=this.booknameTxt.getText();
		String booktypedesc=this.booktypeDescTxt.getText();
	
		if(StringUtil.isempty(booktypename))
		{
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
			return;
		}
		BookType booktype=new BookType(booktypename,booktypedesc);
		Connection con=null;
		try {
			con=dbutil.getCon();//获取连接
			int n=booktypedao.add(con, booktype);
			if(n==1)
			{
				JOptionPane.showMessageDialog(null, "图书类别添加成功");
				resultvalue();//添加成功之后要重置表单
			}else
			{
				JOptionPane.showMessageDialog(null, "图书类别添加失败");
				resultvalue();//添加成功之后要重置表单
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书类别添加失败");
		}finally
		{
			dbutil.closecon(con);
		}
		
	}

	/**
	 * 重置窗口的方法，写的不是很好，不想改了
	 */
	private void resultvalue()throws Exception{
		this.booknameTxt.setText("");
		this.booktypeDescTxt.setText("");
	}
	 private void resultvaluefild(ActionEvent evt)throws Exception{
		 this.resultvalue();
	 }
}
