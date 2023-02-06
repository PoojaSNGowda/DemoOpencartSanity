package opencarte2etests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchItemFunctionality {
	
	WebDriver driver;
	
	@BeforeMethod
	public void initializeMethod(){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
	}

	@Test(groups= {"ErrorHandling"})
	public void searchItem() {
		
		
		
		
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iPhone");
		
		try {
			
			driver.findElement(By.xpath("//i[@class='fas fa-search']")).click();
			
			
			String error= driver.findElement(By.xpath("//div//h5")).getText();
			
			Assert.assertEquals(error, "Internal Server Error!");
		
		}
		catch(Exception e) {
			
			System.out.println("Internal Server Error!");
		}
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}
}
