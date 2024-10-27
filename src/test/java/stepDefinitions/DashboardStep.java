package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DashboardPage;
import testContext.TestContext;

import utilities.ExcelFileReader;
import utilities.ResourceBundleReader;

public class DashboardStep {
	
	TestContext testContext;
	DashboardPage dashboard;
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	ExcelFileReader excelReader;
	
	Logger logger= LogManager.getLogger(DashboardStep.class);
	
	@SuppressWarnings("static-access")
	public DashboardStep(TestContext testcontext) {
		this.testContext = testcontext;
		this.dashboard = testcontext.getPageObjectManager().getDashboardPage();
		this.resourceBundleReader = testcontext.getResourceBundleReader();
		this.driver = testcontext.getDriverManager().getDriver();
		
		
	}
	
	@Given("Admin is in loginPage")
	public void admin_is_in_login_page() {
		logger.info("Admin is on the dashboard Page" );
	}

	@When("Admin enters valid credentials from excel {string} and {string} and clicks submit")
	public void admin_enters_valid_credentials_from_excel_and_and_clicks_submit(String Scenario, String SheetName) throws Exception {
		 Map<String, String> credentials = ExcelFileReader.getData1(Scenario, SheetName);
		    dashboard.login(credentials.get("Username"), credentials.get("Password"));
	}

	@Then("Admin should see dashboard")
	public void admin_should_see_dashboard() {
		assertEquals(dashboard.assertingDashboard(), resourceBundleReader.getHomePageHeader());
	}

	
	@Then("Maximum navigation time in milliseconds should default to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_should_default_to_seconds(Integer int1) {
		assertEquals(dashboard.responseTime(), true);
	}

	@Then("HTTP response should be >= {int} and the link is broken")
	public void http_response_should_be_and_the_link_is_broken(Integer int1) {
	   
	}

	@Then("Admin should see LMS - Learning Management System as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
	    
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
	    
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
	   
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
	  
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
	    
	}

	@Then("Admin should see Home in the 1st place")
	public void admin_should_see_home_in_the_1st_place() {
	   
	}

	@Then("Admin should see Program in the 2nd place")
	public void admin_should_see_program_in_the_2nd_place() {
	   
	}

	@Then("Admin should see Batch in the 3rd place")
	public void admin_should_see_batch_in_the_3rd_place() {
	  
	}

	@Then("Admin should see Class in the 4th place")
	public void admin_should_see_class_in_the_4th_place() {
	   
	}

	@Then("Admin should see Logout in the 5th place")
	public void admin_should_see_logout_in_the_5th_place() {
	    
	}




}
