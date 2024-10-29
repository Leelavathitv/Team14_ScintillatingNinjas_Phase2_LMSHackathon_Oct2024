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
	
	public String getuserErrorMsg() {
		String txt = resouceBundle.getString("userErrorMsg");
		return txt;
	}
	
	public String getpasswordErrorMsg() {
		String txt = resouceBundle.getString("passwordErrorMsg");
		return txt;
	}


	public String getPageTitle(String titleName) {
		String title = resouceBundle.getString(titleName);
		return title;
	}
	
	public String getFunctionalityMessage(String name) {
		String batch = resouceBundle.getString(name);
		return batch;
	}
	
	public String getDashBoardPageText() {
		String text = resouceBundle.getString("DashBoardPageText");
		return text;
	}
	
	public String getInvalidURL() {
		String url = resouceBundle.getString("InvalidURL");
		return url;
	}
	public String getCompanyName() {
		String name = resouceBundle.getString("CompanyName");
		return name;
	}
	
	public String getAppName() {
		String appName = resouceBundle.getString("AppName");
		return appName;
	}
	
	public String getCompanyLogoScreeshot() {
		String logo = resouceBundle.getString("CompanyLogoScreenshot"); 
		return logo;
	}
	
	public String getSignInContent() {
		String content = resouceBundle.getString("SignInContent");
		return content;
	}
	
	public String getTextBox1() {
		String text = resouceBundle.getString("TextBox1");
		return text;
	}
	
	public String getTextBox2() {
		String text = resouceBundle.getString("TextBox2");
		return text;
	}
}
