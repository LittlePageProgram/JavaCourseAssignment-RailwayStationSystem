package com.littlepage.entity;
/**
 * Copyright (c) 2018 Shanghai University of Electric Power
 * @function:The instance of ContactPeople
 * @author:Little Page
 * @version:1.0
 * @isCompleted:true
 */
public class ContactPeople {
	private int id;
	private int parentId;
	private int contactId;
	
	@SuppressWarnings("unused")
	private ContactPeople() {
	}
	
	public ContactPeople(int id, int parentId, int contactId) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.contactId = contactId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	@Override
	public String toString() {
		return "ContactPeople [id=" + id + ", parentId=" + parentId
				+ ", contactId=" + contactId + "]";
	}
}
