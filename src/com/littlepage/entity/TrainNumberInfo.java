package com.littlepage.entity;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The instance of TrainNumverInfo
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */

public class TrainNumberInfo {
	private int id;
	private String trainNumber;
	private int trainType;
	private String startLocation;
	private String endLocation;
	private String startTime;
	private String endTime;
	private String runTime;
	
	@SuppressWarnings("unused")
	private TrainNumberInfo() {
	}
	
	public TrainNumberInfo(int id, String trainNumber, int trainType,
			String startLocation, String endLocation, String startTime,
			String endTime, String runTime) {
		super();
		this.id = id;
		this.trainNumber = trainNumber;
		this.trainType = trainType;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.startTime = startTime;
		this.endTime = endTime;
		this.runTime = runTime;
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
	public int getTrainType() {
		return trainType;
	}
	public void setTrainType(int trainType) {
		this.trainType = trainType;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public String getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
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
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	@Override
	public String toString() {
		return "TrainNumberInfo [id=" + id + ", trainNumber=" + trainNumber
				+ ", trainType=" + trainType + ", startLocation="
				+ startLocation + ", endLocation=" + endLocation
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", runTime=" + runTime + "]";
	}
	
}
