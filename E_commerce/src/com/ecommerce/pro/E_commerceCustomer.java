package com.ecommerce.pro;

import java.util.Scanner;

import com.ecommerce.pro.ConsoleColours.ConsoleColors;

public class E_commerceCustomer 
{
	public static final String ANSI_RESET = "\u001B[0m";

	Scanner scanner=new Scanner(System.in);
	String name,userName, password,mobile,email;
	int number;
	long num;
	DbConnect d=new DbConnect();
	public void customerPage() throws Exception 
	{
		System.out.println(ConsoleColors.LIGHT_PURPLE+"\n"+"1.Login"+"\n"
				+"2.Create Account"+ANSI_RESET);
		number=scanner.nextInt();

		switch (number) 
		{
		case 1:login_mobile();
		break;
		case 2:createAcc();
		break;


		}
	}
	public void login_mobile() throws Exception
	{
		System.out.println(ConsoleColors.RED_BRIGHT+"Enter Mobile Number");
		num=scanner.nextLong();

		login_pass();
		System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND+"Login sucessfull"+ANSI_RESET);
		searchpro();
	}
	public void login_pass() 
	{
		System.out.println("Enter Password"+ANSI_RESET);
		name=scanner.next();
	}
	public void createAcc() throws Exception
	{
		System.out.println(ConsoleColors.GREEN+"Enter your name");
		userName=scanner.next();
		System.out.println("Enter mobile number");
		num=scanner.nextLong();
		System.out.println("Enter Email");
		name=scanner.next();
		System.out.println("Enter password");
		name=scanner.next();
		System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND+userName+" : Create Account Sucessfully "
				+"Do You want to try again ? 'Y' or 'N'"+ANSI_RESET);
		cre_login();
	}
	public void cre_login() throws Exception
	{
		name=scanner.next();
		if(name.equals("Y"))
		{
			login_mobile();
		}
	}
	public void searchpro() throws Exception 
	{
		System.out.println(ConsoleColors.GREEN+"SEARCH product ?");
		name=scanner.next();
		d.addProduct();
		number=scanner.nextInt();
		switch (number) 
		{
		case 1:mob();
		break;
		case 2:fashion();
		break;
		case 3:electronics();
		break;
		case 4:newRelese();
		break;
		case 5:computer() ;
		break;

		}

	}
	public void mob() throws Exception
	{
		d.getmobile();
		System.out.println("Do You want to more option ? 'BACK' or 'BUY'");
		ord();
	}
	public void ord() throws Exception
	{
		name=scanner.next();
		if(name.equals("BACK"))
		{
			searchpro();
		}
		else
		{
			buy();
		}
	}
	public void fashion() throws Exception
	{
		d.getfashion();
		System.out.println(ConsoleColors.RED_BRIGHT+" Do You want to more option ? 'BACK' or 'BUY'");
		ord();

	}
	public void newRelese() throws Exception
	{
		d.getNewReleses();
		System.out.println("Do You want to more option ? 'BACK' or 'BUY'");
		ord();
	}
	public void electronics() throws Exception
	{
		d.getElectronics();
		System.out.println(" Do You want to more option ? 'BACK' or 'BUY'");
		ord();
	}
	public void computer() throws Exception 
	{
		d.getcomputer();
		System.out.println(" Do You want to more option ? 'BACK' or 'BUY'");
		ord();
	}
	public void buy()
	{
		System.out.println("Enter your Debitcard number");
		num=scanner.nextLong();
		System.out.println("card valid throw");
		num=scanner.nextLong();
		System.out.println("Enter your cvv");
		num=scanner.nextLong();
		System.out.println("Enter your OTP");
		num=scanner.nextLong();
		System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND+"Ordered sucessfull"+ANSI_RESET);
	}
}





