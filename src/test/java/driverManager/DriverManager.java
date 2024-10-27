package driverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	static {
	    WebDriverManager.chromedriver().setup();
	    WebDriverManager.firefoxdriver().setup();
	    WebDriverManager.edgedriver().setup();
	}

static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();
	
//	public static  WebDriver initializeDriver(String browser) {
//		WebDriver driverInstance;
//		if(browser.equalsIgnoreCase("Chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driverInstance = new ChromeDriver();
//		}
//		else if(browser.equalsIgnoreCase("Firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driverInstance = new FirefoxDriver();
//		}
//		else if (browser.equalsIgnoreCase("Edge")) {
//			WebDriverManager.edgedriver().setup();
//			driverInstance = new EdgeDriver();
//		}
//		else {
//			throw new IllegalArgumentException("Browser not found: " +browser);
//		}
//		setDriver(driverInstance);
//		getDriver().manage().window().maximize();
//		return driverInstance;
//	}
//	

public static WebDriver getDriver() {
    if (driver.get() == null) {
        String browser = System.getProperty("browser", "Chrome");
        driver.set(initializeDriver(browser));
    }
    return driver.get();
}

private static WebDriver initializeDriver(String browser) {
    WebDriver driverInstance;
    switch (browser.toLowerCase()) {
        case "chrome":
            WebDriverManager.chromedriver().setup();
            driverInstance = new ChromeDriver();
            break;
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driverInstance = new FirefoxDriver();
            break;
        case "edge":
            WebDriverManager.edgedriver().setup();
            driverInstance = new EdgeDriver();
            break;
        default:
            throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
    driverInstance.manage().window().maximize();
    driverInstance.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return driverInstance;
}

public static void quitDriver() {
    if (driver.get() != null) {
        driver.get().quit();
        driver.remove();
    }
}
}
