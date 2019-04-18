package com.littlepage.dao;


import java.sql.*;
import java.util.*;
import com.littlepage.dbUtils.*;
import com.littlepage.entity.*;

/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:Operator data of railwaySystem
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
public class RailwayDBOperation {
	/**
	 * Add an instance customerInfo
	 * @param:CustomerInfo ci
	 * @return:void
	 */
	public static void customerInfoAdd(CustomerInfo ci) {
		String loginName=ci.getLoginName();
		String name=ci.getCustomerName();
		String sex=ci.getSex();
		String identityNum=ci.getIdentityNumber();
		String birthday=ci.getBirthTime();
		String phoneCall=ci.getPhoneCall();
		String customerPassword=ci.getCustomerPassword();
		DBUtils.UpdateQuickly("insert customerInfo values(null,'"+loginName+"','"+name+"','"+sex+"','"+identityNum+"','"+birthday+"','"+phoneCall+"','"+customerPassword+"');");
		System.out.println("ADD CUSTOMERINFO SUCCESS");
	}
	/**
	 * delete an instance customerInfo
	 * @param:int customerInfoId
	 * @return:void
	 */
	public static void customerInfoDeleteById(int customerInfoId){
		DBUtils.UpdateQuickly("DELETE FROM customerinfo WHERE customerID="+customerInfoId+";");
		System.out.println("DELETE CUSTOMERINFO SUCCESS");
	}
	
