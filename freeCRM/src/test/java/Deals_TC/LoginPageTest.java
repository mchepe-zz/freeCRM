package Deals_TC;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Functions.TestBase;
import Pages.HomePage;
import Pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage login_page;
	HomePage home_page;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		openBrowser();
		openUrl("homepage");
		login_page = new LoginPage();
	}
	
	@Test
	public void LoginTestUsingPropertyValues()
	{
		login_page.enterUsername(prop.getProperty("admin_usr"));
		login_page.enterPassword(prop.getProperty("admin_pwd"));
		home_page = login_page.clickLogin();
		String title = home_page.validateTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(dataProvider = "validCredentials", dataProviderClass = Functions.DataProviders.class)
	public void LoginWithValidCred(String username, String password)
	{
		login_page.enterUsername(username);
		login_page.enterPassword(password);
		home_page = login_page.clickLogin();
		String title = home_page.validateTitle();
		Assert.assertEquals(title, "CRMPRO");
	}

	@Test(dataProvider = "invalidCredentials", dataProviderClass = Functions.DataProviders.class)
	public void LoginWithInvalidCred(String username, String password) throws InterruptedException
	{
		login_page.enterUsername(username);
		login_page.enterPassword(password);
		home_page = login_page.clickLogin();
		Assert.assertTrue(login_page.loginBttnAvailable());
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
