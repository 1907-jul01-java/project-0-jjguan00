package com.revature.entities;

import java.util.Scanner;
import java.sql.*;
import com.revature.UserMenu;
//import com.revature.model.*;

public class UserDao {
	Connection connection;
	ResultSet user = null;

	public UserDao(Connection connection) {
		this.connection = connection;
	}

//    public static void main(String[] args) {
//    // Declare the object and initialize with 
//    // predefined standard input object 
//	    @SuppressWarnings("resource")
//		Scanner sc = new Scanner(System.in);
//	    String name = sc.nextLine();
//	    String pw = sc.nextLine();
//	    Customer c = new Customer(name,pw);
//	    System.out.println(c.getUsername());
//    }
	public void insert() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Hi, welcome to the sign up menu");
		System.out.println("Please enter a new username");
		String name = sc.nextLine();
		System.out.println("Please enter your password");
		String pw = sc.nextLine();
		System.out.println("Please enter your first name");
		String firstname = sc.nextLine();
		System.out.println("Please enter your license");
		String license = sc.nextLine();
		Boolean status = false;
		try {
			PreparedStatement pStatement = connection.prepareStatement(
					"insert into users(username, password, firstname,license,status) values(?,?,?,?,?)");
			pStatement.setString(1, name);
			pStatement.setString(2, pw);
			pStatement.setString(3, firstname);
			pStatement.setString(4, license);
			pStatement.setBoolean(5, status);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			System.out.println("Thank you for signing up for bank. You can log in now.");
		}
	}
	
    public void getOne() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please enter your username");
    	String username = sc.nextLine();
    	System.out.println("Please enter your password");
    	String password = sc.nextLine();
    	try {
    		PreparedStatement pStatement = connection.prepareStatement("select * from users where username = ? and password = ?");
    		pStatement.setString(1,username);
    		pStatement.setString(2,password);
    		user = pStatement.executeQuery();
		   if( user.next()){
		        System.out.print("true");
	    		UserMenu login = new UserMenu();
	    		login.setResultset(user);
		   } else {
		        System.out.print("Wrong UserName and Password");
		   }
    		System.out.print((user.getString("username")));
    	}catch(SQLException e) {
    		e.getMessage();
    	}
    }
}