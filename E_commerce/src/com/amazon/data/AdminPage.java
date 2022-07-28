package com.amazon.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminPage extends Eshop
{
	public void adminFirstPage() throws SQLException, ClassNotFoundException, IOException
	{
		Eshop e= new Eshop();
		e.dbConnection();
		System.out.println("\t\tAdmin Page\n");
		System.out.println("1. Login\t2. Back to homepage\n\nSelect one option\n");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			adminlogin();
			break;
		case 2:
			e.mainPage();
			break;
		}
	}


	public void adminlogin() throws SQLException, ClassNotFoundException, IOException 
	{
		Eshop e= new Eshop();
		e.dbConnection();
		String adminpwd= "";
		System.out.println("\t\tEshop Admin Page\n");
		System.out.println("Enter admin name:");
		String adminname= sc.next();
		System.out.println("Enter password:");
		String adminpwdentered= sc.next();
		ResultSet rs=stmt.executeQuery("select adminpassword from admin where adminname='"+adminname+"'");
		while(rs.next())
		{
			adminpwd=rs.getString(1);
		}
		if(adminpwdentered.equals(adminpwd))
		{
			System.out.println("\t\tWelcome Admin\n");
			adminHome();
		}
		else
		{
			System.out.println("Please enter valid credentials");
			System.out.println("1. Do you want to login again");
			System.out.println("2. Exit");
			int i=sc.nextInt();
			switch(i) {
			case 1:
				adminlogin();
				break;
			case 2:
				e.mainPage();
				break;

			}
		}
	}

	public void adminHome() throws SQLException, ClassNotFoundException, IOException
	{
		System.out.println("1. Approved Vendor List");
		System.out.println("2. Waiting for Approval");
		System.out.println("3. Logout");
		System.out.println("Select the option:");
		int option= sc.nextInt();
		switch(option)
		{
		case 1: approvedVendor();
				break;
		case 2: waitingForApproval();
			    break;
		case 3: adminFirstPage();
				break;
		default: System.out.println("Select the given option");
		}
	}

	public void approvedVendor() throws SQLException, ClassNotFoundException, IOException {
		Eshop e= new Eshop();
		e.dbConnection();
		ResultSet rs= stmt.executeQuery("select * from vendorlist where isapproved=1");
		System.out.println("size of table "+rs.getRow());
		while(rs.next()) 

		System.out.println(rs.getString(1)+" " +rs.getString(2)+" " +rs.getString(3)+" "+rs.getString(4));
		adminHome();

	}
	public void waitingForApproval() throws SQLException, ClassNotFoundException, IOException 
	{
		Eshop e= new Eshop();
		e.dbConnection();
		ResultSet rs=stmt.executeQuery("select * from vendorlist where isapproved=0");
		while(rs.next())  
			System.out.println(rs.getString(1)+" " +rs.getString(2)+" " +rs.getString(3)+" "+rs.getString(4));

		System.out.println("Do you want to approve everyone? (y/n)");
		String choice=sc.next();

		if(choice.equalsIgnoreCase("y"))
		{
			stmt.executeQuery("update vendorlist set isapproved=1 where isapproved=0");
			System.out.println("Approved successfully !!!");
			approvedVendor();
		}
		else 
		{
			adminHome();
		}
	}
}



