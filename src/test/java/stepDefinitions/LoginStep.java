package stepDefinitions;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.sourceforge.tess4j.TesseractException;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testContext.TestContext;
import utilities.ExcelFileReader;
import utilities.ResourceBundleReader;

public class LoginStep {
	
	TestContext testContext;
	ResourceBundleReader resourceBundleReader;
	WebDriver driver;
	DashboardPage dashboard;
	Logger logger= LogManager.getLogger(LoginStep.class);
	ExcelFileReader excelReader;
	LoginPage login;
	
	
	
	@SuppressWarnings("static-access")
	public LoginStep(TestContext testcontext) {
		this.testContext = testcontext;
		this.dashboard = testcontext.getPageObjectManager().getDashboardPage();
		this.resourceBundleReader = testcontext.getResourceBundleReader();
		this.driver = testcontext.getDriverManager().getDriver();
		this.login = testcontext.getPageObjectManager().getLoginPage();

	}
	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
//	System.out.println("Driver value in stepdef *******" +driver);
		logger.info("Admin launched the Browser");
	   
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
//		driver.get(resourceBundleReader.getUrl());
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
	    assertTrue(login.validateLoginPage());
	}

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
	    driver.get(resourceBundleReader.getInvalidURL());
	}

	

	@Then("HTTP response >= {int} and the link is broken")
	public void http_response_and_the_link_is_broken(Integer int1) {
		dashboard.brokenLinks();
	}

	@Given("Admin launches the browser")
	public void admin_launches_the_browser() {
	    
	}

	@SuppressWarnings("static-access")
	@Then("Admin should receive {int} page not found error")
	public void admin_should_receive_page_not_found_error(Integer int1) {
		 try {
				login.verifyLink(resourceBundleReader.getInvalidURL());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
	@Then("Admin should see correct spelling for the {string} in login page from {string}")
	public void admin_should_see_correct_spelling_for_the_in_login_page_from(String Scenario, String SheetName) throws Exception {
		Map<String, String> text = ExcelFileReader.getData1(Scenario, SheetName);
		assertEquals(login.spellCheckloginPageContent(), text.get("VerifyPageText"));
	}

	@Then("Admin should see the logo on the left side")
	public void admin_should_see_the_logo_on_the_left_side() {
	   try {
		login.verifyLogoAlignment();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Then("Admin should see {string}")
	public void admin_should_see(String string) throws TesseractException {
	   assertEquals(login.verifySignInContent(), resourceBundleReader.getSignInContent());
	}

	@Then("Admin should see the company name below the app name")
	public void admin_should_see_the_company_name_below_the_app_name() throws TesseractException {
	  assertEquals(login.verifyCompanyName(), resourceBundleReader.getCompanyName());
	}

	@Then("Admin should see two text fields")
	public void admin_should_see_two_text_fields() {
	   assertTrue(login.verifyTextBox());
	}

	@Then("Admin should see {string} in the first text field")
	public void admin_should_see_in_the_first_text_field(String string) {
	    assertEquals(login.checkPlaceHolder1(), resourceBundleReader.getTextBox1());
	}

	@Then("Admin should see field mandatory aestrik symbol next to Admin text")
	public void admin_should_see__field_mandatory_aestrik_symbol_next_to_admin_text() {
	   assertTrue(login.checkPlaceHolder1().contains("*"));
	}

	@Then("Admin should see {string} in the second text field")
	public void admin_should_see_in_the_second_text_field(String string) {
		assertEquals(login.checkPlaceHolder2(), resourceBundleReader.getTextBox2());
	}

	@Then("Admin should see aestrik symbol next to the password text")
	public void admin_should_see_aestrik_symbol_next_to_the_password_text() {
		assertTrue(login.checkPlaceHolder2().contains("*"));
	}

	@Then("Admin should see the text fields aligned correctly")
	public void admin_should_see_the_text_fields_aligned_correctly() {

	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		login.verifyLoginBtn();
	}

	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {
	    
	}


	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
	   dashboard.validLogin();
	}

	@Then("Admin should land on dashboard page \\( centre of the page will be empty , menu bar is present).")
	public void admin_should_land_on_dashboard_page_centre_of_the_page_will_be_empty_menu_bar_is_present() {
	    assertEquals(dashboard.verifyTitle(), resourceBundleReader.getHomePageHeader());
	}

	@When("Admin enter valid credentials  from sheet {string} and {string} and clicks login button through keyboard")
	public void admin_enter_valid_credentials_from_sheet_and_and_clicks_login_button_through_keyboard(String option, String sheetName) throws Exception {
		Map<String, String> credentials = ExcelFileReader.getData1(option, sheetName);
	    dashboard.loginUsingKeys(credentials.get("Username"), credentials.get("Password"));
	}
	@When("Admin enter valid credentials from sheet {string} and {string} and clicks login button through mouse")
	public void admin_enter_valid_credentials_from_sheet_and_and_clicks_login_button_through_mouse(String option, String sheetName) throws Exception {
		Map<String, String> credentials = ExcelFileReader.getData1(option, sheetName);
	    dashboard.login(credentials.get("Username"), credentials.get("Password"));
	   
	}
	@When("Admin enter no value only in input and password field and click on Loginbutton")
	public void admin_enter_no_value_only_in_input_and_password_field_and_click_on_loginbutton() {
		dashboard.noValueLogin();
	}
	@Then("Error message please enter username and password")
	public void error_message_please_enter_username_and_password() {
	    
	}
	@When("Admin enter value only in password from sheet {string} and {string} and clicks login button")
	public void admin_enter_value_only_in_password_from_sheet_and_and_clicks_login_button(String option, String sheetName) throws Exception {
		Map<String, String> credentials = ExcelFileReader.getData1(option, sheetName);
	    dashboard.login(credentials.get("Username"), credentials.get("Password"));
	}
	@Then("Error message please enter username")
	public void error_message_please_enter_username() {
	    assertEquals(login.checkUserErrorMsg(), resourceBundleReader.getuserErrorMsg()); 
	}
	@When("Admin enter value only in username from sheet {string} and {string} and clicks login button")
	public void admin_enter_value_only_in_username_from_sheet_and_and_clicks_login_button(String option, String sheetName) throws Exception {
		Map<String, String> credentials = ExcelFileReader.getData1(option, sheetName);
	    dashboard.login(credentials.get("Username"), credentials.get("Password"));
	}
	@Then("Error message please enter password")
	public void error_message_please_enter_password() {
	   assertEquals(login.checkpasswordErrorMessage(), resourceBundleReader.getpasswordErrorMsg());
	}



	
	@When("Admin enter value only only numeric value in password from sheet {string} and {string} and clicks login button")
	public void admin_enter_value_only_only_numeric_value_in_password_from_sheet_and_and_clicks_login_button(String option, String sheetName) throws Exception {
		Map<String, String> credentials = ExcelFileReader.getData1(option, sheetName);
	    dashboard.login(credentials.get("Username"), credentials.get("Password"));
	}
	@Then("Error message please check username\\/password")
	public void error_message_please_check_username_password() {
		assertEquals(login.checkpasswordErrorMessage(), resourceBundleReader.getpasswordErrorMsg());
		assertEquals(login.checkUserErrorMsg(), resourceBundleReader.getuserErrorMsg());
	}



}