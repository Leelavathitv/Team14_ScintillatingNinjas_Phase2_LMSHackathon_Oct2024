package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ResourceBundleReader;
import utilities.CommonUtils;

public class ClassModPage {
	
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	CommonUtils utilsObj = new CommonUtils();

	public ClassModPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.resourceBundleReader = new ResourceBundleReader();
	}
	
	
	
	@FindBy(xpath = "//span[text()='Class']")
	WebElement classNavBarBtn;
	
	@FindBy(xpath = "//div[@*='signin-content']//div[text()=' Manage Class']")
	WebElement manageClassText;
	
	@FindBy (xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	WebElement disabledDelIcon;
		
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	WebElement lmsSystem;
	
	@FindBy(xpath = "//button[@*='new']")
	WebElement addClassBtn;
	
	@FindBy(xpath = "//span[text()='Class Details']")
	WebElement classDetailsPopupHeading;
	
	@FindBy(xpath = "//span[@*='pr_id_5-label']")
	WebElement classdetailsDlgBox;
	
	@FindBy(xpath = "//input[@placeholder='Select a Batch Name']")
	WebElement nameTextField;
	
	@FindBy(xpath = "//input[@*='classTopic']")
	WebElement topicTextField;
	
	@FindBy(xpath = "//input[@*='classDescription']")
	WebElement descriptionTextField;
	
	@FindBy(xpath = "//input[@placeholder='Select a Staff Name']")
	WebElement staffNameTextField;
	
	@FindBy(xpath = "//p-radiobutton[@ng-reflect-input-id= 'Active']")
	WebElement statusActiveRadiobtn;
	
	@FindBy(xpath = "//p-radiobutton[@ng-reflect-input-id= 'Inactive']")
	WebElement statusINactiveRadiobtn;
	
	@FindBy(xpath = "//div[@*='button']/span[1]") 
	WebElement staffNameFieldDropDownBtn;
	

	@FindBy(xpath = "//button[@label='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//button[@label='Cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//input[@id='classDescription']")
	WebElement descriptionLabel;


	@FindBy(xpath = "//button[contains(@class, 'p-button-danger')]")
	List<WebElement> deleteButton; 
	
	@FindBy(xpath = "//button[text()='Add New Class']")
	WebElement addNewclass;
	
	@FindBy(xpath = "//th[contains(text(), 'Edit / Delete')]")
	WebElement editandDeleteIcon;
	
	@FindBy(xpath = "//input[@id='filterGlobal']")
	WebElement searchBox;

	@FindBy(xpath = "//table/thead/tr/th[@class='p-sortable-column']")
	List<WebElement> headerTableList;
	

	@FindBy(xpath = "//table/thead/tr/th[@class='p-sortable-column']/p-sorticon")
	List<WebElement> headerSortList;
	
	@FindBy(xpath = "//span[contains(@class, 'p-paginator-current')]")
	List<WebElement> paginationEnabledList;
	
	@FindBy(xpath = "//span[contains(text(),'Class')]")
	WebElement dashboardClass;
	
		
	@FindBy(xpath = "//div[contains(text(), 'In total there are')]") 
    private WebElement totalClassesElement;

	
	static Set<Cookie> allCookies;
		
	public void clickDashboardClass() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dashboardClass.click();
	}	
		
	public List<String> getElementText() {
		List<String> headerListString = new ArrayList<String>();
		for (WebElement ele : headerTableList) {
			headerListString.add(ele.getText());
		}
		return headerListString;
	}
	
	
	public String manageClassgetText() {
		return manageClassText.getText();
	}
	
	public boolean deleteIconIsDisabled() {
		return !utilsObj.isEnabled(disabledDelIcon);
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
		
		public String getActualTitle() {
			return driver.getTitle();
		}
		
		public boolean editIconEnable() {
			return editandDeleteIcon.isEnabled();
		}
	
		public String addNewClass() {
			return addNewclass.getText();
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
		
		
		public boolean verifydeletebtn() {
			boolean isPresent = true;
			for (WebElement delIcon : deleteButton) {
				isPresent = delIcon.isDisplayed();
			}
			return isPresent;
		}

		public void loginUsingCookies() {
			for (Cookie cookie : allCookies) {
				driver.manage().addCookie(cookie);
			}
			driver.navigate().to("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/");

		}

		public boolean getDisplayedTotalClasses() {
			return totalClassesElement.isDisplayed();
		}

		public boolean clicksearchBox() {
			return searchBox.isDisplayed();
		}

		public List<String> getTableHeader() {

			return null;
		}

	}
