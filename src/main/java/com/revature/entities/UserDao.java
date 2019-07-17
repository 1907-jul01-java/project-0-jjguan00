package com.revature.entities;

import java.util.Scanner;
import java.sql.*;
import com.revature.UserMenu;
import com.revature.model.User;

public class UserDao {
	Connection connection;
	User user;
	public UserDao(Connection connection) {
		this.connection = connection;
	}

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
		try {
			PreparedStatement pStatement = connection
					.prepareStatement("insert into users(username, password, firstname) values(?,?,?)");
			pStatement.setString(1, name);
			pStatement.setString(2, pw);
			pStatement.setString(3, firstname);
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
    		ResultSet rs = pStatement.executeQuery();
		   if( rs.next()){
			   String uname = rs.getString("username");
			   String fname = rs.getString("firstname");
			   int id = rs.getInt("id");
			   User user = new User(uname,fname,id);
	    		UserMenu login = new UserMenu();
	    		login.setResultset(user);
		   } else {
		        System.out.print("Wrong UserName and Password");
		   }
    	}catch(SQLException e) {
    		e.getMessage();
    	}
    }
	public int getUseridByUsername(String username) {
    	try {
    		PreparedStatement pStatement = connection.prepareStatement("select * from users where username = ?");
    		pStatement.setString(1,username);
    		ResultSet rs = pStatement.executeQuery();
		   if( rs.next()){
			   int tuserid = rs.getInt("id");
			   return tuserid;
		   } else {
		        System.out.print("Wrong UserName and Password");
		   }
    	}catch(SQLException e) {
    		e.getMessage();
    	}
    	return 0;
	}
}