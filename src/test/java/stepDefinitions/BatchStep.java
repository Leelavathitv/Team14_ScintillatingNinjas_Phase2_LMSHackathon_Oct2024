package stepDefinitions;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import driverManager.DriverManager;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import testContext.TestContext;
import io.cucumber.java.en.*;

import utilities.ConfigFileReader;
import utilities.LoggerLoad;
import utilities.Pagination;
import utilities.ResourceBundleReader;

public class BatchStep {

	TestContext testContext;
	DashboardPage dashObj;
	BatchPage batchObj;
	WebDriver driver;
	Pagination paginationObj;
	ResourceBundleReader resourceBundleReader;
	Logger logger = LogManager.getLogger(LoginStep.class);
	WebElement clickandEnable;

	public BatchStep(TestContext testcontext) {
		this.testContext = testcontext;
		this.dashObj = testcontext.getPageObjectManager().getDashboardPage();
		this.batchObj = testcontext.getPageObjectManager().getBatchPage();
		this.resourceBundleReader = testcontext.getResourceBundleReader();
		this.driver = testcontext.getDriverManager().getDriver();
		this.paginationObj=testcontext.getPageObjectManager().getPgPage();

	}

//-------------01-----------
	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
		batchObj.clickDashboardBatch();
	}

	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() {
		Assert.assertEquals(batchObj.getActualTitle(), resourceBundleReader.getPageTitle("ManageBatchPageTitle"));
		LoggerLoad.info("You are viewing the " + driver.getTitle() + " page.");
	}

	// -----------02----------------------------

	@Then("Admin should see the Manage Batch Heading")
	public void admin_should_see_the_Manage_Batch_Heading() {
		Assert.assertEquals(batchObj.manageBatchgetText(), resourceBundleReader.getFunctionalityMessage("batch"));
		LoggerLoad.info("You are viewing the " + driver.getTitle() + " page.");
	}

	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
		Assert.assertTrue(batchObj.isPaginationEnabled(), "Pagination in Page is not Enabled");
		LoggerLoad.info("Pagination in Batch Page is Enabled = " + batchObj.isPaginationEnabled());
	}

	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {
		Assert.assertTrue(batchObj.editIconEnable(), "Edit Icon in Batch Page is not Enabled");
		LoggerLoad.info("Edit Icon in Batch Page is Enabled = " + batchObj.editIconEnable());
	}

	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {
		Assert.assertTrue(batchObj.deleteIconEnable(), "Delete Icon in Batch Page is not Enabled");
		LoggerLoad.info("Delete Icon in Batch Page is Enabled = " + batchObj.deleteIconEnable());
	}

	@Then("Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit\\/Delete")
	public void admin_should_see_the_datatable_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
		List<String> actualElementTexts = batchObj.getElementText();
		actualElementTexts.forEach(System.out::println);

		List<String> expectedElementTexts = Arrays
				.asList(resourceBundleReader.getFunctionalityMessage("HeaderName1").split(","));
		Assert.assertEquals(actualElementTexts, expectedElementTexts);

		Assert.assertTrue(batchObj.editIconEnable(), "Edit/Delete Icon in Batch Page is not Enabled");

		LoggerLoad.info("The User is seeing all Header Names present in the page" + batchObj.getElementText());
		LoggerLoad.info("Edit/Delete Icon in Batch Page is present = " + batchObj.editIconEnable());

	}

	@Then("Admin should see the checkbox in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
		Assert.assertTrue(batchObj.headerCheckboxVisible());
		LoggerLoad.info("CheckBox is present in Page " + batchObj.headerCheckboxVisible());
	}

	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
		Assert.assertTrue(batchObj.verifyHeaderSortPresence());
		LoggerLoad.info("All header sort elements are present and displayed. " + batchObj.verifyHeaderSortPresence());
	}

