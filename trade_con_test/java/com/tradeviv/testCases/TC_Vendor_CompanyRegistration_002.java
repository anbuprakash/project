package com.tradeviv.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.tradeviv.pageObjects.VendorCompanyRegistration;
import com.tradeviv.pageObjects.VendorLogin;


public class TC_Vendor_CompanyRegistration_002 extends BaseClass {
	
	@Test
	public void companyReg()
	{
		VendorLogin vl=new VendorLogin(driver);
		vl.sellButton();
		vl.vendorLoginSection();
		vl.emailField("daswinraja@gmail.com");
		vl.passwordField("CP3M69");
		vl.loginVendor();
		
		VendorCompanyRegistration vcr=new VendorCompanyRegistration(driver);
		vcr.companyDetailsClick();
		vcr.shopDetailsField("something about company/shop");
		vcr.companyNameFild("SRK Enterprises");
		vcr.proprietorNameField("Sivarajakumar");
		vcr.totalNoOfEmployeesField("1000");
		vcr.selectCategory(2);
		vcr.yearOfEstablishment("1994");
		vcr.legalStatusOfFirm("This is legal status of firm");
		vcr.gstNumber("CHBC12HU76");
		vcr.panNumber("HJVPSSS678AB");
		vcr.cinNumber("12345678HGV");
		vcr.totalAnnualRevenue("20000");
		vcr.companyEmail("tradevivsivaraj@gmail.com");
		vcr.companyMobile("7867994576");
		vcr.companyLandline("4362292376");
		vcr.companyAddress("19/a 11th street, Queensland");
		
		String cc_path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\tradeviv\\testData\\Company Details\\product certificate.pdf";
		vcr.companyCertificateUpload(cc_path);
		
		String pc_path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\tradeviv\\testData\\Company Details\\\\product certificate.pdf";
		vcr.productCertificateUpload(pc_path);
		
		String cv_path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\tradeviv\\testData\\Company Details\\\\company video.mp4";
		vcr.videoUpload(cv_path);
		
		String cp_path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\tradeviv\\testData\\Company Details\\\\product certificate.pdf";
		vcr.photoUpload(cp_path);
		
		String cl_path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\tradeviv\\testData\\Company Details\\\\product certificate.pdf";
		vcr.logoUpload(cl_path);
		
		vcr.companySubmit();
		
		
	}

}
