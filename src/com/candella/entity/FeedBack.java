package com.candella.entity;

public class FeedBack {
	private int fedId;
	private User user;
	private Turf turf;
	private String feedBack;
	public FeedBack(int fedId, User user, Turf turf, String feedBack) {
		super();
		this.fedId = fedId;
		this.user = user;
		this.turf = turf;
		this.feedBack = feedBack;
	}
	public FeedBack(int int1, int int2, User user2, Turf turf2) {
		// TODO Auto-generated constructor stub
	}
	public FeedBack(int int1, String string, User user2, Turf turf2) {
		// TODO Auto-generated constructor stub
	}
	public int getFedId() {
		return fedId;
	}
	public void setFedId(int fedId) {
		this.fedId = fedId;
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
	public String getFeedBack() {
		return feedBack;
	}
	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
	

}
