package com.candella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import com.candella.dbconnectionpool.DBConnectionPool;
import com.candella.entity.Fare;
import com.candella.entity.Turf;


public class FareDAOImp implements FareDAO {

	private static final int rate = 0;
	private static final int rate1 = 0;

	@Override
	public List<Fare> viewFare() {
		
		List<Fare>fareList=new ArrayList<>();
		try {
			Connection connection=null;
			DataSource ds=DBConnectionPool.getDataSource();
			connection=ds.getConnection();
			Scanner scanner=new Scanner(System.in);
			String query="Select * from fare_table";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet resultSet=preparedStatement.executeQuery(query);
			while(resultSet.next())
			{  
			    
				int fareId=resultSet.getInt("fare_id");
				Turf turf=new Turf();
				turf.setTurfId(resultSet.getInt("turf_id"));
				double amount =resultSet.getDouble("fare_2hr");
				Fare fare =new Fare(fareId,turf,amount);
				fareList.add(fare);
				
			}
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return fareList;
		

	
	}


	public static double searchFare(int turfid) {
		Fare fare =null;
		double rate=0;
try {
			
			DataSource ds=DBConnectionPool.getDataSource();
			Connection connection =ds.getConnection();
			String query="select * from fare_table where turf_id =?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(2,turfid);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				 rate=resultSet.getDouble("fare_2hr");
			}
		

	}catch(SQLException e)
	{
		System.out.println(e.getMessage());
	}
return rate;

}}