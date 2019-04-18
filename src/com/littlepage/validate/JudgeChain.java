package com.littlepage.validate;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:Judge chain by using chain of responsibility  design parttern
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import com.littlepage.entity.CustomerInfo;
import com.littlepage.entity.StationInfo;
import com.littlepage.entity.TicketInfo;
import com.littlepage.entity.TrainNumberInfo;

public class JudgeChain {
	
	/**
	 * @function:judge the chainLoginFrame
	 * @param:String
	 * @return:boolean
	 * @annoation:if data does not regex, return false
	 */
	public static boolean JudgeChainLoginFrame(String name,String password){
		name=SecurityFilter.securityFilter(name);
		password=SecurityFilter.securityFilter(password);
		if(Judge.judgeVoid(name).equals("-1")) return false;
		if(Judge.judgeVoid(password).equals("-1")) return false;
		if(Judge.judgeAlphabet(name).equals("-1")) return false;
		return true;
	}
	
	/**
	 * @function:judge the JudgeChainAdministratorRegisterFrame
	 * @param:String
	 * @return:boolean
	 * @annoation:if data does not regex, return false
	 */
	public static boolean JudgeChainAdministratorRegisterFrame(String name,String password,String passwordRepeat){
		name=SecurityFilter.securityFilter(name);
		password=SecurityFilter.securityFilter(password);
		passwordRepeat=SecurityFilter.securityFilter(passwordRepeat);
		if(Judge.judgeVoid(name).equals("-1")) return false;
		if(Judge.judgeVoid(password).equals("-1")) return false;
		if(Judge.judgeVoid(passwordRepeat).equals("-1")) return false;
		if(Judge.judgeAlphabet(name).equals("-1")) return false;
		if(!Judge.judgeRepeatAdministrator(name)) return false;
		return Judge.judgePasswordRepitation(password, passwordRepeat);
	}
	
	/**
	 * @function:judge the JudgeChainCommonRegisterFrame
	 * @param:String
	 * @return:boolean
	 * @annoation:if data does not regex, return false
	 */
	public static boolean JudgeChainCommonRegisterFrame(String loginName,String name, String identityNum,
			String birthdateYear, String birthdateMonth, String birthdateDay, String phonecall,
			String password, String repeatPassword) {
		loginName=SecurityFilter.securityFilter(loginName);
		name=SecurityFilter.securityFilter(name);
		identityNum=SecurityFilter.securityFilter(identityNum);
		birthdateYear=SecurityFilter.securityFilter(birthdateYear);
		birthdateMonth=SecurityFilter.securityFilter(birthdateMonth);
		birthdateDay=SecurityFilter.securityFilter(birthdateDay);
		phonecall=SecurityFilter.securityFilter(phonecall);
		password=SecurityFilter.securityFilter(password);
		repeatPassword=SecurityFilter.securityFilter(repeatPassword);
		if(Judge.judgeVoid(loginName).equals("-1")) return false;
		if(Judge.judgeVoid(name).equals("-1")) return false;
		if(Judge.judgeVoid(identityNum).equals("-1")) return false;
		if(Judge.judgeVoid(name).equals("-1")) return false;
		if(Judge.judgeVoid(birthdateYear).equals("-1")) return false;
		if(Judge.judgeVoid(birthdateMonth).equals("-1")) return false;
		if(Judge.judgeVoid(birthdateDay).equals("-1")) return false;
		if(Judge.judgeVoid(phonecall).equals("-1")) return false;
		if(Judge.judgeVoid(password).equals("-1")) return false;
		if(Judge.judgeVoid(repeatPassword).equals("-1")) return false;
		
		if(Judge.judgeAlphabet(loginName).equals("-1")) return false;
		if(!Judge.judgeIdentityNum(identityNum)) return false;
		if(!Judge.judgeYear(birthdateYear)) return false;
		if(!Judge.judgeMonth(birthdateMonth)) return false;
		if(!Judge.judgeDay(birthdateDay)) return false;
		if(!Judge.judgePhone(phonecall)) return false;
		return Judge.judgePasswordRepitation(password, repeatPassword);
	}
	
