package com.littlepage.entity;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The instance of TicketPurchaseInfo
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */

public class TicketPurchaseInfo {
	private int id;
	private String trainNumber;
	private String startTime;
	private String endTime;
	private String startStation;
	private String endStation;
	private String roomNumber;
	private String seatNumber;
	private double ticketPrice;
	private String identityNumber;
	private String purchaseTime;
	
	@SuppressWarnings("unused")
	private TicketPurchaseInfo() {
	}
	
	public TicketPurchaseInfo(int id, String trainNumber, String startTime,
			String endTime, String startStation, String endStation,
			String roomNumber, String seatNumber, double ticketPrice,
			String identityNumber, String purchaseTime) {
		super();
		this.id = id;
		this.trainNumber = trainNumber;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startStation = startStation;
		this.endStation = endStation;
		this.roomNumber = roomNumber;
		this.seatNumber = seatNumber;
		this.ticketPrice = ticketPrice;
		this.identityNumber = identityNumber;
		this.purchaseTime = purchaseTime;
	}
	public int getId() {
		return id;
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
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public String getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(String purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	@Override
	public String toString() {
		return "TicketPurchaseInfo [id=" + id + ", trainNumber=" + trainNumber
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", startStation=" + startStation + ", endStation="
				+ endStation + ", roomNumber=" + roomNumber + ", seatNumber="
				+ seatNumber + ", ticketPrice=" + ticketPrice
				+ ", identityNumber=" + identityNumber + ", purchaseTime="
				+ purchaseTime + "]";
	}
	
	
}
