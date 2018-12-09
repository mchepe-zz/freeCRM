package Functions;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	static String workingDir = System.getProperty("user.dir");
	static String testDataFolder = "\\src\\main\\java\\TestData\\";
	public Object[][] testData;
	Utils utilities = new Utils();

	@DataProvider(name = "validCredentials")
	public Object[][] validCredentials()
	{
		testData = Utils.readExcelDataArray(workingDir+testDataFolder+"LoginData.xlsx", "login_with_valid_data");
		return testData;
	}
	
	@DataProvider(name = "invalidCredentials")
	public Object[][] invalidCredentials()
	{
		testData = Utils.readExcelDataArray(workingDir+testDataFolder+"LoginData.xlsx", "login_with_invalid_data");
		return testData;
	}
	
	@DataProvider(name = "createNewDeal")
	public Object[][] createNewDeal()
	{
		testData = Utils.readExcelDataArray(workingDir+testDataFolder+"Deals.xlsx", "new_deal");
		return testData;
	}
	@DataProvider(name = "editDeal")
	public Object[][] editDeal()
	{
		testData = Utils.readExcelDataArray(workingDir+testDataFolder+"Deals.xlsx", "edit_deal");
		return testData;
	}

}