	/**
	 * @function:judge the JudgeChainCustomerInfo
	 * @param:String
	 * @return:boolean
	 * @annoation:if data does not regex, return false
	 */
	public static boolean JudgeChainCustomerInfo(CustomerInfo ci) {
		String loginName=ci.getLoginName();
		String name=ci.getCustomerName();
		String sex=ci.getSex();
		String identityNumber=ci.getIdentityNumber();
		String birthTime=ci.getBirthTime();
		String phoneCall=ci.getPhoneCall();
		String customerPassword=ci.getCustomerPassword();
		loginName=SecurityFilter.securityFilter(loginName);
		name=SecurityFilter.securityFilter(name);
		sex=SecurityFilter.securityFilter(sex);
		identityNumber=SecurityFilter.securityFilter(identityNumber);
		birthTime=SecurityFilter.securityFilter(birthTime);
		phoneCall=SecurityFilter.securityFilter(phoneCall);
		customerPassword=SecurityFilter.securityFilter(customerPassword);
		if(Judge.judgeVoid(loginName).equals("-1"))return false;
		if(Judge.judgeVoid(name).equals("-1"))return false;
		if(Judge.judgeVoid(sex).equals("-1"))return false;
		if(Judge.judgeVoid(identityNumber).equals("-1"))return false;
		if(Judge.judgeVoid(birthTime).equals("-1"))return false;
		if(Judge.judgeVoid(phoneCall).equals("-1"))return false;
		if(Judge.judgeVoid(customerPassword).equals("-1"))return false;
		
		if(Judge.judgeAlphabet(customerPassword).equals("-1")) return false;
		if(Judge.judgeAlphabet(loginName).equals("-1")) return false;
		if(!Judge.judgeSex(sex)) return false;
		if(!Judge.judgeIdentityNum(identityNumber)) return false;
		if(!Judge.judgeBirthTime(birthTime)) return false;
		if(!Judge.judgePhone(phoneCall))return false;
		return true;
	}
	
	/**
	 * @function:judge the JudgeChainTrainNumberInfo
	 * @param:String
	 * @return:boolean
	 * @annoation:if data does not regex, return false
	 */
	public static boolean JudgeChainTrainNumberInfo(String trainNum, String startLocation,
			String endLocation, String startYear, String startMonth, String startDay,
			String endYear, String endMonth, String endDay, String runTime,String startHour,
			String startMin,String endHour,String endMin) {
		trainNum=SecurityFilter.securityFilter(trainNum);
		startLocation=SecurityFilter.securityFilter(startLocation);
		endLocation=SecurityFilter.securityFilter(endLocation);
		startYear=SecurityFilter.securityFilter(startYear);
		startMonth=SecurityFilter.securityFilter(startMonth);
		startDay=SecurityFilter.securityFilter(startDay);
		endYear=SecurityFilter.securityFilter(endYear);
		endMonth=SecurityFilter.securityFilter(endMonth);
		endDay=SecurityFilter.securityFilter(endDay);
		runTime=SecurityFilter.securityFilter(runTime);
		startMin=SecurityFilter.securityFilter(startMin);
		endHour=SecurityFilter.securityFilter(endHour);
		startMin=SecurityFilter.securityFilter(startMin);
		endMin=SecurityFilter.securityFilter(endMin);
		if(Judge.judgeVoid(trainNum).equals("-1"))return false;
		if(Judge.judgeVoid(startLocation).equals("-1"))return false;
		if(Judge.judgeVoid(endLocation).equals("-1"))return false;
		if(Judge.judgeVoid(startYear).equals("-1"))return false;
		if(Judge.judgeVoid(startMonth).equals("-1"))return false;
		if(Judge.judgeVoid(startDay).equals("-1"))return false;
		if(Judge.judgeVoid(endYear).equals("-1"))return false;
		if(Judge.judgeVoid(endMonth).equals("-1"))return false;
		if(Judge.judgeVoid(endDay).equals("-1"))return false;
		if(Judge.judgeVoid(runTime).equals("-1"))return false;
		if(Judge.judgeVoid(startHour).equals("-1"))return false;
		if(Judge.judgeVoid(startMin).equals("-1"))return false;
		if(Judge.judgeVoid(endHour).equals("-1"))return false;
		if(Judge.judgeVoid(endMin).equals("-1"))return false;
		
		if(Judge.judgeAlphabet(trainNum).equals("-1")) return false;
		
		if(!Judge.judgeYear(startYear)) return false;
		if(!Judge.judgeMonth(startMonth)) return false;
		if(!Judge.judgeDay(startDay)) return false;
		
		if(!Judge.judgeYear(endYear)) return false;
		if(!Judge.judgeMonth(endMonth)) return false;
		if(!Judge.judgeDay(endDay)) return false;
		
		if(!Judge.judgeRunTime(runTime)) return false;
		

		if(!Judge.judgeHour(startHour))return false;
		if(!Judge.judgeMin(startMin))return false;
		if(!Judge.judgeHour(endHour))return false;
		if(!Judge.judgeMin(endMin))return false;
		return true;
	}
	
