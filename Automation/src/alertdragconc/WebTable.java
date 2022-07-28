package alertdragconc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\browser\\ChromeDriver.exe");
		WebData wd=new WebData();
		wd.getdata();
	}

}

class WebData{
	WebDriver driver;

	public void getdata() {
		driver=new ChromeDriver();

		driver.get(" http://demo.guru99.com/test/web-table-element.php"); //get url
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize(); //maximize window

		List<WebElement> rowsize=driver.findElements(By.xpath("//table//tbody//tr"));
		int size=rowsize.size();
		System.out.println("row of table :"+size);

		List<WebElement> colsize=driver.findElements(By.xpath("//table//thead//tr//th"));
		int columsize=colsize.size();
		System.out.println("col of table :"+columsize);

		//      //*[@id="leftcontainer"]/table/tbody/tr[2]/td[3]

		String first="//*[@id=\"leftcontainer\"]/table/tbody/tr[";
		String secound="]/td[";
		String third="]";

		//	XSSFReader  reader=new XSSFReader("D:\\prakash\\excelldata\\Test.xlsx");

		for(int i = 1; i<=size; i++)
		{
			for(int j=1;j<=columsize;j++) {
				String finalp=first+i+secound+j+third;
				//System.out.println(finalp);
				String text=driver.findElement(By.xpath(finalp)).getText();
				System.out.print( text+ " | ");

				//String dynamicPath = "//table//tbody//tr["+i+"]//td["+j+"]";
				//String rowsData = driver.findElement(By.xpath(dynamicPath)).getText();
				//System.out.println(rowsData);
							
			}
			System.out.println(" \n ");

		}

		driver.close();
	}
}

//for(int i=1;i<=48;i++) {
////	driver.findElement(By.xpath("//div[@id='artlist-6267361117']//article["+ i +"]")).click();
//	
//	driver.findElement(By.xpath("//div[@class='artlist artlist-grid artlist-4-cols']//following-sibling::article["+i+"]")).click();
//	driver.findElement(By.xpath("//a[contains(text(),'Features')]")).click();
//	driver.navigate().back();
//	
//}


