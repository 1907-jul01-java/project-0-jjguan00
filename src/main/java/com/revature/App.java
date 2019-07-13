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
        ArrayList<Integer> commands = new ArrayList<Integer>();
        commands.add(1);
        commands.add(2);
        commands.add(999);
		Scanner sc = new Scanner(System.in);
		int command = sc.nextInt();
		if(commands.contains(command)) {
			if(command == 1) {
				ConnectionUtil cu = new ConnectionUtil();
				UserDao start = new UserDao(cu.getConnection());
		        start.insert();
		        cu.close();
			}
			if(command == 2) {
				ConnectionUtil cu = new ConnectionUtil();
				UserDao start = new UserDao(cu.getConnection());
				start.getOne();
				cu.close();
			}
			if(command == 999) {
				System.out.println("Welcome to admin mode, please log in.");
			}
			}
		else {
			System.out.println("Please enter a proper command");
		}
		}

}
