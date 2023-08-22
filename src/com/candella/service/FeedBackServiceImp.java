package com.candella.service;

import java.util.List;

import com.candella.dao.FeedBackDAOImp;
import com.candella.entity.FeedBack;

public class FeedBackServiceImp implements FeedBackService {
	FeedBackDAOImp feedBackDAOImp=new FeedBackDAOImp();

	@Override
	public FeedBack searchFeedBack(FeedBack feedBack) {
		
		return null;
	}

	@Override
	public void addFeedBack(FeedBack feedBack) {
		feedBackDAOImp.addFeedBack(feedBack);
		

	}

	@Override
	public List<FeedBack> ListAllFeedBack() {
		// TODO Auto-generated method stub
		return feedBackDAOImp.ListAllFeedBack();
	}

}
