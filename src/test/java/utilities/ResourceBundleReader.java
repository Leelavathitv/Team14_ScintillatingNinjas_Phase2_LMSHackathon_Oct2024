package utilities;

import java.util.ResourceBundle;

public class ResourceBundleReader {
	
	ResourceBundle resouceBundle = ResourceBundle.getBundle("config/Configuration");
	
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
	
	public String getPageTitle(String titleName) {
		String title = resouceBundle.getString(titleName);
		return title;
	}
	
	public String getFunctionalityMessage(String name) {
		String batch = resouceBundle.getString(name);
		return batch;
	}
	
	public String getProgramDeleteConfirm(String titleName) {
		String title = resouceBundle.getString(titleName);
		return title;
	}

//	public String getSuccessfulProgramDeleted(String titleName) {
//		String title = resouceBundle.getString(titleName);
//		return title;
//	}

	
}
