package pageObjects;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Pagination;
import utilities.ResourceBundleReader;

public class Program2Page {
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;	
	List<String> programNames;
	Pagination pg;
	
	public Program2Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.resourceBundleReader = new ResourceBundleReader();
	}

	
   
	//--------------delete program--------------
	@FindBy(xpath = "//button[@id='program']")
	WebElement pgm;
	//@FindBy(className="signin-content")
	@FindBy(xpath = "//body") // Example using XPath
	WebElement pgmClickOutside;	
	@FindBy(xpath = "(//span[contains(@class,'trash')]//parent::button)[1]")
	WebElement deleteMultiple;
	@FindBy(xpath="//span[text()='Confirm']")
	public WebElement confirmDeletion;
	@FindBy(xpath="//span[text()='Yes']//parent::button")
	public WebElement deleteYes;
	
	
    @FindBy(xpath = "//div[contains(@class,'toast-summary')]")
    private WebElement deletedMsgToastSummary;

    @FindBy(xpath = "//div[contains(@class,'toast-detail')]")
    private WebElement deletedMsgToastDetail;
	
	@FindBy(id="filterGlobal") 
	public WebElement searchPgm;
//	@FindBy(className="p-paginator-current ng-star-inserted")
//	public WebElement zeroResult;
	@FindBy(xpath="//div[@class='p-checkbox-box p-component'][1]")
	public WebElement checkDeletion;
	@FindBy(xpath="//span[text()='No']//parent::button")
	public WebElement deleteNo;
	@FindBy(xpath="//button[contains(@class, 'dialog-header-close')]")
	public WebElement clickXtoClose;
