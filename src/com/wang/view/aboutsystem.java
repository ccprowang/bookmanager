package com.wang.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

public class aboutsystem extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aboutsystem frame = new aboutsystem();
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
	public aboutsystem() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5173\u4E8E\u7CFB\u7EDF");
		setBounds(100, 100, 356, 219);
		
		JLabel lblNewLabel = new JLabel("\u5F53\u524D\u7CFB\u7EDF\u7248\u672C1.0   @ccpro");
		lblNewLabel.setIcon(new ImageIcon(aboutsystem.class.getResource("/image/\u8BA2\u8D2D.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);

	}

}
