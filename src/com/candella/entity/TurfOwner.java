package com.candella.entity;

public class TurfOwner {
	private int ownerId;
	private String ownerName;
	private String address;
	private long phone;
	public TurfOwner(int ownerId, String ownerName, String address, long phone) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.address = address;
		this.phone = phone;
	}
	public TurfOwner() {
		// TODO Auto-generated constructor stub
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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
