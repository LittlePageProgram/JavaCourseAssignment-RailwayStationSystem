package com.littlepage.entity;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The instance of SeatInfo
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */

public class SeatInfo {
	private String roomNum;
	private int seatLevel;
	private int seatNum;
	
	@SuppressWarnings("unused")
	private SeatInfo() {
	}
	
	public SeatInfo( String roomNum, int seatLevel, int seatNum) {
		super();
		this.roomNum = roomNum;
		this.seatLevel = seatLevel;
		this.seatNum = seatNum;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public int getSeatLevel() {
		return seatLevel;
	}
	public void setSeatLevel(int seatLevel) {
		this.seatLevel = seatLevel;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	@Override
	public String toString() {
		return "SeatInfo [roomNum=" + roomNum + ", seatLevel=" + seatLevel
				+ ", seatNum=" + seatNum + "]";
	}

}
