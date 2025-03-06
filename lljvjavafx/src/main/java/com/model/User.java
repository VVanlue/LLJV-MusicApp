package com.model;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String emailAddress;

    public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
    
}
