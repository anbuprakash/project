package com.demo.mam;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

//author prakash
public class Chumma 
{

	public static void main(String[] args) 
	{
		c s=new c();
		//s.a();
		s.evende();
	}
}
class c{
	Scanner scan=new Scanner(System.in);
	public void a() {
		System.out.println("enter sentence");
		String my_str=scan.nextLine();
		//      String my_str = "hi do what do hi";
		my_str = Arrays.stream(my_str.split("\\s+")).distinct().collect(Collectors.joining(" "));
		System.out.println(my_str);
		System.out.println(my_str.replaceAll(" ",""));


	}
	public void evende()
	{
		
		
		
			int number, i, evenSum = 0, oddSum = 0;
			
			
			System.out.print(" Please Enter any Number : ");
			number = scan.nextInt();	
			
			for(i = 1; i <= number; i++)
			{
				if(i % 2 == 0)
				{
				//	evenSum = evenSum + i; 
					int v=i;
					
					System.out.println(i);
				}
//				else
//				{
//			//		oddSum = oddSum + i;
//					System.out.println(i);
//				}
			}
//			System.out.println("\n The Sum of Even Numbers upto " + number + "  =  " + evenSum);
//			System.out.println("\n The Sum of Odd Numbers upto " + number + "  =  " + oddSum);
//		
	}
}