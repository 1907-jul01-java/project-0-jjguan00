package com.revature;
import com.revature.App;
import java.sql.*;
import java.util.Scanner;
import com.revature.entities.*;
import com.revature.util.*;
import com.revature.model.User;
public class UserMenu {

	Connection connection;
//	public ResultSet getResultset() {
//		return user;
//	}
	App app;
	public void setResultset(User user) throws SQLException {
		System.out.print(user.getFirstname());;
		this.menu(user);
	}
	
	@SuppressWarnings("static-access")
	private void menu(User user) throws SQLException {
		if(user != null) {
			System.out.println("Welcome to bank " + user.getFirstname() + ".");
			System.out.println("========================================");
			System.out.println("Please choose from the following menu.");
			System.out.println("1. Apply for a checking account.");
			System.out.println("2. Apply for a joint checking account.");
			System.out.println("3. Make a deposit to current account.");
			System.out.println("4. Withdrawn money from current account.");
			System.out.println("5. Transfer money from one account to another");
			System.out.println("6. Check on current checking account application");
			System.out.println("7. Log Out");
			Scanner sc = new Scanner(System.in);
			int command = sc.nextInt();
			if(command == 1) {
				ConnectionUtil cu = new ConnectionUtil();
				CheckDao check = new CheckDao(cu.getConnection());
				check.apply();
				cu.close();
			}
			if(command == 6)
			if(command == 7) {
				user = null;
				System.out.println("Thank you for using bank, good bye.");
				App restart = new App();
			    String[] arguments = new String[] {};
				restart.main(arguments);
			}
			}
		else {
			System.out.println("You do not have permission to view this page.");
		}
	}
}