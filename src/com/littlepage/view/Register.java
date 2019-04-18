package com.littlepage.view;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for Register
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import java.awt.EventQueue;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton jbCommon=new JButton("  普通用户  ");
	JButton jbAdministrator=new JButton("管理员用户");
	Box box=Box.createVerticalBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		//frame design
		box.add(Box.createVerticalStrut(50));
		box.add(jbCommon);
		box.add(Box.createVerticalStrut(50));
		box.add(jbAdministrator);
		add(box);
		//listeners
		jbCommon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CommonRegister();
				dispose();
			}
		});
		jbAdministrator.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdministratorRegister();
				dispose();
			}
		});
		//Must Method
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 450, 300);
		setIconImage(new ImageIcon("img/icon.jpg").getImage());
		setTitle("注册");
		getContentPane().setLayout(new FlowLayout());
		setVisible(true);
	}

}
