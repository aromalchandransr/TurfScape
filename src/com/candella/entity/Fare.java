package com.candella.entity;

public class Fare {
	private int fareId;
	private Turf turf;
	private double fare;
	public Fare(int fareId, Turf turf, double fare) {
		super();
		this.fareId = fareId;
		this.turf = turf;
		this.fare = fare;
	}
	
	

	public Fare(double rate) {
		// TODO Auto-generated constructor stub
		this.fare = rate;
	}

	public int getFareId() {
		return fareId;
	}
	public void setFareId(int fareId) {
		this.fareId = fareId;
	}
	public Turf getTurf() {
		return turf;
	}
	public void setTurf(Turf turf) {
		this.turf = turf;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	

}
