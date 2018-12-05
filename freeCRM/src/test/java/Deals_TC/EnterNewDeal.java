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
		//new_deal_page = new NewDealPage();
		deal = new Deals();
		login_page = new LoginPage();
		home_page = login_page.login(prop.getProperty("admin_usr"), prop.getProperty("admin_pwd"));
		new_deal_page = home_page.openNewDealForm();
	}
	
	@Test
	public void enter_new_deal()
	{
		new_deal_page.enterTitle(deal.title);
		new_deal_page.enterAmount(deal.amount);
		new_deal_page.enterQuantity(deal.quantity);
		new_deal_page.selectType(deal.type);
		new_deal_page.setStatus(deal.status);
		new_deal_page.selectExcludeReports();
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
