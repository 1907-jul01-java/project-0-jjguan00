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
	User loginUser;
	App app;
	public void setResultset(User loginUser) throws SQLException {
		this.menu(loginUser);
	}
	
	@SuppressWarnings("static-access")
	private void menu(User user) throws SQLException {
		if(user != null) {
			System.out.println("");
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
			String command = sc.nextLine();
			if(command.contentEquals("1")) {
				ConnectionUtil cu = new ConnectionUtil();
				CheckDao check = new CheckDao(cu.getConnection());
				check.apply();
				cu.close();
				this.setResultset(user);
			}
			if(command.contentEquals("2")) {
				ConnectionUtil cu = new ConnectionUtil();
				CheckDao check = new CheckDao(cu.getConnection());
				System.out.println("Please enter the username of the person you want to create account with");
				UserDao juser = new UserDao(cu.getConnection());
				String jusername = sc.nextLine();
				int jusrid = juser.getUseridByUsername(jusername);
				if(jusrid == 0) {
					System.out.println("Please enter a valid user");
					this.menu(user);
				}
				System.out.println("Please enter your initial deposit");
				int damount = sc.nextInt();
				check.applyjoint(user.getId(),damount,jusrid);
				cu.close();
				this.setResultset(user);
			}
			if(command.contentEquals("3")) {
				ConnectionUtil cu = new ConnectionUtil();
				CheckDao check = new CheckDao(cu.getConnection());
				System.out.print(check.getAccountByUser(user.getId()));
				System.out.println("");
				System.out.println("Enter the account you want to deposit into");
				int daccount = sc.nextInt();
				System.out.println("Enter the amount you want to deposit");
				int damount = sc.nextInt();
				check.deposit(daccount,damount);
				System.out.println("You have deposited "+ damount + " into "+ daccount + ".");
				System.out.print(check.getAccountByUser(user.getId()));
				cu.close();
				this.setResultset(user);
			}
			if(command.contentEquals("4")) {
				ConnectionUtil cu = new ConnectionUtil();
				CheckDao check = new CheckDao(cu.getConnection());
				System.out.print(check.getAccountByUser(user.getId()));
				System.out.println("");
				System.out.println("Enter the account you want to withdraw from");
				int waccount = sc.nextInt();
				System.out.println("Enter the amount you want to withdraw");
				int wamount = sc.nextInt();
				check.withdraw(waccount,wamount);
				System.out.println("You have withdrawn "+ wamount + " into "+ waccount + ".");
				System.out.print(check.getAccountByUser(user.getId()));
				cu.close();
				this.setResultset(user);
			}
			if(command.contentEquals("5")) {
				ConnectionUtil cu = new ConnectionUtil();
				CheckDao check = new CheckDao(cu.getConnection());
				System.out.print(check.getAccountByUser(user.getId()));
				System.out.println("");
				System.out.println("Enter the account you want to transfer from");
				int uaccount = sc.nextInt();
				System.out.println("Enter the account you want to transfer to");
				int taccount = sc.nextInt();
				System.out.println("Enter the amount you want to transfer");
				int amount = sc.nextInt();
				check.transfer(uaccount,amount,taccount);
				System.out.println("You have transfer "+ amount + " into "+ taccount + ".");
				System.out.print(check.getAccountByUser(user.getId()));
				cu.close();
				this.setResultset(user);
			}
			if(command.contentEquals("7")) {
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