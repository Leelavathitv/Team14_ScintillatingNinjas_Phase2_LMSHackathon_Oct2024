package utilities;


import java.util.ResourceBundle;

public class ResourceBundleReader {
	ResourceBundle resouceBundle = ResourceBundle.getBundle("config/Configuration");
	
	public String getUrl() {
		String url = resouceBundle.getString("homeUrl");
		return url;
	}
	public String getUserName() {
		String userName = resouceBundle.getString("username");
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

}
