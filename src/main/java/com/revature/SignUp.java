package com.revature;

import java.util.Scanner;

public class SignUp 
{ 
 	
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
    public void sign() {
	    @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	    System.out.println("Hi, welcome to the sign up menu");
	    System.out.println("Please enter a new username");
	    String name = sc.nextLine();
	    String pw = sc.nextLine();
	    Customer c = new Customer(name,pw);
	    System.out.println(c.getUsername());
    }
} 

