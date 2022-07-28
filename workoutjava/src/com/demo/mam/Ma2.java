package com.demo.mam;

import java.util.Scanner;

public class Ma2 
{

	public static void main(String[] args) 
	{
		s e=new s();
		e.map();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter value");
		String s1=s.nextLine();
		s.close();

		for(char c='a'; c<='z'; c++)
		{ 
			if(s1.toLowerCase().indexOf(c)==-1) 
			{
				System.out.print(c);
			}
			
		}
		
	}

}
class s{
	public void map()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter value");
		String s1=s.nextLine();
		for(char c='A'; c<='Z'; c++)
		{ 
			if(s1.toUpperCase().indexOf(c)==-1) 
			{
				System.out.print(c);
			}
			
		}
	}
}
