package com.tradeviv.build;

import org.testng.annotations.Test;

public class CategoryTest extends TradevivBase{

	@Test
	public void ac()
	{
		browserInitialization();
		implicitWait();
		TradevivAdminPage admin=new TradevivAdminPage();
		admin.userMail();
		admin.passWord();
		admin.login();
	}
	@Test
	public void cTest() throws Exception
	{
		CategoryBox c=new CategoryBox();
		c.cate_base();
	}
}
