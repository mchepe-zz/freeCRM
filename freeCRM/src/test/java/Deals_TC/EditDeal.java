package Deals_TC;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Functions.TestBase;
import Pages.DealsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewDealPage;
import Pages.OpenDealPage;

public class EditDeal extends TestBase{
	LoginPage login_page;
	HomePage home_page;
	NewDealPage new_deal_page;
	DealsPage deal_page;
	OpenDealPage open_existing_deal_page;
	
	
	public EditDeal()
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
	
	@Test(dataProvider = "editDeal", dataProviderClass = Functions.DataProviders.class)
	public void editDeal(String title, String amount, String quantity, String status, String type, String exclude_reports, String new_title)
	{
		new_deal_page.enterTitle(title);
		new_deal_page.enterAmount(amount);
		new_deal_page.enterQuantity(quantity);
		new_deal_page.setStatus(status);
		new_deal_page.selectPredictedOrActualCloseDateAs("Predicted");
		new_deal_page.saveDeal();
		
		deal_page = home_page.openDeals();
		
		open_existing_deal_page = deal_page.openExistingDeal();
		
		open_existing_deal_page.clickEdit();
		
		new_deal_page.enterTitle(new_title);
		new_deal_page.selectPredictedOrActualCloseDateAs("Actual");
		new_deal_page.saveDeal();
	}
	
	@AfterMethod
	public void baseAfterMethod()
	{
		driver.close();
	}

}
