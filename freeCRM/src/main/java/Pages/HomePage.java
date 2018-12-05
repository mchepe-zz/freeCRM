package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Functions.TestBase;

public class HomePage extends TestBase{
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="a[title='Deals']")
	WebElement deals;
	
	@FindBy(css="a[title='New Deal']")
	WebElement newDeal;
	
	public NewDealPage openNewDealForm()
	{
		driver.switchTo().frame("mainpanel");
		Actions action = new  Actions(driver);
		action.moveToElement(deals).build().perform();
		newDeal.click();
		return new NewDealPage();
	}
	
	public DealsPage openDeals()
	{
//		driver.switchTo().frame("mainpanel");
//		Actions action = new Actions(driver);
//		action.moveToElement(deals).click().build().perform();
		deals.click();
		return new DealsPage();
	}
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
}
