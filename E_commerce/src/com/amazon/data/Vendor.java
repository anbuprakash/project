package com.amazon.data;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Vendor extends Eshop
{

	public void vendorFirstPage()  throws SQLException, ClassNotFoundException, IOException 
	{

		System.out.println("\t\tVendor Page\n");
		System.out.println("1. Sign up");
		System.out.println("2. Login");
		System.out.println("3. Back to home page");
		System.out.println("Select your option");
		int option=sc.nextInt();
		switch(option)
		{
		case 1: vendorSignup();
		break;
		case 2: vendorLogin();
		break;
		case 3: mainPage();
		break;
		}
	}
	public void vendorSignup() throws SQLException, ClassNotFoundException, IOException
	{
		dbConnection();
		System.out.println("Enter your User Name: ");
		String vendorname=sc.next();
		System.out.println("Enter your Mobile Number: ");
		long vendormob=sc.nextLong();
		System.out.println("Enter Password: ");
		String pwd=sc.next();
		System.out.println("Re-Enter Password: ");
		String repwd=sc.next();
		if (pwd.equals(repwd))
		{
			try {
				stmt.executeQuery("insert into vendorlist(vendorname, vendormobnumber, vendorpassword, isapproved) values('"+vendorname+"', " +vendormob+ ",'"+pwd+"', 0)");
			}
			catch (SQLException s)
			{
				System.out.println("User name already taken \n Try with another !");
				vendorSignup();
			}
			System.out.println("Registration Successful");
			System.out.println("Welcome " +vendorname);
			vendorHome(vendorname);
		}
		else
		{
			System.out.println("Invalid Credentials");
			vendorSignup();
		}
	}			


	public void vendorLogin() throws SQLException, ClassNotFoundException, IOException
	{ 
		dbConnection();
		String vendorpwd="";
		System.out.println("Enter your User name:");
		String username= sc.next();
		System.out.println("Enter your Password name:");
		String pwd= sc.next();
		ResultSet rs=stmt.executeQuery("select vendorpassword from vendorlist where vendorname='"+username+"'");
		while(rs.next())
		{
			vendorpwd=rs.getString(1);
		}
		if(vendorpwd.equals(pwd))
		{
			System.out.println("\t\tWelcome  "+ username+"\n");
			vendorHome(username);
		}
		else{

			System.out.println("Please enter valid credentials");
			System.out.println("1. Do you want to login again");
			System.out.println("2. Exit");
			int option=sc.nextInt();
			switch(option) 
			{
			case 1:
				vendorLogin();
				break;
			case 2:
				mainPage();
				break;

			}
		}
	}




	public void vendorHome(String username) throws SQLException, ClassNotFoundException, IOException 
	{
		System.out.println("1. Add Products");
		System.out.println("2. View Products");
		System.out.println("3. Back");
		int option= sc.nextInt();
		switch(option)
		{
		case 1: addProducts(username);
		break;
		case 2: viewProducts(username);
		break;
		case 3: vendorFirstPage();
		break;
		}
	}


	public void addProducts(String soldby) throws SQLException, ClassNotFoundException, IOException
	{
		dbConnection();
		String check="";
		ResultSet rs=stmt.executeQuery("select isapproved from vendorlist where vendorname='"+soldby+"'");
		while(rs.next())  
			check=rs.getString(1);
		if(check.equals("1"))
		{
			System.out.println("Enter the number of products you want to add");
			int n=sc.nextInt();

			for(int i=1; i<=n;i++)
			{
				System.out.println("Enter the product category name:");
				String category=sc.next();
				System.out.println("Enter the product product name:");
				String productname=sc.next();
				System.out.println("Enter the product price:");
				String productprice=sc.next();
				
				stmt.executeQuery("insert into productlist(category, productname, productprice, soldby) values("+category+"','" +productname+ "','"+productprice+"', '"+soldby+"')");
			}
			System.out.println("Products added successfully !");
			vendorHome(soldby);
		}
		else {
			System.out.println("Your account is not yet approved!!!");
			vendorHome(soldby);
		}
	}

	public void viewProducts(String soldby) throws SQLException, ClassNotFoundException, IOException
	{
		dbConnection();
		ResultSet rs=stmt.executeQuery("select * from productlist where soldby='"+soldby+"'");
		while(rs.next())  
			System.out.println(rs.getString(1)+" " +rs.getString(2)+" " +rs.getString(3)+" "+rs.getString(4));
		vendorHome(soldby);

	}

}



