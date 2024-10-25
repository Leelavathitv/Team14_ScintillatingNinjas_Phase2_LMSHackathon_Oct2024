package runner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		 features = {"src/test/resources/feature"},
   glue = {"stepDefinition","hooks"},
   monochrome = true,

	


  tags= "",
   plugin= {"pretty","html:target/cucumber-reports/cucumber.html",
   		//"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
   		// "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
   		// "rerun:target/rerun.txt",
   		})

public class TestRunner extends AbstractTestNGCucumberTests{
	
	@BeforeTest
	@Parameters({"browser"})
	public void defineBrowser(@Optional ("chrome") String browser) {
		//ConfigFileReader.setBrowserType(browser);
	}
	@Override
   @DataProvider(parallel = false)//true means execute parallely false mean not execute parallely
	
   public Object[][] scenarios() {
				
		return super.scenarios();
   }	
}