package Functions;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	static String workingDir = System.getProperty("user.dir");
	static String testDataFolder = "\\src\\main\\java\\TestData\\";
	Utils utilities = new Utils();

	@DataProvider(name = "validCredentials")
	public Object[][] validCredentials()
	{
		Object[][] loginDetails = Utils.readExcelDataArray(workingDir+testDataFolder+"LoginData.xlsx", "login_with_valid_data");
		return loginDetails;
	}
	
	@DataProvider(name = "invalidCredentials")
	public Object[][] invalidCredentials()
	{
		Object[][] loginDetails = Utils.readExcelDataArray(workingDir+testDataFolder+"LoginData.xlsx", "login_with_invalid_data");
		return loginDetails;
	}

}
