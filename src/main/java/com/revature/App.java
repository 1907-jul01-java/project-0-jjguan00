package com.revature;
import java.util.ArrayList;
import java.util.List;
import com.revature.util.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
    	ConnectionUtil connectionUtil = new ConnectionUtil();
        System.out.println("Welcome to Bank, Please choose from the following menu.");
        System.out.println("1.Sign up, 2.Apply for a checking account");
        ArrayList<Integer> commands = new ArrayList<Integer>();
        commands.add(1);
        commands.add(2);
		Scanner sc = new Scanner(System.in);
		int command = sc.nextInt();
		if(commands.contains(command)) {
			if(command == 1) {
				SignUp start = new SignUp();
		        start.sign();
			}
			if(command == 2) {
				Apply start = new Apply();
		        start.apply();
			}
			}
		else {
			System.out.println("Please enter a proper command");
		}
		}

}
