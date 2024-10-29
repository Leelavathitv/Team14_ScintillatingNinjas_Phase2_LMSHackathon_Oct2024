package pageObjects;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import utilities.ExcelFileReader;
import utilities.ResourceBundleReader;

public class LoginPage {
	
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	static Map<String, String> testData;
	ExcelFileReader excelReader;
	public static String UserName;
	public static String Password;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.resourceBundleReader = new ResourceBundleReader();
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	
	@FindBy(xpath = "//img[@class = 'images']")
	WebElement loginpage;
	
	@FindBy (tagName = "mat-card-content")
	WebElement loginPageContent;
	
	@FindBy(className = "images")
	WebElement logo;
	
	@FindBy (xpath ="//form[@class = 'ng-pristine ng-invalid ng-touched']")
	WebElement SigninContent;
	
	@FindBy (id = "username")
	WebElement userNameTextBox;
	
	@FindBy(id = "password")
	WebElement userPasswordTextBox;
	
	@FindBy(id = "mat-form-field-label-5")
	WebElement userPlaceHolder;
	
	@FindBy (xpath ="//div[@class = 'mat-form-field-infix ng-tns-c78-6']")
	WebElement passwordPlaceHolder;
	
	@FindBy (id = "login")
	WebElement loginBtn;
	
	@FindBy(xpath = "//mat-error[@class = 'mat-error ng-tns-c78-7 ng-star-inserted']")
	WebElement userErrorMessage;
	
	
	@FindBy(xpath = "//mat-error[@class = 'mat-error ng-tns-c78-8 ng-star-inserted']")
	WebElement passwordErrorMessage;
	
	
	public boolean validateLoginPage() {
		if(loginpage.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	public void invalidURLValidation() {
		
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
		
		if(httpURLConnection.getResponseCode() == 404) {
			System.out.println(url+"_"+httpURLConnection.getResponseMessage());
		}
		else {
			System.out.println(url+"_"+httpURLConnection.getResponseMessage()+"_"+"is a broken link");
		}
		
	}
	
	public String spellCheckloginPageContent() {
		String text = loginPageContent.getText().toString();
		return text;
	}
	
	public String verifyCompanyName() throws TesseractException {

		File screenShots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		ITesseract tesseract = new Tesseract();
		String text = tesseract.doOCR(screenShots);
		return text;

	}
	
	public File verifyLogoAlignment() throws IOException {

		String align = logo.getCssValue("text-align");
		String logofloat = logo.getCssValue("float");
		String loc = logo.getLocation().toString();
		String margin = logo.getCssValue("margin");
		System.out.println("Align: " + align + "Location: " + loc + "Margin: " + margin + "LogoFloat:" + logofloat);
		// add screenshot code
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotFileName = "Screenshot_VerifyLogoAlignment_" + timestamp + ".png";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Destfile = new File(resourceBundleReader.getCompanyLogoScreeshot()
				+ screenshotFileName);
		FileUtils.copyFile(screenshotFile, Destfile);

		return screenshotFile;
	}
	
	public String verifySignInContent() {
		String text = SigninContent.getText().toString();
		return text;
	}
	
	public boolean verifyTextBox() {
		if((userNameTextBox.isEnabled() && userNameTextBox.isDisplayed()) && (userPasswordTextBox.isDisplayed() && userPasswordTextBox.isEnabled())) {
			return true;
		}
		return false;
	}
	
	public String checkPlaceHolder1() {
		String value = userPlaceHolder.getText();
		return value;
	}
	public String checkPlaceHolder2() {
		String value = passwordPlaceHolder.getText();
		return value;
	}
	
	public boolean verifyLoginBtn() {
		if(loginBtn.isEnabled()) {
			return true;
		}
		return false;
	}
	
	public String checkUserErrorMsg() {
		return userErrorMessage.getText().toString();
	}
	
	public String checkpasswordErrorMessage() {
		return passwordErrorMessage.getText().toString();
	}
}