	/**
	 * Query all the instance customerInfo from database
	 * @param:void
	 * @return:ArrayList<CustomerInfo>
	 */
	public static ArrayList<CustomerInfo> customerInfoQueryAll(){
		ArrayList<CustomerInfo> arr=new ArrayList<CustomerInfo>();
		Connection conn=DBUtils.getConnection();
		Statement stmt=DBUtils.getStatement(conn);
		ResultSet rs=DBUtils.executeQuery(stmt, "select * from customerInfo");
		try {
			while(rs.next()){
				arr.add(new CustomerInfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.releaseResultSet(rs);
			DBUtils.releaseStatement(stmt);
			DBUtils.releaseConnection(conn);
		}
		return arr;
	}
	
	/**
	 * Update customerInfo except password by id
	 * @param:CustomerInfo
	 * @return:void
	 */
	public static void customerInfoUpdate(CustomerInfo ci) {
		int id=ci.getId();
		String loginName=ci.getLoginName();
		String name=ci.getCustomerName();
		String sex=ci.getSex();
		String identityNum=ci.getIdentityNumber();
		String birthday=ci.getBirthTime();
		String phoneCall=ci.getPhoneCall();
		DBUtils.UpdateQuickly("UPDATE customerinfo SET customerLoginName='"+loginName+"',"
				+ "customerName='"+name+"',sex='"+sex+"',identityNumber='"+identityNum+"',"
				+ "birthTime='"+birthday+"',"
				+ "phoneCall='"+phoneCall+"' WHERE customerID="+id+"");
		System.out.println("UPDATE CUSTOMERINFO SUCCESS");
	}
	
	/**
	 * Change customerInfo  password by id
	 * @param:CustomerInfo
	 * @return:void
	 */
	public static void customerInfoChangePassword(CustomerInfo customerInfo,String password) {
		int id=customerInfo.getId();
		DBUtils.UpdateQuickly("UPDATE customerinfo SET customerPassword='"+password+"' where customerID="+id);
	}
	//if the project use the change customerInfo method, i will add it in this place.
	
	/**
	 * Add an instance SeatInfo
	 * @param:SeatInfo si
	 * @return:void
	 */
	public static void seatInfoAdd(SeatInfo si) {
		String roomNum=si.getRoomNum();
		int seatLevel=si.getSeatLevel();
		int seatNum=si.getSeatNum();
		DBUtils.UpdateQuickly("insert seatInfo values(null,'"+roomNum+"',"+seatLevel+",'"+seatNum+"');");
		System.out.println("ADD SEATINFOADD SUCCESS");
	}
	/**
	 * Delete an instance seatInfoDelete
	 * @param:CustomerInfo ci
	 * @return:void
	 */
	public static void seatInfoDeleteById(int seatInfoId){
		DBUtils.UpdateQuickly("DELETE FROM seatInfo WHERE seatId="+seatInfoId+";");
		System.out.println("DELETE SEATINFO SUCCESS");
	}
	
	/**
	 * Query all the instance seatInfo from database
	 * @param:void
	 * @return:ArrayList<SeatInfo>
	 */
	public static ArrayList<SeatInfo> seatInfoQueryAll(){
		ArrayList<SeatInfo> arr=new ArrayList<SeatInfo>();
		Connection conn=DBUtils.getConnection();
		Statement stmt=DBUtils.getStatement(conn);
		ResultSet rs=DBUtils.executeQuery(stmt, "select * from seatInfo");
		try {
			while(rs.next()){
				arr.add(new SeatInfo(rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.releaseResultSet(rs);
			DBUtils.releaseStatement(stmt);
			DBUtils.releaseConnection(conn);
		}
		return arr;
	}
	
	//if the project use the change seatInfo method, i will add it in this place.
	
	/**
	 * Add an instance StationInfo
	 * @StationInfo si
	 * @return:void
	 */
	public static void stationInfoAdd(StationInfo si) {
		String trainNumber=si.getTrainNumber();
		String stationNumber=si.getStationNumber();
		String stationInfo=si.getStationInfo();
		String startTime=si.getStartTime();
		double distance=si.getDistance();
		int step=si.getStep();
		DBUtils.UpdateQuickly("INSERT stationinfo VALUES(NULL,'"+trainNumber+"','"+stationNumber+
				"','"+stationInfo+"','"+startTime+"',"+distance+","+step+");");
		System.out.println("ADD STATIONINFO SUCCESS");
	}
	/**
	 * Delete an instance stationInfo
	 * @param:StationInfo si
	 * @return:void
	 */
	public static void stationInfoDeleteById(int stationInfoId){
		DBUtils.UpdateQuickly("DELETE FROM stationInfo WHERE stationId="+stationInfoId+";");
		System.out.println("DELETE STATIONINFO SUCCESS");
	}
	
	/**
	 * Query all the instance stationInfo from database
	 * @param:void
	 * @return:ArrayList<SeatInfo>
	 */
	public static ArrayList<StationInfo> stationInfoQueryAll(){
		ArrayList<StationInfo> arr=new ArrayList<StationInfo>();
		Connection conn=DBUtils.getConnection();
		Statement stmt=DBUtils.getStatement(conn);
		ResultSet rs=DBUtils.executeQuery(stmt, "select * from stationInfo");
		try {
			while(rs.next()){
				arr.add(new StationInfo(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6),rs.getInt(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.releaseResultSet(rs);
			DBUtils.releaseStatement(stmt);
			DBUtils.releaseConnection(conn);
		}
		return arr;
	}
	
	/**
	 * Update the StationInfo
	 * @param:StationInfo si
	 * @return:void
	 */
	public static void StationInfoUpdate(StationInfo si) {
		String id=si.getId()+"";
		String trainNumber=si.getTrainNumber();
		String stationNumber=si.getStationNumber();
		String stationInfo=si.getStationInfo();
		String startTime=si.getStartTime();
		String distance=si.getDistance()+"";
		String step=si.getStep()+"";
		DBUtils.UpdateQuickly("UPDATE stationinfo SET trainnumber='"+trainNumber+"'"
				+ ",stationNumber='"+stationNumber+"',stationInfo='"+stationInfo+"'"
						+ ",startTime='"+startTime+"',distance="+distance+",step="+step+" WHERE stationid="+id+";");
		System.out.println("UPDATE STATIONINFO SUCCESS");
	}
	//if the project use the change stationInfo method, i will add it in this place.
	
	/**
	 * Add an instance TicketInfo
	 * @param:TicketInfo ti
	 * @return:void
	 */
	public static void ticketInfoAdd(TicketInfo ti) {
		String trainNumber=ti.getTrainNumber();
		String startTime=ti.getStartTime();
		String endTime=ti.getEndTime();
		String roomNumber=ti.getRoomNumber();
		int seatLevel=ti.getSeatLevel();
		int spareSeatNum=ti.getSpareSeatNum();
		String startStation=ti.getStartStation();
		String endStation=ti.getEndStation();
		String ticketPrice=ti.getTicketPrice()+"";
		DBUtils.UpdateQuickly("INSERT ticketInfo VALUES(NULL,'"+trainNumber+"','"+startTime+"','"+endTime+"','"+startStation+"','"+endStation+"','"+roomNumber+"',"+seatLevel+","+spareSeatNum+","+ticketPrice+");");
		System.out.println("ADD TICKETINFO SUCCESS");
	}
	
	/**
	 * Delete an instance ticketInfo
	 * @param:TicketInfo si
	 * @return:void
	 */
	public static void ticketInfoDeleteById(int ticketInfoId){
		DBUtils.UpdateQuickly("DELETE FROM ticketInfo WHERE ticketID="+ticketInfoId+";");
		System.out.println("DELETE TICKETINFO SUCCESS");
	}
	
	/**
	 * Query all the instance ticketInfo from database
	 * @param:void
	 * @return:ArrayList<TicketInfo>
	 */
	public static ArrayList<TicketInfo> ticketInfoQueryAll(){
		ArrayList<TicketInfo> arr=new ArrayList<TicketInfo>();
		Connection conn=DBUtils.getConnection();
		Statement stmt=DBUtils.getStatement(conn);
		ResultSet rs=DBUtils.executeQuery(stmt, "select * from ticketInfo");
		try {
			while(rs.next()){
				arr.add(new TicketInfo(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9),rs.getDouble(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.releaseResultSet(rs);
			DBUtils.releaseStatement(stmt);
			DBUtils.releaseConnection(conn);
		}
		return arr;
	}

	//if the project use the change ticketInfo method, i will add it in this place.
	
	/**
	 * Add an instance TicketPurchaseInfo
	 * @TicketPurchaseInfo tpi
	 * @return:void
	 */
	public static void ticketPurchaseInfoAdd(TicketPurchaseInfo tpi) {
		String trainNumber=tpi.getTrainNumber();
		String startTime=tpi.getStartTime();
		String endTime=tpi.getEndTime();
		String startLocation=tpi.getStartStation();
		String endLocation=tpi.getEndStation();
		String roomNumber=tpi.getRoomNumber();
		String seatNumber=tpi.getSeatNumber();
		double ticketPrice=tpi.getTicketPrice();
		String identityNumber=tpi.getIdentityNumber();
		String purchaseTime=tpi.getPurchaseTime();
		DBUtils.UpdateQuickly("INSERT ticketpurchaseinfo VALUES(NULL,'"+trainNumber+"','"+startTime+"','"+endTime+"','"+startLocation+"','"+endLocation+"','"+roomNumber+"','"+seatNumber+"',"+ticketPrice+",'"+identityNumber+"','"+purchaseTime+"');");
		System.out.println("ADD TICKETPURCHASEINFO SUCCESS");
	}
	
	/**
	 * Delete an instance TicketPurchaseInfo
	 * @param:TicketInfo tpi
	 * @return:void
	 */
	public static void ticketPurchaseInfoDeleteById(int purchaseId){
		DBUtils.UpdateQuickly("DELETE FROM ticketPurchaseInfo WHERE purchaseId="+purchaseId+";");
		System.out.println("DELETE TICKETPURCHASEINFO SUCCESS");
	}
	
	/**
	 * Query all the instance ticketPurchaseInfo from database
	 * @param:void
	 * @return:ArrayList<TicketPurchaseInfo>
	 */
	public static ArrayList<TicketPurchaseInfo> ticketPurchaseInfoQueryAll(){
		ArrayList<TicketPurchaseInfo> arr=new ArrayList<TicketPurchaseInfo>();
		Connection conn=DBUtils.getConnection();
		Statement stmt=DBUtils.getStatement(conn);
		ResultSet rs=DBUtils.executeQuery(stmt, "select * from ticketPurchaseInfo");
		try {
			while(rs.next()){
				arr.add(new TicketPurchaseInfo(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getString(10), rs.getString(11)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.releaseResultSet(rs);
			DBUtils.releaseStatement(stmt);
			DBUtils.releaseConnection(conn);
		}
		return arr;
	}
	
	/**
	 * Update ticketInfo by id
	 * @param:TicketInfo
	 * @return:void
	 */
	public static void ticketInfoUpdate(TicketInfo ti) {
		int id=ti.getId();
		String trainNumber=ti.getTrainNumber();
		String startTime=ti.getStartTime();
		String endTime=ti.getEndTime();
		String roomNumber=ti.getRoomNumber();
		int seatLevel=ti.getSeatLevel();
		int spareSeatNum=ti.getSpareSeatNum();
		DBUtils.UpdateQuickly("UPDATE ticketInfo SET "
				+ "trainNumber='"+trainNumber+"',startTime='"+
				startTime+"',endTime='"+endTime+"',roomNumber='"+
				roomNumber+"',seatLevel="+seatLevel+",spareseatNum="+spareSeatNum
				+" WHERE ticketid="+id+";");
	}
	//if the project use the change ticketPurchaseInfo method, i will add it in this place.
	
	/**
	 * Add an instance TrainNumberInfo
	 * @TrainNumberInfo tni
	 * @return:void
	 */
	public static void trainNumberInfoAdd(TrainNumberInfo tni) {
		String trainNumber=tni.getTrainNumber();
		int trainType=tni.getTrainType();
		String startLocation=tni.getStartLocation();
		String endLocation=tni.getEndLocation();
		String startTime=tni.getStartTime();
		String endTime=tni.getEndTime();
		String runTime=tni.getRunTime();
		DBUtils.UpdateQuickly("INSERT trainnumberinfo VALUES(NULL,'"+trainNumber+"',"+trainType+",'"+startLocation+"','"+endLocation+"','"+startTime+"','"+endTime+"','"+runTime+"');");
		System.out.println("ADD TRAINNUMBERINFO SUCCESS");
	}
	
	/**
	 * Delete an instance TrainNumberInfo
	 * @param:TrainNumberInfo tni
	 * @return:void
	 */
	public static void trainNumberInfoDeleteById(int trainId){
		DBUtils.UpdateQuickly("DELETE FROM trainNumberInfo WHERE trainId="+trainId+";");
		System.out.println("DELETE TRAINNUMBERINFO SUCCESS");
	}
	
	/**
	 * Query all the instance TrainNumberInfo from database
	 * @param:void
	 * @return:ArrayList<TrainNumberInfo>
	 */
	public static ArrayList<TrainNumberInfo> trainNumberInfoQueryAll(){
		ArrayList<TrainNumberInfo> arr=new ArrayList<TrainNumberInfo>();
		Connection conn=DBUtils.getConnection();
		Statement stmt=DBUtils.getStatement(conn);
		ResultSet rs=DBUtils.executeQuery(stmt, "select * from trainNumberInfo");
		try {
			while(rs.next()){
				arr.add(new TrainNumberInfo(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.releaseResultSet(rs);
			DBUtils.releaseStatement(stmt);
			DBUtils.releaseConnection(conn);
		}
		return arr;
	}
	
	/**
	 * Update customerInfo except password by id
	 * @param:CustomerInfo
	 * @return:void
	 */
	public static void trainNumberInfoUpdate(TrainNumberInfo ti) {
		String trainId=ti.getId()+"";
		String trainNumber=ti.getTrainNumber();
		String trainType=ti.getTrainType()+"";
		String startLocation=ti.getStartLocation();
		String endLocation=ti.getEndLocation();
		String startTime=ti.getStartTime();
		String endTime=ti.getEndTime();
		String runTime=ti.getRunTime();
		
		DBUtils.UpdateQuickly("UPDATE trainnumberinfo SET trainNumber='"+trainNumber+"',trainType="+trainType+""
				+ ",startLocation='"+startLocation+"',endLocatuion='"+endLocation+"',startTime='"+startTime+"',"
						+ "endTime='"+endTime+"',runtime='"+runTime+"' WHERE trainid="+trainId+";");
	}
	
	/**
	 * Add an instance Administrator
	 * @Administrator a
	 * @return:void
	 */
	public static void administratorAdd(Administrator a) {
		String name=a.getName();
		String password=a.getPassword();
		DBUtils.UpdateQuickly("INSERT administrator VALUES(NULL,'"+name+"','"+password+"');");
		System.out.println("ADD Administrator SUCCESS");
	}
	
	/**
	 * Add an instance Administrator
	 * @int administratorId
	 * @return:void
	 */
	public static void administratorDeleteById(int administratorId){
		DBUtils.UpdateQuickly("DELETE FROM administrator WHERE administratorId="+administratorId+";");
		System.out.println("DELETE TRAINNUMBERINFO SUCCESS");
	}
	
	/**
	 * Query all the instance Administrator from database
	 * @param:void
	 * @return:ArrayList<Administrator>
	 */
	public static ArrayList<Administrator> administratorQueryAll(){
		ArrayList<Administrator> arr=new ArrayList<Administrator>();
		Connection conn=DBUtils.getConnection();
		Statement stmt=DBUtils.getStatement(conn);
		ResultSet rs=DBUtils.executeQuery(stmt, "select * from administrator");
		try {
			while(rs.next()){
				arr.add(new Administrator(rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.releaseResultSet(rs);
			DBUtils.releaseStatement(stmt);
			DBUtils.releaseConnection(conn);
		}
		return arr;
	}

	/**
	 * Add an instance ContactPeopleAdd
	 * @param:int parentId,int contactId
	 * @return:void
	 */
	public static void contactPeopleAdd(ContactPeople contactPeople) {
		String parentId=contactPeople.getParentId()+"";
		String contactId=contactPeople.getContactId()+"";
		DBUtils.UpdateQuickly("INSERT contactPeople VALUES(NULL,"+parentId+","+contactId+");");
		System.out.println("ADD CONTACTPEOPLE SUCCESS");
	}
	
	/**
	 * Query all the instance contactPeople from database
	 * @param:void
	 * @return:ArrayList<ContactPeople>
	 */
	public static ArrayList<ContactPeople> contactPeopleQuery(){
		ArrayList<ContactPeople> arr=new ArrayList<>();
		Connection conn=DBUtils.getConnection();
		Statement stmt=DBUtils.getStatement(conn);
		ResultSet rs=DBUtils.executeQuery(stmt, "select * from contactPeople");
		try {
			while(rs.next()){
				arr.add(new ContactPeople(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.releaseResultSet(rs);
			DBUtils.releaseStatement(stmt);
			DBUtils.releaseConnection(conn);
		}
		return arr;
	}
	
	/**
	 * Delete an instance TrainNumberInfo
	 * @param:TrainNumberInfo tni
	 * @return:void
	 */
	public static void contactPeopleDeleteById(int id){
		DBUtils.UpdateQuickly("DELETE FROM contactPeople WHERE contactPeopleId="+id+";");
		System.out.println("DELETE CONTACTPEOPLE SUCCESS");
	}
}