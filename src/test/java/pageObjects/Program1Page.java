package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import static org.testng.Assert.assertEquals;

import utilities.ExcelFileReader;
import utilities.LoggerLoad;
import utilities.ResourceBundleReader;

public class Program1Page {
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;

	List<String> actualModules;

	public Program1Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.resourceBundleReader = new ResourceBundleReader();
	}

	@FindBy(xpath ="//span[@class='mat-button-wrapper']")
	List<WebElement> modules;

	@FindBy(tagName ="link")
	List<WebElement> links;

	@FindBy(xpath ="//span[contains(text(), 'LMS')]")
	WebElement dashBoard_LMS;

	@FindBy(xpath ="//button[@role='menuitem']")
	WebElement submenu_module;

	@FindBy(xpath ="//*[@class='mat-card-title']/div[1]")
	WebElement subTitle_anyModule;

	@FindBy(xpath ="//button[@icon='pi pi-trash']")
	WebElement trashButn;	

	@FindBy (id = "program") 
	WebElement program;

	@FindBy(xpath = "//button[text()='Add New Program']")
	WebElement addNewProgram;

	@FindBy(xpath = "//div/span[contains(text(), 'Program Details')]")
	WebElement titleProgramDetails;

	@FindBy(xpath = "//button[contains(@class, 'p-dialog-header-close')]")
	WebElement closeButton;

	@FindBy(xpath = "//button/span[text()='Cancel']")
	WebElement cancelButton;

	@FindBy(xpath = "//span[text()='*']")
	List<WebElement> asteriskList;


	@FindBy (id = "programName")
	WebElement programName;

	@FindBy (id = "programDescription")
	WebElement programDesc;

	@FindBy (xpath = "//div[@class='radio ng-star-inserted']/div[2]")
	WebElement activeProgramStatus;

	@FindBy (id ="saveProgram")
	WebElement saveProgram;

	@FindBy (xpath = "//div//small[contains(text(), 'is required.')]")
	WebElement errorMessage;

	public void sanityCheck()
	{
		System.out.println("The title of the page is" +driver.getTitle());

		for(WebElement module:modules)
		{

			System.out.println(module.getText());
			System.out.println("is the "+ module.getText()+" is visible - "+module.isDisplayed());


		}

	}
	public void clickProg(String target) 
	{
		System.out.println("Targeted module is "+target);
		for(WebElement module:modules)
		{
			if(module.getText().equals(target))
			{
				module.click();
				System.out.println("The title of the page is" +driver.getTitle());
				String dynamicXpath= String.format("//div[contains(text(),'%s')]", target);
				System.out.println("SubTitle of the page is "+driver.findElement(By.xpath(dynamicXpath)).getText());


				List<WebElement> module_menus= driver.findElements(By.xpath("//thead[@class='p-datatable-thead']/tr/th"));

				for(WebElement menu:module_menus)
				{
					System.out.println("The menus are: "+ menu.getText());

				}

			}

		}

	}
	public void page_admin_should_be_navigated_to_program_module(String Titile)
	{

		System.out.println("Targeted module is "+Titile);
		for(WebElement module:modules)
		{
			if(module.getText().equals(Titile))
			{
				System.out.println("The subtitle on the current module " + Titile +" is "+subTitle_anyModule.getText());
				System.out.println("This shows admin is current module");
			}
		}
	}
	public void page_admin_clicks_on_the_navigations_bar(String target) {


		for(WebElement module:modules)
		{
			if(module.getText().equals(target))
			{
				System.out.println("module.getText()"+module.getText());
				module.click();

			}
		}
	}
	public void page_admin_should_not_have_any_broken_links_for_program_module()
	{
		for(WebElement link:links)
		{
			String url=link.getAttribute("href");
			if(url==null || url.isEmpty())
			{
				System.out.println("empty or null url in <link> tag");
				continue;
			}


			// Validate each link by checking the HTTP status code
			try {
				URL linkUrl = new URL(url);
				HttpURLConnection httpURLConnection = (HttpURLConnection) linkUrl.openConnection();
				httpURLConnection.setConnectTimeout(3000); // 3 seconds timeout
				httpURLConnection.connect();

				int responseCode = httpURLConnection.getResponseCode();

				if (responseCode >= 200 && responseCode < 400) {
					System.out.println(url + " -----is a valid link with response code: " + responseCode);
				} else {
					System.out.println(url + " -----is a broken link with response code: " + responseCode);
				}

			} catch (IOException e) {
				System.out.println("Error checking URL " + url + ": " + e.getMessage());
			}
		}
	}
	public void page_admin_should_see_the_heading(String title)
	{

		if(dashBoard_LMS.getText().equals(title))
		{
			System.out.println("The admin viewing the heading as "+title+" is same as "+ dashBoard_LMS.getText());
		}
	}

	public void page_admin_should_see_the_module_names_as_in_order(String expecModules)
	{	
		List<String> listModule= Arrays.asList(expecModules.split(","));
		actualModules = new ArrayList<String>();

		for(WebElement module:modules)
		{
			System.out.println("The modules listed are ..."+ module.getText());
			actualModules.add(module.getText());

		}

		//assertEquals("The menu items are not displayed in the correct order."+listModule, actualModules);
	}

	public void page_admin_should_see_in_menu_bar(String expecModule) throws InterruptedException

	{
		for (WebElement module : modules) {

			actualModules = new ArrayList<String>();
			// System.out.println("The modules listed are ..."+ module.getText());
			actualModules.add(module.getText());
		}
		if (actualModules.contains(expecModule)) {

			System.out.println("The actualModules are " + actualModules);
			// assertTrue("The module '" + expecModule + "' is not displayed in the menu
			// bar.", actualModules.contains(expecModule));
		}

		Thread.sleep(4000);
	}
	public void page_admin_should_see_sub_menu_in_menu_bars_as(String expectedSubMenu)
	{


		if (submenu_module.isDisplayed()) {
			// Get the actual text from the submenu_module element
			String actualSubMenu = submenu_module.getText();

			// Print the submenu text for debugging purposes
			System.out.println("The submenu in the module is " + actualSubMenu);

			//assertTrue("Expected submenu to be '" + expectedSubMenu + "', but found '" + actualSubMenu + "'",
			//actualSubMenu.equals(expectedSubMenu));
		}
	}

	public void page_admin_should_see_the_heading_inside_program(String expectedSubTitle, String moduleName)
	{

		System.out.println("Targeted module is "+moduleName);
		for(WebElement module:modules)
		{
			if(module.getText().equals(moduleName))
			{
				String actualSubTitle =subTitle_anyModule.getText();
				System.out.println("The subtitle on the current module " + expectedSubTitle +" is "+subTitle_anyModule.getText());
				System.out.println("This shows admin is current module");
				//assertTrue("Expected submenu to be '" + expectedSubTitle + "', but found '" + actualSubTitle + "'",
				//actualSubTitle.equals(expectedSubTitle));
			}
		}
	}
	public void page_dmin_should_able_to_see_program_name_description_and_status_for_each(String targetTitle)
	{
		String dynamicXpath= String.format("//div[contains(text(),'%s')]", targetTitle);
		System.out.println("SubTitle of the page is "+driver.findElement(By.xpath(dynamicXpath)).getText());


		List<WebElement> module_menus= driver.findElements(By.xpath("//thead[@class='p-datatable-thead']/tr/th"));

		for(WebElement menu:module_menus)
		{
			System.out.println("The menus are: "+ menu.getText());
		}
	}
	public void page_admin_should_see_a_delete_button_in_left_top_is_disabled()
	{

		trashButn.getAttribute("disabled");

		//WebElement deleteButton = driver.findElement(By.xpath("//button[@icon='pi pi-trash']"));
		String isDisabled = trashButn.getAttribute("disabled");

		if (isDisabled != null) {
			System.out.println("The delete button is disabled.");
		} else {
			System.out.println("The delete button is enabled.");
		}

	}

	public void clickaddNewProgram() {
		addNewProgram.click();
	}
	public String getTextNewProgram() {
		return addNewProgram.getText();
	}

	public String verifyTitleProgramDetails() {
		return titleProgramDetails.getText();

	}
	public void clickCloseButton() {
		closeButton.click();
	}
	public void clickCancelButton() {
		cancelButton.click();
	}

	public boolean verifyAsteriskPresence() {
		boolean isPresent = true;
		for (WebElement asteriskSymbol : asteriskList) {
			isPresent = asteriskSymbol.isDisplayed();
			if (!isPresent)
				break;
		}
		return isPresent;
	}

	public boolean closeProgramDetailsForm() {
		try {

			closeButton.click();

			// Wait until the form disappears
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'p-dialog-header-icons')]")));
		} catch (Exception e) {
			return false;
		}
	}

	public void clickSaveButton() {
		saveProgram.click();
	}

	public void errorMessage() {
		if (errorMessage.isDisplayed()) {
			System.out.println("Error message is displayed: " + errorMessage.getText());
		} else {
			System.out.println("Error message is NOT displayed.");
		}
	}


	public void addNewProgram() throws InvalidFormatException, IOException {

		String excelPath = System.getProperty("user.dir") + "/src/test/resources/ExcelData/Login1.xlsx";
		String sheetName = "Sheet1";  // Replace with your actual sheet name
		ExcelFileReader excelFileReader = new ExcelFileReader();

		List<Map<String, String>> testdata = excelFileReader.getData(excelPath, sheetName);
		String programNameFromExcel = testdata.get(2).get("programName");
		String programDescFromExcel = testdata.get(2).get("programDescription");

		// Print data for verification
		System.out.println("Program Name from Excel: " + programNameFromExcel);
		System.out.println("Program Description from Excel: " + programDescFromExcel);

		// Use Selenium to interact with the web page elements
		program.click();
		addNewProgram.click();
		programName.sendKeys(programNameFromExcel);
		programDesc.sendKeys(programDescFromExcel);
		activeProgramStatus.click();
		saveProgram.click();
	}
}

