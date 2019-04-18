package com.littlepage.view;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for StationInfoAdd
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import com.littlepage.dao.RailwayDBOperation;
import com.littlepage.entity.StationInfo;
import com.littlepage.validate.JudgeChain;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StationInfoAdd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfTrainNumber;
	private JTextField jtfStationInfo;
	private JTextField jtfDistance;
	private JTextField jtfStationNumber;
	private final JButton jbAdd = new JButton("添加");
	private JTextField jtfStep;
	private JLabel jlStep;
	private JTextField jtfStartTimeYear;
	private JTextField jtfStartTimeMonth;
	private JTextField jtfStartTimeDay;
	private JTextField jtfStartTimeHour;
	private JTextField jtfStartTimeMin;
	public static void main(String[] args) {
		new StationInfoAdd();
	}
	/**
	 * Create the frame.
	 */
	public StationInfoAdd() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(6,2));
		
		JLabel jlTrainNumber = new JLabel("车次");
		jlTrainNumber.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(jlTrainNumber);
		
		jtfTrainNumber = new JTextField();
		panel.add(jtfTrainNumber);
		jtfTrainNumber.setColumns(10);
		
		JLabel jlStationNumber = new JLabel("站点序号");
		jlStationNumber.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(jlStationNumber);
		
		jtfStationNumber = new JTextField();
		panel.add(jtfStationNumber);
		jtfStationNumber.setColumns(10);
		
		JLabel jlStationInfo = new JLabel("站点信息");
		jlStationInfo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(jlStationInfo);
		
		jtfStationInfo = new JTextField();
		jtfStationInfo.setText("");
		panel.add(jtfStationInfo);
		jtfStationInfo.setColumns(10);
		
		JLabel jlStartTime = new JLabel("发车时间");
		jlStartTime.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(jlStartTime);
		
		JPanel jpStartTime = new JPanel();
		panel.add(jpStartTime);
		
		jtfStartTimeYear = new JTextField();
		jtfStartTimeYear.setColumns(4);
		jpStartTime.add(jtfStartTimeYear);
		
		JLabel jlStartTimeYear = new JLabel("年");
		jpStartTime.add(jlStartTimeYear);
		
		jtfStartTimeMonth = new JTextField();
		jtfStartTimeMonth.setColumns(2);
		jpStartTime.add(jtfStartTimeMonth);
		
		JLabel jlStartTimeMonth = new JLabel("月");
		jpStartTime.add(jlStartTimeMonth);
		
		jtfStartTimeDay = new JTextField();
		jtfStartTimeDay.setColumns(2);
		jpStartTime.add(jtfStartTimeDay);
		
		JLabel jlStartTimeDay = new JLabel("日");
		jpStartTime.add(jlStartTimeDay);
		
		jtfStartTimeHour = new JTextField();
		jtfStartTimeHour.setColumns(2);
		jpStartTime.add(jtfStartTimeHour);
		
		JLabel jlStartTimeHour = new JLabel("时");
		jpStartTime.add(jlStartTimeHour);
		
		jtfStartTimeMin = new JTextField();
		jtfStartTimeMin.setColumns(2);
		jpStartTime.add(jtfStartTimeMin);
		
		JLabel jlStartTimeMin = new JLabel("分");
		jpStartTime.add(jlStartTimeMin);
		
		JLabel jlDistance = new JLabel("里程");
		jlDistance.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(jlDistance);
		
		jtfDistance = new JTextField();
		panel.add(jtfDistance);
		jtfDistance.setColumns(10);
		
		jlStep = new JLabel("站台号");
		jlStep.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(jlStep);
		
		jtfStep = new JTextField();
		panel.add(jtfStep);
		jtfStep.setColumns(10);
		
		Panel panel_1 = new Panel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.add(jbAdd);
		
		JButton jbCancel = new JButton("取消");
		panel_1.add(jbCancel);
		
		//listeners
		jbAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String startTime=jtfStartTimeYear.getText()+"-"+jtfStartTimeMonth.getText()+
						"-"+jtfStartTimeDay.getText()+" "+jtfStartTimeHour.getText()+":"+jtfStartTimeMin.getText();
				//Judge format
				if(JudgeChain.JudgeChainStationInfo(jtfTrainNumber.getText(),jtfStationNumber.getText(),
						jtfStationInfo.getText(),startTime,jtfDistance.getText(),jtfStep.getText())==false) return;
				
				//Judge Repeat not necessary
				
				//insert data
				RailwayDBOperation.stationInfoAdd(new StationInfo(0, jtfTrainNumber.getText(), jtfStationNumber.getText()
						, jtfStationInfo.getText(), startTime, Double.parseDouble(jtfDistance.getText()),Integer.parseInt(jtfStep.getText())));
				
				JOptionPane.showMessageDialog(null, "插入成功");
				dispose();
				new AdministratorModifyStationInfo();
			}
		});
		//jbCancel Listener
		jbCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdministratorModifyStationInfo();
			}
		});
		//Must Method
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 609, 402);
		setIconImage(new ImageIcon("img/icon.jpg").getImage());
		setTitle("添加车次信息");
		setVisible(true);
		
		
		setVisible(true);
	}
}
