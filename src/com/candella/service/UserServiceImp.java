package com.candella.service;

import java.util.List;

import com.candella.dao.UserDAOImpl;
import com.candella.entity.User;

public class UserServiceImp implements UserService {
	UserDAOImpl userDAOImpl=new UserDAOImpl();

	@Override
	public void addUser(User user) {
		
		userDAOImpl.addUser(user);
		

	}

	@Override
	public List<User>viewUsers() {
		
	
		return userDAOImpl.viewUsers();
	}

	@Override
	public void updateUser(int userid, String columnname) {
		userDAOImpl.updateUser(userid,columnname);
		
	}

	@Override
	public User searchUser(int userid) {
		
		return userDAOImpl.searchUser(userid);
		
	}

	
		
	

	
	}


