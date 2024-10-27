package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.DashboardPage;
import pageObjects.Program2Page;

public class PageObjectManager {
	WebDriver driver;
	DashboardPage loginPage;
	Program2Page program2Page;
	
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
	
	public Program2Page getProgram2Page()
	{
		if(program2Page == null) {
			System.out.println("Inside getProgram2Page object creation");
			program2Page = new Program2Page(driver);
		}
		return program2Page;
	}
}
