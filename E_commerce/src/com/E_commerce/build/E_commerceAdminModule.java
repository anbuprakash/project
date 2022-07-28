package com.E_commerce.build;


import java.sql.ResultSet;

import java.util.Scanner;
import com.ecommerce.pro.ConsoleColours.ConsoleColors;
import com.ecommerce.pro.DbConnect;

public class E_commerceAdminModule extends DbBuild  {
	public static final String ANSI_RESET = "\u001B[0m";
	DbConnect d=new DbConnect();
	E_commerceTest e=new E_commerceTest();
	Scanner scan=new Scanner(System.in);
	String mail,pass,name;
	String adminname;
	String adminpwd="admin";
	
	E_commerceVendorModule v=new E_commerceVendorModule();
	public void adminPage() throws Exception
	{
		admin_Mail();
		admin_pass();
		admin_do();
		approve();
	}
	
	public void admin_Mail() 
	{

		System.out.println(ConsoleColors.RED_BRIGHT+"\n"+"\tEnter email id"+ANSI_RESET);
		mail=scan.next();
	}
	public void admin_pass() 
	{

		System.out.println(ConsoleColors.GREEN_ITALIC+"\n"+"\tEnter Password");
		pass=scan.next();
	}
	public void admin_do() throws Exception
	{

		dbConnection();
		ResultSet rs=stmt.executeQuery("select name from admin");
		while(rs.next())
		{
		adminname=rs.getString(1);		}
		
		if (adminname.equals(mail) && pass.equals(adminpwd)) 
		{
			System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND+"\n"+"\t\tYou are successfully logged in"+ANSI_RESET);
			System.out.println(ConsoleColors.BLACK_BRIGHT+"\n"+"\tWelcome ");
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
				System.out.println("\n"+"\tDo You want to go ? 'main' or 'close'");
				a_main();

			}

		}

	}
	public void approve() throws Exception
	{
		System.out.println("\n"+"\t1.Approve vendor"+"\n"+"\t2.manage vendor");
		System.out.println("\tNew vendor Register ? 'approve' or 'reject'"+ANSI_RESET);
		v_approve();
		
	}
	public void v_approve() throws Exception
	{
		name=scan.next();
		if(name.equals("approve"))
		{
			System.out.println("\n"+"\tNew vendor approve sucessfull");
			System.out.println("\tDo You want to go ? 'main' or 'close'");
			a_main();
		}
		else
		{
			System.out.println("\n"+"\tNew vendor reject sucessfull");
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


