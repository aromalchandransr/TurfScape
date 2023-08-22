package com.candella.entity;

public class User {
	private int userId;
	private String firstName;
	private String last_Name;
	private String email;
	private String address;
	private long phone;
	public User(int userId, String firstName, String last_Name, String email, String address, long phone) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.last_Name = last_Name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	

}
