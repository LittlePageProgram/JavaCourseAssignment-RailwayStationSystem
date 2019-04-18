package com.littlepage.view;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for MainFrame
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import com.littlepage.entity.Administrator;
import com.littlepage.entity.CustomerInfo;
import com.littlepage.session.LoginSession;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		//Menubar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("用户");
		menuBar.add(menu);
		
		JMenuItem menuItemLogin = new JMenuItem("登录");
		menu.add(menuItemLogin);
		
		JMenuItem menuItemRegister = new JMenuItem("注册");
		menu.add(menuItemRegister);
		
		JMenuItem menuItemLogout = new JMenuItem("注销");
		menu.add(menuItemLogout);

		//Menubar Listeners
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
		//Must Method
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1024, 768);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon("img/icon.jpg").getImage());
		//title判断是否登陆
		if(LoginSession.type==null) setTitle("铁路车票实名销售系统"+"(未登陆)");
		else {
			if(LoginSession.type.equals("Customer")){
				CustomerInfo ci=(CustomerInfo)LoginSession.loginObject;
				setTitle("铁路车票实名销售系统"+" 普通用户:"+ci.getCustomerName());
			}else{
				Administrator ad=(Administrator)LoginSession.loginObject;
				setTitle("铁路车票实名销售系统"+" 管理员:"+ad.getName());
			}
		}
		setVisible(true);
	}

}
