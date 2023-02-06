package opencartPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddItemsToCartAndWishListPage extends ReusableAbstractComponents {

	WebDriver driver;

	Actions actions;

	JavascriptExecutor js;

	// Constructor to initialize driver
	public AddItemsToCartAndWishListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);

	}

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement myAccountDrpdown;

	@FindBy(xpath = "//a[text()='Tablets']")
	WebElement selectTabletDropdown;

	@FindBy(xpath = "//button[@aria-label='Add to Wish List']")
	WebElement addToWishListBtn;

	@FindBy(xpath = "//a[text()='Desktops']")
	WebElement DesktopDropdown;

	@FindBy(xpath = "//a[contains(text(),'Mac (1)')]")
	WebElement macDesktop;

	@FindBy(xpath = "//button[@aria-label='Add to Cart']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//div[@id='alert']")
	WebElement alertPopup;

	By selectTabletBy = By.xpath("//a[text()='Tablets']");

	By DesktopDropdownBy = By.xpath("//a[text()='Desktops']");

	By addToWishListBy = By.xpath("//button[@aria-label='Add to Wish List']");

	By addToCartBtnBy = By.xpath("//button[@aria-label='Add to Cart']");

	public void addItemToCart() {
		waitForElement(DesktopDropdownBy);
		actions.moveToElement(DesktopDropdown).build().perform();
		macDesktop.click();
		waitForElement(addToWishListBy);
		actions.sendKeys(Keys.END).build().perform();
		waitForElement(addToCartBtnBy);
		addToCartBtn.click();

	}

	public boolean alertMsg() {

		boolean alertIsPresent = alertPopup.isDisplayed();
		return alertIsPresent;
	}

	public void addItemToWishList() throws InterruptedException {

		actions.sendKeys(Keys.HOME).build().perform();
		Thread.sleep(4000);
		waitForElement(selectTabletBy);
		selectTabletDropdown.click();
		actions.sendKeys(Keys.END).build().perform();
		waitForElement(addToWishListBy);
		actions.sendKeys(Keys.END).build().perform();
		addToWishListBtn.click();
	}

}
