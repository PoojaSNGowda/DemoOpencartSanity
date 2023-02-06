package opencarte2etests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import opencartPageFactory.AccountRegLoginPage;

public class AccountRegistration {

	WebDriver driver;

	AccountRegLoginPage registrationPage;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeTest
	public void initializeMethod() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		registrationPage = new AccountRegLoginPage(driver);

	}
	
	@Test
	public void CustomerAccountRegisteration() {
		
		String actualPageTitle = driver.getTitle();

		String expectedPageTitle = "Your Store";

		System.out.println(actualPageTitle);

		Assert.assertEquals(actualPageTitle, expectedPageTitle);

		registrationPage.customerAccountRegister();

	}

	@Test
	public void ReturningCustomerLoginTest() {

		registrationPage.returningCustomerLogin();

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
