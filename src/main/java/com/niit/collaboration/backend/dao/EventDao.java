/**
 * 
 */
package com.niit.collaboration.backend.dao;

import java.util.List;

import com.niit.collaboration.backend.model.Event;

/**
 * @author Deepika
 *
 */
public interface EventDao {

	void create(Event event);
	
	void update(Event event);
	
	Event get(long eventId);
	
	List<Event> getAll();
	
}