//	@FindBy(className="p-dialog-header ng-tns-c204-32 ng-star-inserted")
//	public WebElement confirmDialog; 
	@FindBy(xpath="//tbody[contains(@class,'datatable')]/tr/td/following-sibling::td[1]")
	public WebElement pgmName;

	@FindBy(xpath="//tbody[contains(@class,'datatable')]/tr/td/following-sibling::td[2]")
	public WebElement pgmDesc;
	
	@FindBy(xpath="//tbody[contains(@class,'datatable')]/tr/td/following-sibling::td[3]")
	public WebElement pgmStatus;

	public void click_element_with_timeout(WebDriver driver, int timeout, String xpath) {
		
		Actions action = new Actions(this.driver);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement elem_name = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));	    
		elem_name.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));

	}

    public boolean checkConfirmDeletion() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(confirmDeletion));
            return confirmDeletion.isDisplayed();
        } catch (Exception e) {
            // Handle any exceptions (e.g., NoSuchElementException, TimeoutException)
            return false;
        }
    }
	
	public void confirmationDialog()
	{
    // Validate that the confirmation dialog is no longer visible
    boolean isDialogPresent = driver.findElements(By.xpath("//span[text()='Confirm']")).size() == 0 ;

    if (!isDialogPresent) {
        System.out.println("Confirmation dialog has disappeared.");
    } else {
        System.out.println("Confirmation dialog is still present.");
    }
	}
	
	
	public void openMenu() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement programModule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='program']")));
	    programModule.click();	    
	}
	
	public void closeMenu() {
		pgmClickOutside.click(); // click body, to close program menu.
	}
	

	public void clickSingleDelete(String programName)
	{		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='"+ programName +"']/following-sibling::td/div/span/button[contains(@id,'deleteProgram')]")));
	    deleteButton.click();		
    }
	
	public String getProgramDescription(WebElement s) {
		String progDesc = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return progDesc;
	}

	public String getProgStatus(WebElement s) {
		String progStatus = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return progStatus;
	}

	public void searchProgram(String searchString) {
        try {
        	searchPgm.sendKeys(searchString);       	
        } catch (NoSuchElementException e) {
        	System.out.println("Program not found: " + searchString);

        } catch (Exception e) {
            System.out.println("An error occurred while trying to delete " + searchString + ": " + e.getMessage());

        }
	    
	}

	public boolean isSearchProgramNameSuccessful(String programName) {
    	return programName.equals(pgmName.getText());
	}
	
	public boolean isSearchProgramDescSuccessful(String programDesc) {
    	return programDesc.equals(pgmDesc.getText());
	}
	
	public void deleteSingleProgramWithName(String programName) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
        	searchPgm.sendKeys(programName);        	
            this.clickSingleDelete(programName); // deleting the appropriate program one at a time.        
        } catch (NoSuchElementException e) {
        	System.out.println("Program not found: " + programName);
        } catch (Exception e) {
            System.out.println("An error occurred while trying to delete " + programName + ": " + e.getMessage());
        }	       
	    
	}

	public void deleteMultipleProgramsWithName(String[] programNames) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    for (String programName : programNames) {
	        try {
	        	searchPgm.sendKeys(programName);	        	
	            // Locate the delete button for the program based on its name
	            WebElement selectProgram = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//td[text()='" + programName + "']/preceding-sibling::td//div")
	            ));
	            selectProgram.click();	            
	            
	            //searchPgm.clear(); // clear is not clearing the form.
	            // Select all text with Ctrl+A and then delete
	            searchPgm.sendKeys(Keys.CONTROL, "a"); // For Windows/Linux
	            // searchPgm.sendKeys(Keys.COMMAND, "a"); // For Mac
	            searchPgm.sendKeys(Keys.DELETE);

	            // Wait until the input field is empty
	            WebDriverWait waitForNewSearch = new WebDriverWait(driver, Duration.ofSeconds(10));
	            waitForNewSearch.until(ExpectedConditions.textToBePresentInElementValue(searchPgm, ""));
	            
	        } catch (NoSuchElementException e) {
	        	System.out.println("Program not found: " + programName);
	        } catch (Exception e) {
	            System.out.println("An error occurred while trying to delete " + programName + ": " + e.getMessage());
	        }	       
	    }
	    deleteMultiple.click();
	}

	public void selectMultipleProgramsWithCheckBox() {
        
        List<WebElement> CheckBoxElements = driver.findElements(By.xpath("//div[@role='checkbox']"));
        for (int i=1; i<CheckBoxElements.size(); i++) { //staring from index 1, to avoid master checkbox selection.
        	WebElement checkBox = CheckBoxElements.get(i);
	        try {
	        	checkBox.click();
	        	
	        } catch (NoSuchElementException e) {
	        	System.out.println("CheckBox not clickable ");
	        } catch (Exception e) {
	            System.out.println("An error occurred while trying to click checkbox for Program : " + e.getMessage());
	        }       
        	        	
        }           
              
	}

	
	public boolean checkMultipleProgramsSelectedWithCheckBox() {
		this.programNames = new ArrayList<>();
		
        List<WebElement> CheckBoxElements = driver.findElements(By.xpath("//div[@role='checkbox']"));
        for (int i=1; i<CheckBoxElements.size(); i++) { //staring from index 1, to avoid master checkbox selection.
        	WebElement checkBox = CheckBoxElements.get(i);
	        try {
	        	if (!checkBox.isEnabled()) { 
	        		return false;
	        	}
	        	else
	        	{
	                String programName = checkBox.findElement(By.xpath("ancestor::tr/td[2]")).getText();
	                System.out.println("Program name: " + programName); // Print the program name
	                programNames.add(programName); 
	        	}
	        	
	        } catch (NoSuchElementException e) {
	        	System.out.println("CheckBox not clickable ");
	        } catch (Exception e) {
	            System.out.println("An error occurred while trying to click checkbox for Program : " + e.getMessage());
	        }       
        	        	
        }
        return true;
              
	}
	
	public void printSelectedCheckBoxProgramNames() {
	    System.out.println("Selected Program Names:");
	    for (String name : programNames) {
	        System.out.println(name); // Process or print each program name
	    }
	}
	
	public void confirmDeletionYes()
	{
		 deleteYes.click();
	}
	
	public void clickDeleteLeftTopButton()
	{
		 deleteMultiple.click();
	}


	public void confirmDeletionNo()
	{
		 deleteNo.click();
         try {
             Thread.sleep(100); // Wait for 100 milliseconds (adjust as needed, sometimes browser is slow to respond.)
         } catch (InterruptedException e) {
             e.printStackTrace();
         }  
	}

	public void confirmDeletionClickClose()
	{
		clickXtoClose.click();
        try {
            Thread.sleep(100); // Wait for 100 milliseconds (adjust as needed, sometimes browser is slow to respond.)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
	}

	
	public boolean isAlertPresent(WebDriver driver, Duration timeout) {
	    try {
	        // Create a WebDriverWait instance with Duration
	        WebDriverWait wait = new WebDriverWait(driver, timeout);
	        
	        // Wait until an alert is present
	        wait.until(ExpectedConditions.alertIsPresent());
	        
	        // If alert is present, switch to it
	        driver.switchTo().alert();
	        return true;
	    } catch (NoAlertPresentException e) {
	        return false;
	    }
	}
	
    public boolean isProrgramDeleted() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(deletedMsgToastSummary));
            wait.until(ExpectedConditions.visibilityOf(deletedMsgToastDetail));
            
            return deletedMsgToastSummary.getText().equals("Successful") && 
            		(deletedMsgToastDetail.getText().equals("Program Deleted") || deletedMsgToastDetail.getText().equals("Programs Deleted"));
        } catch (Exception e) {
            return false; // Handle exceptions (e.g., element not found, timeout)
        }
    }
	
    public String  isProgramDeletedSuccessfully() {
        if (isProrgramDeleted()) {
            return "Successful Program Deleted";
        } else {
            return "Program Deletion Failed";
        }
    }
    
	public void deleteNo()
	{
		deleteNo.click();
	}
	
	public void searchPgm()
	{
		searchPgm.click();
    } 
	public void checkDeletion()
	{
		checkDeletion.click();
	}
	
//	public void clickX()
//	{
//		clickX.click();
//	}
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