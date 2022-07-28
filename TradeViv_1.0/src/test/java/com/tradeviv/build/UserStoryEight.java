package com.tradeviv.build;

import org.testng.annotations.Test;

public class UserStoryEight extends TradevivBase
{
	@Test
	public void base()
	{
		browserInitialization();
		implicitWait();
		TradevivAdminPage admin=new TradevivAdminPage();
		admin.userMail();
		admin.passWord();
		admin.login();
	}
	@Test
	public void us() throws Exception
	{
		Testcase s=new Testcase();
		s.vendors();
		s.dropDown();
		s.manageVendor();
//		s.show();
		s.head();
		s.m_Body();
		s.table();
	//	s.next();
	//	s.previous();
	//	s.search();
		s.action();
		s.actionList();
		s.edit();
//		s.editOption();
//		s.shopName();
//		s.submit();
//		s.update();
	}
}
