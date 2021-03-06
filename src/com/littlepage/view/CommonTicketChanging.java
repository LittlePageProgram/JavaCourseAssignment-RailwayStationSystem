package com.littlepage.view;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for CommonTicketChanging
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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.littlepage.dao.RailwayDBOperation;
import com.littlepage.entity.CustomerInfo;
import com.littlepage.entity.TicketInfo;
import com.littlepage.entity.TicketPurchaseInfo;
import com.littlepage.session.LoginSession;
import com.littlepage.utils.Now;

public class CommonTicketChanging extends CommonUserMainFrame {
	private Panel panel;
	private JTextField jtfId;
	private JTextField jtfTrainNum;
	private JTextField jtfStartTime;
	private JTextField jtfReachTime;
	private JTextField jtfRoomNum;
	private JTextField jtfLevel;
	private JTextField jtfRelease;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the frame.
	 */
	public CommonTicketChanging() {
			// user table
			final Vector<Vector<String>> row = new Vector<>();
			Vector<String> column = new Vector<>();
			column.add("编号");
			column.add("车次");
			column.add("发车日期");
			column.add("到达日期");
			column.add("车厢号");
			column.add("等级");
			column.add("空余座位号");
	
			ArrayList<TicketInfo> arrTi = RailwayDBOperation.ticketInfoQueryAll();
			for (TicketInfo ticketInfo : arrTi) {
				Vector<String> temp = new Vector<String>();
				temp.add(ticketInfo.getId() + "");
				temp.add(ticketInfo.getTrainNumber());
				StringBuilder sbst = new StringBuilder(ticketInfo.getStartTime());
				temp.add(sbst.substring(0, 16));
				StringBuilder edst = new StringBuilder(ticketInfo.getEndTime());
				temp.add(edst.substring(0, 16));
				temp.add(ticketInfo.getRoomNumber());
				temp.add(ticketInfo.getSeatLevel() + "");
				temp.add(ticketInfo.getSpareSeatNum() + "");
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
			// southPanel
			Panel jpSouth = new Panel();
			getContentPane().add(jpSouth, BorderLayout.SOUTH);

			JButton jbAdd = new JButton("改签");
			jpSouth.add(jbAdd);
			validate();
			
			//listeners
			jbAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int row = jtTicketInfo.getSelectedRow();// get selected row
					if (row == -1) {
						JOptionPane.showMessageDialog(null, "未选中任何数据");
						return;
					}
					//judge trainNum identityNum is equals
					ArrayList<TicketPurchaseInfo> arrTicket=RailwayDBOperation.ticketPurchaseInfoQueryAll();
					for (TicketPurchaseInfo ticketPurchaseInfo : arrTicket) {
						if(ticketPurchaseInfo.getIdentityNumber().equals(((CustomerInfo)(LoginSession.loginObject)).getIdentityNumber())){
							if(ticketPurchaseInfo.getTrainNumber().equals(jtTicketInfo.getValueAt(jtTicketInfo.getSelectedRow(), 1).toString())){
								System.out.println();
								JOptionPane.showMessageDialog(null, "您今日已经购买了当日的票");
								return;
							}
						}
					}
					//add the data into database
					String userId=((CustomerInfo)(LoginSession.loginObject)).getId()+"";
					String userIdentityNum=((CustomerInfo)(LoginSession.loginObject)).getIdentityNumber();
					String ticketId=jtTicketInfo.getValueAt(row, 0).toString();
					//got the ticket property from database
					TicketInfo selectedTicket=null;
					ArrayList<TicketInfo> arrTicketInfo=RailwayDBOperation.ticketInfoQueryAll();
					for (TicketInfo ticketInfo : arrTicketInfo) {
						if(ticketId.equals(ticketInfo.getId()+"")) {
							selectedTicket=ticketInfo;
							break;
						}
					}
					RailwayDBOperation.ticketPurchaseInfoAdd(new TicketPurchaseInfo(Integer.parseInt(userId),
							selectedTicket.getTrainNumber(),
							selectedTicket.getStartTime(), 
							selectedTicket.getEndTime(), 
							selectedTicket.getStartStation(),
							selectedTicket.getEndStation(), 
							selectedTicket.getRoomNumber(), 
							selectedTicket.getSpareSeatNum()+"", 
							selectedTicket.getTicketPrice(),
							userIdentityNum,
							Now.getNow()));
					JOptionPane.showMessageDialog(null, "改签成功");
					dispose();
					new CommonUserMyTicket();
				}
			});
			
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
			
			jtfRoomNum = new JTextField();
			panel.add(jtfRoomNum);
			jtfRoomNum.setColumns(10);
			
			jtfLevel = new JTextField();
			panel.add(jtfLevel);
			jtfLevel.setColumns(10);
			
			jtfRelease = new JTextField();
			panel.add(jtfRelease);
			jtfRelease.setColumns(10);
			
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
			
			jtfRoomNum.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER){
						row.removeAllElements();
						for(int i=0;i<copy.size();i++){
							if(copy.get(i).get(4).contains(jtfRoomNum.getText())) row.addElement(copy.get(i));
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
							if(copy.get(i).get(5).contains(jtfLevel.getText())) row.addElement(copy.get(i));
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
							if(copy.get(i).get(6).contains(jtfRelease.getText())) row.addElement(copy.get(i));
						}
						jtTicketInfo.updateUI();
					}
				}
			});
			
			final JScrollPane jsp = new JScrollPane(jtTicketInfo);
			getContentPane().add(jsp, BorderLayout.CENTER);
			setVisible(true);
	}

}
