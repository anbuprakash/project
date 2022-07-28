package com.tradeviv.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tradeviv.testCases.BaseClass;

public class VendorAddProduct extends BaseClass{
	
	WebDriver ldriver;
	BaseClass bc=new BaseClass();
		
		public VendorAddProduct(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}

		@FindBy (xpath="//a[@href='#menu2']")
		@CacheLookup
		WebElement products_menu;
		

		@FindBy (xpath="//a[contains(@href,'products/create')]")
		@CacheLookup
		WebElement add_newproduct;

		@FindBy (xpath="//input[@placeholder='Product Name']")
		@CacheLookup
		WebElement product_name;

		@FindBy (xpath="//select[@name='category_id']")
		@CacheLookup
		WebElement select_main;

		@FindBy (xpath="//select[@id='subcat']")
		@CacheLookup
		WebElement select_sub;

		@FindBy (xpath="//select[@id='childcat']")
		@CacheLookup
		WebElement select_child;

		@FindBy (xpath="//select[@name='location']")
		@CacheLookup
		WebElement select_location;

		@FindBy (xpath="//input[@placeholder='S.No*']")
		@CacheLookup
		WebElement pf_s_no;
		

		@FindBy (xpath="//input[@placeholder='Specification*']")
		@CacheLookup
		WebElement pf_specifi;

		@FindBy (xpath="//input[@placeholder='Values*']")
		@CacheLookup
		WebElement pf_values;

		@FindBy (xpath="//*[@id=\"geniusform\"]/div/div[1]/div/div/div/div/div/div[10]/div[2]/div/div[2]/div")
		@CacheLookup
		WebElement product_desc;

		@FindBy (xpath="(//input[contains(@name,'price')])[1]")
		@CacheLookup
		WebElement price;

		@FindBy (xpath="//select[contains(@name,'measurement_system')]")
		@CacheLookup
		WebElement measurement;

		@FindBy (xpath="//input[contains(@name,'p_v_qty[]')]")
		@CacheLookup
		WebElement pv_qty;

		@FindBy (xpath="//input[contains(@name,'p_v_price[]')]")
		@CacheLookup
		WebElement pv_price;
		
		@FindBy (xpath="//input[contains(@name,'p_v_measurement[]')]")
		@CacheLookup
		WebElement pv_meas;
		
		@FindBy (xpath="//input[contains(@name,'availablity')]")
		@CacheLookup
		WebElement product_avail;
		
		@FindBy (xpath="//input[contains(@value,'By Road')]")
		@CacheLookup
		WebElement shipping_desc;
		
		@FindBy (xpath="//input[contains(@name,'d_t_qty[]')]")
		@CacheLookup
		WebElement edt_qty;
		
		@FindBy (xpath="//input[contains(@name,'d_t_estimate_days[]')]")
		@CacheLookup
		WebElement edt_day;
		
		@FindBy (xpath="//input[@name='photo']")
		@CacheLookup
		WebElement product_image;
		
		@FindBy (xpath="//input[@name='p_p_photo']")
		@CacheLookup
		WebElement pp_image;
		
		@FindBy (xpath="//input[@name='p_t_photo']")
		@CacheLookup
		WebElement pt_image;
		
		@FindBy (xpath="//button[@class='addProductSubmit-btn']")
		@CacheLookup
		WebElement add_product_submit;
		
		@FindBy(xpath="//*[contains(text(),'New Product Added Successfully')]")
		@CacheLookup
		WebElement sucessmesg;
		
		public void clickProductMenu()
		{
			bc.explicitWait(products_menu, driver);
			products_menu.click();
		}
		
		public void clickAddNewProductMenu()
		{
			add_newproduct.click();
		}
		
		public void addproductName(String p_name)
		{
			product_name.sendKeys(p_name);
		}
		
		public void selectMainCategory(int index)
		{
			
			Select drop=new Select(select_main);
			drop.selectByIndex(index);
		}
		
		public void selectSubCategory(int sub_index)
		{
//			WebDriverWait wait=new WebDriverWait(driver,60);
//			wait.until(ExpectedConditions.visibilityOf(select_sub));
			Select drop1=new Select(select_sub);
			drop1.selectByIndex(sub_index);
		}
		
		public void selectChildCategory(int child_index)
		{
			Select drop2=new Select(select_child);
			drop2.selectByIndex(child_index);
		}
		
		public void selectLocation(int loc_index)
		{
			bc.explicitWait(select_location, driver);
			Select drop3=new Select(select_location);
			drop3.selectByIndex(loc_index);
		}
		
		public void productFeatureSNo()
		{
			pf_s_no.sendKeys("1");
		}
		
		public void productFeatureSpeci(String specification)
		{
			pf_specifi.sendKeys(specification);
		}
		
		public void productFeatureValue(String values)
		{
			pf_values.sendKeys(values);
		}
		
		public void productDescription(String p_desc)
		{
			bc.explicitWait(product_desc, driver);
			product_desc.sendKeys(p_desc);
		}
		public void produtPrice(String p_price)
		{
			price.sendKeys(p_price);
		}
		
		public void productMeasurement(int mea_index)
		{
			Select meas=new Select(measurement);
			meas.selectByIndex(mea_index);
		}
		
		public void priceVaraintQty(String p_qty)
		{
			pv_qty.sendKeys(p_qty);
		}

		public void priceVariantPrice(String p_price)
		{
			pv_price.sendKeys(p_price);
		}
		
		public void priceVaraintMeas(String pv_mes)
		{
			pv_meas.sendKeys(pv_mes);
		}
		
		public void producAvailability(String ava)
		{
			product_avail.sendKeys(ava);
		}
		
		public void productShippingDescription()
		{
			shipping_desc.click();
		}
		
		public void estimateDeleiveryQty(String ed_qty)
		{
			edt_qty.sendKeys(ed_qty);
		}
		
		public void estimateDeliverDays(String day)
		{
			edt_day.sendKeys(day);
		}
		
		public void productImage(String img_path)
		{
			product_image.sendKeys(img_path);
		}
		
		public void productpackageImage(String pack_path)
		{
			pp_image.sendKeys(pack_path);
		}
		
		public void productTransportaionImg(String traimg_path)
		{
			pt_image.sendKeys(traimg_path);
		}
		
		public void addProductSubmit()
		{
			bc.explicitWait(add_product_submit, driver);
			bc.callJavascriptExecutor(add_product_submit);
		}
		
		public String successfullMessage()
		{
			bc.explicitWait(sucessmesg, driver);
			return sucessmesg.getText();
		}
}
