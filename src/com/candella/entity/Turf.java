package com.candella.entity;

public class Turf {
	private int turfId;
	private String turfName;
	private String location;
	private String type;
	private String address;
	private String facilities;
	private String size;
	private long phone;
	private TurfOwner turfowner;
	
	
	
	public Turf(int turfId, String turfName, String location, String type, String address, String facilities,
			String size, long phone, TurfOwner turfowner) {
		super();
		this.turfId = turfId;
		this.turfName = turfName;
		this.location = location;
		this.type = type;
		this.address = address;
		this.facilities = facilities;
		this.size = size;
		this.phone = phone;
		this.turfowner = turfowner;
	}
	public Turf() {
		// TODO Auto-generated constructor stub
	}
	public String getTurfName() {
		return turfName;
	}
	public void setTurfName(String turfName) {
		this.turfName = turfName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public TurfOwner getTurfowner() {
		return turfowner;
	}
	public void setTurfowner(TurfOwner turfowner) {
		this.turfowner = turfowner;
	}
	public int getTurfId() {
		return turfId;
	}
	public void setTurfId(int turfId) {
		this.turfId = turfId;
	}
	
	
	
	

}
