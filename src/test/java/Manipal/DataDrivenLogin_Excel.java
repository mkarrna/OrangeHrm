package Manipal;



import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DataDrivenLogin_Excel {
	WebDriver driver;
	@Test(dataProvider="supplier",dataProviderClass=Dataproviderclass.class)
	public void loginTest(String email,String password) {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\maven\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
			
	driver.manage().window().maximize();		
	driver.get("http://tutorialsninja.com/demo/");
	
	driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	driver.findElement(By.linkText("Login")).click();
	driver.findElement(By.id("input-email")).sendKeys(email);
	driver.findElement(By.id("input-password")).sendKeys(String.valueOf(password));
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	driver.quit();
}

	
}
