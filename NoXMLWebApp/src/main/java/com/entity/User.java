package com.entity;

public class User {

	private int id;
	private String email;
	private String hashString;
	private String dob;
	private String saltString;

	public User(int id, String email, String hashString, String dob, String saltString) {
		super();
		this.id = id;
		this.email = email;
		this.saltString = saltString;
		this.dob = dob;
		this.hashString = hashString;
	}

	public int getId() {
		return id;
	}

	public User(String email, String hashString, String dob, String saltString) {

		this.email = email;
		this.saltString = saltString;
		this.dob = dob;
		this.hashString = hashString;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashString() {
		return hashString;
	}

	public void setHashString(String hashString) {
		this.hashString = hashString;
	}

	public String getSaltString() {
		return saltString;
	}

	public void setSaltString(String saltString) {
		this.saltString = saltString;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", dob=" + dob + "]";
	}

}
