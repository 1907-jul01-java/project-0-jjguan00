package com.revature;

import java.util.Scanner;

public class Apply {
	
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
