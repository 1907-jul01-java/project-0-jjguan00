package com.revature.entities;

import java.sql.*;
import java.util.Scanner;

import com.revature.AdminMenu;

public class AdminDao {
	Connection connection;
	ResultSet admin = null;

	public AdminDao(Connection connection) {
		this.connection = connection;
	}

	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your admin name");
		String adminname = sc.nextLine();
		System.out.println("Please enter your password");
		String password = sc.nextLine();
		try {
			PreparedStatement pStatement = connection
					.prepareStatement("select * from admins where adminname = ? and password = ?");
			pStatement.setString(1, adminname);
			pStatement.setString(2, password);
			admin = pStatement.executeQuery();
			if (admin.next()) {
				AdminMenu login = new AdminMenu();
				String loginAdmin = admin.getString("adminname");
				login.setResultset(loginAdmin);
			} else {
				System.out.print("Wrong AdminName and Password");
			}
		} catch (SQLException e) {
			e.getMessage();
		}
	}
}
