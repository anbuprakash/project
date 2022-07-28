package com.E_commerce.build;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbBuild 
{
	static Connection connect;
	static Statement stmt;
	static Scanner sc=new Scanner(System.in);
	static String sql;

	public void dbConnection() throws SQLException, ClassNotFoundException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		connect= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","prakash","manbarasu");
		stmt=connect.createStatement();

	}
	public void db() throws Exception
	{
		dbConnection();
		sql= ("select * from admin");
		ResultSet rs=stmt.executeQuery(sql);  
		while(rs.next())  
			System.out.println(rs.getString(1)+" "+rs.getString(2));
		connect.close();
	}
	public void addProduct() throws Exception
	{
		dbConnection();
		sql=("select * from amazon");
		ResultSet rs=stmt.executeQuery(sql);  
		while(rs.next())  
			for(int i=1;i<=5;i++)
			{
				System.out.println("\n"+"\t"+rs.getString(i));
			}
		connect.close();
	}
	public void getmobile() throws Exception
	{
		dbConnection();
		sql=("select * from products");
		ResultSet rs=stmt.executeQuery(sql);  
		while(rs.next())
			System.out.println("\t"+rs.getString(1)+"||"+rs.getString(2)+"||"+rs.getString(3)+"||"+rs.getString(4)+"||"+rs.getString(5));

		connect.close();
	}
	public void getfashion() throws Exception
	{
		dbConnection();
		sql=("select fashioin from products");
		ResultSet rs=stmt.executeQuery(sql);  
		while(rs.next())  
			System.out.println(rs.getString("fashioin"));
		connect.close();
	}
	public void getNewReleses() throws Exception
	{
		dbConnection();
		sql=("select newreleses from products");
		ResultSet rs=stmt.executeQuery(sql);  
		while(rs.next())  
			System.out.println(rs.getString("newreleses"));
		connect.close();
	}
	public void getElectronics() throws Exception
	{
		dbConnection();
		sql=("select electronics from products");
		ResultSet rs=stmt.executeQuery(sql);  
		while(rs.next())  
			System.out.println(rs.getString("electronics"));
		connect.close();
	}
	public void getcomputer() throws Exception
	{
		dbConnection();
		sql=("select computers from products");
		ResultSet rs=stmt.executeQuery(sql);  
		while(rs.next())  
			System.out.println(rs.getString("computers"));
		connect.close();
	}
	public void getcat() throws ClassNotFoundException, SQLException
	{
		dbConnection();
		sql=("select * from test");
		ResultSet rs=stmt.executeQuery(sql);  
		while(rs.next())  
			System.out.println("\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		connect.close();	
	}
}
