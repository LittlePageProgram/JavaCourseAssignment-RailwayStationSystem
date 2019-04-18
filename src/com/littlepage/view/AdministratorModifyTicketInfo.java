package com.littlepage.view;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for AdministratorModifyTicketInfo
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
import com.littlepage.session.LoginSession;
import com.littlepage.validate.*;

public class AdministratorModifyTicketInfo extends AdministratorMainFrame {
	private Panel panel;
	private JTextField jtfId;
	private JTextField jtfTrainNum;
	private JTextField jtfStartTime;
	private JTextField jtfReachTime;
	private JTextField jtfStartStation;
	private JTextField jtfEndStation;
	private JTextField jtfRoomNum;
	private JTextField jtfLevel;
	private JTextField jtfRelease;
	private JTextField jtfPrice;
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public AdministratorModifyTicketInfo() {
		// user table
		final Vector<Vector<String>> row = new Vector<>();
		Vector<String> column = new Vector<>();
		column.add("编号");
		column.add("车次");
		column.add("发车日期");
		column.add("到达日期");
		column.add("出发站点");
		column.add("到达站点");
		column.add("车厢号");
		column.add("等级");
		column.add("空余座位号");
		column.add("票价");

		ArrayList<TicketInfo> arrTi = RailwayDBOperation.ticketInfoQueryAll();
		for (TicketInfo ticketInfo : arrTi) {
			Vector<String> temp = new Vector<String>();
			temp.add(ticketInfo.getId() + "");
			temp.add(ticketInfo.getTrainNumber());
			StringBuilder sbst = new StringBuilder(ticketInfo.getStartTime());
			temp.add(sbst.substring(0, 16));
			StringBuilder edst = new StringBuilder(ticketInfo.getEndTime());
			temp.add(edst.substring(0, 16));
			temp.add(ticketInfo.getStartStation());
			temp.add(ticketInfo.getEndStation());
			temp.add(ticketInfo.getRoomNumber());
			temp.add(ticketInfo.getSeatLevel() + "");
			temp.add(ticketInfo.getSpareSeatNum() + "");
			temp.add(ticketInfo.getTicketPrice()+"");
			row.add(temp);
		}
		final JTable jtTicketInfo = new JTable(row, column) {
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
		final JScrollPane jsp = new JScrollPane(jtTicketInfo);
		getContentPane().add(jsp, BorderLayout.CENTER);
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
		//northPanel
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
		
		jtfStartStation = new JTextField();
		panel.add(jtfStartStation);
		jtfStartStation.setColumns(10);
		
		jtfEndStation = new JTextField();
		panel.add(jtfEndStation);
		jtfEndStation.setColumns(10);
		
		jtfRoomNum = new JTextField();
		panel.add(jtfRoomNum);
		jtfRoomNum.setColumns(10);
		
		jtfLevel = new JTextField();
		panel.add(jtfLevel);
		jtfLevel.setColumns(10);
		
		jtfRelease = new JTextField();
		panel.add(jtfRelease);
		jtfRelease.setColumns(10);
		
		jtfPrice = new JTextField();
		panel.add(jtfPrice);
		jtfPrice.setColumns(10);
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
					jtTicketInfo.updateUI();
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
					jtTicketInfo.updateUI();
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
					jtTicketInfo.updateUI();
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
					jtTicketInfo.updateUI();
				}
			}
		});
		
		jtfStartStation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(4).contains(jtfStartStation.getText())) row.addElement(copy.get(i));
					}
					jtTicketInfo.updateUI();
				}
			}
		});
		
		jtfEndStation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(5).contains(jtfEndStation.getText())) row.addElement(copy.get(i));
					}
					jtTicketInfo.updateUI();
				}
			}
		});
		
		jtfRoomNum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(6).contains(jtfRoomNum.getText())) row.addElement(copy.get(i));
					}
					jtTicketInfo.updateUI();
				}
			}
		});
		
		jtfLevel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(7).contains(jtfLevel.getText())) row.addElement(copy.get(i));
					}
					jtTicketInfo.updateUI();
				}
			}
		});
		
		jtfRelease.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(8).contains(jtfRelease.getText())) row.addElement(copy.get(i));
					}
					jtTicketInfo.updateUI();
				}
			}
		});
		
		jtfPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(9).contains(jtfPrice.getText())) row.addElement(copy.get(i));
					}
					jtTicketInfo.updateUI();
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
				new TicketInfoAdd();
				dispose();
			}
		});

		jbUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = jtTicketInfo.getSelectedRow();// get selected row
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "未选中任何数据");
					return;
				}
				TicketInfo ti = new TicketInfo(Integer.parseInt(jtTicketInfo.getValueAt(row, 0).toString()),
						jtTicketInfo.getValueAt(row, 1).toString(),jtTicketInfo.getValueAt(row, 2).toString(),
						jtTicketInfo.getValueAt(row, 3).toString(),jtTicketInfo.getValueAt(row, 4).toString(),
						jtTicketInfo.getValueAt(row, 5).toString(),jtTicketInfo.getValueAt(row, 6).toString(),
						Integer.parseInt(jtTicketInfo.getValueAt(row, 7).toString()),
						Integer.parseInt(jtTicketInfo.getValueAt(row, 8).toString()),
						Double.parseDouble(jtTicketInfo.getValueAt(row, 9).toString()));
				
				// Judge
				if (JudgeChain.JudgeChainTicketInfo(ti) == false) {
					return;
				}
				RailwayDBOperation.ticketInfoUpdate(ti);
				JOptionPane.showMessageDialog(null, "更新成功");
				validate();
			}
		});
		jbDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = jtTicketInfo.getSelectedRow();// get selected row
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "未选中任何数据");
					return;
				}
				RailwayDBOperation.ticketInfoDeleteById(Integer
						.parseInt(jtTicketInfo.getValueAt(row, 0).toString()));
				dispose();
				new AdministratorModifyTicketInfo();
			}
		});
		setVisible(true);

	}

}
