package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();
	
	public static  WebDriver initializeDriver(String browser) {
		WebDriver driverInstance;
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driverInstance = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driverInstance = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driverInstance = new EdgeDriver();
		}
		else {
			throw new IllegalArgumentException("Browser not found: " +browser);
		}
		setDriver(driverInstance);
		getDriver().manage().window().maximize();
		return driverInstance;
	}
	
	public static void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
		
	}

	public static WebDriver getDriver() {
		System.out.println("*************The driver value is *********" +driver);
		return driver.get();
	}

	public static void quitDriver() {
		getDriver().quit();
		driver.remove();
	}
}
