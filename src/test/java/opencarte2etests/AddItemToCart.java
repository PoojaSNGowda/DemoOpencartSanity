package opencarte2etests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import opencartPageFactory.AddItemsToCartAndWishListPage;
import opencarte2e.testcomponents.BaseTest;

public class AddItemToCart extends BaseTest{

	WebDriver driver;

	AddItemsToCartAndWishListPage addItemsTocartAndWishlist;

	@BeforeTest
	public void initializeMethod() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		addItemsTocartAndWishlist = new AddItemsToCartAndWishListPage(driver);

	}

	@Test

	public void addItemCart() throws InterruptedException, IOException {

		
		addItemsTocartAndWishlist.addItemToCart();

		Assert.assertTrue(addItemsTocartAndWishlist.alertMsg(), "Sucess message displayed");

	}

	@Test(dependsOnMethods= {"addItemCart"})
	public void wishList() throws InterruptedException {

		addItemsTocartAndWishlist.addItemToWishList();
		
		Assert.assertTrue(addItemsTocartAndWishlist.alertMsg(), "Sucess message displayed");

		System.out.println("item added to wishlist");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