	/**
	 * @function:judge the JudgeChainTrainNumberInfo
	 * @param:TrainNumberInfo
	 * @return:boolean
	 * @annoation:if data does not regex, return false
	 */
	public static boolean JudgeChainTrainNumberInfo(TrainNumberInfo ti) {
		String id=ti.getId()+"";
		String type=ti.getTrainType()+"";
		String startTime=ti.getStartTime();
		String endTime=ti.getEndTime();
		String startLocation=ti.getStartLocation();
		String endLocation=ti.getEndLocation();
		String runTime=ti.getRunTime();

		id=SecurityFilter.securityFilter(id);
		type=SecurityFilter.securityFilter(type);
		startTime=SecurityFilter.securityFilter(startTime);
		endTime=SecurityFilter.securityFilter(endTime);
		startLocation=SecurityFilter.securityFilter(startLocation);
		endLocation=SecurityFilter.securityFilter(endLocation);
		runTime=SecurityFilter.securityFilter(runTime);
		if(Judge.judgeVoid(id).equals("-1"))return false;
		if(Judge.judgeVoid(type).equals("-1"))return false;
		if(Judge.judgeVoid(startTime).equals("-1"))return false;
		if(Judge.judgeVoid(endTime).equals("-1"))return false;
		if(Judge.judgeVoid(startLocation).equals("-1"))return false;
		if(Judge.judgeVoid(endLocation).equals("-1"))return false;
		if(Judge.judgeVoid(runTime).equals("-1"))return false;
		
		if(Judge.judgeAlphabet(id).equals("-1")) return false;
		if(Judge.judgeAlphabet(type).equals("-1")) return false;
		
		if(!Judge.judgeTimeAndHour(startTime))return false;
		if(!Judge.judgeTimeAndHour(endTime))return false;
		if(!Judge.judgeRunTime(runTime))return false;
		return true;
	}
	
	/**
	 * @function:judge the JudgeChainTicketInfo
	 * @param:String
	 * @return:boolean
	 * @annoation:if data does not regex, return false
	 */
	public static boolean JudgeChainTicketInfo(String trainNumber, String startTimeYear,
			String startTimeMonth, String startTimeDay, String startHour, String startMin,
			String roomNum, String spareSeatNum,String endTimeYear,String endTimeMonth,
			String endTimeDay,String endTimeHour,String endTimeMin,String startStation,String endStation,String ticketPrice) {

		trainNumber=SecurityFilter.securityFilter(trainNumber);
		startTimeYear=SecurityFilter.securityFilter(startTimeYear);
		startTimeMonth=SecurityFilter.securityFilter(startTimeMonth);
		startTimeDay=SecurityFilter.securityFilter(startTimeDay);
		startHour=SecurityFilter.securityFilter(startHour);
		startMin=SecurityFilter.securityFilter(startMin);
		roomNum=SecurityFilter.securityFilter(roomNum);
		spareSeatNum=SecurityFilter.securityFilter(spareSeatNum);
		endTimeYear=SecurityFilter.securityFilter(endTimeYear);
		endTimeMonth=SecurityFilter.securityFilter(endTimeMonth);
		endTimeDay=SecurityFilter.securityFilter(endTimeDay);
		endTimeHour=SecurityFilter.securityFilter(endTimeHour);
		endTimeMin=SecurityFilter.securityFilter(endTimeMin);
		startStation=SecurityFilter.securityFilter(startStation);
		endStation=SecurityFilter.securityFilter(endStation);
		ticketPrice=SecurityFilter.securityFilter(ticketPrice);
		if(Judge.judgeVoid(trainNumber).equals("-1"))return false;
		if(Judge.judgeVoid(startTimeYear).equals("-1"))return false;
		if(Judge.judgeVoid(startTimeMonth).equals("-1"))return false;
		if(Judge.judgeVoid(startTimeDay).equals("-1"))return false;
		if(Judge.judgeVoid(startHour).equals("-1"))return false;
		if(Judge.judgeVoid(startMin).equals("-1"))return false;
		if(Judge.judgeVoid(roomNum).equals("-1"))return false;
		if(Judge.judgeVoid(spareSeatNum).equals("-1"))return false;
		if(Judge.judgeVoid(endTimeYear).equals("-1"))return false;
		if(Judge.judgeVoid(endTimeMonth).equals("-1"))return false;
		if(Judge.judgeVoid(endTimeDay).equals("-1"))return false;
		if(Judge.judgeVoid(endTimeHour).equals("-1"))return false;
		if(Judge.judgeVoid(endTimeMin).equals("-1"))return false;
		if(Judge.judgeVoid(startStation).equals("-1"))return false;
		if(Judge.judgeVoid(endStation).equals("-1"))return false;
		if(Judge.judgeVoid(ticketPrice).equals("-1"))return false;
		
		if(Judge.judgeAlphabet(trainNumber).equals("-1")) return false;
		if(Judge.judgeAlphabet(roomNum).equals("-1")) return false;
		if(Judge.judgeAlphabet(spareSeatNum).equals("-1")) return false;

		if(!Judge.judgeYear(startTimeYear)) return false;
		if(!Judge.judgeMonth(startTimeMonth)) return false;
		if(!Judge.judgeDay(startTimeDay)) return false;
		if(!Judge.judgeHour(startHour))return false;
		if(!Judge.judgeMin(startMin))return false;
		
		if(!Judge.judgeYear(endTimeYear)) return false;
		if(!Judge.judgeMonth(endTimeMonth)) return false;
		if(!Judge.judgeDay(endTimeDay)) return false;
		if(!Judge.judgeHour(endTimeHour))return false;
		if(!Judge.judgeMin(endTimeMin))return false;
		if(!Judge.judgePrice(ticketPrice))return false;
		return true;
	}
	
