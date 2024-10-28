package utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import utilities.LoggerLoad;

public class CommonUtils {

	public boolean isDisplayed(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()) {
				flag = true;
				System.out.println("The element is Displayed" + element);

			} else {
				flag = false;
				System.out.println("The element is not Displayed" + element);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	public boolean isEnabled(WebElement element) {
		if (element.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed() || element.isEnabled()) {
				flag = true;
			}

		} catch (NoSuchElementException | StaleElementReferenceException e) {
			flag = false;
			LoggerLoad.error("Element'" + element + "'is not present");
		}

		return flag;

	}

	// Method to return all Get Started elements as a list
//		public List<WebElement> getAnylinkofGetStarted() {
//			List<WebElement> getStartedLinks = new ArrayList<>();
//			getStartedLinks.add(datastructureGetstarted);
//			getStartedLinks.add(arrayGetstarted);
//			getStartedLinks.add(linkedlistGetstarted);
//			getStartedLinks.add(stackGetstarted);
//			getStartedLinks.add(queueGetstarted);
//			getStartedLinks.add(treeGetstarted);
//			getStartedLinks.add(graphGetstarted);
//			return getStartedLinks;
//		}
//
//		// Method to click on specific Get Started buttons
//		public void clickspecificGetStartedlink(WebElement link) {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.visibilityOf(link)).click();
//			// link.click();
//		}
//	@Then("The User should get the alert message")
//	public void The_User_should_get_the_alert_message() {
//		// Check the alert message
//		for (WebElement link : homeObj.getAnylinkofGetStarted()) {
//			homeObj.clickspecificGetStartedlink(link);
//			Assert.assertEquals(homeObj.getActualMessage(), configFileReader.getAlert("homepageGetStartedAlert"));
//			LoggerLoad.info("The User is seeing the alert message " + homeObj.getActualMessage());
//		}
//	}

}
