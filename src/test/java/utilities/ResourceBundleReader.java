package utilities;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;

public class ResourceBundleReader {

	private static ResourceBundleReader resourceBundleReader = new ResourceBundleReader();

	ResourceBundle resouceBundle = ResourceBundle.getBundle("config/Configuration");
	WebDriver driver;
	public ResourceBundleReader() {
		
	}
	public ResourceBundleReader getInstance() {
		return resourceBundleReader;
	}
	
	public String getUrl() {
		String url = resouceBundle.getString("loginUrl");
		return url;
	}
	public String getUserName() {
		String userName = getFunctionalityMessage("username");
		return userName;
	}

	public String getPassword() {
		String password = resouceBundle.getString("password");
		return password;
	}
	
	public String getExcel() {
		String excelData = resouceBundle.getString("exceldata");
		return excelData;
	}
	

	public String getHomePageHeader() {
		String header = resouceBundle.getString("HomePageHeader");
		return header;
	}

	public String getPageTitle(String titleName) {
		String title = resouceBundle.getString(titleName);
		return title;
	}
	
	public String getFunctionalityMessage(String name) {
		String batch = resouceBundle.getString(name);
		return batch;
	}
	

}
