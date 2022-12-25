package crm.pages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.base.baseClass;


public class DealsPage extends baseClass {
	@FindBy(xpath="//td[contains(text(),'State: Open')]") private WebElement dealslabel;
	@FindBy(xpath="(//input[@class='button_help'] )[2]") private WebElement typeHelp;
	@FindBy(xpath="//table//tr[2]//td") private WebElement childbrowsedatatr2;
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateDealsLable()
	{
		return dealslabel.isDisplayed();
	}
	public String getTitltOfDealsPage()
    {
	return driver.getTitle();
	}
  
	public String getTypePopUptextMessage()
	{
		typeHelp.click();
		Set<String> allhandlesid = driver.getWindowHandles();
		ArrayList<String> ids=new ArrayList<String>(allhandlesid);
		String childwindowid = ids.get(1);
		driver.switchTo().window(childwindowid);
		return childbrowsedatatr2.getText();
	}

	
}
