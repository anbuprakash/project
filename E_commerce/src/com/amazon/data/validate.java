package com.amazon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class validate {

	public static void main(String[] args) throws IOException {
		 
		String userName, password;
		String firstUser, firstUserPassword;
		String userChoice;
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		System.out.println("Please Register with your details");
 
		System.out.println("Enter your username");
		userName = br.readLine();
 
		System.out.println("Enter your password");
		password = br.readLine();
 
		System.out.println("Thanks for registration. do you want to login 'Y' or 'N' ?");
		userChoice = br.readLine().toUpperCase();
 
		if (userChoice.equals("Y")) {
 
			System.out.println("Enter username");
			firstUser = br.readLine();
 
			System.out.println("Enter password");
			firstUserPassword = br.readLine();
 
			if (firstUser.equals(userName) && firstUserPassword.equals(password)) {
				System.out.println("You are successfully logged in");
				System.out.println("Welcome ");
			} else {
 
				System.out.println("Your information is not valid");
				System.out.println("Do You want to try again ? 'Y' or 'N'");
 
				userChoice = br.readLine().toUpperCase();
 
				if (userChoice.equals("Y")) {
					System.out.println("Enter username");
					firstUser = br.readLine();
 
					System.out.println("Enter password");
					firstUserPassword = br.readLine();
 
					if (firstUser.equals(userName) && firstUserPassword.equals(password)) {
						System.out.println("You are successfully logged in");
						System.out.println("Welcome ");
					}else {
						System.out.println("Your information is not valid");
					}
 
				}
 
			}
 
		}
 
	}
 
}
