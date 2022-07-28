package demo;

import java.util.Scanner;

public class FactorialExample {

	private static Scanner sc;

	public static void main(String[] args) {
		  int i,fact=1;  
		  sc = new Scanner(System.in);
		  System.out.println("Enter the number is : ");
		  int number=sc.nextInt();    
		  for(i=1;i<=number;i++){    
		      fact=fact*i;    
		  }    
		  System.out.println("Factorial of "+number+" is: "+fact);    

	}

}
