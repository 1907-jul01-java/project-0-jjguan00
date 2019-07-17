package com.revature;

import java.sql.SQLException;
import com.revature.App;
import java.util.Scanner;
import com.revature.entities.*;
import com.revature.util.*;

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
			System.out.println("4. Delete checking account application");
			System.out.println("5. Approve checking account application");
			System.out.println("6. Show all active checking account");
			System.out.println("7. Log Out");
			Scanner sc = new Scanner(System.in);
			int command = sc.nextInt();
			if(command == 1) {
				ConnectionUtil cu = new ConnectionUtil();
				CheckDao check = new CheckDao(cu.getConnection());
				System.out.println(check.getAll());
				System.out.println("");
				System.out.println("Enter the account you want to deposit into");
				int daccount = sc.nextInt();
				System.out.println("Enter the amount you want to deposit");
				int damount = sc.nextInt();
				check.deposit(daccount,damount);
				System.out.println("You have deposited "+ damount + " into "+ daccount + ".");
				cu.close();
				this.menu(user);
			}
			if(command == 2) {
				ConnectionUtil cu = new ConnectionUtil();
				CheckDao check = new CheckDao(cu.getConnection());
				System.out.println(check.getAll());
				System.out.println("");
				System.out.println("Enter the account you want to withdraw from");
				int waccount = sc.nextInt();
				System.out.println("Enter the amount you want to withdraw");
				int wamount = sc.nextInt();
				check.withdraw(waccount,wamount);
				System.out.println("You have withdrawn "+ wamount + " into "+ waccount + ".");
				cu.close();
				this.menu(user);
			}
			if(command == 3) {
				ConnectionUtil cu = new ConnectionUtil();
				CheckDao checkDao = new CheckDao(cu.getConnection());
				System.out.println(checkDao.getAll());
				System.out.println("");
				System.out.println("Enter the account you want to transfer from");
				int uaccount = sc.nextInt();
				System.out.println("Enter the account you want to transfer to");
				int taccount = sc.nextInt();
				System.out.println("Enter the amount you want to transfer");
				int amount = sc.nextInt();
				checkDao.transfer(uaccount,amount,taccount);
				System.out.println("You have transfer "+ amount + " into "+ taccount + ".");
				cu.close();
				this.menu(user);
			}
			if(command == 4) {
				ConnectionUtil cu = new ConnectionUtil();
				CheckDao checkDao = new CheckDao(cu.getConnection());
				System.out.println(checkDao.getAll());
				System.out.println("Please enter the checking account you want to destroy");
				int destroyAcc = sc.nextInt();
				checkDao.destroy(destroyAcc);
				System.out.println("Account:" + destroyAcc + " has beeen destroyed.");
				cu.close();
				this.menu(user);
			}
			if(command == 5) {
				ConnectionUtil cu = new ConnectionUtil();
				CheckDao checkDao = new CheckDao(cu.getConnection());
				System.out.println(checkDao.getAllUnapprove());
				System.out.println("Please enter the checking account you want to approve");
				int approveAcc = sc.nextInt();
				checkDao.approveCheck(approveAcc);
				System.out.println("Account:" + approveAcc + "has beeen approved.");
				cu.close();
				this.menu(user);
			}
			if(command == 6) {
				ConnectionUtil cu = new ConnectionUtil();
				CheckDao checkDao = new CheckDao(cu.getConnection());
				System.out.println(checkDao.getAll());
				cu.close();
				this.menu(user);
			}
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
