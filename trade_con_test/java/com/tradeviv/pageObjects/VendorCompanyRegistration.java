package com.tradeviv.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VendorCompanyRegistration {

WebDriver ldriver;
	
	public VendorCompanyRegistration(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'vendor/companydetails')]")
	@CacheLookup
	WebElement company_details;
	
	@FindBy(xpath="//*[@id=\"geniusfor\"]/div[1]/div[2]/div[2]/div")
	@CacheLookup
	WebElement shop_details;
	
	@FindBy(xpath="//input[contains(@name,'company_name')]")
	@CacheLookup
	WebElement company_name;
	
	@FindBy(xpath="//input[contains(@name,'company_p_name')]")
	@CacheLookup
	WebElement proprietor_name;
	
	@FindBy(xpath="//input[contains(@placeholder,'Total. No. of Employees')]")
	@CacheLookup
	WebElement total_Employees;
	
	@FindBy(xpath="//*[@name=\"category\"]")
	@CacheLookup
	WebElement category;
	
	@FindBy(xpath="//*[@name=\"year_open\"]")
	@CacheLookup
	WebElement establish_year;
	
	@FindBy(xpath="//*[@placeholder=\"Legal Status of the Firm\"]")
	@CacheLookup
	WebElement legal_status;

	@FindBy(xpath="//*[@name=\"gst\"]")
	@CacheLookup
	WebElement gst;
	
	@FindBy(xpath="//*[@name=\"pan\"]")
	@CacheLookup
	WebElement pan;
	
	@FindBy(xpath="//*[@name=\"cin\"]")
	@CacheLookup
	WebElement cin;
	
	@FindBy(xpath="//*[@placeholder=\"Total Annual Revenue\"]")
	@CacheLookup
	WebElement total_revenue;
	
	@FindBy(xpath="//*[@name=\"cemail\"]")
	@CacheLookup
	WebElement com_email;
	
	@FindBy(xpath="//*[@name=\"cmobile\"]")
	@CacheLookup
	WebElement com_mobile;
	
	@FindBy(xpath="//*[@name=\"clandline\"]")
	@CacheLookup
	WebElement com_landline;
	
	@FindBy(xpath="//*[@id=\"geniusfor\"]/div[15]/div[2]/div[2]/div")
	@CacheLookup
	WebElement com_address;
	
	@FindBy(xpath="(//input[@type='file'])[1]")
	@CacheLookup
	WebElement comp_cert;
	
	@FindBy(xpath="(//input[@type='file'])[2]")
	@CacheLookup
	WebElement product_cert;
	
	@FindBy(xpath="(//input[@type='file'])[3]")
	@CacheLookup
	WebElement comp_vide;
	
	@FindBy(xpath="(//input[@type='file'])[4]")
	@CacheLookup
	WebElement comp_pho;
	
	@FindBy(xpath="(//input[@type='file'])[5]")
	@CacheLookup
	WebElement comp_logo;
	
	@FindBy(xpath="//button[@class='addProductSubmit-btn']")
	@CacheLookup
	WebElement comp_submit;
	
	public void companyDetailsClick()
	{
		company_details.click();
	}
	
	public void shopDetailsField(String shopdetail)
	{
		shop_details.clear();
		shop_details.sendKeys(shopdetail);
	}
	
	public void companyNameFild(String c_name)
	{
		company_name.clear();
		company_name.sendKeys(c_name);
	}
	
	public void proprietorNameField(String pro_name)
	{
		proprietor_name.clear();
		proprietor_name.sendKeys(pro_name);
	}
	
	public void totalNoOfEmployeesField(String tot)
	{
		total_Employees.clear();
		total_Employees.sendKeys(tot);
	}
	
	public void selectCategory(int index)
	{
		Select drop=new Select(category);
		drop.selectByIndex(index);
	}
	
	public void yearOfEstablishment(String year)
	{
		establish_year.clear();
		establish_year.sendKeys(year);
	}
	
	public void legalStatusOfFirm(String legal)
	{
		legal_status.clear();
		legal_status.sendKeys("legal");
	}
	
	public void gstNumber(String gstnum)
	{
		gst.clear();
		gst.sendKeys(gstnum);
	}
	
	public void panNumber(String pan_num)
	{
		pan.clear();
		pan.sendKeys(pan_num);
	}
	
	public void cinNumber(String cinnum)
	{
		cin.clear();
		cin.sendKeys("cinnum");
	}
	
	public void totalAnnualRevenue(String tot_revenue)
	{
		total_revenue.clear();
		total_revenue.sendKeys(tot_revenue);
	}
	
	public void companyEmail(String cmail)
	{
		com_email.clear();
		com_email.sendKeys(cmail);
	}
	
	public void companyMobile(String cmobile)
	{
		com_mobile.clear();
		com_mobile.sendKeys(cmobile);
	}
	
	public void companyLandline(String clandline)
	{
		com_landline.clear();
		com_landline.sendKeys(clandline);
	}
	
	public void companyAddress(String caddress)
	{
		com_address.clear();
		com_address.sendKeys(caddress);
	}
	public void companyCertificateUpload(String cc_path)
	{
		
		comp_cert.sendKeys(cc_path);
	}
	
	public void productCertificateUpload(String pc_path)
	{
		product_cert.sendKeys(pc_path);
	}
	
	public void videoUpload(String cv_path)
	{
		comp_vide.sendKeys(cv_path);
	}
	
	public void photoUpload(String cp_path)
	{
		comp_pho.sendKeys(cp_path);
	}
	
	public void logoUpload(String cl_path)
	{
		comp_logo.sendKeys(cl_path);
	}
	
	public void companySubmit()
	{
		comp_submit.click();
	}
}
