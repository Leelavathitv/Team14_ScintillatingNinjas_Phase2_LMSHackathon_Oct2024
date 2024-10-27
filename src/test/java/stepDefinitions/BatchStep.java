package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import driverManager.DriverManager;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import testContext.TestContext;
import io.cucumber.java.en.*;

import utilities.ConfigFileReader;
import utilities.LoggerLoad;
import utilities.ResourceBundleReader;

public class BatchStep {

	TestContext testContext;
	//DashboardPage dashboard;
	BatchPage batchObj;
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	Logger logger = LogManager.getLogger(LoginStep.class);

	public BatchStep(TestContext testcontext) {
		this.testContext = testcontext;
		this.batchObj = testcontext.getPageObjectManager().getBatchPage();
		this.resourceBundleReader = testcontext.getResourceBundleReader();
		this.driver = testcontext.getDriverManager().getDriver();
	}

	// BatchPage batchObj=new BatchPage();
	// ConfigFileReader configFileReader = ConfigFileReader.getInstance();
	// -------------@StackGetStarted @StackTC_001----------

//	@Given("Admin is on the Dashboard Page after Login")
//	public void admin_is_on_the_dashboard_page_after_login() {
//		LoggerLoad.info("You are in " + driver.getTitle() + " page."); 
//	}

	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
		batchObj.clickDashboardBatch();

	}

//	

	
//	@Given("The Admin is on the login page of the LMS Portal")
//	public void the_admin_is_on_the_login_page_of_the_lms_portal() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	// -----------02----------------------------

	@Then("Admin should see the Manage Batch Heading")
	public void admin_should_see_the_Manage_Batch_Heading() {
		Assert.assertEquals(batchObj.manageBatchgetText(), resourceBundleReader.getFunctionalityMessage("batch"));
	//	Assert.assertEquals(batchObj.getActualTitle(), resourceBundleReader.getPageTitle("pagetitle"));
		LoggerLoad.info("You are viewing the " + driver.getTitle() + " page.");
	   
	}


	@Then("Admin should see the disabled Delete Icon under the header")
	public void admin_should_see_the_disabled_delete_icon_under_the_header() {
		
		Assert.assertTrue(batchObj.deleteIconIsDisabled(),"Delete Icon in Manage Batch is Enabled");
		LoggerLoad.info("Manage Batch Delete Icon is Disabled = " +batchObj.deleteIconIsDisabled());
	}
	
	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
		Assert.assertTrue(batchObj.isPaginationEnabled(),"Pagination in Batch Page is not Enabled");
		LoggerLoad.info("Pagination in Batch Page is Enabled = " +batchObj.isPaginationEnabled());
	   
	}
	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {

	}

	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {

	}

	@Then("Admin should the checkbox in each row")
	public void admin_should_the_checkbox_in_each_row() {

	}

	@Then("Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit\\/Delete")
	public void admin_should_see_the_datatable_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {

	}

	@Then("Admin should see the checkbox  in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {

	}

	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {

	}

//-------------03-------------------------------------
	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {

	}

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String string) {

	}

	@When("Admin clicks on {string} under the {string} menu bar")
	public void admin_clicks_on_under_the_menu_bar(String string, String string2) {

	}

//duplicate in 03 last then
	@Then("Admin should see the Batch Details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {

	}

//----------------------04------------------------------
	@When("Admin checks all the fields are enabled")
	public void admin_checks_all_the_fields_are_enabled() {

	}

	@Then("The pop up should include the fields Batch Name,Number of classes and Description as text box,Program Name as drop down Status as radio button")
	public void the_pop_up_should_include_the_fields_batch_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button() {

	}

	@When("Admin selects program name present in the dropdown")
	public void admin_selects_program_name_present_in_the_dropdown() {

	}

	@Then("Admin should see selected program name in the batch name prefix box")
	public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() {

	}

	@When("Admin enters alphabets in batch name suffix box")
	public void admin_enters_alphabets_in_batch_name_suffix_box() {

	}

	@Then("Admin should get error message below the text box of respective field")
	public void admin_should_get_error_message_below_the_text_box_of_respective_field() {

	}

	@When("Admin enters alphabets in batch name prefix box")
	public void admin_enters_alphabets_in_batch_name_prefix_box() {

	}

	@Then("Admin should see empty text box")
	public void admin_should_see_empty_text_box() {

	}

	@When("Admin enters the data only to the mandatory fiields and clicks save button")
	public void admin_enters_the_data_only_to_the_mandatory_fiields_and_clicks_save_button() {

	}

	@Then("Admin should get a successful message")
	public void admin_should_get_a_successful_message() {

	}

	@When("Admin leaves blank one of the mandatory fields")
	public void admin_leaves_blank_one_of_the_mandatory_fields() {

	}

	@Then("Admin should get a error message on the respective mandatory field")
	public void admin_should_get_a_error_message_on_the_respective_mandatory_field() {

	}

	@When("Admin enters the valid data to all the mandatory fields and click save button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_save_button() {

	}

	@Then("Admin should get a succesesful message")
	public void admin_should_get_a_succesesful_message() {

	}

	@When("Admin enters the valid data to all the mandatory fields and click cancel button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_cancel_button() {

	}

	@Then("Admin can see the batch details popup closes without creating any batch")
	public void admin_can_see_the_batch_details_popup_closes_without_creating_any_batch() {

	}

	@When("Admin clicks on the close icon")
	public void admin_clicks_on_the_close_icon() {

	}

	@Then("Batch details pop up closes")
	public void batch_details_pop_up_closes() {

	}

