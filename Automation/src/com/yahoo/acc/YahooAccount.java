package com.yahoo.acc;

public class YahooAccount {

	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver", ".//ChromeDriver//chromedriver.exe");
		CreatYahooAccount account=new CreatYahooAccount(); //object create
		account.browserLaunch();  //call method

	}

}
