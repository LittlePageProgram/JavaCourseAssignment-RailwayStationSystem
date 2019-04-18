package com.littlepage.entity;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The instance of stationInfo
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */

public class StationInfo {
	private int id;
	private String trainNumber;
	private String stationNumber;
	private String stationInfo;
	private String startTime;
	private double distance;
	private int step;
	
	@SuppressWarnings("unused")
	private StationInfo() {
	}
	
	public StationInfo( int id,String trainNumber, String stationNumber,
			String stationInfo, String startTime,
			double distance,int step) {
		super();
		this.id=id;
		this.trainNumber = trainNumber;
		this.stationNumber = stationNumber;
		this.stationInfo = stationInfo;
		this.startTime = startTime;
		this.distance = distance;
		this.step=step;
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
	public String getStationNumber() {
		return stationNumber;
	}
	public void setStationNumber(String stationNumber) {
		this.stationNumber = stationNumber;
	}
	public String getStationInfo() {
		return stationInfo;
	}
	public void setStationInfo(String stationInfo) {
		this.stationInfo = stationInfo;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	@Override
	public String toString() {
		return "StationInfo [id=" + id + ", trainNumber=" + trainNumber
				+ ", stationNumber=" + stationNumber + ", stationInfo="
				+ stationInfo + ", startTime=" + startTime + ", distance="
				+ distance + ", step=" + step + "]";
	}
	
}
