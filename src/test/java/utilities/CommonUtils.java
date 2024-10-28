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

	public boolean listofElementDisplayed(List<WebElement> element) {
		boolean flag = false;
		try {
			if (((WebElement) element).isDisplayed()) {
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

//	public boolean listCheckBoxes(WebElement ele) {
//		if (element.isEnabled()) {
//			return true;
//		} else {
//			return false;
//		}
		
		
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

	

}
