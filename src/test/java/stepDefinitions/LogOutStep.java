package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import pageObjects.LogOutPage;
import testContext.TestContext;
import utilities.ResourceBundleReader;

public class LogOutStep {
	
	TestContext testContext;
	WebDriver driver;
	ResourceBundleReader resourceBundleReader;
	Logger logger= LogManager.getLogger(LoginStep.class);
	DashboardPage dashboard;
	BatchPage batchpage;
	LogOutPage logoutpage;

	public LogOutStep(TestContext testcontext) {
    	this.testContext = testcontext;    	
    	this.resourceBundleReader = testcontext.getResourceBundleReader();
    	this.driver=testcontext.getDriverManager().getDriver();
    	this.dashboard =testcontext.getPageObjectManager().getDashboardPage();
    	this.batchpage=testcontext.getPageObjectManager().getBatchPage();
    	this.logoutpage=testcontext.getPageObjectManager().getLogOutPage();
    }
	
	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
		logoutpage.LogoutMenu();
		
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
		

	}


}
