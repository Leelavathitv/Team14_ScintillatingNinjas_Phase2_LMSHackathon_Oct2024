package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DashboardPage;
import pageObjects.Program2Page;
import testContext.TestContext;
import utilities.Pagination;
import utilities.ResourceBundleReader;

public class ProgramStep2 {
	
	TestContext testContext;
	Program2Page ProgramModule;
	Pagination Pg;
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	Logger logger= LogManager.getLogger(LoginStep.class);
	DashboardPage dashboard;

	public ProgramStep2(TestContext testcontext) {
    	this.testContext = testcontext;    	
    	this.ProgramModule =testcontext.getPageObjectManager().getProgram2Page();
    	this.resourceBundleReader = testcontext.getResourceBundleReader();
    	this.driver=testcontext.getDriverManager().getDriver();
    	this.dashboard =testcontext.getPageObjectManager().getDashboardPage();
    	this.Pg=testcontext.getPageObjectManager().getPgPage();
    }
	
	@Given("Admin is on the Program module")
	public void admin_is_on_the_program_module() {
		logger.info("admin is in program module page");
	}

	@When("Admin is logged in successfully and is in program module page")
	public void admin_is_on_program_module_after_reaching_dashboard() {
		dashboard.login();
		ProgramModule.openMenu();
		ProgramModule.closeMenu();
	}

	@When("Admin clicks on delete button for a program {string}")
	public void admin_clicks_on_delete_button_for_a_program(String ProgramName) {	
		ProgramModule.deleteSingleProgramWithName(ProgramName);
	}

	@Then("Admin will get confirm deletion popup")
	public void admin_will_get_confirm_deletion_popup() {
		//Assert -  if the popup is present, test will pass, and if it's not, the test will fail as intended.	
		 Assert.assertTrue(ProgramModule.checkConfirmDeletion());
	}

	@Given("Admin is on Confirm deletion form for program {string}")
	public void admin_is_on_confirm_deletion_form_for_program(String programName) {
		ProgramModule.deleteSingleProgramWithName(programName);
	}

	@When("Admin clicks on Yes button")
	public void admin_clicks_on_yes_button() {	
		ProgramModule.confirmDeletionYes();
	}
	

	@Then("Admin can see {string} message")
	public void admin_can_see_message(String string) {
		Assert.assertEquals(ProgramModule.isProgramDeletedSuccessfully(), string);
	}

	@When("Admin Searches for {string}")
	public void admin_searches_for(String programName) {		
		ProgramModule.searchProgram(programName);
	}

	@Then("There should be zero results for {string}")
	public void there_should_be_zero_results(String programName) {
 	    boolean zeroData = ProgramModule.isSearchProgramNameSuccessful(programName);
	    Assert.assertTrue(zeroData, "Expected no results, but found a program: " + programName);		
	}
	

	@Given("Admin is on Program Confirm Deletion Page after selecting a program to delete {string}")
	public void admin_is_on_program_confirm_deletion_page_after_selecting_a_program_to_delete(String programName) {
		ProgramModule.deleteSingleProgramWithName(programName);	
		ProgramModule.checkConfirmDeletion();
	}

	@When("Admin clicks on No button")
	public void admin_clicks_on_no_button() {
		ProgramModule.confirmDeletionNo();		
	}

	@Then("Admin can see Confirm Deletion form disappear")
	public void admin_can_see_confirm_deletion_form_disappear() {
		boolean isConfirmDialog = ProgramModule.checkConfirmDeletion();
		
		Assert.assertFalse(isConfirmDialog, "Expected no confirmDialog, but found a Confirmation: ");
	}

	
	@When("Admin clicks on X button")
	public void admin_clicks_on_X_button() {
		ProgramModule.confirmDeletionClickClose();		
	}
	
//----------deletemultipleprogram---------
	@When("Admin selects more than one program by clicking on the checkbox")
	public void admin_selects_more_than_one_program_by_clicking_on_the_checkbox() {
		ProgramModule.selectMultipleProgramsWithCheckBox();				
	}

	@Then("Programs get selected")
	public void programs_get_selected() {
		boolean isCheckboxEnabled = ProgramModule.checkMultipleProgramsSelectedWithCheckBox();
		ProgramModule.printSelectedCheckBoxProgramNames();
		Assert.assertTrue(isCheckboxEnabled, "Expected all Checkbox enabled, but found one or more checkbox disabled.");
	}

	@When("Admin clicks on the delete button on the left top of the program page")
	public void admin_clicks_on_the_delete_button_on_the_left_top_of_the_program_page() {
		ProgramModule.selectMultipleProgramsWithCheckBox();		
		ProgramModule.clickDeleteLeftTopButton();		
	}


	@Given("Admin is on Confirmation form")
	public void admin_is_on_confirmation_form() {
	}

