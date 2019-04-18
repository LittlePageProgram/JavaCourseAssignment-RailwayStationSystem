package com.littlepage.validate;

/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:Judge data by regular expression
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import java.util.*;
import javax.swing.JOptionPane;
import com.littlepage.dao.RailwayDBOperation;
import com.littlepage.entity.Administrator;
 
public class Judge {
	/**
	 * @function:judge void
	 * @return:String
	 * @annoation:if data is void, return the String "-1"
	 */
	public static String judgeVoid(String str){
		if(str.equals("")) {
			JOptionPane.showMessageDialog(null, "输入不能为空");
			return "-1";
		}
		return str;
	}
	
	/**
	 * @function:judge alphabet
	 * @return:String
	 * @annoation:if data is not alphabet, return the String "-1"
	 */
	public static String judgeAlphabet(String str){
		if(!str.matches("[0-9a-zA-Z]+")){
			JOptionPane.showMessageDialog(null, "输入框只能输入数字和字母");
			return "-1";
		}
		return str;
	}
	
	/**
	 * @function:judge repitation of twice password
	 * @param:String password1,String password2
	 * @return:boolean
	 * @annoation:if data is repitation, return false
	 */
	public static boolean judgePasswordRepitation(String password1,String password2){
		if(!password1.equals(password2)){
			JOptionPane.showMessageDialog(null, "密码不一致");
			return false;
		}
		return true;
	}
	
