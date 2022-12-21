package crm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import crm.base.baseClass;


public class CalenderPage extends baseClass{
	
	@FindBy (xpath="//select[@name='slctMonth']") private WebElement cale_month;
	@FindBy (xpath="//select[@name='slctYear']") private WebElement cale_year;
	
	
	
	public CalenderPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void selectDDMMYYYY(String dd,String mm,String yyyy)
	{
		Select s1=new Select(cale_month);
		s1.selectByVisibleText(mm);
		
		Select s2=new Select(cale_year);
		s2.selectByVisibleText(yyyy);
		
		List<WebElement> date = driver.findElements(By.xpath("//table[@class='crmcalendar']//tr//td[@class='calendarcell']"));
		System.out.println(date.size());
	//using for each loop
	for(WebElement D:date)
	{
		String dateavailable = D.getText();
		if(dd.equalsIgnoreCase(dateavailable))
		{
		D.click();	
		break;
		}
		
		System.out.println(D.getText());
	}
	

	
	}
}
