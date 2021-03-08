package com.wang.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.wang.dao.BookDao;
import com.wang.model.Book;
import com.wang.model.BookType;
import com.wang.util.Dbutil;
import com.wang.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookupdateFrm extends JInternalFrame {
	private Dbutil dbutil=new Dbutil();//数据库连接操作
	private BookDao bookdao=new BookDao();//数据库类别操作
	private JTextField bookSerchTxt;
	private JTable booktable;
	private JComboBox nametypeTxt;
	private JTextField booknameTxt;
	private JTextField bookisbnTxt;
	private JTextField authorTxt;
	private JTextField bookpriceTxt;
	private JTextField booktypeidTxt;
	private JTextArea bookdescTxt;
	private JTextField booknumberTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookupdateFrm frame = new BookupdateFrm();
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
	public BookupdateFrm() {
		//改变系统默认字体
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
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u4FE1\u606F\u4FEE\u6539");
		setBounds(100, 100, 655, 525);
		
		nametypeTxt = new JComboBox();
		nametypeTxt.setModel(new DefaultComboBoxModel(new String[] {"\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u56FE\u4E66\u7F16\u53F7"}));
		
		bookSerchTxt = new JTextField();
		bookSerchTxt.setColumns(10);
		/*
		 * 查询点击
		 */
		JButton button = new JButton("\u641C\u7D22");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonpressectionFrm(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(nametypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookSerchTxt, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(button)
					.addGap(78))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE))
					.addGap(46))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nametypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookSerchTxt, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0");
		
		booknameTxt = new JTextField();
		booknameTxt.setColumns(10);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7F16\u53F7");
		
		bookisbnTxt = new JTextField();
		bookisbnTxt.setEditable(false);
		bookisbnTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4F5C\u8005");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4EF7\u683C");
		
		bookpriceTxt = new JTextField();
		bookpriceTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u7C7B\u522B");
		
		booktypeidTxt = new JTextField();
		booktypeidTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u63CF\u8FF0");
		
		bookdescTxt = new JTextArea();
		/*
		 * 修改点击操作
		 */
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatebottonpressedAction(e);
			}
		});
		/**
		 * 删除点击操作
		 */
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletepressedAction(e);
			}
		});
		
		JLabel label_5 = new JLabel("\u6570\u91CF");
		
		booknumberTxt = new JTextField();
		booknumberTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_1)
						.addComponent(label)
						.addComponent(lblNewLabel)
						.addComponent(label_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(authorTxt, Alignment.LEADING)
								.addComponent(bookisbnTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(booknameTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(label_3)
								.addComponent(label_5)))
						.addComponent(bookdescTxt, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(button_2)
							.addGap(34)
							.addComponent(button_1))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(booknumberTxt, Alignment.LEADING)
							.addComponent(booktypeidTxt, Alignment.LEADING)
							.addComponent(bookpriceTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(booknameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookpriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(bookisbnTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(booktypeidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_3)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1)
									.addGap(12)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_4)
										.addComponent(bookdescTxt, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
								.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(booknumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(78)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_2)
								.addComponent(button_1)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_5)))
					.addGap(176))
		);
		panel.setLayout(gl_panel);
		/*
		 * 点击表格显示数据到下面
		 */
		booktable = new JTable();
		booktable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int row=booktable.getSelectedRow();//获取点击的行号
				//System.out.println(row);
				//设置表格的值
				
				booknameTxt.setText((String)booktable.getValueAt(row, 0));		
				authorTxt.setText((String)booktable.getValueAt(row, 1));
				bookisbnTxt.setText((String)booktable.getValueAt(row, 2));
				bookpriceTxt.setText((String)booktable.getValueAt(row, 3));
				booktypeidTxt.setText((String)booktable.getValueAt(row, 4));
				bookdescTxt.setText((String)booktable.getValueAt(row, 5));
				booknumberTxt.setText((String)booktable.getValueAt(row, 6));
			}
		});
		booktable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u56FE\u4E66\u7F16\u53F7", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u7C7B\u578B", "\u56FE\u4E66\u7B80\u4ECB", "\u5B58\u9986\u6570\u91CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(booktable);
		getContentPane().setLayout(groupLayout);
		//填充表格
		this.fileevalues(new Book());
		//设置文本域边框
		bookSerchTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	}
	/**
	 * 删除按钮点击操作
	 */
	protected void deletepressedAction(ActionEvent e) {
		int result=JOptionPane.showConfirmDialog(null, "是否删除");
		if(result!=0)//如果不是
		{
			return;
		}
		String bookisbnid=bookisbnTxt.getText();
		if(StringUtil.isempty(bookisbnid))
		{
			JOptionPane.showMessageDialog(null, "请选择要修改的列");
			return;
		}
		Connection con=null;
		try {
			con=dbutil.getCon();
			int n=bookdao.delete(con, bookisbnid);
			if(n==1)
			{
				JOptionPane.showMessageDialog(null, "删除成功");
				this.resetcaouo();
				buttonpressectionFrm(e);
			}else
			{
				JOptionPane.showMessageDialog(null, "删除失败");
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
	 * 修改点击 的方法
	 */
	protected void updatebottonpressedAction(ActionEvent e) {
		int result=JOptionPane.showConfirmDialog(null, "是否修改");
		if(result!=0)//如果不是
		{
			return;
		}
		String bookisbn=bookisbnTxt.getText();
		String bookname=booknameTxt.getText();
		String author=authorTxt.getText();
		String price=bookpriceTxt.getText();
		String booktypeid=booktypeidTxt.getText();
		String booktypedesc=bookdescTxt.getText();
		String booknumber=booknumberTxt.getText();
		Book book=new Book(bookname,author,bookisbn,Float.parseFloat(price),booktypeid,booktypedesc,Integer.parseInt(booknumber));
		if(bookisbnTxt==null)
		{
			JOptionPane.showMessageDialog(null, "请选择要修改的列");
			return;
		}
		Connection con=null;
		try {
				con=dbutil.getCon();
				int n=bookdao.update(con, book);
				if(n==1)
				{
					
					JOptionPane.showMessageDialog(null, "修改成功");
					this.resetcaouo();
					buttonpressectionFrm(e);
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
	 * 清空操作的表单
	 */
	private void resetcaouo() {
			authorTxt.setText("");
			bookpriceTxt.setText("");
			booktypeidTxt.setText("");
			bookdescTxt.setText("");
			bookisbnTxt.setText("");
			booknameTxt.setText("");
			booknumberTxt.setText("");
	}


	/*
	 * 查询 点击方法
	 */
	protected void buttonpressectionFrm(ActionEvent e) {
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
		//System.out.println(book.toString());
		fileevalues(book);
	}

	/*
	 * 给表格填充数据方法
	 */
	private void fileevalues(Book book) 
	{
		DefaultTableModel dt=(DefaultTableModel)booktable.getModel();
		dt.setRowCount(0);//把表格清空不然只能一直往后添加
		Connection con=null;
		try {
		 	con=dbutil.getCon();
			ResultSet rs=bookdao.list(con, book);//
		
			while(rs.next())
			{
				Vector v=new Vector();
				//获取图书编号，便于我添加图书的时候添加类别
				String s=rs.getString("id");
				
				//v.add(s);
				v.add(rs.getString("BookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("isbn"));
				v.add(rs.getString("price"));
				v.add(rs.getString("bookTypeId"));
				v.add(rs.getString("bookDesc"));
				v.add(rs.getString("number"));
				dt.addRow(v);
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
