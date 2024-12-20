package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.BatchPage;
import pageObjects.ClassModPage;
import pageObjects.DashboardPage;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;
import pageObjects.Program2Page;
import utilities.Pagination;

public class PageObjectManager {
	WebDriver driver;
	DashboardPage loginPage;
	Program2Page program2Page;
	BatchPage batchPage;
	Pagination pgPage;
	LogOutPage logoutPage;
	LoginPage login;
	ClassModPage classmodPage;
	
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
			program2Page = new Program2Page(driver);
		}
		return program2Page;
	}
	public BatchPage getBatchPage() {
		if(batchPage == null) {
			batchPage = new BatchPage(driver);
		}
		return batchPage;
	}
	public Pagination getPgPage() {
		if(pgPage == null) {
			pgPage = new Pagination(driver);
		}
		return pgPage;
	}
	
	public LogOutPage getLogOutPage() {
		if(logoutPage == null) {
			logoutPage = new LogOutPage(driver);
		}
		return logoutPage;
}
	public LoginPage getLoginPage() {
		if(login == null) {
			login = new LoginPage(driver);
		}
		return login;
	}
		
	public ClassModPage getClassmodPage() {
		if(classmodPage == null) {
			classmodPage = new ClassModPage(driver);
		}
		return classmodPage;
	}
}