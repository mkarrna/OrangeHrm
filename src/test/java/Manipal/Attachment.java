package Manipal;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Manipal.Immegration;

public class Attachment extends OrangeHrm {
	@Test
	
	public void ValidAttachment() throws InterruptedException
	{
		navigateToImmigartion();
		
		AddAttach("C:\\Users\\dell\\eclipse-workspace1\\Manipal_TestNG\\files\\Book11.xlsx");
		
	}
	
@Test
	
	public void InValidAttachment() throws InterruptedException
	{
		navigateToImmigartion();
		
		AddAttach("E:\\mainpal Academy\\assignment\\assignment-6.xlsx");
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[5]/div/form/div[1]/div/div/div/span")).isDisplayed());
		
	}
	
	
	
}
