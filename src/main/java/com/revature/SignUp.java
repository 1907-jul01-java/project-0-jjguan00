package com.revature;

import java.util.Scanner;

public class SignUp 
{ 
 	String username;
 	String password;
 	
    public static void main(String[] args) {
    // Declare the object and initialize with 
    // predefined standard input object 
	    @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	    String name = sc.nextLine();
	    String pw = sc.nextLine();
	    Customer c = new Customer(name,pw);
	    System.out.println(c.getUsername());
    }
} 

