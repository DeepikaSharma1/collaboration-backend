/**
 * 
 */
package com.niit.collaboration.backend.model;

import java.util.Date;

/**
 * @author Deepika
 *
 */
public class PrivateText extends Message {

	private String friendName;
	private Date time;

	/**
	 * 
	 */
	public PrivateText() {
		super();
	}

	/**
	 * @param id
	 * @param message
	 * @param username
	 */
	public PrivateText(Message msg, String friendName, Date time) {
		super(msg.getId(), msg.getMessage(), msg.getUsername());
		this.friendName = friendName;
		this.time = time;
	}

	/**
	 * @return the friendName
	 */
	public String getFriendName() {
		return friendName;
	}

	/**
	 * @param friendName
	 *            the friendName to set
	 */
	public void setFriendName(String friendName) {
		this.friendName = friendName;
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
