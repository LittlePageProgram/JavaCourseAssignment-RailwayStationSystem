package com.littlepage.entity;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The instance of CustomerInfo
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
public class CustomerInfo {
	private int id;
	private String loginName;
	private String customerName;
	private String sex;
	private String identityNumber;
	private String birthTime;
	private String phoneCall;
	private String customerPassword;
	
	@SuppressWarnings("unused")
	private CustomerInfo() {
	}
	
	public CustomerInfo(int id,String loginName,String customerName, String sex,
			String identityNumber, String birthTime, String phoneCall,String customerPassword) {
		super();
		this.id=id;
		this.loginName=loginName;
		this.customerName = customerName;
		this.sex = sex;
		this.identityNumber = identityNumber;
		this.birthTime = birthTime;
		this.phoneCall = phoneCall;
		this.customerPassword=customerPassword;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public String getBirthTime() {
		return birthTime;
	}
	public void setBirthTime(String birthTime) {
		this.birthTime = birthTime;
	}
	public String getPhoneCall() {
		return phoneCall;
	}
	public void setPhoneCall(String phoneCall) {
		this.phoneCall = phoneCall;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	@Override
	public String toString() {
		return "CustomerInfo [id=" + id + ", loginName=" + loginName
				+ ", customerName=" + customerName + ", sex=" + sex
				+ ", identityNumber=" + identityNumber + ", birthTime="
				+ birthTime + ", phoneCall=" + phoneCall
				+ ", customerPassword=" + customerPassword + "]";
	}
}
