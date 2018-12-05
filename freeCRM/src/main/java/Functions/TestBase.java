package Functions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.LoginPage;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	String workingDir = System.getProperty("user.dir");
	String propertiesFolder = "\\src\\main\\java\\";
	//Utils utilities = new Utils();
	
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream(workingDir + propertiesFolder + "TestBase.properties");
			prop.load(fis);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void openBrowser()
	{
		//driver = driv;
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
			driver = new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriver"));
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//return driver;
	}
	
	public void openUrl(String page)
	{
		driver.get(prop.getProperty(page));
	}
	
	public void login()
	{
		LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
		login_page.enterUsername("mayurc");
		login_page.enterPassword("test@123");
		login_page.clickLogin();
	}

}
