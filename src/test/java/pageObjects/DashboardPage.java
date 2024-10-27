package pageObjects;

import java.util.ResourceBundle;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ResourceBundleReader;



public class DashboardPage {
	
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.resourceBundleReader = new ResourceBundleReader();
	}
	
	@FindBy (id = "username") 
	WebElement userName;
	
	@FindBy (id = "password")
	WebElement password;
	
	@FindBy (id = "login")
	WebElement submitBtn;
	
	static Set<Cookie> allCookies;
	
	public void login() {
		userName.sendKeys(resourceBundleReader.getUserName());
		password.sendKeys(resourceBundleReader.getPassword());
		submitBtn.click();
		allCookies = driver.manage().getCookies();
	
	}
	public void loginUsingCookies() {
		for(Cookie cookie: allCookies) {
			driver.manage().addCookie(cookie);
		}
		driver.navigate().to("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/");
	}

}