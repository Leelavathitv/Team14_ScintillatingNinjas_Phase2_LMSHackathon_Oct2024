package pageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverManager.DriverManager;
import utilities.CommonUtils;
import utilities.ResourceBundleReader;

public class BatchPage {

	WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	CommonUtils cu = new CommonUtils();

	public BatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.resourceBundleReader = new ResourceBundleReader();
	}

	@FindBy(xpath = "//*[text()='Batch']/..")
	WebElement dashboardBatch;

	@FindBy(xpath = "//div[text()=' Manage Batch']")
	WebElement manageBatch;

	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	WebElement disbaledDeleteIcon;

	@FindBy(xpath = "//th[text()=' Edit / Delete ']")
	WebElement editandDeleteIcon;

//	@FindAll(xpath = "//div[@class='p-checkbox p-component']", value = { @FindBy })
//	WebElement checkbox;

	WebElement paginationEnabled;

	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	WebElement manageSystem;

	@FindBy(xpath = "//button[contains(@class, 'mat-focus-indicator mat-menu-item ng-tns-c225-105')]")
	WebElement addNewBatch;

	static Set<Cookie> allCookies;

	public void clickDashboardBatch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dashboardBatch = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Batch']/..")));
		dashboardBatch.click();
	}

	public String manageBatchgetText() {
		return manageBatch.getText();
	}

	public boolean deleteIconIsDisabled() {
		return !cu.isEnabled(disbaledDeleteIcon);
	}

	public boolean isPaginationEnabled() {
		return paginationEnabled.isDisplayed();
	}

	public boolean editIconEnable() {
		return editandDeleteIcon.isEnabled();
	}

	public boolean deleteIconEnable() {
		return editandDeleteIcon.isEnabled();
	}

	public void checkboxClickable() {
		// checkbox.click();
	}

	public void clickaddNewBatch() {
		addNewBatch.click();

	}
	public String getTextNewBatch() {
	return addNewBatch.getText();
	
	}

	public String getActualTitle() {
		return driver.getTitle();
	}

	public void loginUsingCookies() {
		for (Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}
		driver.navigate().to("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/");
	}

}
