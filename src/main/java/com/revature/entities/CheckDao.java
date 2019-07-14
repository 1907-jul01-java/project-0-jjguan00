package com.revature.entities;

import java.util.Scanner;
import java.security.SecureRandom;
import java.sql.*;
public class CheckDao {
	Connection connection;

	public CheckDao(Connection connection) {
		this.connection = connection;
	}
	
	public void apply() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please make your initial deposit");
		int initialDeposit = sc.nextInt();
		SecureRandom random = new SecureRandom();
		int num = 10000 + random.nextInt(90000);
		try {
			PreparedStatement pStatement = connection.prepareStatement(
					"insert into checks values(?,?,?)");
			pStatement.setInt(1, num);
			pStatement.setInt(2, initialDeposit);
			pStatement.setBoolean(3, false);
			pStatement.executeUpdate();
			System.out.println("Thank you for applying for checking account, our agents will approve and give your the account ready.");
		} catch (SQLException e) {
			e.getMessage();
		} finally {
		}
	}
}
