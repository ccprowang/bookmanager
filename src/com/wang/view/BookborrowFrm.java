package com.wang.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.wang.dao.BorrowDao;
import com.wang.model.Book;
import com.wang.model.Borrow;
import com.wang.util.Dbutil;
import com.wang.util.StringUtil;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class BookborrowFrm extends JInternalFrame {
	private JTable borrowtableTxt;
	private JTable returntableTxt;
	private Dbutil dbutil=new Dbutil();//数据库连接操作
	private BorrowDao borrowdao=new BorrowDao();//数据库类别操作
	private JTextField caozuobooknameTxt;
	private JTextField returntimeTxt;
	private JTextField borrowtimeTxt;
	private JButton BorrowButton;
	private JButton ReturnButton;
	private JButton Renewbutton;
	SimpleDateFormat mydate=new SimpleDateFormat("yyyy-MM-dd");
	private JTextField searchuseridTxt;
	private JTextField bookSerchTxt;
	private JComboBox nametypeTxt ;
	private JTextField useridTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookborrowFrm frame = new BookborrowFrm();
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
	public BookborrowFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u501F\u9605");
		setBounds(100, 100, 728, 534);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
	
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 546, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(99, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
							.addGap(41)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(59))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(317, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
					.addGap(70))
		);
		
		JLabel lblNewLabel = new JLabel("\u8BFB\u4E66\u8BC1\u53F7");
		
		searchuseridTxt = new JTextField();
		searchuseridTxt.setColumns(10);
		/*
		 * 根据读书证id查询借书信息
		 */
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchborrowInAction(e);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(searchuseridTxt, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton)
						.addComponent(searchuseridTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		nametypeTxt = new JComboBox();
		nametypeTxt.setModel(new DefaultComboBoxModel(new String[] {"\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u56FE\u4E66\u7F16\u53F7"}));
		
		bookSerchTxt = new JTextField();
		bookSerchTxt.setColumns(10);
		/*
		 * 图书查询
		 */
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchbookAction(e);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(nametypeTxt, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookSerchTxt, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(nametypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookSerchTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label_4 = new JLabel("\u501F\u9605\u65F6\u95F4");
		
		JLabel label_3 = new JLabel("\u5F52\u8FD8\u65F6\u95F4");
		
		borrowtimeTxt = new JTextField();
		borrowtimeTxt.setColumns(10);
		
		returntimeTxt = new JTextField();
		returntimeTxt.setColumns(10);
		BorrowButton = new JButton("\u501F\u9605");
		BorrowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					borrowbottonAction(e);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		Renewbutton = new JButton("\u7EED\u501F");
		Renewbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					renewbuttonpressedAction(e);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		ReturnButton = new JButton("\u5F52\u8FD8");
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					returnbookAction(e);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		
		JLabel label_2 = new JLabel("\u64CD\u4F5C\u4E66\u7C4D");
		
		caozuobooknameTxt = new JTextField();
		caozuobooknameTxt.setEditable(false);
		caozuobooknameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BFB\u4E66\u8BC1");
		
		useridTxt = new JTextField();
		useridTxt.setEditable(false);
		useridTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(BorrowButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Renewbutton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ReturnButton))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(label_3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(returntimeTxt, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(label_4)
									.addComponent(label_2))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(caozuobooknameTxt, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
									.addComponent(borrowtimeTxt)
									.addComponent(useridTxt, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(useridTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(caozuobooknameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(borrowtimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(returntimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(BorrowButton)
						.addComponent(Renewbutton)
						.addComponent(ReturnButton))
					.addGap(28))
		);
		panel.setLayout(gl_panel);
		
		/*
		 * 已借书表格点击
		 */
		returntableTxt = new JTable();
		returntableTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					returntableAction(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		returntableTxt.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFB\u8005\u7F16\u53F7", "\u56FE\u4E66\u7F16\u53F7", "\u501F\u4E66\u65E5\u671F", "\u8FD8\u4E66\u65E5\u671F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(returntableTxt);
		
		/**
		 * 点击可借书表格事件
		 */
		borrowtableTxt = new JTable();
		borrowtableTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e1) {
					try {
						borrowtablepressedevent(e1);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		});
		borrowtableTxt.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u4EF7\u683C", "\u53EF\u501F\u6570\u91CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(borrowtableTxt);
		getContentPane().setLayout(groupLayout);
		//刷新表格
		///this.fileevalues(new Book());
		//this.fileevalues2(new Borrow());
		//居中显示
		
	}
	/*
	 * 根据读书证号查询借阅信息
	 */
	protected void searchborrowInAction(ActionEvent e) {
			String userid=this.searchuseridTxt.getText();
			if(userid.hashCode()==0)
			{
				return;
			}
			Borrow borrow=new Borrow();
			borrow.setUserid(Integer.parseInt(userid));
			this.fileevalues2(borrow);
	}

	/*
	 * 图书查询按钮
	 */
	protected void searchbookAction(ActionEvent e) {
		String bookserchtxt=bookSerchTxt.getText();//搜索的选项
		String nametypetxt=nametypeTxt.getSelectedItem().toString();//具体内容
		
		Book book=new Book();
		if(nametypetxt.equals("图书名称"))
		{
			book.setBookName(bookserchtxt);
		}
		 else if(nametypetxt.equals("作者"))
		{
			 book.setAuthor(bookserchtxt);
		}
		else
		{
			book.setisbn(bookserchtxt);
		}
		this.fileevalues( book);
	}

	/*
	 * 续借按钮点击事件方法
	 */
	protected void renewbuttonpressedAction(ActionEvent e) throws Exception {
		int result=JOptionPane.showConfirmDialog(null, "是否续借");
		if(result!=0)//如果不是
		{
			return;
		}
		Connection con=null;
		con=dbutil.getCon();
		String borrowdatetxt=borrowtimeTxt.getText();
		Date borrowdate=Date.valueOf(borrowdatetxt);
		String returndatetxt=returntimeTxt.getText();
		Date returndate=Date.valueOf(returndatetxt);
		Borrow borrow=new Borrow(borrowdate,returndate);
		int n=borrowdao.renewbook(con, borrow);
		if(n==1)
		{
			JOptionPane.showMessageDialog(null, "续借成功");
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "续借失败");
		}
		this.resultvalues();
		//刷新表格
		searchbookAction(e);
		searchborrowInAction(e);
	}

	/*
	 *还书按钮点击事件
	 */
	protected void returnbookAction(ActionEvent e) throws Exception {
		int result=JOptionPane.showConfirmDialog(null, "是否还书");
		if(result!=0)//如果不是
		{
			return;
		}
		Connection con=null;
		con=dbutil.getCon();
		int n=borrowdao.returnbook(con,StringUtil.S_id,StringUtil.B_id);
		if(n==1)
		{
			JOptionPane.showMessageDialog(null, "还书成功");
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "还书失败");
		}
		this.resultvalues();
		//刷新表格
		//刷新表格
				searchbookAction(e);
				searchborrowInAction(e);
	}

	/*
	 *借阅按钮点击事件
	 */
	protected void borrowbottonAction(ActionEvent e) throws Exception {
		int result=JOptionPane.showConfirmDialog(null, "是否借阅");
		if(result!=0)//如果不是
		{
			return;
		}
		Connection con=null;
		con=dbutil.getCon();
		String borrowdatetxt=borrowtimeTxt.getText();
		Date borrowdate=Date.valueOf(borrowdatetxt);
		String returndatetxt=returntimeTxt.getText();
		Date returndate=Date.valueOf(returndatetxt);
		Borrow borrow=new Borrow(borrowdate,returndate);
		int n=borrowdao.borrowbook(con, borrow);
		if(n==1)
		{
			JOptionPane.showMessageDialog(null, "借书成功");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "借书失败");
		}
		this.resultvalues();
		//刷新表格
		//刷新表格
				searchbookAction(e);
				searchborrowInAction(e);
	}
	/*
	 * 已借 表格点击
	 */
	protected void returntableAction(MouseEvent e) throws Exception {
		int row=returntableTxt.getSelectedRow();//获取点击的行号
		String bookidtxt=(String)returntableTxt.getValueAt(row, 1);//得到id
		StringUtil.B_id=Integer.parseInt(bookidtxt);//设置借还书操作的编号
		String borrowtine=(String)returntableTxt.getValueAt(row, 2);
		String returntine=(String)returntableTxt.getValueAt(row, 3);
		String userid=(String)returntableTxt.getValueAt(row, 0);
		int bookidstr=Integer.parseInt(bookidtxt);
		Connection con=null;
		con=dbutil.getCon();
		
		ResultSet getbookname=borrowdao.serchbookname(con, bookidstr);
		while(getbookname.next())
		{
			//设置操作书籍	
			caozuobooknameTxt.setText(getbookname.getString("bookname"));
		}
		
		   
		
		//设置两个日期和读书证号
		useridTxt.setText(userid);
		returntimeTxt.setText(returntine);
		borrowtimeTxt.setText(borrowtine);
		//设置日期是否可编辑
		borrowtimeTxt.setEditable(false);
		returntimeTxt.setEditable(false);
		//设置按钮状态
		BorrowButton.setEnabled(false);
		Renewbutton.setEnabled(false);
		ReturnButton.setEnabled(true);
		//需要判断是否超时，超时日期可编辑，且按钮可编辑
		Date datenow = new Date(System.currentTimeMillis());
		String datetrue=mydate.format(datenow);
		if(returntine.compareTo(datetrue)<0)
		{
			Renewbutton.setEnabled(true);
			returntimeTxt.setEditable(true);
		}
	}

	
	/*
	 *点击可借书表格事件方法
	  @param e
	 */
	protected void borrowtablepressedevent(MouseEvent e) throws Exception {
		int row=borrowtableTxt.getSelectedRow();//获取点击的行号
		String bookname=(String)borrowtableTxt.getValueAt(row, 1);//获取图书名称
		this.useridTxt.setText(Integer.toString(StringUtil.S_id));
		caozuobooknameTxt.setText(bookname);//设置所得数据
		borrowtimeTxt.setText(mydate.format(new java.util.Date()).toString());
		returntimeTxt.setText(mydate.format(new java.util.Date()).toString());
		borrowtimeTxt.setEditable(false);
		returntimeTxt.setEditable(true);
		String bookid=(String)borrowtableTxt.getValueAt(row, 0);//获取图书编号
		StringUtil.B_id=Integer.parseInt(bookid);//设置借还书操作的编号
		//设置按钮状态
		BorrowButton.setEnabled(true);
		ReturnButton.setEnabled(false);
		Renewbutton.setEnabled(false);
	}

/*
 * 给查询图书表格填充数据方法
 */
private void fileevalues(Book book) 
{
	DefaultTableModel dtborrow=(DefaultTableModel)borrowtableTxt.getModel();
	dtborrow.setRowCount(0);//把表格清空不然只能一直往后添加
	Connection con=null;
	try {
	 	con=dbutil.getCon();
		ResultSet rsborrow=borrowdao.listborrow(con, book);
		while(rsborrow.next())
		{
				int countbook=Integer.parseInt(rsborrow.getString("number"));//记录书本数量
				if(countbook>0)
				{
					Vector v=new Vector();
					v.add(rsborrow.getString("isbn"));
					v.add(rsborrow.getString("BookName"));
					v.add(rsborrow.getString("author"));
					v.add(rsborrow.getString("price"));
					v.add(rsborrow.getString("number"));
					dtborrow.addRow(v);
				}	
		}
		
		
 	} catch (Exception e) {
		e.printStackTrace();
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
 * 给查询借书表格填充数据方法
 */
private void fileevalues2(Borrow borrow) 
{
	DefaultTableModel dtreturn=(DefaultTableModel)returntableTxt.getModel();
	dtreturn.setRowCount(0);
	
	Connection con=null;
	try {
	 	con=dbutil.getCon();
		ResultSet rsreturn=borrowdao.listreturn(con, borrow);
		//System.out.println(rsreturn.toString());
		while(rsreturn.next())
		{
			Vector v=new Vector();
			v.add(rsreturn.getString("userid"));
			v.add(rsreturn.getString("bookid"));
			v.add(rsreturn.getString("borrowdata"));
			v.add(rsreturn.getString("returndata"));
			dtreturn.addRow(v);
		}
 	} catch (Exception e) {
		e.printStackTrace();
	}finally
 	{
	try {
		dbutil.closecon(con);
	} catch (Exception e1) {
		// TODO 自动生成的 catch 块
		e1.printStackTrace();
	}}}

/*
 * 重置界面
 */
private void resultvalues() 
{
	//重置按钮状态和其他的控件
		BorrowButton.setEnabled(true);
		ReturnButton.setEnabled(true);
		Renewbutton.setEnabled(true);
		returntimeTxt.setText("");
		borrowtimeTxt.setText("");
		caozuobooknameTxt.setText("");
		useridTxt.setText("");
}
}
