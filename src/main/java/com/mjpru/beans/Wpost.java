package com.mjpru.beans;

public class Wpost {
    public Wpost(int wid, String message, String sender, String dop) {
		
		this.wid = wid;
		this.message = message;
		this.sender = sender;
		this.dop = dop;
	}
	int wid;
    String message , sender, dop;
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getDop() {
		return dop;
	}
	public void setDop(String dop) {
		this.dop = dop;
	}
}
