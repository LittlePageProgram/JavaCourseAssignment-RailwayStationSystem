package com.littlepage.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:Get the instance time
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
import java.util.Calendar;
import java.util.Date;

public class Now {
	/**
	 * Get a method return instance time to String
	 * @param:void
	 * @return:String
	 */
	public static String getNow(){
		Calendar ca=Calendar.getInstance();
		int year=ca.get(Calendar.YEAR);
		int month=ca.get(Calendar.MONTH)+1;
		int dayOfMonth=ca.get(Calendar.DAY_OF_MONTH);
		int hour=ca.get(Calendar.HOUR_OF_DAY);
		int minute=ca.get(Calendar.MINUTE);
		int second=ca.get(Calendar.SECOND);
		return year+"-"+month+"-"+dayOfMonth+"-"+hour+"-"+minute+"-"+second;
	}
	
	/**
	 * Get a method return time about two time's divide
	 * @param:String startTime,String endTime
	 * @return:String
	 */
	public static int getSubTime(String startTime,String endTime) {
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat inputgetNowFormat=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate=inputgetNowFormat.parse(startTime);
            endDate=inputFormat.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long firstDateMilliSeconds = startDate.getTime();
        long secondDateMilliSeconds = endDate.getTime();

        long firstMinusSecond = secondDateMilliSeconds - firstDateMilliSeconds;
        long totalDays = (firstMinusSecond / 1000/60/60/24);
        return Integer.parseInt(totalDays+"");
	}
}
