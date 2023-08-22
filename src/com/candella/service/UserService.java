package com.candella.service;

import java.util.List;

import com.candella.entity.User;


public interface UserService {
	public void addUser(User user);

	public void updateUser(int userid,String columnname);
	
	public User searchUser(int userid);

	public List<User> viewUsers();


}

