package StepDefinitions;

import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Functions.TestBase;
import Pages.LoginPage;

public class login extends TestBase{
	LoginPage login_page = new LoginPage();
	
	@Given("^User is on Free CRM Login Page$")
	public void user_is_on_Free_CRM_Login_Page() {
		openBrowser();
	}

	@When("^user enter username as \"(.*?)\"$")
	public void user_enter_username_as(String username) {
		//LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
		login_page.enterUsername(username);
	}

	@When("^user enter password as \"(.*?)\"$")
	public void user_enter_password_as(String password) {
		//LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
		login_page.enterPassword(password);
	}

	@When("^user click on login button$")
	public void user_click_on_login_button() {
		//LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
		login_page.clickLogin();
	}

	@Then("^User should be able to log into Free CRM website successfully$")
	public void user_should_be_able_to_log_into_Free_CRM_website_successfully() {
		Assert.assertEquals("CRMPRO", driver.getTitle());
	}
	
	@Then("^User closes the browser$")
	public void user_closes_the_browser() {
		driver.close();
	}
	
	@Then("^User should not be able to log into Free CRM website$")
	public void user_should_not_be_able_to_log_into_Free_CRM_website() throws Throwable {
		//LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertTrue("User should not be able to Login with invalid credentials : TC Failed", login_page.loginBttnAvailable());
	}
}
