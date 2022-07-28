package com.E_commerce.build;

import java.util.Scanner;
import com.ecommerce.pro.ConsoleColours.ConsoleColors;

public class E_commerceVendorModule extends DbBuild 
{
	public static final String ANSI_RESET = "\u001B[0m";
	Scanner scan=new Scanner(System.in);
	String v_name,v_email,v_company,v_mob,name;
	long v_number,number;int num;
	DbBuild d=new DbBuild();
	E_commerceTest e=new E_commerceTest();
	public void vendorPage() throws Exception 
	{
		System.out.println(ConsoleColors.RED_BRIGHT+"\n"+"\t1.Vendor Registration\t\t2.Vendor Login "+ANSI_RESET);
		num=scan.nextInt();
		switch (num) 
		{
		case 1:vendor_Registration();
		break;
		case 2:vendor_login() ;
		break;

		}
	}

	public void vendor_Registration() throws Exception 
	{
		d.dbConnection();
		System.out.println(ConsoleColors.ROSY_PINK+"\n"+"\tEnter Vendor Name");
		v_name=scan.next();
		System.out.println("\n"+"\tEnter Email id");
		v_email=scan.next();
		System.out.println("\n"+"\tEnter Company Name");
		v_company=scan.next();
		System.out.println("\n"+"\tEnter Mobile Number");
		v_number=scan.nextLong();
		stmt.executeQuery("insert into vendor(vname, vmail, vcom, vmob) values('"+v_name+"','" +v_email+ "','"+v_company+"',"+v_number+")");
		
		System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND+v_name+" :\t Register vendor Sucessfully "
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
		System.out.println(ConsoleColors.RED_BRIGHT+"\n"+"\tEnter EMail id");
		name=scan.next();
		System.out.println("\n"+"\tEnter Password");
		name=scan.next();
		System.out.println(ConsoleColors.LIGHT_GREEN_BACKGROUND+"\n"+"\t\tLogin Sucessfull"+ANSI_RESET);
		System.out.println("choose option");
		add();

	}
	public void add() throws Exception {
		System.out.println("\t\t1.Add product\t 2.viewProduct");
		add_p();
	}
	public void add_p() throws Exception 
	{
		num=scan.nextInt();
		switch (num) {
		case 1:pro();
		break;
		case 2:viewProducts();
		break;
		}
	}
	public void pro() throws Exception
	{

		d.dbConnection();
		if(num == 1)
		{
			System.out.println("\n"+"\tEnter the number of products you want to add");
			int n=sc.nextInt();

			for(int i=1; i<=n;i++)
			{
				System.out.println("\n"+"\tEnter the product category name:");
				v_name=sc.next();
				System.out.println("\n"+"\tEnter the product product name:");
			String v_name1=sc.next();
				System.out.println("\n"+"\tEnter the product price:");
				v_number=scan.nextLong();
				stmt.executeQuery("insert into test(c_name,p_name,price) values('"+v_name+"','" +v_name1+ "',"+v_number+")");

			}
			System.out.println("\n"+"\t\tProducts added successfully ! you want to see viewproduct 'Y' or 'N'");
			//			System.out.println("Do You want to go ? 'main' or 'close'");
			//			getcat();
			//			System.out.println("Do You want to go ? 'main' or 'close'");
			v_addproducts();
		}
		else {
			System.out.println("Your account is not yet approved!!!");
			System.out.println("Do You want to go ? 'main' or 'close'");
			v_addproducts();
		}
	}
	public void view() throws Exception
	{
		name=scan.next();
		if(name.contains("Y"))
		{
			viewProducts();
			System.out.println("Do You want to go ? 'main' or 'close'");
		}
		else
		{
			System.out.println("Your account is not yet approved!!!");
			System.out.println("Do You want to go ? 'main' or 'close'");
			v_main();
		}
	}


	public void viewProducts() throws Exception
	{
		d.addProduct();

	}
	public void v_addproducts() throws Exception
	{
		name=scan.next();
		if(name.equals("Y")) 
		{
			System.out.println("Add products"+ANSI_RESET);
			d.getcat();
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
