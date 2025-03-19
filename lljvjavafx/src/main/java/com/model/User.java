package com.model;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String emailAddress;

    public void UserLogin(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
    
    public String getPassword() {
        return password;
    }
}
