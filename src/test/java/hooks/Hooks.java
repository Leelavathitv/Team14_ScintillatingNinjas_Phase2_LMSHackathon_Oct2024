package hooks;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import driverManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.qameta.allure.Allure;


public class Hooks {
	WebDriver driver;
	@Before
	public void setUp() {
		String browser = System.getProperty("browser","Chrome");
		driver = DriverManager.initializeDriver(browser);
//	System.out.println("*******Driver value in hooks*******" +driver);
	}
	
	@After
	public void getScreenShot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			String scenarioName = scenario.getName();
			Status scenarioStatus = scenario.getStatus();
			scenario.log("Scenario Name: " + scenarioName);
			scenario.log("Scenario Status: " + scenarioStatus);
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
			String dir = System.getProperty("user.dir");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		     String timestamp = sdf.format(new Timestamp(System.currentTimeMillis()));
//				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				String path =  dir +"/src/test/resources/Screenshot/"+scenarioName+"_"+timestamp+".jpeg";
				File desFile = new File(path);
				FileUtils.copyFile(srcFile, desFile);
		    Allure.attachment("FailedScreenshot", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
		
	}
	}
		
	@After
	public void tearDown() {
		DriverManager.quitDriver();
	}
	
}
