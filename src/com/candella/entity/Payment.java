package com.candella.entity;

public class Payment {
	private int paymentId;
	private Booking bookingID;
	private double totalCost;
	private String paymentMethod;
	private String paymentStatus;
	public Payment(int paymentId, Booking bookingID, double totalCost, String paymentMethod, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.bookingID = bookingID;
		this.totalCost = totalCost;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public Booking getBookingID() {
		return bookingID;
	}
	public void setBookingID(Booking bookingID) {
		this.bookingID = bookingID;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	

}
