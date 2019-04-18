package com.littlepage.entity;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The instance of ticketInfo
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */

public class TicketInfo {
	private int id;
	private String trainNumber;
	private String startTime;
	private String endTime;
	private String startStation;
	private String endStation;
	private String roomNumber;
	private int seatLevel;
	private int spareSeatNum;
	private double ticketPrice;
	
	@SuppressWarnings("unused")
	private TicketInfo() {
	}
	
	public TicketInfo(int id, String trainNumber, String startTime,
			String endTime, String startStation, String endStation,
			String roomNumber, int seatLevel, int spareSeatNum,double ticketPrice) {
		super();
		this.id = id;
		this.trainNumber = trainNumber;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startStation = startStation;
		this.endStation = endStation;
		this.roomNumber = roomNumber;
		this.seatLevel = seatLevel;
		this.spareSeatNum = spareSeatNum;
		this.ticketPrice=ticketPrice;
	}

	public int getId() {
		return id;
	}
	public String getStartStation() {
		return startStation;
	}
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	public String getEndStation() {
		return endStation;
	}
	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getSeatLevel() {
		return seatLevel;
	}
	public void setSeatLevel(int seatLevel) {
		this.seatLevel = seatLevel;
	}
	public int getSpareSeatNum() {
		return spareSeatNum;
	}
	public void setSpareSeatNum(int spareSeatNum) {
		this.spareSeatNum = spareSeatNum;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "TicketInfo [id=" + id + ", trainNumber=" + trainNumber
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", startStation=" + startStation + ", endStation="
				+ endStation + ", roomNumber=" + roomNumber + ", seatLevel="
				+ seatLevel + ", spareSeatNum=" + spareSeatNum
				+ ", ticketPrice=" + ticketPrice + "]";
	}
}
