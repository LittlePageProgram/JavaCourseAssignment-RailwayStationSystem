package com.littlepage.view;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for AdministratorModifyTheUser
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import com.littlepage.dao.RailwayDBOperation;
import com.littlepage.entity.*;
import com.littlepage.validate.*;

public class AdministratorModifyTheUser extends AdministratorMainFrame {
	private Panel panel;
	private JTextField jtfId;
	private JTextField jtfLoginName;
	private JTextField jtfName;
	private JTextField jtfSex;
	private JTextField jtfIdentityNum;
	private JTextField jtfBirthTime;
	private JTextField jtfMobiles;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AdministratorModifyTheUser() {
		// user table
		final Vector<Vector<String>> row = new Vector<>();
		Vector<String> column = new Vector<>();
		column.add("编号");
		column.add("登录名");
		column.add("姓名");
		column.add("性别");
		column.add("身份证号码");
		column.add("出生日期");
		column.add("手机号");

		ArrayList<CustomerInfo> arrCus = RailwayDBOperation
				.customerInfoQueryAll();
		for (CustomerInfo customerInfo : arrCus) {
			Vector<String> temp = new Vector<String>();
			temp.add(customerInfo.getId() + "");
			temp.add(customerInfo.getLoginName());
			temp.add(customerInfo.getCustomerName());
			temp.add(customerInfo.getSex());
			temp.add(customerInfo.getIdentityNumber());
			StringBuilder birth = new StringBuilder(customerInfo.getBirthTime());
			temp.add(birth.substring(0, 10));
			temp.add(customerInfo.getPhoneCall());
			row.add(temp);
		}
		final JTable jtUser = new JTable(row, column) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 0)
					return false;
				else
					return true;
			}
		};
		final JScrollPane jsp = new JScrollPane(jtUser);
		getContentPane().add(jsp, BorderLayout.CENTER);
		
		//northPanel
		panel=new Panel();
		panel.setLayout(new GridLayout(1,7));
		add(panel,BorderLayout.NORTH);
		
		jtfId = new JTextField();
		panel.add(jtfId);
		jtfId.setColumns(10);
		
		jtfLoginName = new JTextField();
		panel.add(jtfLoginName);
		jtfLoginName.setColumns(10);
		
		jtfName = new JTextField();
		panel.add(jtfName);
		jtfName.setColumns(10);
		
		jtfSex = new JTextField();
		panel.add(jtfSex);
		jtfSex.setColumns(10);
		
		jtfIdentityNum = new JTextField();
		panel.add(jtfIdentityNum);
		jtfIdentityNum.setColumns(10);
		
		jtfBirthTime = new JTextField();
		panel.add(jtfBirthTime);
		jtfBirthTime.setColumns(10);
		
		jtfMobiles = new JTextField();
		panel.add(jtfMobiles);
		jtfMobiles.setColumns(10);
		
		//testfield listener
		final Vector<Vector<String>> copy=new Vector<>();
		copy.addAll(row);
		jtfId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(0).contains(jtfId.getText())) row.addElement(copy.get(i));
					}
					jtUser.updateUI();
				}
			}
		});
		
		jtfLoginName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(1).contains(jtfLoginName.getText())) row.addElement(copy.get(i));
					}
					jtUser.updateUI();
				}
			}
		});
		
		jtfName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(2).contains(jtfName.getText())) row.addElement(copy.get(i));
					}
					jtUser.updateUI();
				}
			}
		});
		
		jtfSex.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(3).contains(jtfSex.getText())) row.addElement(copy.get(i));
					}
					jtUser.updateUI();
				}
			}
		});
		
		jtfIdentityNum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(4).contains(jtfIdentityNum.getText())) row.addElement(copy.get(i));
					}
					jtUser.updateUI();
				}
			}
		});
		
		jtfBirthTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(5).contains(jtfBirthTime.getText())) row.addElement(copy.get(i));
					}
					jtUser.updateUI();
				}
			}
		});
		
		jtfMobiles.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(6).contains(jtfMobiles.getText())) row.addElement(copy.get(i));
					}
					jtUser.updateUI();
				}
			}
		});
		// southPanel
		Panel jpSouth = new Panel();
		getContentPane().add(jpSouth, BorderLayout.SOUTH);

		JButton jbAdd = new JButton("增加");
		jpSouth.add(jbAdd);

		JButton jbUpdate = new JButton("更新");
		jpSouth.add(jbUpdate);

		JButton jbDelete = new JButton("删除");
		jpSouth.add(jbDelete);
		validate();

		// Button Listeners
		jbAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CommonRegister();
			}
		});

		jbUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = jtUser.getSelectedRow();// get selected row
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "未选中任何数据");
					return;
				}
				CustomerInfo ci = new CustomerInfo(Integer.parseInt(jtUser
						.getValueAt(row, 0).toString()), jtUser.getValueAt(row,
						1).toString(), jtUser.getValueAt(row, 2).toString(),
						jtUser.getValueAt(row, 3).toString(), jtUser
								.getValueAt(row, 4).toString(), jtUser
								.getValueAt(row, 5).toString(), jtUser
								.getValueAt(row, 6).toString(), "111");
				if (JudgeChain.JudgeChainCustomerInfo(ci) == false) {
					return;
				}
				RailwayDBOperation.customerInfoUpdate(ci);
				JOptionPane.showMessageDialog(null, "更新成功");
				validate();
			}
		});
		jbDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = jtUser.getSelectedRow();// get selected row
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "未选中任何数据");
					return;
				}
				RailwayDBOperation.customerInfoDeleteById(Integer
						.parseInt(jtUser.getValueAt(row, 0).toString()));
				dispose();
				new AdministratorModifyTheUser();
			}
		});
		setVisible(true);
	}
}
