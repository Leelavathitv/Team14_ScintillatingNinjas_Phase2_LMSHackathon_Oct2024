package utilities;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pagination {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	@FindBy(xpath="//p-paginator/div/span[1]") WebElement paginationString;
	@FindBy(xpath="//div[@class='p-datatable-footer ng-star-inserted']/div") WebElement pageFooter;
	@FindBy(xpath="//span[@class='p-paginator-pages ng-star-inserted']/button")List<WebElement> paginationNumbers;
	@FindBy(xpath="//span[@class='p-paginator-pages ng-star-inserted']//button[contains(@class,'highlight')]")WebElement currentPage;
	@FindBy(xpath="//span[@class='p-paginator-pages ng-star-inserted']/button[1]") WebElement firstPage;
	
	@FindBy(xpath ="//span[contains(@class,'angle-left')]/parent::button[contains(@class,'prev')]") WebElement previousPageIcon;
	@FindBy(xpath = "//span[contains(@class,'angle-right')]/parent::button[contains(@class,'next')]") WebElement nextPageIcon;
	@FindBy(xpath = "//span[contains(@class,'angle-double-right')]/parent::button") WebElement lastPageIcon;
	@FindBy(xpath = "//span[contains(@class,'angle-double-left')]/parent::button") WebElement firstPageIcon;
	@FindBy (xpath = "//button[contains(@class,'paginator-next')]")
	WebElement nextIcon;
	
	@FindBy (xpath = "//button[@class = 'p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']")
	WebElement lastIcon;
	
	@FindBy (xpath = "//button[@class = 'p-paginator-next p-paginator-element p-link p-ripple p-disabled']")
	WebElement checkNextIcon;	
	
	@FindBy (xpath = "//button[@class = 'p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']")
	WebElement firstpage;

	String totalRecords;
	
	public Pagination(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}

	//Total Records
	public int extractTotalProgramFromFooter()
	{
		totalRecords = (pageFooter.getText()).replaceAll("[^0-9]","");
		return Integer.parseInt(totalRecords);
	}
	
	public boolean isPrevPageIconDisplayed()
	{
		if(previousPageIcon.isDisplayed()) 
			return true;
		else
			return false;
			
	}
	
	public boolean isNextPageIconDisplayed()
	{
		if(nextPageIcon.isDisplayed()) 
			return true;
		else 
			return false;
	}
	

	public boolean isFirstPageIconDisplayed()
	{
		if(firstPageIcon.isDisplayed()) 
			return true;
		else 
			return false;
			
	}


	public void waitForElementToBeClickable(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void nextPageClick()
	{
		waitForElementToBeClickable(nextPageIcon);
		nextPageIcon.click();
	}
		

	

	public void lastPageClick()
	{
		waitForElementToBeClickable(lastPageIcon);
		lastPageIcon.click();
	}
	
	public void firstPageClick()
	{
		waitForElementToBeClickable(firstPageIcon);
		firstPageIcon.click();		
	}
	
	public boolean isLastPageIconDisplayed()
	{
		if(lastPageIcon.isDisplayed()) 
			return true;
		else 
			return false;			
	}
	
	public boolean isPreviousLinksDisabled()
	{
		firstPage.click();
		if((!previousPageIcon.isEnabled()) &&(!firstPageIcon.isEnabled()))
			return true;
		else 
			return false;
	}
	
	public boolean isNextLinksDisabled()
	{
		int lastRecord = paginationNumbers.size();
		WebElement lastPage = driver.findElement(By.xpath("//button[normalize-space()='"+lastRecord+"']"));
		lastPage.click();
		
		if((!lastPageIcon.isEnabled()) &&(!nextPageIcon.isEnabled()))
			return true;
		else 
			return false;
	}
	

	public int getSelectedPageNumber() {
		int currentPageNumber=Integer.parseInt(currentPage.getText().trim());
		return currentPageNumber;
	}
	
	public boolean isPreviousPageFromLastPageDisplayed()
	{
		//Identify last page number
		int lastRecord = paginationNumbers.size();
		//last page number -1 should be my current page number
	    int expectedpagenumber=lastRecord-1;	    
	    if(expectedpagenumber==getSelectedPageNumber())
	    	return true;
	    else
	    	return false;	    
	}

	//Pagination Footer 
	public boolean verifyFooterText(String moduleName)
	{
		String actualFooterText = pageFooter.getText();
		String expectedFooterText = "In total there are "+totalRecords+" "+moduleName+ " ";
		
		if(actualFooterText.equals(expectedFooterText))
			return true;
		else
			return false;
	}
	
	public boolean checkForNoProgramRecords() {
		int totalProgramRecord = extractTotalProgramFromFooter();
		if (totalProgramRecord==0)
			return true;
		else
			return false;
	}

	public void clickPreviousPageIcon() {
		focusAndClick(previousPageIcon);
	}
	
    public void focusAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait for the element to be visible
        wait.until(ExpectedConditions.visibilityOf(element));
        
        // Create an Actions object
        Actions actions = new Actions(driver);
        
        // Move to the element to focus on it and then click
        actions.moveToElement(element).click().perform();
    }
	
	public boolean checkIsNextPageDisabled() {
		if(checkNextIcon.isEnabled()) {
			System.out.println("Next Page icon is enabled");
			return false;
		}
		else {
			System.out.println("Next Page icon is diabled");
			return true;
		}
	}
	

	public boolean clickPage(WebElement element) {
		try {
	        
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        element.click();
	        System.out.println("The element clicked successfully");
	        
	        return true;
	    } catch(Exception e){
	        return false;
	    }
		}

	public WebElement getNextIcon() {
		return nextIcon;
	}
	
	public WebElement getfirstpage() {
		return firstpage;
	}
	
	public void getfirstPage() {
		firstPage.click();
	}

	public WebElement getLastIcon() {
		return lastIcon;
	}



}

