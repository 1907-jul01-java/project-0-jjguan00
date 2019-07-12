package com.revature.model;

public class User {
	private String username;
	private String password;
	private String firstname;
	private String license;
	private Boolean status;
	
    public User(String username, String password,String firstname, String license, Boolean status) {
    	super();
    	this.setUsername(username);
    	this.setPassword(password);
    	this.setFirstname(firstname);
    	this.setLicense(license);
    	this.setStatus(status);
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstname=" + firstname + ", license="
				+ license + ", status=" + status + "]";
	}
	
	


}
