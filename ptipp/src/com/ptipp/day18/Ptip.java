package com.ptipp.day18;
//Author PRAKASH M

import java.util.Scanner;

public class Ptip 
{
	public int factorial(int n){    
		  if (n == 0)    
		    return 1;    
		  else    
		    return(n * factorial(n-1));    
		 }    
		 public static void main(String args[]){  
			 Ptip p=new Ptip();
		  int fact=1;  
		  Scanner scan=new Scanner(System.in);
		  System.out.println("Enter number");
		  int number=scan.nextInt();//It is the number to calculate factorial    
		  fact =p. factorial(number);   
		  System.out.println("Factorial of "+number+"! is: "+fact);  
		  scan.close();
		 }  

	

}
