package com.littlepage.view;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for AdministratorModifyStationInfo
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

public class AdministratorModifyStationInfo extends AdministratorMainFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfTrainNumber;
	private JTextField jtfStationNumber;
	private JTextField jtfStationInfo;
	private JTextField jtfStartTime;
	private JTextField jtfMils;
	private JTextField jtfStepNum;


	public AdministratorModifyStationInfo() {
		// user table
				final Vector<Vector<String>> row = new Vector<>();
				Vector<String> column = new Vector<>();
				column.add("编号");
				column.add("车次");
				column.add("站点序号");
				column.add("站点信息");
				column.add("发车时间");
				column.add("里程");
				column.add("站号");

				ArrayList<StationInfo> arrSta=RailwayDBOperation.stationInfoQueryAll();
				for (StationInfo stationInfo : arrSta) {
					Vector<String> temp=new Vector<>();
					temp.add(stationInfo.getId()+"");
					temp.add(stationInfo.getTrainNumber());
					temp.add(stationInfo.getStationNumber());
					temp.add(stationInfo.getStationInfo());
					StringBuilder startTime=new StringBuilder(stationInfo.getStartTime());
					temp.add(startTime.substring(0,16));
					temp.add(stationInfo.getDistance()+"");
					temp.add(stationInfo.getStep()+"");
					row.add(temp);
				}
				final JTable jtStationInfo = new JTable(row, column) {
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
				final JScrollPane jsp = new JScrollPane(jtStationInfo);
				getContentPane().add(jsp, BorderLayout.CENTER);
				
				Panel panel = new Panel();
				getContentPane().add(panel,BorderLayout.NORTH);
				panel.setLayout(new GridLayout(1,7));
				
				jtfId = new JTextField();
				panel.add(jtfId);
				jtfId.setColumns(10);
				
				jtfTrainNumber = new JTextField();
				panel.add(jtfTrainNumber);
				jtfTrainNumber.setColumns(10);
				
				jtfStationNumber = new JTextField();
				panel.add(jtfStationNumber);
				jtfStationNumber.setColumns(10);
				
				jtfStationInfo = new JTextField();
				panel.add(jtfStationInfo);
				jtfStationInfo.setColumns(10);
				
				jtfStartTime = new JTextField();
				panel.add(jtfStartTime);
				jtfStartTime.setColumns(10);
				
				jtfMils = new JTextField();
				panel.add(jtfMils);
				jtfMils.setColumns(10);
				
				jtfStepNum = new JTextField();
				panel.add(jtfStepNum);
				jtfStepNum.setColumns(10);
				
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
							jtStationInfo.updateUI();
						}
					}
				});
				
				jtfTrainNumber.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode()==KeyEvent.VK_ENTER){
							row.removeAllElements();
							for(int i=0;i<copy.size();i++){
								if(copy.get(i).get(1).contains(jtfTrainNumber.getText())) row.addElement(copy.get(i));
							}
							jtStationInfo.updateUI();
						}
					}
				});
				
				jtfStationNumber.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode()==KeyEvent.VK_ENTER){
							row.removeAllElements();
							for(int i=0;i<copy.size();i++){
								if(copy.get(i).get(2).contains(jtfStationNumber.getText())) row.addElement(copy.get(i));
							}
							jtStationInfo.updateUI();
						}
					}
				});
				
				jtfStationInfo.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode()==KeyEvent.VK_ENTER){
							row.removeAllElements();
							for(int i=0;i<copy.size();i++){
								if(copy.get(i).get(3).contains(jtfStationInfo.getText())) row.addElement(copy.get(i));
							}
							jtStationInfo.updateUI();
						}
					}
				});
				
				jtfStartTime.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode()==KeyEvent.VK_ENTER){
							row.removeAllElements();
							for(int i=0;i<copy.size();i++){
								if(copy.get(i).get(4).contains(jtfStartTime.getText())) row.addElement(copy.get(i));
							}
							jtStationInfo.updateUI();
						}
					}
				});
				
				jtfMils.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode()==KeyEvent.VK_ENTER){
							row.removeAllElements();
							for(int i=0;i<copy.size();i++){
								if(copy.get(i).get(5).contains(jtfMils.getText())) row.addElement(copy.get(i));
							}
							jtStationInfo.updateUI();
						}
					}
				});
				
				jtfStepNum.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode()==KeyEvent.VK_ENTER){
							row.removeAllElements();
							for(int i=0;i<copy.size();i++){
								if(copy.get(i).get(6).contains(jtfStepNum.getText())) row.addElement(copy.get(i));
							}
							jtStationInfo.updateUI();
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
						new StationInfoAdd();
						dispose();
					}
				});

				jbUpdate.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int row = jtStationInfo.getSelectedRow();// get selected row
						if (row == -1) {
							JOptionPane.showMessageDialog(null, "未选中任何数据");
							return;
						}
						StationInfo si=new StationInfo(Integer.parseInt(jtStationInfo.getValueAt(row, 0).toString()), 
								jtStationInfo.getValueAt(row, 1).toString(), jtStationInfo.getValueAt(row, 2).toString(), 
								jtStationInfo.getValueAt(row, 3).toString(), jtStationInfo.getValueAt(row, 4).toString(),
								Double.parseDouble(jtStationInfo.getValueAt(row, 5).toString()),
								Integer.parseInt(jtStationInfo.getValueAt(row, 6).toString()));
						if (JudgeChain.JudgeChainStationInfo(si) == false) {
							return;
						}
						RailwayDBOperation.StationInfoUpdate(si);
						JOptionPane.showMessageDialog(null, "更新成功");
						validate();
					}
				});
				
				jbDelete.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int row = jtStationInfo.getSelectedRow();// get selected row
						if (row == -1) {
							JOptionPane.showMessageDialog(null, "未选中任何数据");
							return;
						}
						RailwayDBOperation.stationInfoDeleteById(Integer.parseInt(jtStationInfo.getValueAt(row, 0).toString()));
						dispose();
						new AdministratorModifyStationInfo();
					}
				});
				setVisible(true);

	}

}
