package com.candella.entity;

public class TimeSlot {
	private int slNum;
	private String time;
	private String slot;
	public TimeSlot(int slNum, String time, String slot) {
		super();
		this.slNum = slNum;
		this.time = time;
		this.slot = slot;
	}
	public TimeSlot() {
		// TODO Auto-generated constructor stub
	}
	public int getSlNum() {
		return slNum;
	}
	public void setSlNum(int slNum) {
		this.slNum = slNum;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	

}
