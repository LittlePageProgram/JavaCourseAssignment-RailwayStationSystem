package com.littlepage.view;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for CommonUserMainFrame
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.littlepage.entity.*;
import com.littlepage.session.LoginSession;

public class CommonUserMainFrame extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public CommonUserMainFrame() {
		//Menubar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuUser = new JMenu("用户");
		menuBar.add(menuUser);
		
		JMenuItem menuItemLogin = new JMenuItem("登录");
		menuUser.add(menuItemLogin);
		
		JMenuItem menuItemRegister = new JMenuItem("注册");
		menuUser.add(menuItemRegister);
		
		JMenuItem menuItemLogout = new JMenuItem("注销");
		menuUser.add(menuItemLogout);
		
		JMenu menuView = new JMenu("查看");
		menuBar.add(menuView);
		
		JMenuItem menuItemTicketList = new JMenuItem("车票信息");
		menuView.add(menuItemTicketList);
		
		JMenuItem menuItemMyTicket = new JMenuItem("我的车票");
		menuView.add(menuItemMyTicket);
		
		JMenuItem menuItemContactPeople = new JMenuItem("常用联系人");
		menuView.add(menuItemContactPeople);
		
		JMenuItem menuItemPasswordChange = new JMenuItem("密码修改");
		menuView.add(menuItemPasswordChange);
		
		JMenuItem menuItemReturn = new JMenuItem("返回");
		menuView.add(menuItemReturn);
		
		JMenu menu_2 = new JMenu("帮助");
		menuBar.add(menu_2);
		
		JMenuItem menuItemHELP = new JMenuItem("帮助文档");
		menu_2.add(menuItemHELP);
		
		JMenuItem menuItemContact = new JMenuItem("联系作者");
		menu_2.add(menuItemContact);
		
		JMenu menu_1 = new JMenu("选项");
		menuBar.add(menu_1);
		
		JMenuItem menuItemExit = new JMenuItem("退出");
		menu_1.add(menuItemExit);

		
		//Menubar Listeners
		
		//Must Method
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1024, 768);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon("img/icon.jpg").getImage());
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		// title判断是否登陆
		if (LoginSession.type == null)
			setTitle("铁路车票实名销售系统" + "(未登陆)");
		else {
			if (LoginSession.type.equals("Customer")) {
				CustomerInfo ci = (CustomerInfo) LoginSession.loginObject;
				setTitle("铁路车票实名销售系统" + " 普通用户:" + ci.getCustomerName());
			} else {
				Administrator ad = (Administrator) LoginSession.loginObject;
				setTitle("铁路车票实名销售系统" + " 管理员:" + ad.getName());
			}
		}
		setVisible(true);
		
		menuItemExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		menuItemTicketList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 new CommonUserTicketInfoSelected();
				 dispose();
			}
		});
		menuItemLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				dispose();
			}
		});
		menuItemRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Register();
				dispose();
			}
		});
		menuItemLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginSession.type=null;
				LoginSession.loginObject=null;
				new MainFrame();
				dispose();
			}
		});
		menuItemContact.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "作者:    littlepage  \n\n有问题请联系我的工作邮箱:\n\nlittlepageprogram@outlook.com\n");
			}
		});
		menuItemPasswordChange.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PasswordChange();
			}
		});
		menuItemContactPeople.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 new CommonUserContactPeople();
				 dispose();
			}
		});
		menuItemMyTicket.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CommonUserMyTicket();
				dispose();
			}
		});
		menuItemReturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();new CommonUserMainFrame();
			}
		});
		menuItemHELP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "请查看目录下的帮助文档");
			}
		});
	}
}
