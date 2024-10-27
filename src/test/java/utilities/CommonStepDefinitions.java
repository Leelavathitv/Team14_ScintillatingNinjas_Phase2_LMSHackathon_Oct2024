package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import stepDefinitions.LoginStep;
import testContext.TestContext;

public class CommonStepDefinitions {
	TestContext testContext;
	DashboardPage dashboard;
	BatchPage batchObj;
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	Logger logger= LogManager.getLogger(LoginStep.class);
	
	public CommonStepDefinitions(TestContext testcontext) {
		this.testContext = testcontext;
		this.dashboard = testcontext.getPageObjectManager().getDashboardPage();
		this.resourceBundleReader = testcontext.getResourceBundleReader();
		this.driver = testcontext.getDriverManager().getDriver();
		this.batchObj = testcontext.getPageObjectManager().getBatchPage();
	
	}
	
	@Given("The Admin is on the login page of the LMS Portal")
	public void the_admin_is_on_the_login_page_of_the_lms_portal() {
		LoggerLoad.info("The Admin is on the login page of the LMS Portal");
	}
	
	
	//---- This is coming from the Each Scenario Given -----------
	
	@Given("Admin is on the Dashboard Page after Login")
	public void admin_is_on_the_dashboard_page_after_Login() {
		LoggerLoad.info("You are in " + driver.getTitle() + " page.");
		System.out.println("You are in Dashboard Page");
	}
	
	//---Batch  @BatchPageValidTitle @BatchvalidTC_001-----------
	
		
	@Then("Admin should see the LMS Learning Management Systems Title")
	public void admin_should_see_the_lms_learning_management_systems_title() {
		Assert.assertEquals(batchObj.getActualTitle(), resourceBundleReader.getPageTitle("pagetitle"));
		LoggerLoad.info("You are viewing the " + driver.getTitle() + " page.");
	}

//	@Then("Admin should be in the Manage Batch Page")
//	public void admin_should_be_in_the_manage_batch_page() {
//		Assert.assertEquals(batchObj.getActualTitle(), resourceBundleReader.getPageTitle("pagetitle"));
//		 LoggerLoad.info("You are viewing the " + driver.getTitle() + " page.");
//	}
}
