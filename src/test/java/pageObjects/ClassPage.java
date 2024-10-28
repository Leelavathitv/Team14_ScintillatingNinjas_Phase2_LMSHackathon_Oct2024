package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testContext.TestContext;
import utilities.ResourceBundleReader;

public class ClassPage {
	
	WebDriver driver;
//	TestContext testcontext;
	
	
	ResourceBundleReader resourceBundleReader;

	public ClassPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.resourceBundleReader = new ResourceBundleReader();
	}
	
	
	
	@FindBy(xpath = "//span[text()='Class']")
	WebElement classNavBarBtn;
	
	@FindBy(xpath = "//div[@*='signin-content']//div[text()=' Manage Class']")
	WebElement manageClassText;
	
	@FindBy (xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only'])")
	WebElement disabledDelIcon;
	
	
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	WebElement lmsSystem;
	
	@FindBy(xpath = "//button[@*='new']")
	WebElement addClassBtn;
	
	@FindBy(xpath = "//span[text()='Class Details']")
	WebElement classDetailsPopupHeading;
	
//	@FindBy(xpath = "//span[@*='pr_id_5-label']")
//	WebElement classdetailsDlgBox;
	@FindBy(xpath = "//input[contains(@class, 'p-dropdown-label') and contains(@class, 'p-inputtext')]")
	WebElement nameTextField;
	
	@FindBy(xpath = "//input[@*='classTopic']")
	WebElement topicTextField;
	
	@FindBy(xpath = "//input[@*='classDescription']")
	WebElement descriptionTextField;
	
	@FindBy(xpath = "//input[@placeholder='Select a Staff Name']")
	WebElement staffNameTextField;
	
	@FindBy(xpath = "(//div[@class='p-radiobutton-box'])[1]")
	WebElement statusActiveRadiobtn;
	
	@FindBy(xpath = "(//div[@class='p-radiobutton-box'])[2]")
	WebElement statusINactiveRadiobtn;
	
	@FindBy(xpath = "//div[@*='button']/span[1]") // dropdown is in second option place
	WebElement staffNameFieldDropDownBtn;
	
//	@FindBy(xpath = "//input[@id='ClassDate']") //unable to find as the dates popup
//	WebElement classDateField;
	@FindBy(xpath = "//button[@label='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//button[@label='Cancel']")
	WebElement cancelBtn;
	
	@FindBy(css = "span.p-dialog-header-close-icon.ng-tns-c132-50.pi.pi-times") // need clarity
	WebElement clearCrossBtn;

	@FindBy(xpath = "//input[@id='classDescription']")
	WebElement descriptionLabel;

//	@FindBy(css = "tbody.p-datatable-tbody tr")
//	List<WebElement> tableRowData;
	@FindBy(css = "//div[@role='checkbox' and contains(@class, 'p-checkbox')]")//showing multiple 
	List<WebElement> tableCellData;
	
	@FindBy(xpath = "//button[@class='p-paginator-next p-paginator-element p-link p-ripple']")
	WebElement nextPageBtn;
	//both next page xpath is for same.
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']")
	WebElement nextPageButton;
//	@FindBy(css = "tbody.p-datatable-tbody tr")
//	List<WebElement> CurrentRows;

	@FindBy(xpath = "//small[contains(@class, 'p-invalid') and contains(text(), 'Batch Name is required.')]")
	WebElement nameFieldErrorMsg;

	@FindBy(xpath = "//small[normalize-space()='Batch Name is required.']")
	WebElement nameErrorElement;

	@FindBy(xpath = "//small[normalize-space()='Class Topic is required.']")
	WebElement classTopicErrorElement;
	
	@FindBy(xpath = "//small[normalize-space()='Status is required.']")
	WebElement statusActiveErrorElement;
	
	@FindBy(xpath = "//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']")
	WebElement parentPaginators;
	
	@FindBy(xpath = "//span[@class='p-paginator-pages ng-star-inserted']/button")
	List<WebElement> noPaginators;


	@FindBy(xpath = "//button[contains(@class, 'p-button-danger')]")
	WebElement deleteButton; //how to choose first
	
	@FindBy(xpath = "//button[text()='Add New Class']")
	WebElement addNewclass;
	
	@FindBy(xpath = "//table[@role='grid']")
	WebElement tableBody;
	
	@FindBy(xpath = "//div[contains(@class, 'p-confirm-dialog')]")
	WebElement dialog;
	
	@FindBy(xpath = "//span[normalize-space()='Yes']")
	WebElement yesButton;
	
	@FindBy(xpath = "//button[contains(@class, 'p-confirm-dialog-reject')]")
	WebElement noButton;
	
	@FindBy(xpath = "//span[@class='p-button-icon pi pi-pencil']")
	WebElement editIcon;
	
	@FindBy(xpath = "//input[@id='filterGlobal']")
	WebElement searchBox;
	
	

	
	static Set<Cookie> allCookies;
	
	public void clickDashboardClass() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dashboardClass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Class']/..")));
		dashboardClass.click();

	
	}	
	public String manageClassgetText() {
		return manageClassText.getText();
	}
	
	public boolean deleteIconIsDisabled() {
		boolean isDisabled = disabledDelIcon.getAttribute("disabled") != null;
		return isDisabled;
	}
		
//		public boolean isPaginationEnabled() {
//			return paginationEnabled.isDisplayed();
//		}
		
		public String getActualTitle() {
			return driver.getTitle();
		}
		
		public void loginUsingCookies() {
			for(Cookie cookie: allCookies) {
				driver.manage().addCookie(cookie);
			}
			driver.navigate().to("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/");
		
	}
		public void searchBox() {
			searchBox.click();
		
		}
			
			public boolean clicksearchBox() {
				return searchBox.isDisplayed();
			}
}
