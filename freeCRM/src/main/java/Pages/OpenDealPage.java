package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Functions.TestBase;

public class OpenDealPage extends TestBase{
	
	public OpenDealPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[value='Edit']")
	WebElement edit;
	
	public NewDealPage clickEdit()
	{
		edit.click();
		return new NewDealPage();
	}

}
