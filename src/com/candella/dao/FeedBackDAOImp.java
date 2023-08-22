package com.candella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import com.candella.dbconnectionpool.DBConnectionPool;
import com.candella.entity.FeedBack;
import com.candella.entity.Turf;
import com.candella.entity.User;

public class FeedBackDAOImp implements FeedBackDAO {

	@Override
	public FeedBack searchFeedBack(FeedBack feedBack) {
		
		return null;
	}

	@Override
	public void addFeedBack(FeedBack feedBack) {
		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "insert into feedback (fed_id,user_id,turf_id,feed_back) "
					+ "values(?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1,feedBack.getFedId());
			statement.setInt(2,feedBack.getUser().getUserId());
			statement.setInt(3, feedBack.getTurf().getTurfId());
			statement.setString(4, feedBack.getFeedBack());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	

	

	@Override
	public List<FeedBack> ListAllFeedBack() {
    List<FeedBack> feedbackList = new ArrayList<FeedBack>();
		
		try {
		
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection= ds.getConnection();
			
			
			String sqlQuery = "select * from feedback";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			ResultSet resultSet	= statement.executeQuery();
			
			
			while(resultSet.next())
			{   int feedBackId=resultSet.getInt("fed_id");
				User user = new User();
				user.setUserId(resultSet.getInt("user_id"));
				Turf turf = new Turf();
				turf.setTurfId(resultSet.getInt("turf_id"));
			    String feedback1=resultSet.getString("feed_back");
				FeedBack feedback = new FeedBack(feedBackId,user,turf,feedback1);
				feedbackList.add(feedback);
			}
			connection.close();
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		
		}
			
		return feedbackList;
		
	
		
		
	

		
	
		
		
	}

}
