package com.revature;

import java.sql.SQLException;
import com.revature.App;
import java.util.Scanner;

public class AdminMenu {
	App app;
	public void setResultset(String user) throws SQLException {
		this.menu(user);
	}
	
	@SuppressWarnings("static-access")
	private void menu(String user) throws SQLException {
		if(user != null) {
			System.out.println("Welcome to bank Admin " + user + ".");
			System.out.println("========================================");
			System.out.println("Please choose from the following menu.");
			System.out.println("1. Make a deposit to a account.");
			System.out.println("2. Withdrawn money from a account.");
			System.out.println("3. Transfer money from one account to another");
			System.out.println("4. View checking account application");
			System.out.println("5. Approve checking account application");
			System.out.println("6. Log Out");
			Scanner sc = new Scanner(System.in);
			int command = sc.nextInt();
			if(command == 6) {
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
