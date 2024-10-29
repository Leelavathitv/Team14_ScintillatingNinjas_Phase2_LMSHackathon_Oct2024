package utilities;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

public class ExcelFileData extends ResourceBundleReader {

    public static String programName;
    public static String programDescription;
    public static String programStatus;
    public static String EditProgramName;
    public static String EditProgramDescription;
    public static String userName;
    public static String password;

    static Map<String, String> xLDataMap;

    
        // Initialize resourceBundleReader
    public static ResourceBundleReader resourceBundleReader = new ResourceBundleReader();
    

    // Home Page validation TestData
    public static Map<String, String> programExcelData(String key, String sheetName) throws Exception {
        String excelFilePath = resourceBundleReader.getExcel(); // Retrieve the Excel file path
        try (FileInputStream fi = new FileInputStream(excelFilePath)) {
            xLDataMap = ExcelFileReader.getData1(key, sheetName, fi); // Pass FileInputStream to getData1

            programName = xLDataMap.get("ProgramName");
            programDescription = xLDataMap.get("ProgramDescription");
            programStatus = xLDataMap.get("Status");
            EditProgramName = xLDataMap.get("EditProgramName");
            EditProgramDescription = xLDataMap.get("EditProgramDescription");
        }
        return xLDataMap;
    }

    // Login Page validation TestData
    public static Map<String, String> loginPageExcelData(String key, String sheetName) throws Exception {
        String excelFilePath = resourceBundleReader.getExcel(); // Retrieve the Excel file path
        try (FileInputStream fi = new FileInputStream(excelFilePath)) {
            xLDataMap = ExcelFileReader.getData1(key, sheetName, fi); // Pass FileInputStream to getData1

            userName = xLDataMap.get("UserNameData");
            password = xLDataMap.get("PasswordData");
        }
        return xLDataMap;
    }
}