package com.demo.kalai;

import java.util.Scanner;

public class count {

	private static Scanner obj;

	public static void main(String[] args) {
		  obj = new Scanner(System.in);
	      int count = 0;
	      System.out.println("Enter a number :");
	      int num = obj.nextInt();
	      while(num!=0){
	         num = num/10;
	         count++;
	      }
	      System.out.println("Number of digits in the entered : "+count);
	   }

	}


