package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Functions.TestBase;

public class DealsPage extends TestBase{
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='pagination']/a")
	List<WebElement> total_pages;
	
	@FindBy(css="input[value='Show All']")
	WebElement all_deals;
	
	@FindBy(xpath="//strong[text()='History']//following::a[@class='small_link']")
	WebElement last_used_deal;
	
	public WebElement dealId(String title, String id)
	{
		return driver.findElement(By.xpath("//a[@_title='" + title + "'][text()='" + id + "']"));
	}
	
	public OpenDealPage openExistingDeal()
	{
		last_used_deal.click();
		return new OpenDealPage();
	}
	
//	public void openExistingDeal(String title, String id)
//	{
//		for (int a = 0; a <= total_pages.size(); a++) //(WebElement a : total_pages)
//		{
//			if(this.dealId(title, id).isDisplayed())
//			{
//				this.dealId(title, id).click();
//				break;
//			}
//			else
//			{
//				total_pages.get(a++).click();
//			}
//		}
//	}
	
	public void show_all_deals()
	{
		all_deals.click();
	}
}
