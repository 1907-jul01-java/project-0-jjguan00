package com.revature.model;

public class CheckAccount {
	private String firstname;
	private String lastname;
	private String license;
	private int deposit;
	public CheckAccount(String firstname, String lastname, String license, int deposit) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setLicense(license);
		this.setDeposit(deposit);
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

}
