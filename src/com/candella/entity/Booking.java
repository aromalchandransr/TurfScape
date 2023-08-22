package com.candella.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
	private int bookingId;
	private User user;
	private Turf turf;
	private LocalDate bookingDate;
	private LocalTime startTime;
	private LocalTime endTime;
	
	private TimeSlot slot;
	private String bookingStatus;
	public Booking(int bookingId, User user, Turf turf, LocalDate bookingDate, LocalTime startTime, LocalTime endTime, TimeSlot slot, String bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.turf = turf;
		this.bookingDate = bookingDate;
		this.startTime = startTime;
		this.endTime = endTime;
		
		this.slot = slot;
		this.bookingStatus = bookingStatus;
	}
	
	
	


	public Booking(Turf turf, LocalDate bdate) {
		this.turf = turf;
		this.bookingDate = bdate;
		
	}


	public Booking() {
		// TODO Auto-generated constructor stub
	}





	public Booking(Turf turf2, LocalDate bdate, LocalTime startTime2, LocalTime endTime2) {
		this.turf = turf2;
		this.bookingDate = bdate;
		this.startTime = startTime2;
		this.endTime = endTime2;
		
	}





	public Booking(Turf turf2) {
		this.turf = turf2;
		// TODO Auto-generated constructor stub
	}





	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Turf getTurf() {
		return turf;
	}
	public void setTurf(Turf turf) {
		this.turf = turf;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	
	public TimeSlot getSlot() {
		return slot;
	}
	public void setSlot(TimeSlot slot) {
		this.slot = slot;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	
	
	
	

}
