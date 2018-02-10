package com.kshrd.model;

public class Message {
	private String username;
	private String message;
	private String socketId;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSocketId() {
		return socketId;
	}
	public void setSocketId(String socketId) {
		this.socketId = socketId;
	}
	@Override
	public String toString() {
		return "Message [username=" + username + ", message=" + message + ", socketId=" + socketId + "]";
	}
}
