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
import com.candella.entity.User;

public class UserDAOImpl implements UserDao {
	

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		try
		{
		
			Connection connection=null;
			DataSource ds=DBConnectionPool.getDataSource();
			connection =ds.getConnection();
			String sqlQuery= "insert into user(user_id,first_name,last_name,email,address,phone)"+ "values(?,?,?,?,?,?)";
			PreparedStatement statement =connection.prepareStatement(sqlQuery);
			statement.setLong(1, user.getUserId());
			statement.setString(2,user.getFirstName());
			statement.setString(3,user.getLast_Name());
			statement.setString(4,user.getEmail());
			statement.setString(5,user.getAddress());
			statement.setLong(6,user.getPhone());
			statement.executeUpdate();
			connection.close();
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
		
	}

	@Override
	public void updateUser(int userid, String columnname) {
		try
		{
			Scanner scanner=new Scanner(System.in);
			Connection connection=null;
			DataSource ds=DBConnectionPool.getDataSource();
			connection=ds.getConnection();
			String tablename="User";
			System.out.println("New value is:");
			String newValue=scanner.nextLine();
			String condition="user_id="+userid;
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
	public List<User> viewUsers() {
		List<User>userList=new ArrayList<>();
		try {
			Connection connection=null;
			DataSource ds=DBConnectionPool.getDataSource();
			connection=ds.getConnection();
			String query="Select * from User";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet resultSet=preparedStatement.executeQuery(query);
			while(resultSet.next())
			{
				int userid=resultSet.getInt("user_id");
				String fname=resultSet.getString("first_name");
				String lname=resultSet.getString("last_name");
				String email=resultSet.getString("email");
				String address=resultSet.getString("address");
				long phone=resultSet.getLong("phone");
				User user=new User(userid,fname,lname,email,address,phone);
				userList.add(user);
				
			}
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return userList;
	}

	@Override
	public User searchUser(int userid) {
		User user=null;
		try {
			
			DataSource ds=DBConnectionPool.getDataSource();
			Connection connection =ds.getConnection();
			String query="select * from user where user_id =?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1,userid);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				int userid1=resultSet.getInt("user_id");
				String fname=resultSet.getString("first_name");
				String lname=resultSet.getString("last_name");
				String email=resultSet.getString("email");
				String address=resultSet.getString("address");
				long phone=resultSet.getLong("phone");
				user=new User(userid1,fname,lname,email,address,phone);
				
				
			}
		
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return user;
		
	}

	



	}


