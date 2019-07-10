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
        System.out.println("Sign up, Log in");
        List<String> commands = new ArrayList<String> ();
        commands.add("Sign Up");
        commands.add("Log In");
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		if(commands.contains(command)) {
			System.out.print(command);
			}
		else {
			System.out.println("Please enter a proper command");
		}
		}
}
