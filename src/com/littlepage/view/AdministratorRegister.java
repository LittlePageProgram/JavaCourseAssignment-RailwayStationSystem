package com.littlepage.view;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for AdministratorRegister
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.littlepage.validate.*;
import com.littlepage.dao.RailwayDBOperation;
import com.littlepage.entity.Administrator;

public class AdministratorRegister extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField jpfPasswordConfirm;

	/**
	 * Create the frame.
	 */
	public AdministratorRegister() {
		
		//frame design
		getContentPane().setLayout(new BorderLayout());
		JPanel jpCenter = new JPanel();
		getContentPane().add(jpCenter, BorderLayout.CENTER);
		jpCenter.setLayout(new GridLayout(3,2));
		
		JLabel jlName = new JLabel("姓名");
		jlName.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlName);
		
		final JTextField jtfName = new JTextField();
		jpCenter.add(jtfName);
		jtfName.setColumns(10);
		
		JLabel jlPassword = new JLabel("密码");
		jlPassword.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlPassword);
		
		final JPasswordField jpfPassword = new JPasswordField();
		jpCenter.add(jpfPassword);
		
		JLabel jlConfirmPassword = new JLabel("确认密码");
		jlConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlConfirmPassword);
		
		jpfPasswordConfirm = new JPasswordField();
		jpCenter.add(jpfPasswordConfirm);
		
		JPanel jpSouth = new JPanel();
		getContentPane().add(jpSouth, BorderLayout.SOUTH);
		
		JButton jbRegister = new JButton("注册");
		jpSouth.add(jbRegister);
		
		JButton jbCancel = new JButton("取消");
		jpSouth.add(jbCancel);
		
		
		//listeners
		jbRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//validate
				String name=jtfName.getText();
				String password=String.valueOf(jpfPassword.getPassword());
				String passwordRepeat=String.valueOf(jpfPasswordConfirm.getPassword());
				if(JudgeChain.JudgeChainAdministratorRegisterFrame(name, password, passwordRepeat)==false){
					return;
				}
				//insert user
				RailwayDBOperation.administratorAdd(new Administrator(name, password));
				JOptionPane.showMessageDialog(null, "注册成功");
				new Login();
				dispose();
			}
			
		});
		
		jbCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
				dispose();
			}
		});
		//Must Method
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 450, 300);
		setIconImage(new ImageIcon("img/icon.jpg").getImage());
		setTitle("管理员注册");
		setVisible(true);
	}

}
