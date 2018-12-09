package Pages;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Functions.TestBase;

public class NewDealPage extends TestBase{
	
	public NewDealPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="title")
	WebElement title;
	
	@FindBy(id="amount")
	WebElement amount;
	
	@FindBy(id="quantity")
	WebElement quantity;
	
	@FindBy(name="exclude_reports")
	WebElement exclude_reports;
	
	@FindBy(css="[name='type'][size='1']") 	//	xpath="//strong[text()='Type']/following::select[1]"
	WebElement type;
	
	@FindBy(xpath="//input[@name='addmore']//preceding::input[1]")
	WebElement save;
	
	@FindBy(css="input[name='sequence']")
	WebElement deal_no_before_save;
	
	@FindBy(xpath="//strong[contains(text(), 'Deal No')]/following::td[1]")
	WebElement deal_no_after_save;
	
	@FindBy(css="input[name='closed'][value='Y']")
	WebElement statusClosed;
	
	@FindBy(css="input[name='closed'][value='N']")
	WebElement statusOpen;
	
	@FindBy(xpath="//td[@class='day'] | //td[@class='day weekend']")
	List<WebElement> dates;
	
	@FindBy(id="f_trigger_c_close_date")
	WebElement predictedCloseDate;
	
	@FindBy(id="f_trigger_c_actual_close_date")
	WebElement actualCloseDate;
	
	
	public void enterTitle(String dealTitle)
	{
		title.clear();
		title.sendKeys(dealTitle);
	}
	
	public void enterAmount(String dealAmount)
	{
		amount.sendKeys(dealAmount);
	}
	
	public void enterQuantity(String dealQuantity)
	{
		quantity.sendKeys(dealQuantity);
	}
	
	public void selectExcludeReports(String exclude_rep)
	{
		if (exclude_rep.equalsIgnoreCase("true"))
		exclude_reports.click();
	}
	
	public void saveDeal()
	{
		save.click();
	}
	
	public String dealNoBeforeSave()
	{
		return deal_no_before_save.getAttribute("value");
	}
	
	public String dealNoAfterSave()
	{
		return deal_no_after_save.getText().replaceAll("\\s+", "");
	}
	
	public void selectType(String typevalue)
	{
		Select dealType = new Select(type);
		dealType.selectByValue(typevalue);
	}
	
	public void setStatusAsOpen()
	{
		if(statusOpen.isSelected() == false)
			statusOpen.click();
	}
	
	public void setStatusAsClosed()
	{
		if(statusClosed.isSelected() == false)
			statusClosed.click();
	}

	public void setStatus(String status)
	{
		if(status.equalsIgnoreCase("Open"))
			statusOpen.click();
		else if(status.equalsIgnoreCase("Closed"))
			statusClosed.click();
		else
			System.out.println("'Status' mentioned in test data excel file is invalid");
	}
	
	public void selectPredictedOrActualCloseDateAs(String dateType)
	{
		Calendar cal = Calendar.getInstance();
		Integer date_to_be_selected = cal.get(Calendar.DAY_OF_MONTH);
		
		if(dateType.equalsIgnoreCase("predicted"))
		{
			predictedCloseDate.click();
			date_to_be_selected = date_to_be_selected + 3;
		}
		else if(dateType.equalsIgnoreCase("actual"))
		{
			actualCloseDate.click();
			date_to_be_selected = date_to_be_selected + 5;
		}
		else
			System.out.println("Invalid date type is provided. Please enter either 'Predicted' or 'Actual' as date type.");
		
		for (int counter = 0; counter < dates.size(); counter++)
		{
			Integer date_value = Integer.parseInt(dates.get(counter).getText());
			if(date_value == date_to_be_selected)
			{
				dates.get(counter).click();
				break;
			}
		}
	}
	
//	public void selectActualCloseDateAs(String date)
//	{
//		actualCloseDate.click();
//		for (int counter = 0; counter < dates.size(); counter++)
//		{
//			if(dates.get(counter).getText().equals(date))
//			{
//				dates.get(counter).click();
//				break;
//			}
//		}
//	}
	
}
