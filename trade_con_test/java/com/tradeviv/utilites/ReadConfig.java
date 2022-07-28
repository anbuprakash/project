package com.tradeviv.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is"+ e.getMessage());
		}
	}
	public String getApplicaionURl()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getURL()
	{
		String com_url=pro.getProperty("URL");
		return com_url;
	}
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	public String getChromepath()
	{
		String chromepath=pro.getProperty("chrompath");
		return chromepath;
	}
	public String getFirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	public String getIEPath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
