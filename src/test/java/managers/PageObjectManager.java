package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class PageObjectManager {
	WebDriver driver;
	DashboardPage loginPage;
	BatchPage batchPage;
	LoginPage login;
	
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
	
	public BatchPage getBatchPage() {
		if(batchPage == null) {
			batchPage = new BatchPage(driver);
		}
		return batchPage;
	}
	
	public LoginPage getLoginPage() {
		if(login == null) {
			login = new LoginPage(driver);
		}
		return login;
	}
}
