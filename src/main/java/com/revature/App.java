package com.revature;
import com.revature.entities.*;
import java.util.ArrayList;
import com.revature.util.*;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Bank, Please choose from the following menu.");
        System.out.println("1.Sign up, 2.Log in");
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("1");
        commands.add("2");
        commands.add("999");
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		if(commands.contains(command)) {
			if(command.contentEquals("1")) {
				ConnectionUtil cu = new ConnectionUtil();
				UserDao start = new UserDao(cu.getConnection());
		        start.insert();
		        cu.close();
			}
			if(command.contentEquals("2")) {
				ConnectionUtil cu = new ConnectionUtil();
				UserDao start = new UserDao(cu.getConnection());
				start.getOne();
				cu.close();
			}
			if(command.contentEquals("999")) {
				System.out.println("Welcome to admin mode, please log in.");
				ConnectionUtil cu = new ConnectionUtil();
				AdminDao start = new AdminDao(cu.getConnection());
				start.login();
				cu.close();
			}
			}
		else {
			System.out.println("Please enter a proper command");
			App restart = new App();
		    String[] arguments = new String[] {};
			restart.main(arguments);
		}
		}

}