	/**
	 * @function:judge the JudgeChainTicketInfo
	 * @param:TicketInfo
	 * @return:boolean
	 * @annoation:if data does not regex, return false
	 */
	public static boolean JudgeChainTicketInfo(TicketInfo ti) {
		String id=ti.getId()+"";
		String trainNumber=ti.getTrainNumber();
		String startTime=ti.getStartTime();
		String endTime=ti.getEndTime();
		String startStation=ti.getStartStation();
		String endStation=ti.getEndStation();
		String roomNumber=ti.getRoomNumber();
		String seatLevel=ti.getSeatLevel()+"";
		String spareSeatNum=ti.getSpareSeatNum()+"";

		id=SecurityFilter.securityFilter(id);
		trainNumber=SecurityFilter.securityFilter(trainNumber);
		startTime=SecurityFilter.securityFilter(startTime);
		endTime=SecurityFilter.securityFilter(endTime);
		startStation=SecurityFilter.securityFilter(startStation);
		endStation=SecurityFilter.securityFilter(endStation);
		roomNumber=SecurityFilter.securityFilter(roomNumber);
		seatLevel=SecurityFilter.securityFilter(seatLevel);
		spareSeatNum=SecurityFilter.securityFilter(spareSeatNum);
		if(Judge.judgeVoid(id).equals("-1"))return false;
		if(Judge.judgeVoid(trainNumber).equals("-1"))return false;
		if(Judge.judgeVoid(startTime).equals("-1"))return false;
		if(Judge.judgeVoid(endTime).equals("-1"))return false;
		if(Judge.judgeVoid(roomNumber).equals("-1"))return false;
		if(Judge.judgeVoid(seatLevel).equals("-1"))return false;
		if(Judge.judgeVoid(spareSeatNum).equals("-1"))return false;
		if(Judge.judgeVoid(startStation).equals("-1"))return false;
		if(Judge.judgeVoid(endStation).equals("-1"))return false;
		if(!Judge.judgeNum(id))return false;
		if(Judge.judgeAlphabet(trainNumber).equals("-1"))return false;
		if(!Judge.judgeTimeAndHour(startTime)) return false;
		if(!Judge.judgeTimeAndHour(endTime)) return false;
		if(Judge.judgeAlphabet(roomNumber).equals("-1")) return false;
		if(!Judge.judgeNum(seatLevel)) return false;
		if(Judge.judgeAlphabet(spareSeatNum).equals("-1")) return false;
		return true;
	}
	
