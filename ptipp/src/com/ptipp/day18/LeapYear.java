package com.ptipp.day18;

import java.util.Scanner;

public class LeapYear 
{

	public void leap()
	{
		int year;
		System.out.println("Enter an Year :: ");
		Scanner sc = new Scanner(System.in);
		year = sc.nextInt();

		if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0))
			System.out.println(" year is a leap year");
		else
			System.out.println(" year is not a leap year");
		sc.close();
	}

	public static void main(String[] args) 
	{
		LeapYear l=new LeapYear();
		l.leap();

	}


}

