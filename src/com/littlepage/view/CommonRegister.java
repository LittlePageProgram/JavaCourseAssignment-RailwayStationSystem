package com.littlepage.view;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The frame for CommonRegister
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import java.awt.*;
import javax.swing.*;
import com.littlepage.dao.RailwayDBOperation;
import com.littlepage.entity.CustomerInfo;
import com.littlepage.validate.JudgeChain;
import java.awt.event.*;
import java.util.ArrayList;

public class CommonRegister extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jtfName;
	private JTextField jtfIdentityNum;
	private JTextField jtfPhonecall;
	private JPasswordField jpfPassword;
	private JPasswordField jpfRepeatPassword;
	private JTextField jtfBirthdateYear;
	private JTextField jtfBirthdateMonth;
	private JTextField jtfBrithdateDay;
	private JTextField jtfLoginName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommonRegister frame = new CommonRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CommonRegister() {
		//frame design
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel jpCenter = new JPanel();
		getContentPane().add(jpCenter, BorderLayout.CENTER);
		jpCenter.setLayout(new GridLayout(8,2));
		
		JLabel jlLoginName = new JLabel("登录名");
		jlLoginName.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlLoginName);
		
		jtfLoginName = new JTextField();
		jpCenter.add(jtfLoginName);
		jtfLoginName.setColumns(10);
		
		JLabel jlName = new JLabel("姓名");
		jlName.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlName);
		
		jtfName = new JTextField();
		jpCenter.add(jtfName);
		jtfName.setColumns(10);
		
		JLabel jlSex = new JLabel("性别");
		jlSex.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlSex);
		
		JPanel jpSex = new JPanel();
		jpCenter.add(jpSex);
		
		
		final JRadioButton jrbM = new JRadioButton("男");
		jrbM.setSelected(true);
		jpSex.add(jrbM);
		
		JRadioButton jrbF = new JRadioButton("女");
		jpSex.add(jrbF);

		ButtonGroup bg=new ButtonGroup();
		bg.add(jrbM);
		bg.add(jrbF);
		
		JLabel jlIdentityNum = new JLabel("身份证号码");
		jlIdentityNum.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlIdentityNum);
		
		jtfIdentityNum = new JTextField();
		jtfIdentityNum.setText("");
		jpCenter.add(jtfIdentityNum);
		jtfIdentityNum.setColumns(20);
		
		JLabel jlBirthdate = new JLabel("出生日期");
		jlBirthdate.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlBirthdate);
		
		JPanel jpBirthdate = new JPanel();
		jpCenter.add(jpBirthdate);
		
		jtfBirthdateYear = new JTextField();
		jpBirthdate.add(jtfBirthdateYear);
		jtfBirthdateYear.setColumns(4);
		
		JLabel jlBirthdateYear = new JLabel("年");
		jpBirthdate.add(jlBirthdateYear);
		
		jtfBirthdateMonth = new JTextField();
		jpBirthdate.add(jtfBirthdateMonth);
		jtfBirthdateMonth.setColumns(2);
		
		JLabel jlBirthdateMonth = new JLabel("月");
		jpBirthdate.add(jlBirthdateMonth);
		
		jtfBrithdateDay = new JTextField();
		jpBirthdate.add(jtfBrithdateDay);
		jtfBrithdateDay.setColumns(2);
		
		JLabel jlBirthdateDay = new JLabel("日");
		jpBirthdate.add(jlBirthdateDay);
		
		JLabel jlPhonecall = new JLabel("电话号码");
		jlPhonecall.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlPhonecall);
		
		jtfPhonecall = new JTextField();
		jpCenter.add(jtfPhonecall);
		jtfPhonecall.setColumns(20);
		
		JLabel jlPassword = new JLabel("密码");
		jlPassword.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlPassword);
		
		jpfPassword = new JPasswordField();
		jpCenter.add(jpfPassword);
		
		JLabel jlRepeatPassword = new JLabel("确认密码");
		jlRepeatPassword.setHorizontalAlignment(SwingConstants.CENTER);
		jpCenter.add(jlRepeatPassword);
		
		jpfRepeatPassword = new JPasswordField();
		jpCenter.add(jpfRepeatPassword);
		jpfRepeatPassword.setColumns(10);
		
		JPanel jpSouth = new JPanel();
		getContentPane().add(jpSouth, BorderLayout.SOUTH);
		
		JButton jbRegister = new JButton("注册");
		jpSouth.add(jbRegister);
		
		JButton jbCancel = new JButton("取消");
		jpSouth.add(jbCancel);

		//listeners
		jbRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Judge
				if(JudgeChain.JudgeChainCommonRegisterFrame(jtfLoginName.getText(),jtfName.getText(),jtfIdentityNum.getText(),
						jtfBirthdateYear.getText(),jtfBirthdateMonth.getText(),jtfBrithdateDay.getText(),
						jtfPhonecall.getText(),String.valueOf(jpfPassword.getPassword()),String.valueOf(jpfRepeatPassword.getPassword()))==false){
					return;
				}
				//Judge Repeat
				ArrayList<CustomerInfo> arr=RailwayDBOperation.customerInfoQueryAll();
				for (CustomerInfo customerInfo : arr) {
					if(customerInfo.getLoginName().equals(jtfLoginName.getText())){
						JOptionPane.showMessageDialog(null, "用户已存在");
						return;
					}
				}
				//insert data
				String sex;
				if(jrbM.isSelected()) sex="M";
				else sex="F";
				String birthTime=jtfBirthdateYear.getText()+"-"+jtfBirthdateMonth.getText()+"-"+jtfBrithdateDay.getText();
				RailwayDBOperation.customerInfoAdd(new CustomerInfo(0,jtfLoginName.getText(), jtfName.getText(), sex, jtfIdentityNum.getText(), birthTime, jtfPhonecall.getText(), String.valueOf(jpfPassword.getPassword())));
				JOptionPane.showMessageDialog(null, "注册成功");
				new Login();
				dispose();
			}
		});
		jbCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainFrame();
			}
		});
		//Must Method
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 450, 300);
		setIconImage(new ImageIcon("img/icon.jpg").getImage());
		setTitle("普通用户注册");
		setVisible(true);
	}

}
