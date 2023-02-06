package opencartPageFactory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableAbstractComponents {
	
	WebDriver driver;

	public ReusableAbstractComponents(WebDriver driver) {
		this.driver=driver;
	}

	public void waitForElement(By findBy) {
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
}
