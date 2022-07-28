package com.ecommerce.pro;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbConnect {
	static Connection connect;
	static Statement stmt;
	static String sql;
	Scanner scan=new Scanner(System.in);
	String name;
	public  void d() throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connect= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prakash","manbarasu");  
		stmt=connect.createStatement();
	}
	public void db() throws Exception
	{
		d();
		sql= ("select * from admin");
		ResultSet rs=stmt.executeQuery(sql);  
		while(rs.next())  
			System.out.println(rs.getString(1)+" "+rs.getString(2));
		connect.close();
	}
	public void addProduct() throws Exception
	{
		d();
		sql=("select * from amazon");
		ResultSet rs=stmt.executeQuery(sql);  
		while(rs.next())  
		for(int i=1;i<=5;i++)
		{
			System.out.println(rs.getString(i));
		}
		connect.close();
	}
	public void getmobile() throws Exception
	{
		d();
		sql=("select mobile from products");
		ResultSet rs=stmt.executeQuery(sql);  
		while(rs.next())  
			System.out.println(rs.getString("mobile"));
		connect.close();
	}
	public void getfashion() throws Exception
	{
		d();
		sql=("select fashioin from products");
		ResultSet rs=stmt.executeQuery(sql);  
		while(rs.next())  
			System.out.println(rs.getString("fashioin"));
		connect.close();
	}
	public void getNewReleses() throws Exception
	{
		d();
		sql=("select newreleses from products");
		ResultSet rs=stmt.executeQuery(sql);  
		while(rs.next())  
			System.out.println(rs.getString("newreleses"));
		connect.close();
	}
	public void getElectronics() throws Exception
	{
		d();
		sql=("select electronics from products");
		ResultSet rs=stmt.executeQuery(sql);  
		while(rs.next())  
			System.out.println(rs.getString("electronics"));
		connect.close();
	}
	public void getcomputer() throws Exception
	{
		d();
		sql=("select computers from products");
		ResultSet rs=stmt.executeQuery(sql);  
		while(rs.next())  
			System.out.println(rs.getString("computers"));
		connect.close();
	}
	

	
	
	



}