//-------------03-------------------------------------

	@When("Admin is on the Batch page after login successful")
	public void admin_is_on_the_Batch_page_after_login_successful() {
		dashObj.login();
		batchObj.clickDashboardBatch();
	}

	@Given("Admin is on the Batch page")
	public void admin_is_on_the_batch_page() {
		LoggerLoad.info("The Admin is on the login page of the LMS Portal");
	}

	@When("Admin clicks Batch on the navigation bar")
	public void admin_clicks_batch_on_the_navigation_bar() {
		batchObj.clickaddNewBatch();
	}

	@Then("Admin should see sub menu in menu bar as Add New Batch")
	public void admin_should_see_sub_menu_in_menu_bar_as_add_new_batch() {
		Assert.assertEquals(batchObj.getTextNewBatch(), resourceBundleReader.getFunctionalityMessage("addNewBatch"));
		LoggerLoad.info("All header sort elements are present and displayed. " + batchObj.verifyHeaderSortPresence());
	}

	@When("Admin clicks on Add New batch under the batch menu bar")
	public void admin_clicks_on_add_new_batch_under_the_batch_menu_bar() {
		batchObj.clickaddNewBatch();
	}

	@Then("Admin should see the Batch Details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
		Assert.assertEquals(batchObj.getTextNewBatch(), resourceBundleReader.getFunctionalityMessage("addNewBatch"));
		LoggerLoad.info("Admin should see the Batch Details pop up window " + batchObj.getTextNewBatch());
	}

//----------------------04------------------------------

	@When("Admin is on the Add new batch pop up in batch after Login")
	public void admin_is_on_the_add_new_batch_pop_up_in_batch_after_login() {
		dashObj.login();
		batchObj.clickDashboardBatch();
		batchObj.clickaddNewBatch();
	}

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

	@Then("Admin should see the Batch details pop up window")
	public void admin_should_see_the_batch_detail_pop_up_window() {

	}

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
	public void admin_clicks_next_page_link_on_the_data_table() throws InterruptedException {
		paginationObj.clickPage(paginationObj.getNextIcon());
	}

	@Then("Admin should see the Next enabled link")
	public void admin_should_see_the_next_enabled_link() {

		Assert.assertTrue( paginationObj.isNextPageIconDisplayed(), "Next page icon is not displayed");
	}

	@When("Admin clicks last page link on the data table")
	public void admin_clicks_last_page_link_on_the_data_table() {
		paginationObj.clickPage(paginationObj.getLastIcon());
		// pagination.clickPage(pagination.getLastIcon());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
	}

	@Then("Admin should see the last page link with next page link disabled on the table")
	public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table() {
		boolean isDisplayed = paginationObj.isNextLinksDisabled();

		Assert.assertFalse(isDisplayed, "Next page icon should be disabled");

	}

	@When("Admin clicks backward page link on the data table")
	public void admin_clicks_backward_page_link_on_the_data_table() {
		paginationObj.clickPage(paginationObj.getLastIcon());
	}

	@Then("Admin should see the previous page on the table")
	public void admin_should_see_the_previous_page_on_the_table() {
		//Assert.assertFalse(isDisplayed, "Next page icon should be disabled");
		//pagination.checkIsNextPageDisabled();
	}

	@When("Admin clicks first page link on the data table")
	public void admin_clicks_first_page_link_on_the_data_table() {

	}

	@Then("Admin should see the very first page on the data table")
	public void admin_should_see_the_very_first_page_on_the_data_table() {

	}

//--------------------------------09------------------------
	@When("Admin enters the batch name in the search text box")
	public void admin_enters_the_batch_name_in_the_search_text_box() {
		batchObj.searchBoxfilter();
	}

	@Then("Admin should see the filtered batches in the data table")
	public void admin_should_see_the_filtered_batches_in_the_data_table() {
		Assert.assertTrue(batchObj.searchGetText(), "Filtered Results is not showing");
		LoggerLoad.info("Admin should see the filtered batches in the data table ");
	}

	// ----------------------10--------------------

	@When("Admin clicks on the logout button")
	public void admin_clicks_on_the_logout_button() {
		batchObj.clickLogout();
	}

	@Then("Admin should see the Login screen Page")
	public void admin_should_see_the_login_screen_page() {
		Assert.assertEquals(batchObj.getActualTextLogout(), resourceBundleReader.getFunctionalityMessage("logout"));
		LoggerLoad.info("Admin should see the filtered batches in the data table ");
	}
}
