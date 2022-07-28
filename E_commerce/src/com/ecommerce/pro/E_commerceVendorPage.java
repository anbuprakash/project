package com.ecommerce.pro;

import java.util.Scanner;

import com.ecommerce.pro.ConsoleColours.ConsoleColors;

public class E_commerceVendorPage 
{
	public static final String ANSI_RESET = "\u001B[0m";
	Scanner scan=new Scanner(System.in);
	String name,email,company,v_name;
	long number;
	DbConnect d=new DbConnect();
	E_CommerceTest12 e=new E_CommerceTest12();
	public void vendorPage() throws Exception 
	{
		System.out.println(ConsoleColors.RED+"1.Vendor Registration"+
				"\n"+"2.Vendor Login "+ANSI_RESET);
		int number=scan.nextInt();
		switch (number) 
		{
		case 1:vendor_Registration();
		break;
		case 2:vendor_login() ;
		break;

		}
	}

	public void vendor_Registration() throws Exception 
	{

		System.out.println(ConsoleColors.ROSY_PINK+"Enter Vendor Name");
		v_name=scan.next();
		System.out.println("Enter Email id");
		email=scan.next();
		System.out.println("Enter Company Name");
		company=scan.next();
		System.out.println("Enter Mobile Number");
		number=scan.nextLong();
		System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND+v_name+" : Register vendor Sucessfully "
				+"Do You want to login ? 'Y' or 'N'"+ANSI_RESET);
		vendorRe_log();

	}
	public void vendorRe_log() throws Exception
	{
		name=scan.next();
		if(name.equals("Y"))
		{
			vendor_login(); 
		}
	}


	public void vendor_login() throws Exception 
	{
		System.out.println(ConsoleColors.RED_BRIGHT+"Enter EMail id");
		name=scan.next();
		System.out.println("Enter Password");
		name=scan.next();
		System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND+"Login Sucessfull"+ANSI_RESET);
		System.out.println("Do u want to add categories"
				+" 'Y' or 'N'");
		
		v_addproducts(); 
	}
	
	public void v_addproducts() throws Exception
	{
		name=scan.next();
		if(name.equals("Y")) 
		{
		System.out.println("Add products"+ANSI_RESET);
		d.addProduct();
		System.out.println("Do You want to go ? 'main' or 'close'");
		v_main();
		}
		else
		{
			System.out.println("Cancelling the process");
			System.out.println("Do You want to go ? 'main' or 'close'");
			v_main();
		}

	}
	public void v_main() throws Exception
	{
		name=scan.next();
		if(name.equals("main"))
		{
			e.mainMenu();
		}
		else
		{
			System.exit(0);
		}
	}
	


}
