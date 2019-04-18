package com.littlepage.view;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for TrainNumberInfoAdd
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import java.awt.*;
import javax.swing.*;
import com.littlepage.dao.RailwayDBOperation;
import com.littlepage.entity.TrainNumberInfo;
import com.littlepage.validate.JudgeChain;
import java.awt.event.*;
import java.util.ArrayList;

public class TrainNumberInfoAdd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jtfEndLocation;
	private JTextField jtfRunTime;
	private JTextField jtfStartTimeYear;
	private JTextField jtfStartTimeMonth;
	private JTextField jtfStartTimeDay;
	private JTextField jtfTrainNumber;
	private JTextField jtfStartLocation;
	private JTextField jtfEndTimeYear;
	private JTextField jtfEndTimeMonth;
	private JTextField jtfEndTimeDay;
	private JTextField jtfStartHour;
	private JTextField jtfStartMin;
	private JTextField jtfEndHour;
	private JTextField jtfEndMin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new TrainNumberInfoAdd();
	}
	

	/**
	 * Create the frame.
	 */
	public TrainNumberInfoAdd() {
		//frame design
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel jpCenter = new JPanel();
		getContentPane().add(jpCenter, BorderLayout.CENTER);
		jpCenter.setLayout(new GridLayout(7,2));
		
		JLabel jlTrainNumber = new JLabel("车次");
		jlTrainNumber.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlTrainNumber);
		
		jtfTrainNumber = new JTextField();
		jpCenter.add(jtfTrainNumber);
		jtfTrainNumber.setColumns(10);
		
		JLabel jlTrainType = new JLabel("类型");
		jlTrainType.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlTrainType);
		
		Panel jpTrainType = new Panel();
		jpCenter.add(jpTrainType);
		
		final JRadioButton rb0 = new JRadioButton("高铁");
		jpTrainType.add(rb0);
		
		final JRadioButton rb1 = new JRadioButton("动车");
		jpTrainType.add(rb1);
		
		final JRadioButton rb2 = new JRadioButton("快车");
		jpTrainType.add(rb2);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb0);
		bg.add(rb1);
		bg.add(rb2);
		
		JLabel jlStartLocation = new JLabel("起点");
		jlStartLocation.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlStartLocation);
		
		jtfStartLocation = new JTextField();
		jpCenter.add(jtfStartLocation);
		jtfStartLocation.setColumns(10);
		
		JLabel jlEndLocation = new JLabel("终点");
		jlEndLocation.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlEndLocation);
		
		jtfEndLocation = new JTextField();
		jtfEndLocation.setText("");
		jpCenter.add(jtfEndLocation);
		jtfEndLocation.setColumns(20);
		
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
		
		jtfEndTimeYear = new JTextField();
		jtfEndTimeYear.setColumns(4);
		jpEndTime.add(jtfEndTimeYear);
		
		JLabel jlYear2 = new JLabel("年");
		jpEndTime.add(jlYear2);
		
		jtfEndTimeMonth = new JTextField();
		jtfEndTimeMonth.setColumns(2);
		jpEndTime.add(jtfEndTimeMonth);
		
		JLabel jlMonth2 = new JLabel("月");
		jpEndTime.add(jlMonth2);
		
		jtfEndTimeDay = new JTextField();
		jtfEndTimeDay.setColumns(2);
		jpEndTime.add(jtfEndTimeDay);
		
		JLabel jlDay2 = new JLabel("日");
		jpEndTime.add(jlDay2);
		
		jtfEndHour = new JTextField();
		jtfEndHour.setColumns(2);
		jpEndTime.add(jtfEndHour);
		
		JLabel jlEndHour = new JLabel("时");
		jpEndTime.add(jlEndHour);
		
		jtfEndMin = new JTextField();
		jtfEndMin.setColumns(2);
		jpEndTime.add(jtfEndMin);
		
		JLabel jlEndMin = new JLabel("分");
		jpEndTime.add(jlEndMin);
		
		JLabel jlRuntime = new JLabel("运行时间");
		jlRuntime.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlRuntime);
		
		jtfRunTime = new JTextField();
		jpCenter.add(jtfRunTime);
		
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
				if(JudgeChain.JudgeChainTrainNumberInfo(jtfTrainNumber.getText(),jtfStartLocation.getText(),
							jtfEndLocation.getText(),jtfStartTimeYear.getText(),
							jtfStartTimeMonth.getText(),jtfStartTimeDay.getText(),
							jtfEndTimeYear.getText(),jtfEndTimeMonth.getText(),
							jtfEndTimeDay.getText(),jtfRunTime.getText(),
							jtfStartHour.getText(),jtfEndHour.getText(),
							jtfStartMin.getText(),jtfEndMin.getText())==false) return;
				
				//Judge Repeat
				ArrayList<TrainNumberInfo> arr=RailwayDBOperation.trainNumberInfoQueryAll();
				for (TrainNumberInfo trainNumberInfo : arr) {
					if(jtfTrainNumber.getText().equals(trainNumberInfo.getTrainNumber())){
						JOptionPane.showMessageDialog(null, "该车次已经存在");
						return;
					}
				}
				
				//insert data
				int trainType;
				if(rb0.isSelected()) trainType=0;
				else if(rb1.isSelected()) trainType=1;
				else trainType=2;
				
				String startTime=jtfStartTimeYear.getText()+"-"+jtfStartTimeMonth.getText()+"-"+jtfStartTimeDay.getText()+"-"+jtfStartHour.getText()+"-"+jtfStartMin.getText();
				String endTime=jtfEndTimeYear.getText()+"-"+jtfEndTimeMonth.getText()+"-"+jtfEndTimeDay.getText()+"-"+jtfEndHour.getText()+"-"+jtfEndMin.getText();
				
				RailwayDBOperation.trainNumberInfoAdd(new TrainNumberInfo(0, jtfTrainNumber.getText(),
						trainType, jtfStartLocation.getText(), jtfEndLocation.getText(), startTime, endTime, jtfRunTime.getText()));
				JOptionPane.showMessageDialog(null, "插入成功");
				dispose();
				new AdministratorModifyTrainNumberInfo();
			}
		});
		
		
		//jbCancel Listener
		jbCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdministratorModifyTrainNumberInfo();
			}
		});
		//Must Method
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 587, 300);
		setIconImage(new ImageIcon("img/icon.jpg").getImage());
		setTitle("添加车次信息");
		setVisible(true);
	}
}
