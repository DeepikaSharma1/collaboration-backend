package com.niit.collaboration.backend.dao;

import java.util.List;

import com.niit.collaboration.backend.model.User;

/**
 * 
 * @author Deepika
 *
 */
public interface UserDao {

	void create(User user);
	
	void update(User user);
	
	User get(long userId);
	
	User get(String username);
	
	List<User> getAll();
	
	List<User> getAllExcept(long userId);
	
	boolean exists(User auser);
	
	boolean authenticate(String username, String password);
	
	void setOnline(long userId);
	
	void setOffline(long userId);
	
}
