package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Pagination;
import utilities.ResourceBundleReader;

public class LogOutPage {
	
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;	

	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.resourceBundleReader = new ResourceBundleReader();
	}

	public void LogoutMenu() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement logoutModule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='logout']")));
	    logoutModule.click();	    
	}
   

}
