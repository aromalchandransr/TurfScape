package com.candella.dao;

import java.util.List;

import com.candella.entity.User;



public interface UserDao {
	public void addUser(User user);

	public void updateUser(int userid, String columnname);

	public List<User> viewUsers();
	
	public User searchUser(int user_id);


}
