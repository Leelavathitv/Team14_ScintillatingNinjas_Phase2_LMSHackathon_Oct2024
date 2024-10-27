package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ResourceBundleReader;
public class Program2Page {
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;

    public Program2Page(WebDriver driver) {
    	System.out.println(" Program2Page constructor");
//    	if (driver == null) {
//    		System.out.println("Program2Page::WebDriver is null");    		
//            //throw new IllegalStateException("WebDriver is not initialized");
//        }    	
//    	else {this.driver = driver;}
    	this.driver=driver;
    	//PageFactory.initElements(this.driver, this); // Initialize the elements
        this.resourceBundleReader = new ResourceBundleReader();
    }
	
	public void click_element_with_timeout(WebDriver driver, int timeout, String xpath) {
		
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//		WebElement Tryhere = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Try here>>>")));
		//Tryhere.click();
		Actions action = new Actions(this.driver);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement elem_name = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));	    
		//action.scrollToElement(elem_name);
		//action.scrollToElement(elem_name).perform();
		elem_name.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));

		
	}
    
	//--------------delete program--------------
	@FindBy(xpath = "//button[@id='program']")
	WebElement pgm;
	//@FindBy(className="signin-content")
	@FindBy(xpath = "//button[@id='program']") // Example using XPath
	WebElement pgmClick;	
	@FindBy(xpath = "//button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only'])[1]")
	WebElement deletePgm;
	@FindBy(xpath="//span[text()='Confirm']")
	public WebElement confirmDeletion;
	@FindBy(xpath="//div[@class='p-dialog-footer ng-tns-c204-32 ng-star-inserted']//span[contains(@class, 'p-button-label')and text()='Yes']")
	public WebElement deleteYes;
	@FindBy(id="filterGlobal") 
	public WebElement searchPgm;
	@FindBy(className="p-paginator-current ng-star-inserted")
	public WebElement zeroResult;
	@FindBy(xpath="//div[@class='p-checkbox-box p-component'][1]")
	public WebElement checkDeletion;
	@FindBy(xpath="//div[@class='p-dialog-footer ng-tns-c204-32 ng-star-inserted']//span[contains(@class, 'p-button-label')and text()='No']")
	public WebElement deleteNo;
	@FindBy(className="ng-tns-c204-32 p-dialog-header-icon p-dialog-header-close p-link ng-star-inserted")
	public WebElement clickX;
	@FindBy(className="p-dialog-header ng-tns-c204-32 ng-star-inserted")
	public WebElement confirmDialog; 
	
	public void confirmationDialog()
	{
    // Validate that the confirmation dialog is no longer visible
    boolean isDialogPresent = driver.findElements(By.className("p-dialog-header ng-tns-c204-32 ng-star-inserted")).size() > 0 ;

    if (!isDialogPresent) {
        System.out.println("Confirmation dialog has disappeared.");
    } else {
        System.out.println("Confirmation dialog is still present.");
    }
	}
	
//	public void login()
//	{
//		username.sendKeys("Sdet@gmail.com");
//		password.sendKeys("LmsHackathon@2024");
//		login.click();
//	}

	
	public void programModulePage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement programModule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='program']")));
	    programModule.click();	        
		//this.click_tryhere_with_timeout(this.driver, 10, programModulePage);
	    //programModulePage.click();
	}
	
    public void programClick()
    {
    	//programClick.click();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement programClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body")));
        //pgmClick.click();
        
        this.click_element_with_timeout(this.driver, 5, "//body");
	
    }
	public void deletePgm()
	{
		
		this.click_element_with_timeout(this.driver, 30, "//td[contains(text(),'sdetprogram')]//following-sibling::td//button[contains(@id,'deleteProgram')]");
    } 
	public void searchPgm()
	{
		searchPgm.click();
    } 
	public void checkDeletion()
	{
		checkDeletion.click();
	}
	public void deleteYes()
	{
		 deleteYes.click();
	}
	public void deleteNo()
	{
		deleteNo.click();
	}
	public void clickX()
	{
		clickX.click();
	}
	//-----------------Delete Multiple Program-----------
	
	@FindBy(xpath="//span[@class='p-button-icon pi pi-trash'][1]")
	public WebElement deleteButton;
	
	public void deleteButton()
	{
		deleteButton.click();
	}
	
	public void clickCheckBox()
	{
    // Locate multiple checkboxes by their common class name
    List<WebElement> checkboxes = driver.findElements(By.className("p-checkbox-box p-component")); // Change to actual class

    // Iterate through the list of checkboxes
    for (WebElement checkbox : checkboxes) {
        // Check if the checkbox is selected
        if (!checkbox.isSelected()) {
            checkbox.click(); // Select the checkbox if it's not already selected
            System.out.println("Selected a checkbox.");
        } else {
            System.out.println("Checkbox was already selected.");
        }
    }
	
//
//    // Optionally, deselect all checkboxes
//    for (WebElement checkbox : checkboxes) {
//        if (checkbox.isSelected()) {
//            checkbox.click(); // Deselect the checkbox
//            System.out.println("Deselected a checkbox.");
//        }
//    }
	}
	//-------------search-----------
//	ProgramPage programPage; // Assume you have a page object for program interactions
//
//    @Then("Admin should be able to see the program name {string}")
//    public void adminShouldSeeProgramName(String programName) {
//        String displayedName = programPage.getProgramName();
//        assertEquals("Program name does not match.", programName, displayedName);
//    }
//
//    @Then("Admin should see the description for {string}")
//    public void adminShouldSeeDescription(String programName) {
//        String expectedDescription = "Expected description for " + programName; // Replace with actual expected value
//        String actualDescription = programPage.getProgramDescription();
//        assertEquals("Program description does not match.", expectedDescription, actualDescription);
//    }
//
//    @Then("Admin should see the status for {string}")
//    public void adminShouldSeeStatus(String programName) {
//        String expectedStatus = "Expected status for " + programName; // Replace with actual expected value
//        String actualStatus = programPage.getProgramStatus();
//        assertEquals("Program status does not match.", expectedStatus, actualStatus);
//    }
//	
	
	//-----Sorting Program-------
	
	public void checkSorting()
	{
    // Check for Descending Order Icon
    boolean isDescending = driver.findElements(By.xpath("//span[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-down']")).size() > 0;

    // Check for Ascending Order Icon
    boolean isAscending = driver.findElements(By.xpath("//span[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']")).size() > 0;
    

    if (isDescending) {
        System.out.println("The column is sorted in descending order.");
    } else if (isAscending) {
        System.out.println("The column is sorted in ascending order.");
    } else {
        System.out.println("The column is not sorted.");
    }

	}

	
	

   

}
