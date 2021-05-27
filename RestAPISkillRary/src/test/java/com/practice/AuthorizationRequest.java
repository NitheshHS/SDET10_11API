package com.practice;

public class AuthorizationRequest {

	public String userName;
	
	public  String password;

	public AuthorizationRequest(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public AuthorizationRequest() {}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
