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
import com.candella.entity.TimeSlot;


public class TimeSlotDAOImp implements TimeSlotDAO {

	@Override
	public List<TimeSlot> viewTimeSlots() {
		List<TimeSlot>timeList=new ArrayList<>();
		try {
			Connection connection=null;
			DataSource ds=DBConnectionPool.getDataSource();
			connection=ds.getConnection();
			Scanner scanner=new Scanner(System.in);
			String query="Select * from timeslot";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet resultSet=preparedStatement.executeQuery(query);
			while(resultSet.next())
			{  
			    
				int slotId=resultSet.getInt("sl_num");
				String time=resultSet.getString("time");
				String slots=resultSet.getString("slot");
				
				TimeSlot timeSlot=new TimeSlot(slotId,time,slots);
				timeList.add(timeSlot);
				
			}
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return timeList;
		

	
	}

}
