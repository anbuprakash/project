package com.amazon.data;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Customer extends Eshop
{


	public void customerFirstPage() throws SQLException, ClassNotFoundException, IOException
	{
		dbConnection();
		System.out.println("\t\tUser Page\n");
		System.out.println("1. Sign up\t2.login");
		
		System.out.println("Select your option");
		int option=sc.nextInt();
		switch(option)
		{
		case 1:userSignup();
		break;
		case 2: userLogin();
		break;
		case 3: mainPage();
		break;

		}
	}

	public void userSignup() throws SQLException, ClassNotFoundException, IOException
	{
		System.out.println("Enter your name: ");
		String username=sc.next();
		System.out.println("Enter your mobile number: ");
		long usermob=sc.nextLong();
		System.out.println("Enter Password: ");
		String pwd=sc.next();
		System.out.println("Re-Enter Password: ");
		String repwd=sc.next();
		if (pwd.equals(repwd))
		{
			dbConnection();
			try {
				stmt.executeQuery("insert into userlist(username, usermobnumber, userpassword) values ('"+username+"', "+usermob+", '"+pwd+"')");
				System.out.println("Registration Successful");
				userHomePage(username);
			}
			catch (SQLException e) {
				System.out.println("User Already exist!!!");
				userSignup();
			}


		}
		else
		{
			System.out.println("Enter Valid credentials");
			userSignup();
		}
		sc.close();
	}

	public void userLogin() throws SQLException, ClassNotFoundException, IOException
	{
		Scanner sc = new Scanner(System.in);
		String check="", username="";
		System.out.println(" Enter your mobile number:");
		long mobile= sc.nextLong();
		System.out.println(" Enter your password:");
		String pwd= sc.next();
		dbConnection();

		ResultSet rs=stmt.executeQuery("select username,userpassword  from userlist where usermobnumber="+mobile+"");
		while(rs.next())
		{
			check=rs.getString(2);
			username=rs.getString(1);
		}
		if(pwd.equalsIgnoreCase(check))
		{

			System.out.println("Login successful");
			userHomePage(username);
		}
		else {
			System.out.println("Invalid credentials");
			userLogin();
		}
	}

	public void userHomePage(String username) throws SQLException, ClassNotFoundException, IOException
	{
		dbConnection();
		System.out.println("Welcome "+username);
		System.out.println("1. View products\n2. Logout");
		int option=sc.nextInt();
		if(option==1)
		{
			ResultSet rs=stmt.executeQuery("select * from productlist");

			while(rs.next())
			{
				System.out.println("\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
			System.out.println("Enter the product ID you want to buy:");
			int pid=sc.nextInt();
			System.out.println("No of items you want to buy:");
			int noOfItem=sc.nextInt();
			order(pid, noOfItem, username);
			System.out.println("Do you want to continue shopping? (y/n)");
			String proceed=sc.next();

			if(proceed.equalsIgnoreCase("y"))
			{

				userHomePage(username);
			}
			else{
				addToCart(username);
			}
		}
		else {
			customerFirstPage();
		}

	}


	public void order(int pid, int noOfItem, String username) throws SQLException, ClassNotFoundException
	{
		dbConnection();
		String productName;
		String productPrice;
		ResultSet rs=stmt.executeQuery("select productname,productprice from productlist where pid="+pid+"");
		while(rs.next())
		{
			productName=rs.getString(1);
			productPrice=rs.getString(2);
			int totalPrice=Integer.parseInt(productPrice)*noOfItem;

			stmt.executeQuery("insert into orders(pid, productname, productprice, no_item, totalprice, username) values ("+pid+",'"+productName+"', '"+productPrice+"', "+noOfItem+", "+totalPrice+", '"+username+"')");
			System.out.println("product added to cart successfully!!!");
		}
	}




	public void addToCart(String username) throws SQLException, ClassNotFoundException, IOException
	{
		dbConnection();
		System.out.println("Enter your address:");
		String address=sc.next();
		System.out.println("\t\tOrder Summary\n");
		System.out.println("Ordered by: "+username);
		System.out.println("Product ID\tProduct Name\tProduct price\tNo of items\tTotal price\tUsername");
		ResultSet rs=stmt.executeQuery("select * from orders where username='"+username+"'");
		while(rs.next()) 

			System.out.println(rs.getString(1)+"\t\t\t" +rs.getString(2)+"\t" +rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));

		System.out.println("Delivery address: "+address);
		payment();
	}
	public void payment() throws SQLException, ClassNotFoundException, IOException {

		System.out.println("Enter the payment method:");
		System.out.println("1. Card\n2. COD");
		int option=sc.nextInt();
		switch(option)
		{
		case 1:
			//card();
			break;
		case 2:
		//	cod();
			break;
		default:
			System.out.println("select the valid payment method");
		}
	}

	public void card() throws SQLException, ClassNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Card number");
		String cardnum=sc.next();
		System.out.println("Enter the CVV");
		String cvv=sc.next();
		System.out.println("Enter the validthru");
		String validthru=sc.next();

		Random rand=new Random();
		String i=String.format("%04d", rand.nextInt(9999));
		System.out.println("Your OTP: "+i);
		System.out.println("Enter the OTP");
		int otp=sc.nextInt();
		if(Integer.parseInt(i)==otp)
		{
			System.out.println("Payment Successful!");
			System.out.println("Order placed Successfully!");
			System.out.println("Thank you for shopping!");
			userHomePage(null);
		}
		else
		{
			System.out.println("Payment Failed!");
			card();
		}
	}

	public void cod() throws SQLException, ClassNotFoundException, IOException
	{
		System.out.println("Order placed Successfully!");
		System.out.println("Thank you for shopping!");
		userHomePage(null);
	}
}

