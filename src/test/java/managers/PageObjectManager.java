package managers;

import org.openqa.selenium.WebDriver;

import pageObject.DashboardPage;

public class PageObjectManager {
	WebDriver driver;
	DashboardPage loginPage;
	
	public  PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	public WebDriver getDriver() {
		return driver;
	}
	
	public DashboardPage getDashboardPage() {
		if(loginPage == null) {
			loginPage = new DashboardPage(driver);
		}
		return loginPage;
	}
}
