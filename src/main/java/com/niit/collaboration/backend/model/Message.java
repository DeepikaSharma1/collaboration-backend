/**
 * 
 */
package com.niit.collaboration.backend.model;

/**
 * @author Deepika
 *
 */
public class Message {

	private int id;
	private String message;
	private String username;

	public Message() {
	}

	/**
	 * 
	 * @param id the id to set
	 * @param message the message to set
	 * @param username the username to set
	 */
	public Message(int id, String message, String username) {
		this.id = id;
		this.message = message;
		this.username = username;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
