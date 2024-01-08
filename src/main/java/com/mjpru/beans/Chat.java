package com.mjpru.beans;

public class Chat {
         
	
	String sender, reciver, message, dom;
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReciver() {
		return reciver;
	}

	public Chat(String sender, String reciver, String message, String date)
	{
		this.sender = sender;
		this.reciver = reciver;
		this.message = message;
		this.dom = date;
	}

	public void setReciver(String reciver) {
		this.reciver = reciver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String date) {
		this.dom = date;
	}


}

