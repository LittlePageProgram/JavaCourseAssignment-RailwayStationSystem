package com.littlepage.entity;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The instance of Administrator
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
public class Administrator {
	private String name;
	private String password;
	
	@SuppressWarnings("unused")
	private Administrator() {
	}
	
	public Administrator(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Administrator [name=" + name + ", password=" + password + "]";
	}
	@Override
	public boolean equals(Object obj) {
		Administrator a=(Administrator)obj;
		return name.equals(a.getName())&&password.equals(a.getPassword());
	}
}
