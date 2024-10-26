package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DashboardPage;
import pageObjects.Program2Page;
import testContext.TestContext;
import utilities.ResourceBundleReader;

public class ProgramStep2 {
	Program2Page Program2;
	TestContext testContext;
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	Logger logger= LogManager.getLogger(LoginStep.class);
	private DashboardPage dashboard;
	
//	public DashboardStep(TestContext testcontext) {
//		this.testContext = testcontext;
//		this.dashboard = testcontext.getPageObjectManager().getDashboardPage();
//		this.resourceBundleReader = testcontext.getResourceBundleReader();
//		this.driver = testcontext.getDriverManager().getDriver();
//	}
	
    @SuppressWarnings("static-access")
	public ProgramStep2(TestContext testcontext) {
    	this.testContext = testcontext;
    	this.dashboard = testcontext.getPageObjectManager().getDashboardPage();
    	this.resourceBundleReader = testcontext.getResourceBundleReader();
    	this.driver=testcontext.getDriverManager().getDriver();
    	if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized");
        }
        this.Program2 = new Program2Page(driver);
    }
	
	@Given("Admin is on the Program module")
	public void admin_is_on_the_program_module() {
		//driver.get("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/login");
		logger.info("admin is in program module page");
	}

	@When("Admin is logged in successfully and is in program module page")
	public void admin_is_on_program_module_after_reaching_dashboard() {
		dashboard.login();
		Program2.programModulePage();
	}

	@When("Admin clicks on delete button for a program")
	public void admin_clicks_on_delete_button_for_a_program() {
		Program2.programClick();
		Program2.deletePgm();
	}

	@Then("Admin will get confirm deletion popup")
	public void admin_will_get_confirm_deletion_popup() {
	}

	@Given("Admin is on Confirm deletion form")
	public void admin_is_on_confirm_deletion_form() {
		
	}

	@When("Admin clicks on {string} button")
	public void admin_clicks_on_button(String string) {
		Program2.deleteYes();
	}
	

	@Then("Admin can see {string} message")
	public void admin_can_see_message(String string) {
		//alert
	}

	@When("Admin Searches for {string}")
	public void admin_searches_for(String string) {
		//deleted program name
	}

	@Then("There should be zero results")
	public void there_should_be_zero_results() {
	}

	@Given("Admin is on Program Confirm Deletion Page after selecting a program to delete")
	public void admin_is_on_program_confirm_deletion_page_after_selecting_a_program_to_delete() {
		
	}

	@When("Admin click on {string} button")
	public void admin_click_on_button(String string) {
		Program2.deleteNo();
	}

	@Then("Admin can see Confirm Deletion form disappear")
	public void admin_can_see_confirm_deletion_form_disappear() {
	Program2.confirmationDialog();
	}

	
//----------deletemultipleprogram---------
	@When("Admin selects more than one program by clicking on the checkbox")
	public void admin_selects_more_than_one_program_by_clicking_on_the_checkbox() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Programs get selected")
	public void programs_get_selected() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks on the delete button on the left top of the program page")
	public void admin_clicks_on_the_delete_button_on_the_left_top_of_the_program_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin lands on Confirmation form")
	public void admin_lands_on_confirmation_form() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Admin is on Confirmation form")
	public void admin_is_on_confirmation_form() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

//	@Then("There should be zero results")
//	public void there_should_be_zero_results() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@Then("Admin can see Programs are still selected and not deleted")
	public void admin_can_see_programs_are_still_selected_and_not_deleted() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

//---------searchbar----------
	@When("Admin enter the program to search By program name")
	public void admin_enter_the_program_to_search_by_program_name() {
	}

	@Then("Admin should able to see Program name, description, and status for searched program name")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_name() {
	}

	@When("Admin enter the program to search By program description")
	public void admin_enter_the_program_to_search_by_program_description() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should able to see Program name, description, and status for searched program description")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_description() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin enter the program to search By program name that does not exist")
	public void admin_enter_the_program_to_search_by_program_name_that_does_not_exist() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin enter the program to search By partial name of program")
	public void admin_enter_the_program_to_search_by_partial_name_of_program() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


//-------Sorting---------
	@When("Admin clicks on Arrow next to program Name")
	public void admin_clicks_on_arrow_next_to_program_name() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin See the Program Name is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_name_is_sorted_in_ascending_order_descending_order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks on Arrow next to Program Description")
	public void admin_clicks_on_arrow_next_to_program_description() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin See the program Description is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_description_is_sorted_in_ascending_order_descending_order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks on Arrow next to Program status")
	public void admin_clicks_on_arrow_next_to_program_status() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Use See the Program Status is sorted in Ascending order\\/Descending order")
	public void use_see_the_program_status_is_sorted_in_ascending_order_descending_order() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	//------pagination1------
	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see the Pagination has {string} active link")
	public void admin_should_see_the_pagination_has_active_link(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see the last page record on the table with Next page link disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_disabled() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Admin is on last page of Program module table")
	public void admin_is_on_last_page_of_program_module_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks Previous page link")
	public void admin_clicks_previous_page_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Admin is on Previous Program page")
	public void admin_is_on_previous_program_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks on First page link")
	public void admin_clicks_on_first_page_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see the very first page record of the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_of_the_table_with_previous_page_link_are_disabled() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


//-----pagination2----

@When("Admin is logged in to LMS Portal with no records in program list")
public void admin_is_logged_in_to_lms_portal_with_no_records_in_program_list() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should not see any pagination icons and message {string}")
public void admin_should_not_see_any_pagination_icons_and_message(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

	//---------pagination3---------
	@When("Admin is logged in successfully with >={int} records in program list")
	public void admin_is_logged_in_to_lms_portal_with_records_in_program_list(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Admin is on the dashboard page after Login")
	public void admin_is_on_the_dashboard_page_after_login() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks {string} on the dashboard navigation bar")
	public void admin_clicks_on_the_dashboard_navigation_bar(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see pagination icons disabled")
	public void admin_should_see_pagination_icons_disabled() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}





}
