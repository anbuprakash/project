package com.tradeviv.build;

import org.testng.annotations.Test;

public class userStorySeven extends TradevivBase
{

	@Test
	public void baseTest()
	{
		browserInitialization();
		implicitWait();
		TradevivAdminPage admin=new TradevivAdminPage();
		admin.userMail();
		admin.passWord();
		admin.login();
	}
	@Test
	public void userStory_07() throws Exception
	{
		Tradeviv_UserStory_07 test=new Tradeviv_UserStory_07();

		test.vendor();
		test.dropDown();
		test.approveVendor();
		test.approveV_List();
		test.body();
		test.search();
		test.underReview();
		test.uR_Options();
		test.companyEdit();
		test.landLineNo();
	}
	@Test
	public void userStory_08() throws Exception
	{
		
		Testcase s=new Testcase();
		s.vendors();
		s.dropDown();
		s.manageVendor();
		s.show();
		s.head();
		s.m_Body();
		s.action();
		s.actionList();
		s.edit();
		s.editOption();
		}
	
	@Test
	public void userStory_09() throws Exception
	{
		EditVendor e=new EditVendor();
		e.editVendor();
	}
	

}
