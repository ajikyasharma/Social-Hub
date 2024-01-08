package com.mjpru.beans;

public class User {
   String email, password, name;

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getName() {
	return name;
}

public User() {
	
}

public User(String email, String password, String name) {
	super();
	this.email = email;
	this.password = password;
	this.name = name;
}

public void setName(String name) {
	this.name = name;
}
}
