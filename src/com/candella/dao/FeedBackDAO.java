package com.candella.dao;

import java.util.List;

import com.candella.entity.FeedBack;

public interface FeedBackDAO {
FeedBack searchFeedBack(FeedBack feedBack);
public void addFeedBack(FeedBack feedBack);
public List<FeedBack>ListAllFeedBack();
}
