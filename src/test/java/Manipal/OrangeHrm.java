package Manipal;



import java.io.File;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class OrangeHrm {
	
	WebDriver driver;
	@BeforeTest
	
	public void loginTest() throws InterruptedException
	{
				System.setProperty("webdriver.chrome.driver","C:\\Program Files\\maven\\chromedriver.exe");
				 driver = new ChromeDriver();		
					
			driver.manage().window().maximize();		
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Assert.assertTrue(driver.findElement(By.xpath("//div[1]/span/h6")).isDisplayed());
			
	
	}
	
	
	@Test
	public void navigate() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a/span")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Immigration")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/h6")).isDisplayed());
		
		//click add button for add record
		
		
	}
	
	@Test(dependsOnMethods="navigate",dataProvider="supplier",dataProviderClass=Dataproviderclass.class)
	public void FindElement(String passNumber,Object issueDate, Object expireDate, Object approveDate, String eligibleStatus, String comment)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//add button
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/button")).click();
		//visa radio
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div[2]/div[2]/div/label/span")).click();
		//passport or visa number
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(passNumber);
		//issue date
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(String.valueOf(issueDate));
		//expire date
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(String.valueOf(expireDate));
		//eligible status
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[4]/div/div[2]/input")).sendKeys(eligibleStatus);
		//
		//driver.findElement(By.xpath("")).sendKeys("");
		WebElement text=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]"));
				text.sendKeys("Andorra");
			
		// approved date
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[6]/div/div[2]/div/div/input")).sendKeys(String.valueOf(approveDate));	
		//comment
		driver.findElement(By.xpath("//textarea[@placeholder='Type Comments here']")).sendKeys(comment);
		//submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	
		
//	}
//	
//	@Test(dependsOnMethods="addRecord")
//	public void Expire_DateisGreaterThanIssue_Date() throws InterruptedException
//	{
//		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[3]/div/following::span")).isDisplayed());
//		
//	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}
