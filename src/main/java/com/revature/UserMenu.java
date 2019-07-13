package com.revature;
import java.sql.*;

public class UserMenu {

	private ResultSet user;

	public ResultSet getResultset() {
		return user;
	}

	public void setResultset(ResultSet user) {
		this.user = user;
		this.app();
	}
	
	private void app() {
		if(this.user != null) {
			System.out.println("You are logged in");
			}
		else {
			System.out.println("You do not have permission to view this page.");
		}
	}
}