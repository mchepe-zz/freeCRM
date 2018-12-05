package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Functions.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;

	@FindBy(css="[value='Login']")
	WebElement loginbutton;

	public void enterUsername(String user_name)
	{
		username.sendKeys(user_name);
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public HomePage clickLogin()
	{
		try 
		{
			Thread.sleep(2000);
			loginbutton.click();
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		return new HomePage();
	}
	
	public HomePage login(String user_name, String pwd)
	{
		username.sendKeys(user_name);
		password.sendKeys(pwd);
		try 
		{
			Thread.sleep(2000);
			loginbutton.click();
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		return new HomePage();
	}
	
	public boolean loginBttnAvailable()
	{
		boolean status = loginbutton.isDisplayed();
		return status;
	}
}
