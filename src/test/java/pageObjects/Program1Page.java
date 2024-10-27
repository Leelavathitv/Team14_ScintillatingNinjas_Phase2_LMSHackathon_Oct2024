package pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelFileReader;
import utilities.ResourceBundleReader;

public class Program1Page {
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	
	
	public Program1Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.resourceBundleReader = new ResourceBundleReader();
	}
	
	@FindBy (id = "program") 
	WebElement program;
	
	@FindBy (id = "cdk-overlay-0") 
	WebElement addNewProgram;
	
	@FindBy (id = "programName")
	WebElement programName;
	
	@FindBy (id = "programDescription")
	WebElement programDesc;
	
	@FindBy (xpath = "//div[@class='radio ng-star-inserted']/div[2]")
	WebElement activeProgramStatus;
	
	@FindBy (id ="saveProgram")
	WebElement saveProgram;
	
	
	
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

	   