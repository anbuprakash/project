package com.E_commerce.build;
import java.util.Scanner;

import com.ecommerce.pro.ConsoleColours.ConsoleColors;

public class E_commerceTest {
	public static final String ANSI_RESET = "\u001B[0m";
	static Scanner sc=new Scanner(System.in);


	public static void mainMenu() throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(ConsoleColors.BLACK_BACKGROUND_BRIGHT+"\n"+"\t\tWELCOME OUR E_BAY ZONE PROJECT"+ANSI_RESET);
		System.out.println(ConsoleColors.ROSY_PINK+"\n"+"\t1.Admin\t\t2.Vendor\t3.Customer"+ANSI_RESET);
		int s=sc.nextInt();
		E_commerceAdminModule  admin=new E_commerceAdminModule ();
		E_commerceVendorModule vendor=new E_commerceVendorModule();
		E_commerceCustomerModule  page=new E_commerceCustomerModule ();
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


	public static void main(String[] args) throws Exception {
		mainMenu();

	}

}
