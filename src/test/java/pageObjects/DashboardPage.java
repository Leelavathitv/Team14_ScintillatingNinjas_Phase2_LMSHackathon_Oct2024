package pageObjects;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelFileReader;
import utilities.ResourceBundleReader;

public class DashboardPage {
	
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	static Map<String, String> testData;
	ExcelFileReader excelReader;
	public static String UserName;
	public static String Password;
	WebDriverWait wait;
	
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.resourceBundleReader = new ResourceBundleReader();
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy (id = "username") 
	WebElement inputUserName;
	
	@FindBy (id = "password")
	WebElement inputPassword;
	
	@FindBy (id = "login")
	WebElement submitBtn;
	
	@FindBy (xpath = "//span[contains(text(),' LMS - Learning Management System ')]")
	WebElement PageHeader;
	
	
	public void login(String username, String password) {
		inputUserName.sendKeys(username);
		inputPassword.sendKeys(password);
		submitBtn.click();
	}
	
	public String assertingDashboard() {
		return PageHeader.getText();
	}
	
	public void validLogin() {
		inputUserName.sendKeys(resourceBundleReader.getUserName());
		inputPassword.sendKeys(resourceBundleReader.getPassword());
		submitBtn.click();
	}

	public boolean responseTime() {
		
		
		inputUserName.sendKeys(resourceBundleReader.getUserName());
		inputPassword.sendKeys(resourceBundleReader.getPassword());
		long start = System.currentTimeMillis();
		submitBtn.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(PageHeader));
		long finish = System.currentTimeMillis();
		long responseTime = finish - start;
		long maxTime = 30000;
		System.out.println("Response time: " +responseTime);
		if (responseTime < maxTime) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