	/**
	 * @function:judge the judgeChainModifyPassword
	 * @param:String
	 * @return:boolean
	 * @annoation:if data does not regex, return false
	 */
	public static boolean judgeChainModifyPassword(String username,
			String phoneNum, String oPassword, String nPassword,
			String rPassword) {
		username=SecurityFilter.securityFilter(username);
		phoneNum=SecurityFilter.securityFilter(phoneNum);
		oPassword=SecurityFilter.securityFilter(oPassword);
		nPassword=SecurityFilter.securityFilter(nPassword);
		rPassword=SecurityFilter.securityFilter(rPassword);
		if(Judge.judgeVoid(username).equals("-1")) return false;
		if(Judge.judgeVoid(phoneNum).equals("-1")) return false;
		if(Judge.judgeVoid(oPassword).equals("-1")) return false;
		if(Judge.judgeVoid(nPassword).equals("-1")) return false;
		if(Judge.judgeVoid(rPassword).equals("-1")) return false;
		if(Judge.judgeAlphabet(username).equals("-1")) return false;
		if(!Judge.judgePhone(phoneNum)) return false;
		if(!Judge.judgePasswordRepitation(nPassword, rPassword)) return false;
		return true;
	}
	
	/**
	 * @function:judge the JudgeChainStationInfo
	 * @param:String
	 * @return:boolean
	 * @annoation:if data does not regex, return false
	 */
	public static boolean JudgeChainStationInfo(String trainNumber, String stationNumber,
			String stationInfo, String startTime, String distance, String step) {
		trainNumber=SecurityFilter.securityFilter(trainNumber);
		stationNumber=SecurityFilter.securityFilter(stationNumber);
		stationInfo=SecurityFilter.securityFilter(stationInfo);
		startTime=SecurityFilter.securityFilter(startTime);
		distance=SecurityFilter.securityFilter(distance);
		step=SecurityFilter.securityFilter(step);
		if(Judge.judgeVoid(trainNumber).equals("-1")) return false;
		if(Judge.judgeVoid(stationNumber).equals("-1")) return false;
		if(Judge.judgeVoid(stationInfo).equals("-1")) return false;
		if(Judge.judgeVoid(startTime).equals("-1")) return false;
		if(Judge.judgeVoid(distance).equals("-1")) return false;
		if(Judge.judgeVoid(step).equals("-1")) return false;
		if(Judge.judgeAlphabet(trainNumber).equals("-1"))return false;
		if(Judge.judgeAlphabet(stationNumber).equals("-1"))return false;
		if(!Judge.judgeTimeAndHour(startTime)) return false;
		if(!Judge.judgeDouble(distance)) return false;
		if(Judge.judgeAlphabet(step).equals("-1")) return false;
		return true;
	}
	
	/**
	 * @function:judge the JudgeChainStationInfo
	 * @param:StationInfo
	 * @return:boolean
	 * @annoation:if data does not regex, return false
	 */
	public static boolean JudgeChainStationInfo(StationInfo si) {
		String trainNumber=si.getTrainNumber();
		String stationNumber=si.getStationNumber();
		String stationInfo=si.getStationInfo();
		String startTime=si.getStartTime();
		String distance=si.getDistance()+"";
		String step=si.getStep()+"";
		trainNumber=SecurityFilter.securityFilter(trainNumber);
		stationNumber=SecurityFilter.securityFilter(stationNumber);
		stationInfo=SecurityFilter.securityFilter(stationInfo);
		startTime=SecurityFilter.securityFilter(startTime);
		distance=SecurityFilter.securityFilter(distance);
		step=SecurityFilter.securityFilter(step);
		if(Judge.judgeVoid(trainNumber).equals("-1")) return false;
		if(Judge.judgeVoid(stationNumber).equals("-1")) return false;
		if(Judge.judgeVoid(stationInfo).equals("-1")) return false;
		if(Judge.judgeVoid(startTime).equals("-1")) return false;
		if(Judge.judgeVoid(distance).equals("-1")) return false;
		if(Judge.judgeVoid(step).equals("-1")) return false;
		if(Judge.judgeAlphabet(trainNumber).equals("-1"))return false;
		if(Judge.judgeAlphabet(stationNumber).equals("-1"))return false;
		if(!Judge.judgeTimeAndHour(startTime)) return false;
		if(!Judge.judgeDouble(distance)) return false;
		if(Judge.judgeAlphabet(step).equals("-1")) return false;
		return true;
	}
	
	/**
	 * @function:judge the judgeContactPeople
	 * @param:String
	 * @return:boolean
	 * @annoation:if data does not regex, return false
	 */
	public static boolean judgeContactPeople(String name, String phoneNum) {
		name=SecurityFilter.securityFilter(name);
		phoneNum=SecurityFilter.securityFilter(phoneNum);
		if(Judge.judgeVoid(name).equals("-1")) return false;
		if(Judge.judgeVoid(phoneNum).equals("-1")) return false;
		if(!Judge.judgePhone(phoneNum)) return false;
		return true;
	}
}
