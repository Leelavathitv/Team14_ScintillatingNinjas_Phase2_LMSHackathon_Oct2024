package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import driverManager.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

		assertEquals(dashboard.verifyTitle(), resourceBundleReader.getPageTitle("pagetitle"));

	}

	
	@Then("Maximum navigation time in milliseconds should default to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_should_default_to_seconds(Integer int1) {

		assertEquals(dashboard.responseTime(), true);

	}
	
	@When("Admin enters valid credentials and clicks")
	public void admin_enters_valid_credentials_and_clicks() {
	    dashboard.validLogin();
	}


	@Then("HTTP response should be >= {int} and the link is broken")
	public void http_response_should_be_and_the_link_is_broken(Integer int1) {
		dashboard.brokenLinks();
	}

	@Then("Admin should see LMS - Learning Management System as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		assertEquals(dashboard.assertingDashboard(),resourceBundleReader.getHomePageHeader());
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		assertEquals(dashboard.checkLeftPosition(), "Left");
	}

	@Then("Admin should see correct spelling for the {string} in navigation bar text from {string}")
	public void admin_should_see_correct_spelling_for_the_in_navigation_bar_text_from(String Scenario, String SheetName) throws Exception {
		Map<String, String> text = ExcelFileReader.getData1(Scenario, SheetName);
		assertEquals(dashboard.spellCheckOfTitle(), text.get("ExpectedHaeaderText"));
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
		assertEquals(dashboard.HeaderSpellCheck(), resourceBundleReader.getHomePageHeader());
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		dashboard.CheckAlignmentOfNavBar();
	}

	@Then("Admin should see menu in the correct order")
	public void admin_should_see_menu_in_the_correct_order() {
	    dashboard.OrderOFNavBar();
	}

}