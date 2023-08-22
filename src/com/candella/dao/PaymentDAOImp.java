package com.candella.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import com.candella.dbconnectionpool.DBConnectionPool;
import com.candella.entity.Booking;
import com.candella.entity.Payment;


public class PaymentDAOImp implements PaymentDAO {

	@Override
	public void addPayment(Payment payment) {
		 try (Connection connection = DBConnectionPool.getDataSource().getConnection()) {
		        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        String sqlQuery = "insert into payment(payment_id,booking_id,total_cost,payment_method,payment_status)"
		                + "values(?,?,?,?,?)";
		        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
		            statement.setInt(1, payment.getPaymentId());
		            statement.setInt(2, payment.getBookingID().getBookingId());
		            statement.setDouble(3, payment.getTotalCost());
		            statement.setString(4,payment.getPaymentMethod() );
		            statement.setString(5,payment.getPaymentStatus());
		            statement.executeUpdate();
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
		

	

	@Override
	public List<Payment> viewPayment() {
		List<Payment>paymentList=new ArrayList<>();
		
		
		try {
			Connection connection=null;
			DataSource ds=DBConnectionPool.getDataSource();
			connection=ds.getConnection();
			Scanner scanner=new Scanner(System.in);
			
			String query="Select * from payment";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet resultSet=preparedStatement.executeQuery(query);
			
			while(resultSet.next())
			{   Booking booking =new Booking();
			    int paymentId=resultSet.getInt("payment_id");
			    booking.setBookingId(resultSet.getInt("booking_id"));
			    double cost= resultSet.getDouble("total_cost");
				String paymentMethod=resultSet.getString("payment_method");
				String paymentStatus=resultSet.getString("payment_status");

				Payment payment=new Payment(paymentId,booking,cost,paymentMethod,paymentStatus);
				paymentList.add(payment);
				
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return paymentList;
		

	}
		
		
	}


