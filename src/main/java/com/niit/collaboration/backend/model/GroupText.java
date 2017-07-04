/**
 * 
 */
package com.niit.collaboration.backend.model;

import java.util.Date;

/**
 * @author Deepika
 *
 */
public class GroupText extends Message {

	private Date time;

	/**
	 * 
	 */
	public GroupText() {
		super();
	}

	/**
	 * @param id
	 * @param message
	 * @param username
	 */
	public GroupText(Message msg, Date time) {
		super(msg.getId(), msg.getMessage(), msg.getUsername());
		this.time = time;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

}
