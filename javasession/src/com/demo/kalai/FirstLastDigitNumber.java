package com.demo.kalai;

import java.util.Scanner;

public class FirstLastDigitNumber {

	private static Scanner sc;

	public static void main(String[] args) {
//		   int number = 502356997;
		
		sc = new Scanner(System.in);
	        int firstDigit = 0;
	        int lastDigit = 0;
	        System.out.println("Enter the number  :");
	        int number= sc.nextInt();
	 
	        lastDigit = number%10;
	        System.out.println("Last digit : "+lastDigit);
	 
	        while(number!=0) {
	            firstDigit = number%10;
	            number /= 10;
	        }
	        System.out.println("First digit : "+firstDigit);
	    }

	}
