package com.littlepage.view;

/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for AdministratorModifyTrainNumberInfo
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

public class AdministratorModifyTrainNumberInfo extends AdministratorMainFrame {
	private Panel panel;
	private JTextField jtfId;
	private JTextField jtfTrainNum;
	private JTextField jtfType;
	private JTextField jtfStartStation;
	private JTextField jtfEndStation;
	private JTextField jtfStartTime;
	private JTextField jtfEndTime;
	private JTextField jtfRunTime;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public AdministratorModifyTrainNumberInfo() {
		// user table
		final Vector<Vector<String>> row = new Vector<>();
		Vector<String> column = new Vector<>();
		column.add("编号");
		column.add("车次");
		column.add("类型");
		column.add("起点");
		column.add("终点");
		column.add("发车时间");
		column.add("到达时间");
		column.add("运行时间");

		ArrayList<TrainNumberInfo> arrTra = RailwayDBOperation
				.trainNumberInfoQueryAll();
		for (TrainNumberInfo trainNumberInfo : arrTra) {
			Vector<String> temp = new Vector<String>();
			temp.add(trainNumberInfo.getId() + "");
			temp.add(trainNumberInfo.getTrainNumber());
			temp.add(trainNumberInfo.getTrainType() + "");
			temp.add(trainNumberInfo.getStartLocation());
			temp.add(trainNumberInfo.getEndLocation());
			StringBuilder sbst = new StringBuilder(
					trainNumberInfo.getStartTime());
			temp.add(sbst.substring(0, 16));
			StringBuilder sbet = new StringBuilder(trainNumberInfo.getEndTime());
			temp.add(sbet.substring(0, 16));
			temp.add(trainNumberInfo.getRunTime());
			row.add(temp);
		}
		final JTable jtTrainNumberInfo = new JTable(row, column) {
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
		final JScrollPane jsp = new JScrollPane(jtTrainNumberInfo);
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

		jtfType = new JTextField();
		panel.add(jtfType);
		jtfType.setColumns(10);

		jtfStartStation = new JTextField();
		panel.add(jtfStartStation);
		jtfStartStation.setColumns(10);

		jtfEndStation = new JTextField();
		panel.add(jtfEndStation);
		jtfEndStation.setColumns(10);

		jtfStartTime = new JTextField();
		panel.add(jtfStartTime);
		jtfStartTime.setColumns(10);

		jtfEndTime = new JTextField();
		panel.add(jtfEndTime);
		jtfEndTime.setColumns(10);
		
		jtfRunTime = new JTextField();
		panel.add(jtfRunTime);
		jtfRunTime.setColumns(10);
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
					jtTrainNumberInfo.updateUI();
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
					jtTrainNumberInfo.updateUI();
				}
			}
		});

		jtfType.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(2).contains(jtfType.getText()))
							row.addElement(copy.get(i));
					}
					jtTrainNumberInfo.updateUI();
				}
			}
		});

		jtfStartStation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(3).contains(jtfStartStation.getText()))
							row.addElement(copy.get(i));
					}
					jtTrainNumberInfo.updateUI();
				}
			}
		});

		jtfEndStation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(4)
								.contains(jtfEndStation.getText()))
							row.addElement(copy.get(i));
					}
					jtTrainNumberInfo.updateUI();
				}
			}
		});

		jtfStartTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(5)
								.contains(jtfStartTime.getText()))
							row.addElement(copy.get(i));
					}
					jtTrainNumberInfo.updateUI();
				}
			}
		});

		jtfEndTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					row.removeAllElements();
					for (int i = 0; i < copy.size(); i++) {
						if (copy.get(i).get(6).contains(jtfEndTime.getText()))
							row.addElement(copy.get(i));
					}
					jtTrainNumberInfo.updateUI();
				}
			}
		});

		
		jtfRunTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					row.removeAllElements();
					for(int i=0;i<copy.size();i++){
						if(copy.get(i).get(9).contains(jtfRunTime.getText())) row.addElement(copy.get(i));
					}
					jtTrainNumberInfo.updateUI();
				}
			}
		});
		// Button Listeners
		jbAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TrainNumberInfoAdd();
				dispose();
			}
		});

		jbUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = jtTrainNumberInfo.getSelectedRow();// get selected row
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "未选中任何数据");
					return;
				}

				TrainNumberInfo ti = new TrainNumberInfo(Integer
						.parseInt(jtTrainNumberInfo.getValueAt(row, 0)
								.toString()), jtTrainNumberInfo.getValueAt(row,
						1).toString(), Integer.parseInt(jtTrainNumberInfo
						.getValueAt(row, 2).toString()), jtTrainNumberInfo
						.getValueAt(row, 3).toString(), jtTrainNumberInfo
						.getValueAt(row, 4).toString(), jtTrainNumberInfo
						.getValueAt(row, 5).toString(), jtTrainNumberInfo
						.getValueAt(row, 6).toString(), jtTrainNumberInfo
						.getValueAt(row, 7).toString());
				// Judge
				if (JudgeChain.JudgeChainTrainNumberInfo(ti) == false) {
					return;
				}
				RailwayDBOperation.trainNumberInfoUpdate(ti);
				JOptionPane.showMessageDialog(null, "更新成功");
				validate();
			}
		});
		jbDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = jtTrainNumberInfo.getSelectedRow();// get selected row
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "未选中任何数据");
					return;
				}
				RailwayDBOperation.trainNumberInfoDeleteById(Integer
						.parseInt(jtTrainNumberInfo.getValueAt(row, 0)
								.toString()));
				dispose();
				new AdministratorModifyTrainNumberInfo();
			}
		});
		setVisible(true);
	}

}
