package com.wang.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.wang.dao.BookDao;
import com.wang.model.Book;
import com.wang.util.Dbutil;
import com.wang.util.StringUtil;

public class BookAddinterFrm extends JInternalFrame {
	
	private Dbutil dbutil=new Dbutil();//数据库连接操作
	private BookDao bookdao=new BookDao();//数据库类别操作
	private JTextField booknameTxt;
	private JTextField bookauthorTxt;
	private JTextField bookpriceTxt;
	private JTextArea bookdescTxt;
	private JComboBox booktypeId;
	private JTextField booknumberTxt;
	private JTextField isbntext;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddinterFrm frame = new BookAddinterFrm();
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
	public BookAddinterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBounds(100, 100, 458, 374);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0");
		
		booknameTxt = new JTextField();
		booknameTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u4F5C\u8005");
		
		bookauthorTxt = new JTextField();
		bookauthorTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7F16\u53F7");
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4EF7\u683C");
		
		bookpriceTxt = new JTextField();
		bookpriceTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B");
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u63CF\u8FF0");
		
		bookdescTxt = new JTextArea();
		
		booktypeId = new JComboBox();
		booktypeId.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9"}));
		/*
		 * 重置按钮点击
		 */
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultvaluesactionFrm1(e);
			}
		});
		button.setIcon(new ImageIcon(BookAddinterFrm.class.getResource("/image/reset.png")));
		/*
		 * 添加按钮点击
		 */
		JButton button_1 = new JButton("\u6DFB\u52A0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addbookactionFrm(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookAddinterFrm.class.getResource("/image/add.png")));
		//设置文本域边框
		bookdescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		
		JLabel label_4 = new JLabel("\u6570\u91CF");
		
		booknumberTxt = new JTextField();
		booknumberTxt.setColumns(10);
		
		isbntext = new JTextField();
		isbntext.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(button_1)
							.addGap(187)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label)
											.addGap(18))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(label_4)
												.addComponent(lblNewLabel))
											.addPreferredGap(ComponentPlacement.UNRELATED)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(booknameTxt, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(label_1))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(booknumberTxt)
												.addComponent(bookauthorTxt, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNewLabel_1)
												.addComponent(label_2))))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(isbntext)
										.addComponent(booktypeId, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(bookpriceTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addGap(18)
									.addComponent(bookdescTxt, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))))
					.addGap(36))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(booknameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_1)
							.addComponent(bookpriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookauthorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel)
						.addComponent(isbntext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(booktypeId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(label_4)
						.addComponent(booknumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(label_3))
						.addComponent(bookdescTxt, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addGap(160))
		);
		getContentPane().setLayout(groupLayout);
		//更新下拉框
		this.setjcomboxvalue();
	}
	/*
	 * 添加按钮点击方法
	 */
	protected void addbookactionFrm(ActionEvent e) {
		int result=JOptionPane.showConfirmDialog(null, "是否添加");
		if(result!=0)//如果不是
		{
			return;
		}
		String bookname=this.booknameTxt.getText();
		String bookdesc=this.bookdescTxt.getText();
		String bookauthor=this.bookauthorTxt.getText();
		String bookprice=this.bookpriceTxt.getText();
		String isbn=this.isbntext.getText();
		String number=this.booknumberTxt.getText();
		int booktypeid=this.booktypeId.getSelectedIndex();
		if(StringUtil.isempty(bookname)||StringUtil.isempty(bookdesc)||StringUtil.isempty(bookauthor)||StringUtil.isempty(bookprice)
				||(booktypeid==0)||StringUtil.isempty(isbn)||StringUtil.isempty(number))
		{
			JOptionPane.showMessageDialog(null, "图书信息未填写完整");
			return;
		}
     
		Book book=new Book(bookname,bookauthor,isbn, Float.parseFloat(bookprice),Integer.toString(booktypeid),bookdesc,Integer.parseInt(number));
		Connection con=null;
		try {
			con=dbutil.getCon();//获取连接
			
			int n=bookdao.add(con, book);
			if(n==1)
			{
				JOptionPane.showMessageDialog(null, "图书添加成功");
				resultvaluesactionFrm2();//添加成功之后要重置表单
			}else
			{
				JOptionPane.showMessageDialog(null, "图书添加失败");
				resultvaluesactionFrm2();//添加成功之后要重置表单
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败");
		}finally
		{
			try {
				dbutil.closecon(con);
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}	
	}
/*
 * 重置界面方法
 */
	private void resultvaluesactionFrm2() {
	
		
		this.booknameTxt.setText("");
		this.bookauthorTxt.setText("");
		this.bookpriceTxt.setText("");
		this.bookdescTxt.setText("");
		this.booknameTxt.setText("");
		this.booknumberTxt.setText("");
		this.isbntext.setText("");
		this.booktypeId.setSelectedIndex(0);
		
	}
	private void resultvaluesactionFrm1(ActionEvent e) {
		resultvaluesactionFrm2();
	}

//初始化下拉框
	private void setjcomboxvalue()
	{
		Connection con=null;
		try {
			con=dbutil.getCon();
			//更新下拉框
			ResultSet rs=bookdao.searchbooktypeid(con);
			while(rs.next())
			{
				//booktypenamestr[i][]=rs.getString("booktypename");
				this.booktypeId.addItem(rs.getString("booktypename"));	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