	/**
	 * @function:judge the data is existed in database
	 * @param:String name
	 * @return:boolean
	 * @annoation:if data is not exist, return false
	 */
	public static boolean judgeRepeatAdministrator(String name){
		ArrayList<Administrator> arr=RailwayDBOperation.administratorQueryAll();
		for (Administrator administrator : arr) {
			if(administrator.getName().equals(name)){
				JOptionPane.showMessageDialog(null, "用户已存在");
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @function:judge the data is or not identityNum
	 * @param:String identityNum
	 * @return:boolean
	 * @annoation:if data is not identityNum, return false
	 */
	public static boolean judgeIdentityNum(String identityNum) {
		if(!identityNum.matches("\\d+")){
			JOptionPane.showMessageDialog(null, "身份证必须是数字");
			return false;
		}
		if(identityNum.length()<18||identityNum.length()>19){
			JOptionPane.showMessageDialog(null, "身份证在16位到17位之间");
			return false;
		}
		return true;
	}
	
	/**
	 * @function:judge the data is or not year
	 * @param:String year
	 * @return:boolean
	 * @annoation:if data does not like year, return false
	 */
	public static boolean judgeYear(String year) {
		if(!year.matches("\\d{4}")){
			JOptionPane.showMessageDialog(null, "年份必须是4位有效数字");
			return false;
		}
		if(Integer.parseInt(year)>Calendar.getInstance().get(Calendar.YEAR)||Integer.parseInt(year)<1900){
			JOptionPane.showMessageDialog(null, "输入年份不在范围");
			return false;
		}
		return true;
	}
	
	/**
	 * @function:judge the data is or not month
	 * @param:String month
	 * @return:boolean
	 * @annoation:if data does not like month, return false
	 */
	public static boolean judgeMonth(String month) {
		if(!month.matches("\\d+")){
			JOptionPane.showMessageDialog(null, "月份必须是数字");
			return false;
		}
		if(Integer.parseInt(month)>12||Integer.parseInt(month)<1){
			JOptionPane.showMessageDialog(null, "输入月份不在范围");
			return false;
		}
		return true;
	}
	
	/**
	 * @function:judge the data is or not day
	 * @param:String day
	 * @return:boolean
	 * @annoation:if data does not like day, return false
	 */
	public static boolean judgeDay(String day) {
		if(!day.matches("\\d+")){
			JOptionPane.showMessageDialog(null, "日期必须是数字");
			return false;
		}
		if(Integer.parseInt(day)>31||Integer.parseInt(day)<1){
			JOptionPane.showMessageDialog(null, "日期不在范围");
			return false;
		}
		return true;
	}
	
	/**
	 * @function:judge the data is or not phoneNum
	 * @param:String phoneNum
	 * @return:boolean
	 * @annoation:if data does not like phoneNum, return false
	 */
	public static boolean judgePhone(String phoneNum) {
		if(!phoneNum.matches("\\d{11}")){
			JOptionPane.showMessageDialog(null, "手机号必须是11位有效数字");
			return false;
		}
		return true;
	}
	
	/**
	 * @function:judge the data is or not timeStamp
	 * @param:String timeStamp
	 * @return:boolean
	 * @annoation:if data does not like timestamp, return false
	 */
	public static boolean judgeBirthTime(String timeStamp) {
		if(!timeStamp.matches("\\d{4}-\\d{2}-\\d{2}")){
			JOptionPane.showMessageDialog(null, "日期不匹配");
			return false;
		}
		return true;
	}
	
	/**
	 * @function:judge the data is or not sex
	 * @param:String sex
	 * @return:boolean
	 * @annoation:if data does not "M" or "F", return false
	 */
	public static boolean judgeSex(String sex) {
		if(!(sex.equals("M")||sex.equals("F"))){
			JOptionPane.showMessageDialog(null, "性别不正确");
			return false;
		}
		return true;
	}
	
	/**
	 * @function:judge the data is or not runtime
	 * @param:String runtime
	 * @return:boolean
	 * @annoation:if data does not like runtime, return false
	 */
	public static boolean judgeRunTime(String runTime) {
		if(!runTime.matches("\\d+h\\d+min")){
			JOptionPane.showMessageDialog(null, "运行时间必须类似1h5min这个格式");
			return false;
		}
		return true;
	}
	
	/**
	 * @function:judge the data is or not hour
	 * @param:String hour
	 * @return:boolean
	 * @annoation:if data does not like hour, return false
	 */
	public static boolean judgeHour(String startHour) {
		if(!startHour.matches("\\d+")){
			JOptionPane.showMessageDialog(null, "小时不正确");
			return false;
		}
		if(Integer.parseInt(startHour)>24||Integer.parseInt(startHour)<0){
			JOptionPane.showMessageDialog(null, "小时不正确");
			return false;
		}
		return true;
	}
	
	/**
	 * @function:judge the data is or not min
	 * @param:String min
	 * @return:boolean
	 * @annoation:if data does not like min, return false
	 */
	public static boolean judgeMin(String startMin) {
		if(!startMin.matches("\\d+")){
			JOptionPane.showMessageDialog(null, "分钟不正确");
			return false;
		}
		if(Integer.parseInt(startMin)>60||Integer.parseInt(startMin)<0){
			JOptionPane.showMessageDialog(null, "分钟不正确");
			return false;
		}
		return true;
	}
	
	/**
	 * @function:judge the data is or not timeDetails. Its only used in database
	 * @param:String time
	 * @return:boolean
	 * @annoation:if data does not like time, return false
	 */
	public static boolean judgeTimeAndHour(String time) {
		if(!time.matches("\\d+-\\d+-\\d+ \\d+:\\d+")){
			JOptionPane.showMessageDialog(null, "时间不正确");
			return false;
		}
		return true;
	}
	
	/**
	 * @function:judge the data is or not number
	 * @param:String number
	 * @return:boolean
	 * @annoation:if data does not like number, return false
	 */
	public static boolean judgeNum(String number){
		if(!number.matches("\\d+")){
			JOptionPane.showMessageDialog(null, "输入框只能输入数字");
			return false;
		}
		return true;
	}

	/**
	 * @function:judge the data is or not double
	 * @param:String number
	 * @return:boolean
	 * @annoation:if data does not like double, return false.And show the dialog must be a milage
	 */
	public static boolean judgeDouble(String distance) {
		if(!distance.matches("\\d+\\.\\d+")){
			JOptionPane.showMessageDialog(null, "里程必须是小数形式");
			return false;
		}
		return true;
	}
	
	/**
	 * @function:judge the data is or not double
	 * @param:String number
	 * @return:boolean
	 * @annoation:if data does not like double, return false.And show the dialog must be a ticket price
	 */
	public static boolean judgePrice(String distance) {
		if(!distance.matches("\\d+\\.\\d+")){
			JOptionPane.showMessageDialog(null, "票价必须是小数形式");
			return false;
		}
		return true;
	}
}
