package Deals_TC;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Functions.Deals;
import Functions.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewDealPage;

public class EnterNewDeal extends TestBase{
	LoginPage login_page;
	NewDealPage new_deal_page;
	HomePage home_page;
	Deals deal;
	
	public EnterNewDeal()
	{
		super();
	}
	
	@BeforeMethod
	public void baseBeforeMethod()
	{
		openBrowser();
		openUrl("homepage");
		login_page = new LoginPage();
		home_page = login_page.login(prop.getProperty("admin_usr"), prop.getProperty("admin_pwd"));
		new_deal_page = home_page.openNewDealForm();
	}
	
	@Test(dataProvider = "createNewDeal", dataProviderClass = Functions.DataProviders.class)
	public void enter_new_deal(String title, String amount, String quantity, String type, String status, String exclude_reports)
	{
		new_deal_page.enterTitle(title);
		new_deal_page.enterAmount(amount);
		new_deal_page.enterQuantity(quantity);
		new_deal_page.selectType(type);
		new_deal_page.setStatus(status);
		new_deal_page.selectExcludeReports(exclude_reports);
		new_deal_page.selectPredictedOrActualCloseDateAs("Predicted");
		String dealNumber = new_deal_page.dealNoBeforeSave();
		new_deal_page.saveDeal();
		String newDealNumber = new_deal_page.dealNoAfterSave();
		Assert.assertEquals(dealNumber, newDealNumber, "Either Deal is not saved or it is saved with incorrect Deal No.");
	}
	
	@AfterMethod
	public void baseAfterMethod()
	{
		driver.close();
	}

}
