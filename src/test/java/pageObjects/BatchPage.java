package pageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;
import utilities.ResourceBundleReader;

public class BatchPage {
	
    WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	
	
	public BatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.resourceBundleReader = new ResourceBundleReader();
	}


	//@FindBy(xpath = "//span[text()='Batch']")
	@FindBy(xpath ="//*[text()='Batch']/..")
	WebElement dashboardBatch;

	@FindBy(xpath = "//div[text()=' Manage Batch']")
	WebElement manageBatch;

	
	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	WebElement disbaledDeleteIcon;

	
	
	WebElement paginationEnabled;
	
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	WebElement manageSystem;
	

	static Set<Cookie> allCookies;
	
	public void clickDashboardBatch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dashboardBatch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Batch']/..")));
		dashboardBatch.click();

		//dashboardBatch.click();
	}

	public String manageBatchgetText() {
		return manageBatch.getText();
	}

	public boolean deleteIconIsDisabled() {
		
		boolean isDisabled = disbaledDeleteIcon.getAttribute("disabled") != null;
		return isDisabled;
	}

	public boolean isPaginationEnabled() {
		return paginationEnabled.isDisplayed();
	}

	public String getActualTitle() {
		return driver.getTitle();
	}

	public void loginUsingCookies() {
		for(Cookie cookie: allCookies) {
			driver.manage().addCookie(cookie);
		}
		driver.navigate().to("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/");
	}

	public String CheckboxesPresentEachRow() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
