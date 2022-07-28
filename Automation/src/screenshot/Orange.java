package screenshot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Orange {

	@FindBy(how=How.ID,using ="username")
	private WebElement userCrend;
	
	@FindBy(id="password")
	private WebElement passWord;
	
	@FindBy(xpath="//a[@class='btn']")
	private WebElement submit;

   Properties prop=new Properties();
   public void fil() throws FileNotFoundException
   {
	   try {
		   InputStream input=new FileInputStream("//config.properties");
		   prop.load(input);
		
	} catch (Exception e) {
		System.out.println("file not found");
	} 
	   
   }
   
   

	public void browserInitialize(String user,String password)
	{
		System.setProperty("webdriver.chrome.driver",".//chromeDriver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.orange.com/en");
		userCrend.sendKeys(prop.getProperty(password));
		passWord.sendKeys(password);
		submit.click();

	}



}
