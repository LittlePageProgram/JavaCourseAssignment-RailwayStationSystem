package com.littlepage.view;

/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for AdministratorPurchaseInfo
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import com.littlepage.dao.RailwayDBOperation;
import com.littlepage.entity.*;
import com.littlepage.session.LoginSession;

public class AdministratorPurchaseInfo extends AdministratorMainFrame {
	private Panel panel;
	private JTextField jtfId;
	private JTextField jtfTrainNum;
	private JTextField jtfStartTime;
	private JTextField jtfReachTime;
	private JTextField jtfStartStation;
	private JTextField jtfEndStation;
	private JTextField jtfRoomNum;
	private JTextField jtfStationNum;
	private JTextField jtfPrice;
	private JTextField jtfIdentityNum;
	private JTextField jtfPurchaseTime;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public AdministratorPurchaseInfo() {
		setBounds(100, 100, 1600, 768);
		// user table
		final Vector<Vector<String>> row = new Vector<>();
		Vector<String> column = new Vector<>();
		column.add("编号");
		column.add("车次");
		column.add("发车日期");
		column.add("到达日期");
		column.add("起点站");
		column.add("终点站");
		column.add("车厢号");
		column.add("座位号");
		column.add("票价");
		column.add("身份证号");
		column.add("购买时间");

		ArrayList<TicketPurchaseInfo> arrCus = RailwayDBOperation
				.ticketPurchaseInfoQueryAll();
		for (TicketPurchaseInfo ticketPurchaseInfo : arrCus) {
			Vector<String> temp = new Vector<String>();
			temp.add(ticketPurchaseInfo.getId() + "");
			temp.add(ticketPurchaseInfo.getTrainNumber());
			StringBuilder startTime = new StringBuilder(
					ticketPurchaseInfo.getStartTime());
			temp.add(startTime.substring(0, 16));
			StringBuilder endTime = new StringBuilder(
					ticketPurchaseInfo.getEndTime());
			temp.add(endTime.substring(0, 16));
			temp.add(ticketPurchaseInfo.getStartStation());
			temp.add(ticketPurchaseInfo.getEndStation());
			temp.add(ticketPurchaseInfo.getRoomNumber());
			temp.add(ticketPurchaseInfo.getSeatNumber());
			temp.add(ticketPurchaseInfo.getTicketPrice() + "");
			temp.add(ticketPurchaseInfo.getIdentityNumber());
			StringBuilder purchaseTime = new StringBuilder(
					ticketPurchaseInfo.getPurchaseTime());
			temp.add(purchaseTime.substring(0, 16));
			row.add(temp);
		}
		final JTable jtTicketPurchaseInfo = new JTable(row, column) {
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
		final JScrollPane jsp = new JScrollPane(jtTicketPurchaseInfo);
		getContentPane().add(jsp, BorderLayout.CENTER);

		// northPanel
		panel = new Panel();
		panel.setLayout(new GridLayout(1, 10));
		add(panel, BorderLayout.NORTH);

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

		jtfStationNum = new JTextField();
		panel.add(jtfStationNum);
		jtfStationNum.setColumns(10);

		jtfPrice = new JTextField();
		panel.add(jtfPrice);
		jtfPrice.setColumns(10);

		jtfIdentityNum = new JTextField();
		panel.add(jtfIdentityNum);
		jtfIdentityNum.setColumns(10);

		jtfPurchaseTime = new JTextField();
		panel.add(jtfPurchaseTime);
		jtfPurchaseTime.setColumns(10);

		// testfield listener
		final Vector<Vector<String>> copy = new Vector<>();
		copy.addAll(row);
		jtfId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(0).contains(jtfId.getText()))
							row.addElement(copy.get(i));
					}
					jtTicketPurchaseInfo.updateUI();
				}
			}
		});

		jtfTrainNum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(1).contains(jtfTrainNum.getText()))
							row.addElement(copy.get(i));
					}
					jtTicketPurchaseInfo.updateUI();
				}
			}
		});

		jtfStartTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(2).contains(jtfStartTime.getText()))
							row.addElement(copy.get(i));
					}
					jtTicketPurchaseInfo.updateUI();
				}
			}
		});

		jtfReachTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(3).contains(jtfReachTime.getText()))
							row.addElement(copy.get(i));
					}
					jtTicketPurchaseInfo.updateUI();
				}
			}
		});

		jtfStartStation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(4)
								.contains(jtfStartStation.getText()))
							row.addElement(copy.get(i));
					}
					jtTicketPurchaseInfo.updateUI();
				}
			}
		});

		jtfEndStation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(5)
								.contains(jtfEndStation.getText()))
							row.addElement(copy.get(i));
					}
					jtTicketPurchaseInfo.updateUI();
				}
			}
		});

		jtfRoomNum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(6).contains(jtfRoomNum.getText()))
							row.addElement(copy.get(i));
					}
					jtTicketPurchaseInfo.updateUI();
				}
			}
		});

		jtfStationNum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(7)
								.contains(jtfStationNum.getText()))
							row.addElement(copy.get(i));
					}
					jtTicketPurchaseInfo.updateUI();
				}
			}
		});

		jtfPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(8).contains(jtfPrice.getText()))
							row.addElement(copy.get(i));
					}
					jtTicketPurchaseInfo.updateUI();
				}
			}
		});

		jtfIdentityNum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(9)
								.contains(jtfIdentityNum.getText()))
							row.addElement(copy.get(i));
					}
					jtTicketPurchaseInfo.updateUI();
				}
			}
		});

		jtfPurchaseTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(10)
								.contains(jtfPurchaseTime.getText()))
							row.addElement(copy.get(i));
					}
					jtTicketPurchaseInfo.updateUI();
				}
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
	}
}
