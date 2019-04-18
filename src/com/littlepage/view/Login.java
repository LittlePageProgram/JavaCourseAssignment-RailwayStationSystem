package com.littlepage.view;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for Login
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import com.littlepage.dao.RailwayDBOperation;
import com.littlepage.entity.Administrator;
import com.littlepage.entity.CustomerInfo;
import com.littlepage.session.LoginSession;
import com.littlepage.validate.JudgeChain;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Component
	JPanel jpNorth=new JPanel();
	JPanel jpCenter=new JPanel();
	JPanel jpSouth=new JPanel();
	JLabel jlLogin=new JLabel(new ImageIcon("img/title.jpg"));
	JLabel jlAccount=new JLabel("账户",JLabel.CENTER);
	JLabel jlPassword=new JLabel("密码",JLabel.CENTER);
	JTextField jtfAccount=new JTextField();
	JPasswordField jpf=new JPasswordField();
	JButton jbLogin=new JButton("登录");
	JButton jbCancel=new JButton("取消");

	/**
	 * Create the frame.
	 */
	public Login() {
		getContentPane().add(jpNorth,BorderLayout.NORTH);
		getContentPane().add(jpCenter,BorderLayout.CENTER);
		getContentPane().add(jpSouth,BorderLayout.SOUTH);
		
		jpNorth.add(jlLogin);
		
		jpCenter.setLayout(new GridLayout(2,2));
		jpCenter.add(jlAccount);
		jtfAccount.setColumns(20);
		jpCenter.add(jtfAccount);
		jpCenter.add(jlPassword);
		jpf.setColumns(20);
		jpCenter.add(jpf);
		jpSouth.add(jbLogin);
		jpSouth.add(jbCancel);
		
		//listeners
		jbLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//get datas from database
				ArrayList<CustomerInfo> arrCustomerInfo=RailwayDBOperation.customerInfoQueryAll();
				String name=jtfAccount.getText();
				String password=String.valueOf(jpf.getPassword());
				if(JudgeChain.JudgeChainLoginFrame(name,password)==false){
					jtfAccount.setText("");
					jpf.setText("");
					return;
				}
				for (CustomerInfo customerInfo : arrCustomerInfo) {
					if(customerInfo.getLoginName().equals(name)&&customerInfo.getCustomerPassword().equals(password)){
						JOptionPane.showMessageDialog(null, "用户"+customerInfo.getCustomerName()+"登录成功");
						LoginSession.type="Customer";
						LoginSession.loginObject=customerInfo;
						new CommonUserMainFrame();
						dispose();
						return;
					}
				}
				ArrayList<Administrator> arr=RailwayDBOperation.administratorQueryAll();
				for (Administrator administrator : arr) {
					if(administrator.getName().equals(name)&&administrator.getPassword().equals(password)){
						JOptionPane.showMessageDialog(null, "管理员"+administrator.getName()+"登录成功");
						LoginSession.type="Adminstrator";
						LoginSession.loginObject=administrator;
						new AdministratorMainFrame();
						dispose();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
				jtfAccount.setText("");
				jpf.setText("");
			}
		});
		
		jbCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainFrame();
			}
		});
		//Must method
		setBounds(100, 100, 200, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon("img/icon.jpg").getImage());
		setTitle("登录");
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
