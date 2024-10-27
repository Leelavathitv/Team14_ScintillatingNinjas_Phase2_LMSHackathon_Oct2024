package testContext;

import org.openqa.selenium.WebDriver;

import driverManager.DriverManager;
import managers.PageObjectManager;
import utilities.ResourceBundleReader;

public class TestContext {
	WebDriver driver;
	DriverManager driverManager;
	PageObjectManager pageObjectManager;
	ResourceBundleReader resourceBundleReader;
	
	public TestContext() {
		driverManager =  new DriverManager();
		pageObjectManager = new PageObjectManager(DriverManager.getDriver());
		resourceBundleReader = new ResourceBundleReader();
	}
	
	
	public DriverManager getDriverManager() {
		return driverManager;
	}
	
	public ResourceBundleReader getResourceBundleReader() {
		return resourceBundleReader;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
}
