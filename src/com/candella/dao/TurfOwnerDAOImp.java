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
import com.candella.entity.TurfOwner;



public class TurfOwnerDAOImp implements TurfOwnerDAO {

	@Override
	public void addTurfOwner(TurfOwner turfOwner) {
		try
		{
		
			Connection connection=null;
			DataSource ds=DBConnectionPool.getDataSource();
			connection =ds.getConnection();
			String sqlQuery= "insert into turfownerdetails(owner_id,owner_name,address,phone)"+ "values(?,?,?,?)";
			PreparedStatement statement =connection.prepareStatement(sqlQuery);
			statement.setLong(1,turfOwner.getOwnerId());
			statement.setString(2,turfOwner.getOwnerName());
			statement.setString(3,turfOwner.getAddress());
			statement.setLong(4,turfOwner.getPhone());
			statement.executeUpdate();
			connection.close();
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
	

	}

	@Override
	public void updateTurfOwner(int ownerid, String columnname) {
		try
		{
			Scanner scanner=new Scanner(System.in);
			Connection connection=null;
			DataSource ds=DBConnectionPool.getDataSource();
			connection=ds.getConnection();
			String tablename="turfownerdetails";
			System.out.println("New value is:");
			String newValue=scanner.nextLine();
			String condition="owner_id="+ownerid;
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
	public List<TurfOwner> viewTurfOwner() {
		List<TurfOwner>ownerList=new ArrayList<>();
		try {
			Connection connection=null;
			DataSource ds=DBConnectionPool.getDataSource();
			connection=ds.getConnection();
			String query="Select * from turfownerdetails";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet resultSet=preparedStatement.executeQuery(query);
			while(resultSet.next())
			{
				int ownerid=resultSet.getInt("owner_id");
				String name=resultSet.getString("owner_name");
				String address=resultSet.getString("address");
				long phone=resultSet.getLong("phone");
				TurfOwner turfOwner=new TurfOwner(ownerid,name,address,phone);
				ownerList.add(turfOwner);
				
			}
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return ownerList;
		

	}

	@Override
	public TurfOwner searchTurfOwner(int owner_id) {
		TurfOwner turfOwner=null;
		try {
			
			DataSource ds=DBConnectionPool.getDataSource();
			Connection connection =ds.getConnection();
			String query="select * from turfownerdetails where owner_id =?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1,owner_id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				int ownerid=resultSet.getInt("owner_id");
				String name=resultSet.getString("owner_name");
				String address=resultSet.getString("address");
				long phone=resultSet.getLong("phone");
				turfOwner=new TurfOwner(ownerid,name,address,phone);
				
				
			}
		
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return turfOwner;
	}

}
