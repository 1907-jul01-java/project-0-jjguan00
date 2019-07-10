package com.revature;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Bank, Please choose from the following menu.");
        System.out.println("1.Sign up, 2.Log in,3.Apply for a checking account");
        List<String> commands = new ArrayList<String> ();
        commands.add("Sign up");
        commands.add("Log in");
        commands.add("Apply for a checking account");
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		if(commands.contains(command)) {
			if(command == "1") {
				Apply start = new Apply();
		        start.apply();
			}
			}
		else {
			System.out.println("Please enter a proper command");
		}
		}

}
