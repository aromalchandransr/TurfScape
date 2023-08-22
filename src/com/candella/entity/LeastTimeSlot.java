package com.candella.entity;



public class LeastTimeSlot {
	private int id;
	private TimeSlot timeSlot;
	public LeastTimeSlot(int id, TimeSlot timeSlot) {
		super();
		this.id = id;
		this.timeSlot = timeSlot;
	}
	public LeastTimeSlot() {
		// TODO Auto-generated constructor stub
	}
	public LeastTimeSlot(int timeSlotId) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TimeSlot getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}
	

}
