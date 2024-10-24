package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.DashboardPage;
import testContext.TestContext;
import utilities.ResourceBundleReader;

public class BatchStep {
	TestContext testContext;
	ResourceBundleReader resourceBundleReader;
	WebDriver driver;
	DashboardPage loginPage;
	
	@SuppressWarnings("static-access")
	public BatchStep(TestContext testcontext) {
		this.testContext = testcontext;
		
		this.resourceBundleReader = testcontext.getResourceBundleReader();
		this.driver = testcontext.getDriverManager().getDriver();
	}
	
	@Given("Admin successfully Logged on to the LMS Portal")
	public void admin_successfully_logged_on_to_the_lms_portal() {
	   
	}

	@Given("Admin is on the Dashboard Page")
	public void admin_is_on_the_dashboard_page() throws Exception {
//		loginPage.loginUsingCookies();
//		Thread.sleep(3000);
//	    driver.findElement(By.xpath("//span[contains(text(),'Batch')]")).click();
	}

	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
	   
	}

	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() {
	   
	}
}
