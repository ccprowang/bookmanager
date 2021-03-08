package com.wang.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.wang.dao.bookTypeDao;
import com.wang.model.BookType;
import com.wang.util.Dbutil;
import com.wang.util.StringUtil;

public class BookTypeupdateFrm extends JInternalFrame {
	
	private JTable booktypetable;
	private JTextField bookTypeNameTxt;
	
	private Dbutil dbutil=new Dbutil();//���ݿ����Ӳ���
	private bookTypeDao booktypedao=new bookTypeDao();//���ݿ�������
	
	private JButton button;
	private JTextField booktypeidTxt;
	private JLabel label_1;
	private JTextField booktypenameTxt;
	private JLabel label_2;
	private JTextArea booktypeDescTxt;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeupdateFrm frame = new BookTypeupdateFrm();
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
	public BookTypeupdateFrm() {
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
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setBounds(100, 100, 533, 447);
		/*
		 * �����
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//txtmosepressedevent(e);
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		/**
		 * ��ѯ����¼�
		 */
		button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booktypesearchactionfrm(e);
			}
		});
		/**
		 * �������ϵ�һ���¼�����
		 */
		booktypetable = new JTable();
		booktypetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtmosepressedevent(e);
			}
		});
		booktypetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u63CF\u8FF0"
			}
		) {
		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(booktypetable);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(6)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(button)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		
		JLabel label = new JLabel("\u7F16\u53F7");
		
		booktypeidTxt = new JTextField();
		booktypeidTxt.setEnabled(false);
		booktypeidTxt.setColumns(10);
		
		label_1 = new JLabel("\u540D\u79F0");
		
		booktypenameTxt = new JTextField();
		booktypenameTxt.setColumns(10);
		
		label_2 = new JLabel("\u6807\u6CE8");
		
		booktypeDescTxt = new JTextArea();
		/**
		 * �޸İ�ť����¼�����
		 */
		btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					updatepressactionFrm(e);
			}
		});
		/**
		 * ɾ����ť����¼�
		 */
		btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletepressedactionFrm(e);
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(booktypeidTxt, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(110)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(booktypenameTxt, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
									.addComponent(btnNewButton_1))
								.addComponent(booktypeDescTxt))))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(booktypeidTxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(booktypenameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(booktypeDescTxt, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		// ���÷���������ʾ
		this.fileevalues(new BookType());
		//�����ı���߿�
		bookTypeNameTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	}
	/**
	 * ɾ���������
	 * @param e
	 */
	protected void deletepressedactionFrm(ActionEvent e) {
		int result=JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ��");
		if(result!=0)//�������
		{
			return;
		}
		String booktypeid=booktypeidTxt.getText();
		//BookType booktype=new BookType(Integer.parseInt(booktypeid));//stringҪתint
		if(StringUtil.isempty(booktypeid))
		{
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ���");
			return;
		}
		Connection con=null;
		try {
			con=dbutil.getCon();
			int n=booktypedao.delete(con, booktypeid);
			if(n==1)
			{
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				this.resetcaouo();
				booktypesearchactionfrm(e);
			}else
			{
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
			}
			
			} catch (Exception e1) {
			e1.printStackTrace();
		}finally
		{
			try {
				dbutil.closecon(con);
			} catch (Exception e2) {
				// TODO �Զ����ɵ� catch ��
				e2.printStackTrace();
			}
		}
	}
		

	/*
	 * �޸İ�ť���·���
	 */
	protected void updatepressactionFrm(ActionEvent e){
		int result=JOptionPane.showConfirmDialog(null, "�Ƿ��޸�");
		if(result!=0)//�������
		{
			return;
		}
		String booktypename=booktypenameTxt.getText();
		String booktypedesc=booktypeDescTxt.getText();
		String booktypeid=booktypeidTxt.getText();
		BookType booktype=new BookType(Integer.parseInt(booktypeid),booktypename,booktypedesc);//��һ��stringҪתint
		if(StringUtil.isempty(booktypeid))
		{
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ���");
			return;
		}
		Connection con=null;
		try {
			con=dbutil.getCon();
			int n=booktypedao.update(con, booktype);
			if(n==1)
			{
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				this.resetcaouo();
				//this.fileevalues(new BookType());
				booktypesearchactionfrm(e);
			}else
			{
				JOptionPane.showMessageDialog(null, "�޸�ʧ��");
			}
			
			} catch (Exception e1) {
			e1.printStackTrace();
		}finally
		{
			try {
				dbutil.closecon(con);
			} catch (Exception e2) {
				// TODO �Զ����ɵ� catch ��
				e2.printStackTrace();
			}
		}
	}
	/*
	 * ��ղ����ı�
	 */
	private void resetcaouo()
	{
		booktypenameTxt.setText("");;
		booktypeDescTxt.setText("");;
		booktypeidTxt.setText("");;
	}
	/*
	 *���������¼�����
	  @param e
	 */
	protected void txtmosepressedevent(MouseEvent e) {
		int row=booktypetable.getSelectedRow();//��ȡ������к�
		//System.out.println(row);
		booktypeidTxt.setText((String)booktypetable.getValueAt(row, 0));//����
		booktypenameTxt.setText((String)booktypetable.getValueAt(row, 1));
		booktypeDescTxt.setText((String)booktypetable.getValueAt(row, 2));
	}

	/*
	 * ��ѯ����¼�����
	 */
	private void booktypesearchactionfrm(ActionEvent evt) {
		String booktypenametxt=bookTypeNameTxt.getText();
		BookType booktype=new BookType();
		booktype.setBookTypeName(booktypenametxt);
		fileevalues(booktype);
	}

	/*
	 * �����������ݷ���
	 */
	private void fileevalues(BookType booktype) 
	{
		DefaultTableModel dt=(DefaultTableModel)booktypetable.getModel();
		dt.setRowCount(0);//�ѱ����ղ�Ȼֻ��һֱ�������
		Connection con=null;
	 try {
		 	con=dbutil.getCon();
			ResultSet rs=booktypedao.list(con, booktype);//
			while(rs.next())
			{
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
				dt.addRow(v);
			}
	} catch (Exception e) {
			e.printStackTrace();
	}finally
	 {
		try {
			dbutil.closecon(con);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	 }
	}
}
