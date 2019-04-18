package com.littlepage.view;

/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for CommonUserContactPeople
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.littlepage.dao.RailwayDBOperation;
import com.littlepage.entity.Administrator;
import com.littlepage.entity.ContactPeople;
import com.littlepage.entity.CustomerInfo;
import com.littlepage.session.LoginSession;

public class CommonUserContactPeople extends CommonUserMainFrame {

	private Panel panel;
	private JTextField jtfId;
	private JTextField jtfTrainNum;
	private JTextField jtfStartTime;
	private JTextField jtfReachTime;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public CommonUserContactPeople() {
		// user table
		final Vector<Vector<String>> row = new Vector<>();
		Vector<String> column = new Vector<>();
		column.add("编号");
		column.add("联系人名字");
		column.add("生日");
		column.add("电话");

		ArrayList<ContactPeople> arrTi = RailwayDBOperation
				.contactPeopleQuery();// table contact people
		ArrayList<CustomerInfo> arrCi = RailwayDBOperation
				.customerInfoQueryAll();
		for (ContactPeople contactPeople : arrTi) {

			// selectpeople
			Vector<String> rowData = new Vector<String>();// The rowdata vector
			Vector<Integer> temp = new Vector<>();// the table contactpeople
													// vector
			if (contactPeople.getParentId() == ((CustomerInfo) LoginSession.loginObject)
					.getId()) {
				temp.add(contactPeople.getId());
				temp.add(contactPeople.getParentId());
				temp.add(contactPeople.getContactId());
				rowData.add(contactPeople.getId() + "");
				for (CustomerInfo ci : arrCi) {
					if (contactPeople.getContactId() == ci.getId()) {
						rowData.add(ci.getCustomerName());
						StringBuilder sb = new StringBuilder(ci.getBirthTime());
						rowData.add(sb.substring(0, 10));
						rowData.add(ci.getPhoneCall());
					}
				}
				row.add(rowData);
			}
		}

		final JTable jtContactPeople = new JTable(row, column) {
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
		// southPanel
		Panel jpSouth = new Panel();
		getContentPane().add(jpSouth, BorderLayout.SOUTH);

		JButton jbAdd = new JButton("增加联系人");
		jpSouth.add(jbAdd);

		JButton jbDelete = new JButton("删除联系人");
		jpSouth.add(jbDelete);
		validate();

		// listeners
		jbAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddContactPeople();
				dispose();
			}
		});
		jbDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = jtContactPeople.getSelectedRow();// get selected row
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "未选中任何数据");
					return;
				}
				RailwayDBOperation.contactPeopleDeleteById(Integer
						.parseInt(jtContactPeople.getValueAt(row, 0).toString()));
				JOptionPane.showMessageDialog(null, "删除联系人成功");
				dispose();
				new CommonUserContactPeople();
			}
		});

		final JScrollPane jsp = new JScrollPane(jtContactPeople);
		getContentPane().add(jsp, BorderLayout.CENTER);
		
		//North Panel
		panel=new Panel();
		panel.setLayout(new GridLayout(1,10));
		add(panel,BorderLayout.NORTH);
		
		jtfId = new JTextField();
		panel.add(jtfId);
		jtfId.setColumns(10);
		
		jtfTrainNum = new JTextField();
		panel.add(jtfTrainNum);
		jtfTrainNum.setColumns(10);
		
		jtfStartTime = new JTextField();
		panel.add(jtfStartTime);
		jtfStartTime.setColumns(10);
		
		jtfReachTime = new JTextField();
		panel.add(jtfReachTime);
		jtfReachTime.setColumns(10);
		
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
					jtContactPeople.updateUI();
				}
			}
		});
		
		jtfTrainNum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(1).contains(jtfTrainNum.getText())) row.addElement(copy.get(i));
					}
					jtContactPeople.updateUI();
				}
			}
		});
		
		jtfStartTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(2).contains(jtfStartTime.getText())) row.addElement(copy.get(i));
					}
					jtContactPeople.updateUI();
				}
			}
		});
		
		jtfReachTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(3).contains(jtfReachTime.getText())) row.addElement(copy.get(i));
					}
					jtContactPeople.updateUI();
				}
			}
		});
		// Must Method
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
		setVisible(true);
	}

}
