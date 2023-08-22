package com.candella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import com.candella.dbconnectionpool.DBConnectionPool;
import com.candella.entity.Booking;
import com.candella.entity.TimeSlot;
import com.candella.entity.Turf;
import com.candella.entity.User;

public class BookingDAOImp implements BookingDAO {

	@Override
	public void addBooking(Booking booking) {
	    try (Connection connection = DBConnectionPool.getDataSource().getConnection()) {
	        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String sqlQuery = "insert into booking(booking_id,user_id,turf_id,booking_date,start_time,end_time,slot_id,booking_status)"
	                + "values(?,?,?,?,?,?,?,?)";
	        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
	            statement.setInt(1, booking.getBookingId());
	            statement.setInt(2, booking.getUser().getUserId());
	            statement.setInt(3, booking.getTurf().getTurfId());
	            Date date = Date.valueOf(booking.getBookingDate());
	            statement.setDate(4, date);
	            Time time = Time.valueOf(booking.getStartTime());
	            statement.setTime(5, time);
	            Time etime = Time.valueOf(booking.getEndTime());
	            statement.setTime(6, etime);
	           
	            statement.setInt(7,booking.getSlot().getSlNum());
	            statement.setString(8, booking.getBookingStatus());
	            statement.executeUpdate();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void updateBooking(int bookingId, String columnname) {
		try
		{
			Scanner scanner=new Scanner(System.in);
			Connection connection=null;
			DataSource ds=DBConnectionPool.getDataSource();
			connection=ds.getConnection();
			String tablename="booking";
			System.out.println("New value is:");
			String newValue=scanner.nextLine();
			String condition="booking_id="+bookingId;
			String updateQuery="UPDATE "+tablename+" SET "+columnname+" = ? WHERE "+condition;
			PreparedStatement preparedStatement=connection.prepareStatement(updateQuery);
			preparedStatement.setString(1,newValue);
			int rowsAffected=preparedStatement.executeUpdate();
			System.out.println(rowsAffected+"row(s) updated.");
			}catch(SQLException e)
		{
				System.out.println(e.getMessage());
		}

	}
		

	@Override
	public List<Booking> viewBooking() {
		List<Booking>bookingList=new ArrayList<>();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyy-MM-dd");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		try {
			Connection connection=null;
			DataSource ds=DBConnectionPool.getDataSource();
			connection=ds.getConnection();
			Scanner scanner=new Scanner(System.in);
			String query="Select * from booking";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet resultSet=preparedStatement.executeQuery(query);
			while(resultSet.next())
			{   User user =new User();
			    Turf turf=new Turf();
			    TimeSlot slotId=new TimeSlot();
			    int bookingid=resultSet.getInt("booking_id");
			    user.setUserId(resultSet.getInt("user_id"));
			    turf.setTurfId(resultSet.getInt("turf_id"));
				LocalDate bdate= LocalDate.parse(resultSet.getString("booking_date"),formatter);
				LocalTime stime= LocalTime.parse(resultSet.getString("start_time"),timeFormatter);
				LocalTime etime=LocalTime.parse(resultSet.getString("end_time"),timeFormatter);
				
				slotId.setSlNum(resultSet.getInt("slot_id"));
				String bstatus=resultSet.getString("booking_status");

				Booking booking=new Booking(bookingid,user,turf,bdate,stime,etime,slotId,bstatus);
				bookingList.add(booking);
				
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return bookingList;
		

	}
	
	

	@Override
	public Booking searchBooking(int bookingId) {
		Booking booking =null;
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("YYYY-MM-DD");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		try {
			
			DataSource ds=DBConnectionPool.getDataSource();
			Connection connection =ds.getConnection();
			String query="select * from booking where booking_id =?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1,bookingId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				
			    Turf turf =new Turf();
			    
				
				turf.setTurfId(resultSet.getInt("turf_id"));
				
			
				
				
				booking=new Booking(turf);
				
				
			}
		
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return booking;
	
	
}

	@Override
	public List<Booking> getAllBookingBasedONDate(LocalDate bookingDate,LocalTime time) {
		List<Booking>bookingList=new ArrayList<>();	
		
		 try {

	    		
	    		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    		 DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	    		Connection connection = null;
	    		DataSource ds = DBConnectionPool.getDataSource();
	    		connection = ds.getConnection();
	    		
	    		String sqlQuery = "SELECT * FROM booking where booking_date = ?";
	    		PreparedStatement statement = connection.prepareStatement(sqlQuery);
                statement.setString(1,bookingDate.format(format));
                ResultSet resultSet = statement.executeQuery();
                
                
                while(resultSet.next())
                {
                	LocalDate bdate= LocalDate.parse(resultSet.getString("booking_date"),format);
                	Turf turf=new Turf();
                	turf.setTurfId(resultSet.getInt("turf_id"));
                	LocalTime startTime=LocalTime.parse(resultSet.getString("start_time"),timeFormatter);
                    LocalTime endTime=LocalTime.parse(resultSet.getString("end_time"),timeFormatter);
                	Booking booking=new Booking(turf,bdate,startTime,endTime);
              	if ((time.isAfter(startTime) && time.isBefore(endTime))) {
                			bookingList.add(booking);
                	}
                }
	       
		
		  } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return bookingList;
	    }

	public List<Booking> getAllBookingBasedONSlot(LocalDate bookingDate, int time) {

		List<Booking>bookingList=new ArrayList<>();	
		
		 try {

	    		
	    		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    		
	    		Connection connection = null;
	    		DataSource ds = DBConnectionPool.getDataSource();
	    		connection = ds.getConnection();
	    		
	    		String sqlQuery = "SELECT * FROM booking where booking_date = ? and slot_id= ?";
	    		PreparedStatement statement = connection.prepareStatement(sqlQuery);
                statement.setString(1,bookingDate.format(format));
                statement.setInt(2, time);
                ResultSet resultSet = statement.executeQuery();
                
                
                while(resultSet.next())
                {
                	LocalDate bdate= LocalDate.parse(resultSet.getString("booking_date"),format);
                	Turf turf=new Turf();
                	turf.setTurfId(resultSet.getInt("turf_id"));
                	
                	Booking booking=new Booking(turf,bdate);
              	
                			bookingList.add(booking);
                	
                }
	       
		
		  } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return bookingList;
	    }

		
	}
	
