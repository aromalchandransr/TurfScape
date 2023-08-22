package com.candella.service;

import java.util.List;

import com.candella.entity.FeedBack;

public interface FeedBackService {
	FeedBack searchFeedBack(FeedBack feedBack);
	public void addFeedBack(FeedBack feedBack);
	public List<FeedBack>ListAllFeedBack();

}
