package com.revature.model;

public class User {
	private String username;
	private String firstname;
	private int id;

	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User(String username, String password,String firstname, String license, Boolean status) {
    	super();
    	this.setUsername(username);
    	this.setFirstname(firstname);
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstname=" + firstname + ", id=" + id + "]";
	}



}
