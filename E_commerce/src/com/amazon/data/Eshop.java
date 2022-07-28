package com.amazon.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Eshop
{
	static Connection connect;
	static Statement stmt;
	static Scanner sc=new Scanner(System.in);

	public void dbConnection() throws SQLException, ClassNotFoundException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		connect= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prakash","manbarasu");
		stmt=connect.createStatement();

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException
	{
		Eshop e = new Eshop();
		e.mainPage();
	}
	
	
	void mainPage() throws IOException, ClassNotFoundException, SQLException
	{
		Customer cr=new Customer();
		Vendor vr=new Vendor();
		AdminPage ap= new AdminPage();
		int select;
		System.out.println("\t\tWelcome to Eshop\n");
		System.out.println("1. Customer\t2. Vendor\t3. Admin\n");
		System.out.println("Proceed with a option");

		select= sc.nextInt();

		switch(select)
		{
		case 1:	
			cr.customerFirstPage();
			break;
		case 2:
			vr.vendorFirstPage();
			break;
		case 3:
			ap.adminFirstPage();
			break;
		default:
			System.out.println("Please make proper selection");
			mainPage();
		}
	}

	


}

