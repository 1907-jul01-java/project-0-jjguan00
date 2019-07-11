package com.revature.entities;

import com.revature.model.*;
import java.sql.*;
import java.util.Scanner;

public class Apply {
	Connection connection;
    public void create(CheckAccount account) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into CheckAccount(firstname, lastname,license) values(?, ?,?)");
            pStatement.setString(1, account.getFirstname());
            pStatement.setString(2, account.getLastname());
            pStatement.setString(3, account.getLicense());
            pStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }
	@SuppressWarnings("resource")
	public void apply() {
		Scanner sc = new Scanner(System.in);
	    System.out.println("Hi, welcome to apply menu");
	    System.out.println("Please enter your first name");
	    String firstname = sc.nextLine();
	    System.out.println("Please enter your last name");
	    String lastname = sc.nextLine();
	    System.out.println("Please enter your license");
	    String license = sc.nextLine();
	    System.out.println("Please make enter first deposit amount");
	    int deposit = sc.nextInt();
	    CheckAccount c = new CheckAccount(firstname,lastname, license, deposit);
	    System.out.println(c.getDeposit());
	}
	
}
