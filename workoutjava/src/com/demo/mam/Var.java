package com.demo.mam;

import java.util.Scanner;

public class Var
{

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
	int a,arm=0;
	System.out.println("enter the no");
	int n=s.nextInt();
	int temp=n;
	while(n!=0)
	{
		a=n%10;
		arm=arm+(a*a*a);
		n=n/10;
	}
	if(temp==arm) {
		System.out.println("is arm");
	}else {
		System.out.println("is not arm");
	}
	}
}
