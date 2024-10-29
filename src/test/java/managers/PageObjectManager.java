package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import pageObjects.Program1Page;

public class PageObjectManager {
	WebDriver driver;
	DashboardPage loginPage;
	Program1Page programPage;
	BatchPage batchPage;
	
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
	public Program1Page getProgramPage() {
		if(programPage == null) {
			programPage = new Program1Page(driver);
		}
		return programPage;
	}
	
	public BatchPage getBatchPage() {
		if(batchPage == null) {
			batchPage = new BatchPage(driver);
		}
		return batchPage;
	}
}
