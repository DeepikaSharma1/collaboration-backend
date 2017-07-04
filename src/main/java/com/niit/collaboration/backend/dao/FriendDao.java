/**
 * 
 */
package com.niit.collaboration.backend.dao;

import java.util.List;

import com.niit.collaboration.backend.model.Friend;

/**
 * @author Deepika
 *
 */
public interface FriendDao {

	void create(Friend friend);
	
	void update(Friend friend);
	
	Friend get(long userId, long friendId);
	
	List<Friend> getFriends(long userId);
	
	List<Friend> getRequests(long userId);
	
	void setOnline(long userId);
	
	void setOffline(long userId);
	
}
