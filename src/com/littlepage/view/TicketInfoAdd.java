package com.littlepage.view;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for TicketInfoAdd
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import java.awt.*;
import javax.swing.*;
import com.littlepage.dao.RailwayDBOperation;
import com.littlepage.entity.TicketInfo;
import com.littlepage.validate.JudgeChain;
import java.awt.event.*;

public class TicketInfoAdd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jtfStartTimeYear;
	private JTextField jtfStartTimeMonth;
	private JTextField jtfStartTimeDay;
	private JTextField jtfTrainNumber;
	private JTextField jtfStartHour;
	private JTextField jtfStartMin;
	private JTextField jtfRoomNum;
	private JTextField jtfSpareSeatNum;
	private JTextField jtfEndYear;
	private JTextField jtfEndMonth;
	private JTextField jtfEndDay;
	private JTextField jtfEndHour;
	private JTextField jtfEndMinute;
	private JTextField jtfStartStation;
	private JTextField jtfEndStation;
	private JTextField jtfTicketPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new TicketInfoAdd();
	}
	

	/**
	 * Create the frame.
	 */
	public TicketInfoAdd() {
		//frame design
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel jpCenter = new JPanel();
		getContentPane().add(jpCenter, BorderLayout.CENTER);
		jpCenter.setLayout(new GridLayout(9,2));
		
		JLabel jlTrainNumber = new JLabel("车次");
		jlTrainNumber.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlTrainNumber);
		
		jtfTrainNumber = new JTextField();
		jpCenter.add(jtfTrainNumber);
		jtfTrainNumber.setColumns(10);
		
		JLabel jlStartTime = new JLabel("发车时间");
		jlStartTime.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlStartTime);
		
		JPanel jpStartTime = new JPanel();
		jpCenter.add(jpStartTime);
		
		jtfStartTimeYear = new JTextField();
		jpStartTime.add(jtfStartTimeYear);
		jtfStartTimeYear.setColumns(4);
		
		JLabel jlYear1 = new JLabel("年");
		jpStartTime.add(jlYear1);
		
		jtfStartTimeMonth = new JTextField();
		jpStartTime.add(jtfStartTimeMonth);
		jtfStartTimeMonth.setColumns(2);
		
		JLabel jlMonth1 = new JLabel("月");
		jpStartTime.add(jlMonth1);
		
		jtfStartTimeDay = new JTextField();
		jpStartTime.add(jtfStartTimeDay);
		jtfStartTimeDay.setColumns(2);
		
		JLabel jlDay1 = new JLabel("日");
		jpStartTime.add(jlDay1);
		
		jtfStartHour = new JTextField();
		jpStartTime.add(jtfStartHour);
		jtfStartHour.setColumns(2);
		
		JLabel jlStartHour = new JLabel("时");
		jpStartTime.add(jlStartHour);
		
		jtfStartMin = new JTextField();
		jtfStartMin.setColumns(2);
		jpStartTime.add(jtfStartMin);
		
		JLabel jlStartMin = new JLabel("分");
		jpStartTime.add(jlStartMin);
		
		JLabel jlEndTime = new JLabel("到达时间");
		jlEndTime.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlEndTime);
		
		JPanel jpEndTime = new JPanel();
		jpCenter.add(jpEndTime);
		
		jtfEndYear = new JTextField();
		jtfEndYear.setColumns(4);
		jpEndTime.add(jtfEndYear);
		
		JLabel jlEndYear = new JLabel("年");
		jpEndTime.add(jlEndYear);
		
		jtfEndMonth = new JTextField();
		jtfEndMonth.setColumns(2);
		jpEndTime.add(jtfEndMonth);
		
		JLabel jlEndMonth = new JLabel("月");
		jpEndTime.add(jlEndMonth);
		
		jtfEndDay = new JTextField();
		jtfEndDay.setColumns(2);
		jpEndTime.add(jtfEndDay);
		
		JLabel jlEndDay = new JLabel("日");
		jpEndTime.add(jlEndDay);
		
		jtfEndHour = new JTextField();
		jtfEndHour.setColumns(2);
		jpEndTime.add(jtfEndHour);
		
		JLabel jlEndHour = new JLabel("时");
		jpEndTime.add(jlEndHour);
		
		jtfEndMinute = new JTextField();
		jtfEndMinute.setColumns(2);
		jpEndTime.add(jtfEndMinute);
		
		JLabel jlEndMinute = new JLabel("分");
		jpEndTime.add(jlEndMinute);
		
		JLabel jlStartStation = new JLabel("起点站");
		jlStartStation.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlStartStation);
		
		jtfStartStation = new JTextField();
		jpCenter.add(jtfStartStation);
		jtfStartStation.setColumns(10);
		
		JLabel jlEndStation = new JLabel("终点站");
		jlEndStation.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlEndStation);
		
		jtfEndStation = new JTextField();
		jpCenter.add(jtfEndStation);
		jtfEndStation.setColumns(10);
		
		JLabel jlRoomNum = new JLabel("车厢号");
		jlRoomNum.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlRoomNum);
		
		jtfRoomNum = new JTextField();
		jpCenter.add(jtfRoomNum);
		jtfRoomNum.setColumns(10);
		
		JLabel jlLevel = new JLabel("等级");
		jlLevel.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlLevel);
		
		Panel jpLevel = new Panel();
		jpCenter.add(jpLevel);
		
		final JRadioButton rb0 = new JRadioButton("商务座");
		jpLevel.add(rb0);
		
		final JRadioButton rb1 = new JRadioButton("一等座");
		jpLevel.add(rb1);
		
		final JRadioButton rb2 = new JRadioButton("二等座");
		jpLevel.add(rb2);
		
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(rb0);
		bg1.add(rb1);
		bg1.add(rb2);
		
		JLabel jlSpareSeatNum = new JLabel("空余座位数量");
		jlSpareSeatNum.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlSpareSeatNum);
		
		jtfSpareSeatNum = new JTextField();
		jpCenter.add(jtfSpareSeatNum);
		jtfSpareSeatNum.setColumns(10);
		
		JLabel jlTicketPrice = new JLabel("票价");
		jlTicketPrice.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlTicketPrice);
		
		jtfTicketPrice = new JTextField();
		jpCenter.add(jtfTicketPrice);
		jtfTicketPrice.setColumns(10);
		
		JPanel jpSouth = new JPanel();
		getContentPane().add(jpSouth, BorderLayout.SOUTH);
		
		JButton jbAdd = new JButton("添加");
		jpSouth.add(jbAdd);
		
		JButton jbCancel = new JButton("取消");
		jpSouth.add(jbCancel);
		
		//listeners
		jbAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Judge format
				if(JudgeChain.JudgeChainTicketInfo(jtfTrainNumber.getText(),jtfStartTimeYear.getText(),
						jtfStartTimeMonth.getText(),jtfStartTimeDay.getText(),jtfStartHour.getText()
						,jtfStartMin.getText(),jtfRoomNum.getText(),jtfSpareSeatNum.getText(),
						jtfEndYear.getText(),jtfEndMonth.getText(),jtfEndDay.getText(),
						jtfEndHour.getText(),jtfEndMinute.getText(),jtfStartStation.getText(),
						jtfEndStation.getText(),jtfTicketPrice.getText())==false) return;
				
				//Judge Repeat unnessary,skip it
				
				//insert data
				String startTime=jtfStartTimeYear.getText()+"-"
				+jtfStartTimeMonth.getText()+"-"+jtfStartTimeDay.getText()
				+"-"+jtfStartHour.getText()+"-"+jtfStartMin.getText();
				String endTime=jtfEndYear.getText()+"-"
						+jtfEndMonth.getText()+"-"+jtfEndDay.getText()
						+"-"+jtfEndHour.getText()+"-"+jtfEndMinute.getText();
				String seatLevel=null;
				if(rb0.isSelected()) seatLevel="0";
				else if(rb1.isSelected()) seatLevel="1";
				else if(rb2.isSelected()) seatLevel="2";
				RailwayDBOperation.ticketInfoAdd(new TicketInfo(0, jtfTrainNumber.getText()
						, startTime, endTime,jtfStartStation.getText(),jtfEndStation.getText()
						, jtfRoomNum.getText(), Integer.parseInt(seatLevel)
						, Integer.parseInt(jtfSpareSeatNum.getText())
						,Double.parseDouble(jtfTicketPrice.getText())));
				JOptionPane.showMessageDialog(null, "插入成功");
				dispose();
				new AdministratorModifyTicketInfo();
			}
		});
		
		
		//jbCancel Listener
		jbCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdministratorModifyTicketInfo();
			}
		});
		//Must Method
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 609, 402);
		setIconImage(new ImageIcon("img/icon.jpg").getImage());
		setTitle("添加车次信息");
		setVisible(true);
	}
}
