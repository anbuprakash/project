package com.sathya.mobile;

import java.io.IOException;

import org.testng.annotations.Test;

public class TestSathya extends TestBase {
	
	@Test
	public void Test() throws IOException {
		
		openBrowser();
		HomePage home=new HomePage();
		home.electronic();
		home.mobile();
		home.page();
		home.page1();
		home.selectMobile();
		home.writeExcell();
		home.bestOfBest();
		
		
	}

}
