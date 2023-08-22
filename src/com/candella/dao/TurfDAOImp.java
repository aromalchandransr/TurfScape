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
import com.candella.entity.Turf;
import com.candella.entity.TurfOwner;

public class TurfDAOImp implements TurfDAO {

	@Override
	public void addTurf(Turf turf) {
		try
		{
		
			Connection connection=null;
			DataSource ds=DBConnectionPool.getDataSource();
			connection =ds.getConnection();
			String sqlQuery= "insert into turf(turf_id,turf_name,location,owner_id,type,address,facilities,size,phone)"+ "values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement =connection.prepareStatement(sqlQuery);
			statement.setInt(1,turf.getTurfId());
			statement.setString(2,turf.getTurfName());
			statement.setString(3,turf.getLocation());
			statement.setLong(4,turf.getTurfowner().getOwnerId());
			statement.setString(5,turf.getType());
			statement.setString(6,turf.getAddress());
			statement.setString(7,turf.getFacilities());
			statement.setString(8,turf.getSize());
			statement.setLong(9,turf.getPhone());
			statement.executeUpdate();
			connection.close();
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
	
		

	}

	@Override
	public void updateTurf(int turfid, String columnname) {
		try
		{
			Scanner scanner=new Scanner(System.in);
			Connection connection=null;
			DataSource ds=DBConnectionPool.getDataSource();
			connection=ds.getConnection();
			String tablename="turf";
			System.out.println("New value is:");
			String newValue=scanner.nextLine();
			String condition="turf_id="+turfid;
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
	public List<Turf> viewTurf() {
		List<Turf>turfList=new ArrayList<>();
		try {
			Connection connection=null;
			DataSource ds=DBConnectionPool.getDataSource();
			connection=ds.getConnection();
			Scanner scanner=new Scanner(System.in);
			String query="Select * from turf";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet resultSet=preparedStatement.executeQuery(query);
			while(resultSet.next())
			{   TurfOwner turfOwner=new TurfOwner();
			    turfOwner.setOwnerId(resultSet.getInt("owner_id"));
				int turfid=resultSet.getInt("turf_id");
				String tname=resultSet.getString("turf_name");
				String location=resultSet.getString("location");
				String type=resultSet.getString("type");
				String address=resultSet.getString("address");
				String facilities=resultSet.getString("facilities");
				String size=resultSet.getString("size");
				long phone=resultSet.getLong("phone");
				Turf turf=new Turf(turfid,tname,location,type,address,facilities,size,phone,turfOwner);
				turfList.add(turf);
				
			}
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return turfList;
		

	}


	@Override
	public Turf searchTurf(int turf_id) {
		Turf turf=null;
		try {
			
			DataSource ds=DBConnectionPool.getDataSource();
			Connection connection =ds.getConnection();
			String query="select * from turf where turf_id =?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1,turf_id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				TurfOwner turfOwner=new TurfOwner();
			    turfOwner.setOwnerId(resultSet.getInt("owner_id"));
				int turfid=resultSet.getInt("turf_id");
				String tname=resultSet.getString("turf_name");
				String location=resultSet.getString("location");
				String type=resultSet.getString("type");
				String address=resultSet.getString("address");
				String facilities=resultSet.getString("facilities");
				String size=resultSet.getString("size");
				long phone=resultSet.getLong("phone");
				turf=new Turf(turfid,tname,location,type,address,facilities,size,phone,turfOwner);
				
				
			}
		
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return turf;
	
	}

	@Override
	public List<Turf> viewTurfBasedOnLocation(String location) {
		List<Turf>turfList=new ArrayList<>();
		try {
			
			Connection connection=null;
			DataSource ds=DBConnectionPool.getDataSource();
			connection=ds.getConnection();
			Scanner scanner=new Scanner(System.in);
			System.out.println(location);
			String query="Select * from turf ";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			ResultSet resultSet=preparedStatement.executeQuery(query);
			while(resultSet.next())
			{   TurfOwner turfOwner=new TurfOwner();
			    turfOwner.setOwnerId(resultSet.getInt("owner_id"));
				int turfid=resultSet.getInt("turf_id");
				String tname=resultSet.getString("turf_name");
				String locations=resultSet.getString("location");
				String type=resultSet.getString("type");
				String address=resultSet.getString("address");
				String facilities=resultSet.getString("facilities");
				String size=resultSet.getString("size");
				long phone=resultSet.getLong("phone");
				Turf turf=new Turf(turfid,tname,locations,type,address,facilities,size,phone,turfOwner);
				if(locations.equalsIgnoreCase(location))
				turfList.add(turf);
				
			}
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return turfList;
		



}
}