package opencartPageFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccountRegLoginPage extends ReusableAbstractComponents {

	WebDriver driver;

	// Constructor to initialize driver
	public AccountRegLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement myAccountDrpdown;

	@FindBy(linkText = "Register")
	WebElement registerBtn;

	@FindBy(id = "input-firstname")
	WebElement firstNameField;

	@FindBy(id = "input-lastname")
	WebElement lastNameField;

	@FindBy(id = "input-email")
	WebElement emailField;

	@FindBy(id = "input-password")
	WebElement passwordField;

	@FindBy(xpath = "//input[@id='input-newsletter-yes']")
	WebElement subscribeBtn;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkBox;

	@FindBy(css = "button.btn.btn-primary")
	WebElement continueBtn;

	@FindBy(xpath = "//a[text()='login page']")
	WebElement loginPageLink;

	@FindBy(xpath = "//form[@id='form-login']//h2")
	WebElement loginpageFormName;

	@FindBy(id = "input-email")
	WebElement emailLoginField;

	@FindBy(id = "input-password")
	WebElement pwdLoginField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;

	By loginPageLinkBy = By.xpath("//a[text()='login page']");

	By checkBoxBy = By.xpath("//input[@type='checkbox']");

	By continuebtnBy = By.cssSelector("button.btn.btn-primary");

	public void customerAccountRegister() {
		myAccountDrpdown.click();
		registerBtn.click();
		firstNameField.sendKeys("TestA");
		lastNameField.sendKeys("TestB");
		emailField.sendKeys("testa.testb@mailinator.com");
		passwordField.sendKeys("test1234");
		waitForElement(checkBoxBy);
		WebElement ele = driver.findElement(By.xpath("//input[@type='checkbox']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);

	}

	public void returningCustomerLogin() {
		waitForElement(loginPageLinkBy);
		loginPageLink.click();
		emailLoginField.sendKeys("TestA@mailinator.com");
		pwdLoginField.sendKeys("Test1234");
		loginBtn.click();
	}

}
