package com.E_commerce.build;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import com.ecommerce.pro.DbConnect;
import com.ecommerce.pro.ConsoleColours.ConsoleColors;

public class E_commerceCustomerModule  extends DbBuild 
{
	public static final String ANSI_RESET = "\u001B[0m";

	Scanner scanner=new Scanner(System.in);
	String name,userName, password,mobile,email;
	int number;
	long num;
	DbBuild d=new DbBuild();
	public void customerPage() throws Exception 
	{
		System.out.println(ConsoleColors.LIGHT_PURPLE+"\n"+"\t1.Login\t\t2.Create Account"+ANSI_RESET);
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
		System.out.println(ConsoleColors.RED_BRIGHT+"\n"+"\tEnter Mobile Number");
		num=scanner.nextLong();

		login_pass();
		System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND+"\t\tLogin sucessfull"+ANSI_RESET);
		searchpro();
	//	userHomePage(userName);
	}
	public void login_pass() 
	{
		System.out.println("\n"+"\tEnter Password"+ANSI_RESET);
		name=scanner.next();
	}
	public void createAcc() throws Exception
	{
		d.dbConnection();
		System.out.println(ConsoleColors.GREEN+"\n"+"\tEnter your name");
		userName=scanner.next();
		System.out.println("\n"+"\tEnter mobile number");
		num=scanner.nextLong();
		System.out.println("\n"+"\tEnter Email");
		name=scanner.next();
		System.out.println("\n"+"\tEnter password");
	 String	namee=scanner.next();
		System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND+userName+" :\t\t Create Account Sucessfully "
				+"Do You want to try Login ? 'Y' or 'N'"+ANSI_RESET);
		stmt.executeQuery("insert into customer(userName, num, name, namee) values('"+userName+"'," +num+",'"+name+"','"+namee+"')");
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
		System.out.println(ConsoleColors.GREEN+"\n"+"\tSEARCH product ?");
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
		System.out.println(ConsoleColors.RED_BRIGHT+"\n"+"\t Do You want to more option ? 'BACK' or 'BUY'");
		ord();

	}
	public void newRelese() throws Exception
	{
		d.getNewReleses();
		System.out.println("select the product");
		select();
//		System.out.println("\n"+"\tDo You want to more option ? 'BACK' or 'BUY'");
//		ord();
	}
	public void electronics() throws Exception
	{
		d.getElectronics();
		System.out.println("\n"+"\t Do You want to more option ? 'BACK' or 'BUY'");
		ord();
	}
	public void computer() throws Exception 
	{
		d.getcomputer();
		System.out.println("\n"+"\tDo You want to more option ? 'BACK' or 'BUY'");
		ord();
	}
	public void buy() throws Exception
	{
		System.out.println("\n"+"\tEnter your Debitcard number");
		num=scanner.nextLong();
		System.out.println("\n"+"\tcard valid throw");
		num=scanner.nextLong();
		System.out.println("\n"+"\tEnter your cvv");
		num=scanner.nextLong();
		System.out.println("\n"+"\tEnter your OTP");
		num=scanner.nextLong();
		System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND+"\t\tOrdered sucessfull"+ANSI_RESET);
		System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND+"\t\tThank you for shopping!"+ANSI_RESET);
		System.out.println("\n"+"\t Do You want to choose ? 'MAIN' or 'LOGOUT'");
		logOut();
	}
	public void logOut() throws Exception
	{
		name=scanner.next();
		if(name.equals("LOGOUT"))
		{
			System.exit(0);
		}
		else
		{
			E_commerceTest e=new E_commerceTest();
			e.mainMenu();
		}
				
	}
	public void select() throws Exception
	{
		number=scanner.nextInt();
		if(number==1)
		{
			System.out.println("select product are :\tnokia5310");
			System.out.println("\n"+"\tDo You want to more option ? 'BACK' or 'BUY'");
			ord();
		}
	}
	
}








