package com.littlepage.view;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for PasswordChange
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import javax.swing.border.*;

import java.awt.GridLayout;

import javax.swing.*;

import com.littlepage.dao.RailwayDBOperation;
import com.littlepage.entity.CustomerInfo;
import com.littlepage.validate.JudgeChain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PasswordChange extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfUser;
	private JPasswordField jtfOPassword;
	private JPasswordField jtfNPassword;
	private JPasswordField jtfRPassword;
	private JTextField jtfPhoneNum;
	private final JButton jbConfirm = new JButton("修改");
	
	public PasswordChange() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5,2));
		
		JLabel jlUserName = new JLabel("请输入您的用户名：");
		jlUserName.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(jlUserName);
		
		jtfUser = new JTextField();
		panel.add(jtfUser);
		jtfUser.setColumns(20);
		
		JLabel jlPhoneNum = new JLabel("验证手机号：");
		jlPhoneNum.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(jlPhoneNum);
		
		jtfPhoneNum = new JTextField();
		panel.add(jtfPhoneNum);
		jtfPhoneNum.setColumns(20);
		
		JLabel jlOPassword = new JLabel("请输入旧密码：");
		jlOPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(jlOPassword);
		
		jtfOPassword = new JPasswordField();
		jtfOPassword.setText("");
		panel.add(jtfOPassword);
		jtfOPassword.setColumns(20);
		
		JLabel jlNPassword = new JLabel("新密码");
		jlNPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(jlNPassword);
		
		jtfNPassword = new JPasswordField();
		panel.add(jtfNPassword);
		jtfNPassword.setColumns(20);
		
		JLabel jlRPassword = new JLabel("请再次输入：");
		jlRPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(jlRPassword);
		
		jtfRPassword = new JPasswordField();
		panel.add(jtfRPassword);
		jtfRPassword.setColumns(20);
		
		Panel panel_1 = new Panel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.add(jbConfirm);
		
		JButton jbCancel = new JButton("取消");
		panel_1.add(jbCancel);
		
		//listeners
		jbConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username=jtfUser.getText();
				String phoneNum=jtfPhoneNum.getText();
				String oPassword=String.valueOf(jtfOPassword.getPassword());
				String nPassword=String.valueOf(jtfNPassword.getPassword());
				String rPassword=String.valueOf(jtfRPassword.getPassword());
				//judge data
				if(JudgeChain.judgeChainModifyPassword(username,phoneNum,oPassword,nPassword,rPassword)==false) return;
				
				
				//judge repetition
				ArrayList<CustomerInfo> arrCus=RailwayDBOperation.customerInfoQueryAll();
				for (CustomerInfo customerInfo : arrCus) {
					if(username.equals(customerInfo.getLoginName())){
						//judge phoneNum
						if(!customerInfo.getPhoneCall().equals(phoneNum)){
							JOptionPane.showMessageDialog(null, "手机号不正确");
							return;
						}
						//judge password
						if(!customerInfo.getCustomerPassword().equals(oPassword)){
							JOptionPane.showMessageDialog(null, "密码不正确");
							return;
						}
						RailwayDBOperation.customerInfoChangePassword(customerInfo,nPassword);
						JOptionPane.showMessageDialog(null, "密码修改成功");
						dispose();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "该用户未注册");
			}
		});
		jbCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		setVisible(true);
	}
}
