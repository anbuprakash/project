package com.admin.page;

import java.io.IOException;

import org.testng.annotations.Test;

public class AdminTest extends AdminBase{

	@Test (priority=1)
	public void test() throws IOException {

		browserOpen();
		delay();
		AdminPage admin=new AdminPage();
		admin.userMail();
		admin.passWord();
		admin.login();


	}
//	@Test (priority=2)
//	public void main_cate() throws IOException {
//
//		MainCategory main=new MainCategory();
//		main.mainCategory();
//	}
//		@Test (priority=2)
//		public void sub_cate() throws IOException {
//			
//			 SubCategory sub=new SubCategory();
//			 sub.subCategory();
//			
//		}
		@Test (priority=2)
		public void child_cate() throws IOException {
			
			ChildCate cat=new ChildCate();
			 cat.addChildCategory();
			
		}


}
