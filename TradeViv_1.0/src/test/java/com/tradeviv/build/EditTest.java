package com.tradeviv.build;

import org.testng.annotations.Test;

public class EditTest extends TradevivBase{

	@Test
	public void edit()
	{
		browserInitialization();
		implicitWait();
		TradevivAdminPage admin=new TradevivAdminPage();
		admin.userMail();
		admin.passWord();
		admin.login();
	}
	@Test
	public void editing() throws Exception
	{
		EditVendor e=new EditVendor();
		e.editVendor();
	}
}
