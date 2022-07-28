package com.ecommerce.pro;

import java.util.Scanner;
import com.ecommerce.pro.ConsoleColours.ConsoleColors;



public class E_CommerceTest12 
{
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static void mainMenu() throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+"\n"+"WELCOME OUR E_COMMERCE PROJECT"+ANSI_RESET);
		System.out.println(ConsoleColors.ROSY_PINK+"\n"+"1.Admin"+"\n"
				+"2.Vendor"+"\n"
				+"3.Customer"+ANSI_RESET);
		int s=sc.nextInt();
		E_commerceAdmin  admin=new E_commerceAdmin ();
		E_commerceVendorPage vendor=new E_commerceVendorPage();
		E_commerceCustomer  page=new E_commerceCustomer ();
		switch (s) 
		{
		case 1:admin.adminPage();
		break;
		case 2:vendor.vendorPage();
		break;
		case 3:page.customerPage();
		break;
		}
		sc.close();



	}

	public static void main(String[] args) throws Exception 
	{
		mainMenu();

	}


}