//--------05---------------------------------------------------------
	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() {

	}
//duplicate in 05 first then 
//	@Then("Admin should see the Batch details pop up window")
//	public void admin_should_see_the_batch_details_pop_up_window() {
//	   
//	   
//	}

	@Then("Admin should see Program name value field is disabled for editing")
	public void admin_should_see_program_name_value_field_is_disabled_for_editing() {

	}

	@Then("Admin should see batch name value field is disabled for editing")
	public void admin_should_see_batch_name_value_field_is_disabled_for_editing() {

	}

	@When("Admin Updates any fields with invalid data and click save button")
	public void admin_updates_any_fields_with_invalid_data_and_click_save_button() {

	}

	@Then("Admin should get a error message under the respective field")
	public void admin_should_get_a_error_message_under_the_respective_field() {

	}

	@Then("Admin should get a succesesful message for editing the batch")
	public void admin_should_get_a_succesesful_message_for_editing_the_batch() {

	}

	@Then("Admin can see the batch details popup closes without editing the batch")
	public void admin_can_see_the_batch_details_popup_closes_without_editing_the_batch() {

	}

//----------------------------06----------------------
	@When("Admin clicks the delete Icon on any row")
	public void admin_clicks_the_delete_icon_on_any_row() {

	}

	@Then("Admin should see the confirm alert box with yes and no button")
	public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button() {

	}

	@Given("Admin is on the batch confirm popup page")
	public void admin_is_on_the_batch_confirm_popup_page() {

	}

	@When("Admin clicks on the delete icon and click yes buttton")
	public void admin_clicks_on_the_delete_icon_and_click_yes_buttton() {

	}

	@Then("Admin should see the successfull message and the batch should be deleted")
	public void admin_should_see_the_successfull_message_and_the_batch_should_be_deleted() {

	}

	@When("Admin clicks on the delete icon and click no buttton")
	public void admin_clicks_on_the_delete_icon_and_click_no_buttton() {

	}

	@Then("Admin should see the alert box closed and the batch is not deleted")
	public void admin_should_see_the_alert_box_closed_and_the_batch_is_not_deleted() {

	}

	@Then("Admin should see the alert box closed")
	public void admin_should_see_the_alert_box_closed() {

	}

//-----------------07--------------------------------
	@When("Admin clicks on the delete icon under the Manage batch header")
	public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header() {

	}

	@Then("The respective row in the table should be deleted")
	public void the_respective_row_in_the_table_should_be_deleted() {

	}

//-------------------------080---------------------------

	@When("Admin clicks next page link on the data table")
	public void admin_clicks_next_page_link_on_the_data_table() {

	}

	@Then("Admin should see the Next enabled link")
	public void admin_should_see_the_next_enabled_link() {

	}

	@When("Admin clicks last page link on the data table")
	public void admin_clicks_last_page_link_on_the_data_table() {

	}

	@Then("Admin should see the last page link with next page link disabled on the table")
	public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table() {

	}

	@When("Admin clicks backward page link on the data table")
	public void admin_clicks_backward_page_link_on_the_data_table() {

	}

	@Then("Admin should see the previous page on the table")
	public void admin_should_see_the_previous_page_on_the_table() {

	}

	@When("Admin clicks first page link on the data table")
	public void admin_clicks_first_page_link_on_the_data_table() {

	}

	@Then("Admin should see the very first page on the data table")
	public void admin_should_see_the_very_first_page_on_the_data_table() {

	}

//--------------------------------09------------------------
	@When("Admin enters the batch name in the serach text box")
	public void admin_enters_the_batch_name_in_the_serach_text_box() {

	}

	@Then("Admin should see the filtered batches in the data table")
	public void admin_should_see_the_filtered_batches_in_the_data_table() {

	}

	// ----------------------10--------------------

	@When("Admin clicks on the logout button")
	public void admin_clicks_on_the_logout_button() {

	}

	@Then("Admin should see the Login screen Page")
	public void admin_should_see_the_login_screen_page() {

	}

}
