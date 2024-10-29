package pageObjects;

import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mongodb.client.model.geojson.Position;

import utilities.ExcelFileReader;
import utilities.ResourceBundleReader;

public class DashboardPage {
	
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	static Map<String, String> testData;
	ExcelFileReader excelReader;
	public static String UserName;
	public static String Password;
	WebDriverWait wait;
	
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.resourceBundleReader = new ResourceBundleReader();
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy (id = "username") 
	WebElement inputUserName;
	
	@FindBy (id = "password")
	WebElement inputPassword;
	
	@FindBy (id = "login")
	WebElement submitBtn;
	
	@FindBy (xpath = "//span[contains(text(),' LMS - Learning Management System ')]")
	WebElement PageHeader;
	
	@FindBy (xpath = "//mat-toolbar[@class = 'mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']")
	WebElement header;
	
	@FindBy (tagName = "mat-toolbar")
	WebElement dashBoardPage;
	
	
	public void login(String username, String password) {
		inputUserName.sendKeys(username);
		inputPassword.sendKeys(password);
		submitBtn.click();
	}
	
	public void loginUsingKeys(String username, String password) {
		inputUserName.sendKeys(username);
		inputPassword.sendKeys(password);
		submitBtn.sendKeys(Keys.ENTER);
	}
	
	
	public String assertingDashboard() {
		return PageHeader.getText();
	}
	
	public void validLogin() {
		inputUserName.sendKeys(resourceBundleReader.getUserName());
		inputPassword.sendKeys(resourceBundleReader.getPassword());
		submitBtn.click();
	}
	
	public void noValueLogin() {
		inputUserName.sendKeys();
		inputPassword.sendKeys();
		submitBtn.click();
	}

	public String verifyTitle() {
		return driver.getTitle();
	}

	public boolean responseTime() {
		
		
		inputUserName.sendKeys(resourceBundleReader.getUserName());
		inputPassword.sendKeys(resourceBundleReader.getPassword());
		long start = System.currentTimeMillis();
		submitBtn.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(PageHeader));
		long finish = System.currentTimeMillis();
		long responseTime = finish - start;
		long maxTime = 30000;
		System.out.println("Response time: " +responseTime);
		if (responseTime < maxTime) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void brokenLinks() {
		
		List<WebElement> links = driver.findElements(By.tagName("link"));
		
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			try {
				verifyLink(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void verifyLink(String url) throws IOException {
		
		URL link = new URL(url);
		HttpURLConnection httpURLConnection  = (HttpURLConnection)link.openConnection();
		httpURLConnection.setConnectTimeout(3000);
		httpURLConnection.connect();
		
		if(httpURLConnection.getResponseCode() == 200) {
			System.out.println(url+"_"+httpURLConnection.getResponseMessage());
		}
		else {
			System.out.println(url+"_"+httpURLConnection.getResponseMessage()+"_"+"is a broken link");
		}
		
	}
	
	public String spellCheckOfTitle() {
		String header = dashBoardPage.getText().toString();
		return header;
	}
	
	
	
	public boolean isChecked() {
		
		List <WebElement> list = driver.findElements(By.xpath("//div[@class='p-checkbox p-component']"));
		for (WebElement ele : list)
		
		if(ele.isSelected()) {
			return true;
		}
		else {
			return false;
		}
		return false;
	}
	
	public String HeaderSpellCheck() {
		return PageHeader.getText().toString();
	}
	
	public void CheckAlignmentOfNavBar() {
		int windowWidth = driver.manage().window().getSize().getWidth();
		List <WebElement> NavItems = driver.findElements((By.cssSelector(".matf-toolbar button")));
		for(WebElement navMenu : NavItems) {
			Point location = navMenu.getLocation();
			int itemXcoordinate = location.getX();
			Assert.assertTrue(itemXcoordinate > windowWidth * 0.75, "The navigation bar is alogned to the right");
		}
		
	}
	public  void OrderOFNavBar() {
		List <WebElement> menuBar = driver.findElements(By.xpath("//app-header//div[@class = 'ng-star-inserted']//button"));
		String[] expectedOrder = {"Program", "Batch", "Class", "Logout"};
		for (int i = 0; i  < menuBar.size(); i++) {
			String menuTxt = menuBar.get(i).getText();
			if(menuTxt.equalsIgnoreCase(expectedOrder[i])){
				System.out.println("The menu " +menuTxt+"is in the position: " +i);
				
			}
		}
		
	}
	
	public String checkLeftPosition() {
		Point location = header.getLocation();
		@SuppressWarnings("unused")
		String position;
        int xPosition = location.getX();
        int yPosition = location.getY();
        
        int threshold = 10;
        if (xPosition <= threshold && yPosition <= threshold) {
        	position = "Left";
        	System.out.println("The header is aligned to the  left");
        }
        else {
        	position = "No Left";
        	System.out.println("The header is not aligned left");
        }
        return position;
	}
	
}