package com.littlepage.view;

/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for addContact
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */

import java.awt.*;
import javax.swing.*;
import com.littlepage.dao.RailwayDBOperation;
import com.littlepage.entity.*;
import com.littlepage.session.LoginSession;
import com.littlepage.validate.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddContactPeople extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jtfPhoneCalls;
	private JTextField jtfContactName;

	/**
	 * Create the frame.
	 */
	public AddContactPeople() {
		//frame design
		JPanel jpCenter = new JPanel();
		getContentPane().add(jpCenter, BorderLayout.CENTER);
		jpCenter.setLayout(new GridLayout(2,2));
		
		JLabel jlContactName = new JLabel("联系人姓名");
		jlContactName.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlContactName);
		
		jtfContactName = new JTextField();
		jpCenter.add(jtfContactName);
		jtfContactName.setColumns(10);
		
		JLabel jlPhoneCalls = new JLabel("联系人电话");
		jlPhoneCalls.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlPhoneCalls);
		
		jtfPhoneCalls = new JTextField();
		jpCenter.add(jtfPhoneCalls);
		jtfPhoneCalls.setColumns(10);
		
		JPanel jpSouth = new JPanel();
		getContentPane().add(jpSouth, BorderLayout.SOUTH);
		
		JButton jbAdd = new JButton("增加");
		jpSouth.add(jbAdd);
		
		JButton jbCancel = new JButton("取消");
		jpSouth.add(jbCancel);
		
		//Listeners
		
		//MustMethod
		jbAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=jtfContactName.getText();
				String phoneNum=jtfPhoneCalls.getText();
				//judgeData
				if(JudgeChain.judgeContactPeople(name,phoneNum)==false) return;
				//get datas from database
				ArrayList<CustomerInfo> arrCustomers=RailwayDBOperation.customerInfoQueryAll();
				for (CustomerInfo customerInfo : arrCustomers) {
					System.out.println(customerInfo.getCustomerName());
					System.out.println(name);
					System.out.println(customerInfo.getPhoneCall());
					System.out.println(phoneNum);
					if(customerInfo.getCustomerName().equals(name)&&customerInfo.getPhoneCall().equals(phoneNum)){
						CustomerInfo myCu=(CustomerInfo)LoginSession.loginObject;
						RailwayDBOperation.contactPeopleAdd(new ContactPeople(0,myCu.getId(),customerInfo.getId()));
						JOptionPane.showMessageDialog(null, "添加成功");
						new CommonUserContactPeople();
						dispose();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "联系人不存在");
			}
		});
		jbCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200,200,600,300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
