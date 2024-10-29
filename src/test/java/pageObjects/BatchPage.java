package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverManager.DriverManager;
import utilities.CommonUtils;
import utilities.Pagination;
import utilities.ResourceBundleReader;

public class BatchPage {

	WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	CommonUtils utilsObj = new CommonUtils();
	Pagination pageObj;
	
	public BatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.resourceBundleReader = new ResourceBundleReader();
	}

	@FindBy(xpath = "//*[text()='Batch']/..")
	WebElement dashboardBatch;

	@FindBy(xpath = "//div[text()=' Manage Batch']")
	WebElement manageBatch;

	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	WebElement disbaledDeleteIcon;

	@FindBy(xpath = "//th[text()=' Edit / Delete ']")
	WebElement editandDeleteIcon;

	@FindBy(xpath = "//div[@class='p-checkbox p-component']")
	List<WebElement> checkboxList;

	@FindBy(xpath = "//div[@class='p-datatable p-component p-datatable-hoverable-rows']/p-paginator/div/button")
	List<WebElement> paginationEnabledList;

	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	WebElement manageSystem;

	@FindBy(xpath = "//button[text()='Add New Batch']")
	WebElement addNewBatch;

	@FindBy(xpath = "//table/thead/tr/th[@class='p-sortable-column']")
	List<WebElement> headerTableList;

	@FindBy(xpath = "//table/thead/tr/th[1]")
	WebElement headercheckbox;

	@FindBy(xpath = "//table/thead/tr/th[@class='p-sortable-column']/p-sorticon")
	List<WebElement> headerSortList;

	// @FindBy(xpath = "//input[@id='filterGlobal']")
	@FindBy(xpath = "//span[@class='p-input-icon-left']/input")
	WebElement searchBox;

	// @FindBy(xpath = "(//tbody[@class='p-datatable-tbody']/tr/td)[3]")
	@FindBy(xpath = "(//tbody/tr/td)[2]")
	WebElement searchTextEnter;

	@FindBy(xpath = "//div[@class='ng-star-inserted']/button/span[text()='Logout']")
	WebElement logout;

	@FindBy(xpath = "//span[contains(@class,'angle-right')]/parent::button[contains(@class,'next')]")
	WebElement nextPageIcon;

	public boolean CheckboxesPresentEachRow() {
		boolean isPresent = true;
		for (WebElement eachcheckbox : checkboxList) {
			isPresent = eachcheckbox.isDisplayed();
			if (!isPresent)
				break;
		}
		return isPresent;
	}

	//static Set<Cookie> allCookies;

	public void clickDashboardBatch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dashboardBatch = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Batch']/..")));
		dashboardBatch.click();
	}

	public String manageBatchgetText() {
		return manageBatch.getText();
	}

	public boolean deleteIconIsDisabled() {
		return !utilsObj.isEnabled(disbaledDeleteIcon);
	}

	public boolean isPaginationEnabled() {
		boolean isPresent = true;
		for (WebElement sortIcon : paginationEnabledList) {
			isPresent = sortIcon.isDisplayed();
			if (!isPresent)
				break;
		}
		return isPresent;
	}

	public boolean editIconEnable() {
		return editandDeleteIcon.isEnabled();
	}

	public boolean deleteIconEnable() {
		return editandDeleteIcon.isEnabled();
	}

	public void clickaddNewBatch() {
		addNewBatch.click();
	}

	public String getTextNewBatch() {
		return addNewBatch.getText();
	}

	public List<String> getElementText() {
		List<String> headerListString = new ArrayList<String>();
		for (WebElement ele : headerTableList) {
			headerListString.add(ele.getText());
		}
		return headerListString;
	}

	public boolean headerCheckboxVisible() {
		return utilsObj.isDisplayed(headercheckbox);
	}

	public boolean verifyHeaderSortPresence() {
		boolean isPresent = true;
		for (WebElement sortIcon : headerSortList) {
			isPresent = sortIcon.isDisplayed();
			if (!isPresent)
				break;
		}
		return isPresent;
	}

	public void searchBoxfilter() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchBox);
		searchBox.sendKeys("Playwright");
	}

	public boolean searchGetText() {
		return searchTextEnter.isDisplayed();
		// return searchTextEnter.getText();
	}

	public String getActualTitle() {
		return driver.getTitle();
	}

	public void clickLogout() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.elementToBeClickable(logout));
//		logout.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    WebElement logoutModule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='logout']")));
		    logoutModule.click();	    
	}

	public String getActualTextLogout() {
		return logout.getText();
	}

//	public void nextPageClicks() {
//		nextPageIcon.click();
//	}
//	public void waitForElementToBeClickable(WebElement element) {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	    wait.until(ExpectedConditions.elementToBeClickable(element));
//	}
	


//	public void nextPageClicks() throws InterruptedException
//	{                                                         //span[contains(@class,'angle-right')]/parent::button[contains(@class,'next')]")
//		//WebElement nextButton = driver.findElement(By.xpath("//span[contains(@class,'angle-right')]/parent::button[contains(@class,'next')]"));
//		Thread.sleep(1000);
//		
//		
//		//waitForElementToBeClickable(nextPageIcon);
//		
////		WebElement nextButton = new WebDriverWait(driver, Duration.ofSeconds(10))
////		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'angle-right')]/parent::button[contains(@class,'next')]")));
////		nextButton.click();
//
//		//nextPageIcon.click();
//		
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextPageIcon);
//	}

//	public void loginUsingCookies() {
//		for (Cookie cookie : allCookies) {
//			driver.manage().addCookie(cookie);
//		}
//		driver.navigate().to("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/");
//	}
}