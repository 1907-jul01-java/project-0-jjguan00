package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private Connection connection;
	String url = "jdbc:postgresql://192.168.99.100:2376/project_zero";
	String username = "project-zero";
	String password = "password";

	public ConnectionUtil() {
		try {
			this.connection = DriverManager.getConnection(this.url, this.username, this.password);
		} catch (SQLException e) {
			e.getMessage();
		}
	}
	
	public Connection getConnection() {
		System.out.print("here");
		return connection;
	}
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {

        }
    }
}
