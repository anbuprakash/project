package com.ecommerce.pro;


import java.util.Scanner;

import com.ecommerce.pro.ConsoleColours.ConsoleColors;

public class E_commerceAdmin
{
	public static final String ANSI_RESET = "\u001B[0m";
	DbConnect d=new DbConnect();
	E_CommerceTest12 e=new E_CommerceTest12();
	Scanner scan=new Scanner(System.in);
	String mail,pass,name;
	String email="admin123@gmail.com";
	String password="admin";
	E_commerceVendorPage v=new E_commerceVendorPage();
	public void adminPage() throws Exception
	{
		admin_Mail();
		admin_pass();
		admin_do();
		approve();
	}
	public void admin_Mail() 
	{

		System.out.println(ConsoleColors.RED_BRIGHT+"Enter email id"+ANSI_RESET);
		mail=scan.next();
	}
	public void admin_pass() 
	{

		System.out.println(ConsoleColors.GREEN_ITALIC+"Enter Password");
		pass=scan.next();
	}
	public void admin_do() throws Exception
	{

//		d.db();
		 
		if (email.equals(mail) && password.equals(pass)) 
		{
			System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND+"You are successfully logged in"+ANSI_RESET);
			System.out.println(ConsoleColors.RED+"Welcome ");
		}
		else
		{

			System.out.println("Your information is not valid");
			System.out.println("Do You want to try again ? 'Y' or 'N'");
			String get=scan.next();

			if (get.equals("Y"))
			{
				adminPage();
			}
			else
			{
				System.out.println("Your information is not valid");
				System.out.println("Do You want to go ? 'main' or 'close'");
				a_main();

			}

		}

	}
	public void approve() throws Exception
	{
		System.out.println("New vendor Register ? 'approve' or 'reject'"+ANSI_RESET);
		v_approve();
		
	}
	public void v_approve() throws Exception
	{
		name=scan.next();
		if(name.equals("approve"))
		{
			System.out.println("New vendor approve sucessfull");
			System.out.println("Do You want to go ? 'main' or 'close'");
			a_main();
		}
		else
		{
			System.out.println("New vendor reject sucessfull");
			System.out.println("Do You want to go ? 'main' or 'close'");
			a_main();
		}
	}
	public void a_main() throws Exception
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

