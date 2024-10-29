package stepDefinitions;

import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects.ClassModPage;
import pageObjects.DashboardPage;
import testContext.TestContext;
import utilities.LoggerLoad;
import utilities.ResourceBundleReader;

public class ClassModSteps {

	TestContext testContext;
	DashboardPage dashObj;
	ClassModPage classObj;
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	Logger logger = (Logger) LogManager.getLogger(LoginStep.class);
	WebElement clickandEnable;

	public ClassModSteps(TestContext testcontext) {
		this.testContext = testcontext;
		this.dashObj = testcontext.getPageObjectManager().getDashboardPage();

		this.resourceBundleReader = testcontext.getResourceBundleReader();
		this.driver = testcontext.getDriverManager().getDriver();
		this.classObj = testcontext.getPageObjectManager().getClassmodPage();
	}

	@Given("Admin is on the Dashboard page after login")
	public void admin_is_on_the_dashboard_page_after_login() {
		LoggerLoad.info("You are in " + driver.getTitle() + " page.");
	}

	@Then("Admin clicks the Class Navigation bar in the Header")
	public void admin_clicks_the_class_navigation_bar_in_the_header() {
		classObj.clickDashboardClass();
	}

	@Then("Admin should land on the Manage class page")
	public void admin_should_land_on_the_manage_class_page() {
		Assert.assertEquals(classObj.getActualTitle(), resourceBundleReader.getPageTitle("pagetitle"));
		LoggerLoad.info("You are on the " + driver.getTitle() + " page.");
	}

	@Then("Admin should see the showing x to y of z entries and enabled pagination controls under the data table")
	public void admin_should_see_the_showing_x_to_y_of_z_entries_and_enabled_pagination_controls_under_the_data_table() {
		 Assert.assertTrue(classObj.isPaginationEnabled(), "Pagination is not displayed");
	}

	@When("Admin is on the Class page after login successful")
	public void admin_is_on_the_class_page_after_login_successful() {
		 dashObj.validLogin();
		classObj.clickDashboardClass();
	}

	@Then("Admin should see the Manage Class Header")
	public void admin_should_see_the_manage_class_header() {
		Assert.assertEquals(classObj.manageClassgetText(), resourceBundleReader.getFunctionalityMessage("class"));
		LoggerLoad.info("You are viewing the " + driver.getTitle() + " page.");
	}

	@Then("Admin should see the LMS Learning Management System Title")
	public void admin_should_see_the_lms_learning_management_system_title() {
		Assert.assertEquals(classObj.getActualTitle(), resourceBundleReader.getPageTitle("pagetitle"));
		LoggerLoad.info("You are viewing the " + driver.getTitle() + " page.");
	}

	@Then("Admin should see the Searchbar in Manage class page")
	public void admin_should_see_the_searchbar_in_manage_class_page() {
		Assert.assertTrue(classObj.clicksearchBox(), "Search Textbox is not displayed");
	}

	@Then("Admin should see the datatable heading like Batchname, class topic, class description, status, classDate, staff name, Edit\\/Delete")
	public void admin_should_see_the_datatable_heading_like_batchname_class_topic_class_description_status_class_date_staff_name_edit_delete() {
		List<String> actualElementTexts = classObj.getElementText();
		actualElementTexts.forEach(System.out::println);

		List<String> expectedElementTexts = Arrays
				.asList(resourceBundleReader.getFunctionalityMessage("ClHeaderName1").split(","));
		 Assert.assertEquals(actualElementTexts, expectedElementTexts);

		 Assert.assertTrue(classObj.editIconEnable(), "Edit/Delete Icon in Batch Page is not Enabled");

		 LoggerLoad.info("The User is seeing all Header Names present in the page" +
		 classObj.getElementText());
		 LoggerLoad.info("Edit/Delete Icon in Batch Page is present = " +
		 classObj.editIconEnable());
	}

	@Then("Admin should see the Sort icon of all the field in the datatable")
	public void admin_should_see_the_sort_icon_of_all_the_field_in_the_datatable() {
		 Assert.assertTrue(classObj.verifyHeaderSortPresence());
		LoggerLoad.info("All header sort elements are present and displayed. " + classObj.verifyHeaderSortPresence());
	}

	@Then("Admin should see the Delete button under the Manage class page header")
	public void admin_should_see_the_delete_button_under_the_manage_class_page_header() {
		Assert.assertTrue(classObj.verifydeletebtn());
		LoggerLoad.info("Delete icon is present and displayed. " + classObj.verifydeletebtn());
	}

	@Then("Admin should see Total no of classes in below of the data table")
	public void admin_should_see_total_no_of_classes_in_below_of_the_data_table() {
		 Assert.assertTrue(classObj.getDisplayedTotalClasses());
	}
}
