package Manipal;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;


public class Immegration extends OrangeHrm {
	
	
	@Test(dataProvider="supplier",dataProviderClass=Dataproviderclass.class)
	
	public void addRecord(String passNumber,Object issueDate, Object expireDate, Object approveDate, String eligibleStatus, String comment) throws InterruptedException
	{
		navigateToImmigartion();
			
			 FindElement( passNumber, issueDate, expireDate, approveDate,eligibleStatus,comment);
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
