package com.foodapp.model;

public class User {
	private int userID;
	private String userName;
	private String password;
	private String email;
	private String address;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserNameString() {
		return userName;
	}

	public void setUserNameString(String userNameString) {
		this.userName = userNameString;
	}

	public String getPasswordString() {
		return password;
	}

	public void setPasswordString(String passwordString) {
		this.password = passwordString;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddressString() {
		return address;
	}

	public void setAddressString(String addressString) {
		this.address = addressString;
	}

	public User() {
		super();
	}

	public User(int userID, String userName, String password, String email, String address) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	

	public User(String name, String password, String email, String address) {

		super();
		this.userName = name;
		this.password = password;
		this.email = email;
		this.address = address;
	}

	@Override
	public String toString() {
		return userID + ' ' + userName + ' ' + password + ' ' + email + ' ' + address;
	}

}