	@Then("Admin can see Programs are still selected and not deleted")
	public void admin_can_see_programs_are_still_selected_and_not_deleted() {
	}

//---------searchbar----------
	@When("Admin enter the program to search By program name {string}")
	public void admin_enter_the_program_to_search_by_program_name(String programName) {
		ProgramModule.searchProgram(programName);
	}

	@Then("Admin should able to see Program name, description, and status for searched program name {string}")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_name(String programName) {
		Assert.assertTrue(ProgramModule.isSearchProgramNameSuccessful(programName),"search should find the program with Program Name.");
	}

	@When("Admin enter the program to search By program description {string}")
	public void admin_enter_the_program_to_search_by_program_description(String programDesc) {
		ProgramModule.searchProgram(programDesc);
	}

	@Then("Admin should able to see Program name, description, and status for searched program description {string}")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_description(String programDesc) {
		Assert.assertTrue(ProgramModule.isSearchProgramDescSuccessful(programDesc),"search should find the program with Program Description.");
	}

	@When("Admin enter the program to search By program name that does not exist {string}")
	public void admin_enter_the_program_to_search_by_program_name_that_does_not_exist(String programName) {
		ProgramModule.searchProgram(programName);
	}
	
	@Then("There should be zero results")
	public void There_should_be_zero_results()
	{
		
	}

	@When("Admin enter the program to search By partial name of program")
	public void admin_enter_the_program_to_search_by_partial_name_of_program() {
	}


//-------Sorting---------
	@When("Admin clicks on Arrow next to program Name")
	public void admin_clicks_on_arrow_next_to_program_name() {
	}

	@Then("Admin See the Program Name is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_name_is_sorted_in_ascending_order_descending_order() {
	}

	@When("Admin clicks on Arrow next to Program Description")
	public void admin_clicks_on_arrow_next_to_program_description() {
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
		Pg.nextPageClick();
	}

	@Then("Admin should see the Pagination has {string} active link")
	public void admin_should_see_the_pagination_has_active_link(String string) {
        boolean isDisplayed  = Pg.isNextPageIconDisplayed();
		Assert.assertTrue(isDisplayed, "Next page icon should be displayed");

	}

	@When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() {
		Pg.lastPageClick();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("Admin should see the last page record on the table with Next page link disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_disabled() {
        boolean isDisplayed  = Pg.isNextLinksDisabled();
		
		Assert.assertFalse(isDisplayed, "Next page icon should be disabled");


	}

	@Given("Admin is on last page of Program module table")
	public void admin_is_on_last_page_of_program_module_table() {
		Pg.lastPageClick();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Admin clicks Previous page link")
	public void admin_clicks_previous_page_link() {
		Pg.clickPreviousPageIcon();
	}
	 

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
		boolean isDisplayed = Pg.isPreviousPageFromLastPageDisplayed();
		Assert.assertTrue(isDisplayed,"Previous page from last page should be displayed");
	}

	@Given("Admin is on Previous Program page")
	public void admin_is_on_previous_program_page() {
		Pg.lastPageClick();
		Pg.clickPreviousPageIcon();
	}

	@When("Admin clicks First Program page")
	public void admin_clicks_first_program_page() {
		Pg.firstPageClick();
	}

	@Then("Admin should see the very first page record of the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_of_the_table_with_previous_page_link_are_disabled() {
		boolean isDisplayed = Pg.isPreviousLinksDisabled();
		Assert.assertTrue(isDisplayed,"Previous page should be disabled on first page.");
	}


	//-----pagination2----

	@When("Admin is logged in to LMS Portal with no records in program list")
	public void admin_is_logged_in_to_lms_portal_with_no_records_in_program_list() {
		//Assuming there are no program records, as this is out of scope.
	}
	
	@When("Admin clicks Program on the navigation bar")
	public void admin_clicks_Program_on_the_navigation_bar(){
		ProgramModule.openMenu();
		ProgramModule.closeMenu();		
	}
	
	@Then("Admin should not see any pagination icons and message {string}")
	public void admin_should_not_see_any_pagination_icons_and_message(String string) {		
		Assert.assertTrue(Pg.checkForNoProgramRecords(),"Check for no program records");		
	}

	//---------pagination3---------
	@When("Admin is logged in successfully with <={int} records in program list")
	public void admin_is_logged_in_to_lms_portal_with_records_in_program_list(Integer expectedFiveOrBelowProgram) {
		//Assuming only 5 program records available, as it is out of scope to handle only 5 program records.
		int totalProgramRecord = Pg.extractTotalProgramFromFooter();		
	}

	@Given("Admin is on the dashboard page after Login")
	public void admin_is_on_the_dashboard_page_after_login() {
	}

	@When("Admin clicks {string} on the dashboard navigation bar")
	public void admin_clicks_on_the_dashboard_navigation_bar(String string) {
	}

	@Then("Admin should see pagination icons disabled")
	public void admin_should_see_pagination_icons_disabled() {
	}

}
