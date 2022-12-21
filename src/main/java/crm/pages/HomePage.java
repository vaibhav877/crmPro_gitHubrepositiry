package crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.base.baseClass;

public class HomePage extends baseClass {

	@FindBy(xpath="//td[contains(text(),'User: Vaibhav Thorat')]") private WebElement userLabel;
	
@FindBy(xpath="//a[text()='Contacts']") private WebElement contactsLink;
@FindBy(xpath="//a[text()='Deals']") private WebElement dealsLink;
@FindBy(xpath="//a[text()='Tasks']") private WebElement taskLink;
@FindBy(xpath="//a[text()='New Contact']") private WebElement newContactLink;
@FindBy(xpath="//a[text()='Calendar']") private WebElement calenderLink;

Actions act;
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getTitleOfHomePage()
	{
	  return driver.getTitle();
	}
	//validate user name label displayed
	public boolean validateUsername()
	{
		return userLabel.isDisplayed();        
	}
	
	//click on contacts link
	public ContactsPage clickOnContacts()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	//click on Deals link
	public DealsPage clickOnDeals()
	{
		dealsLink.click();
		return new DealsPage();
	}
	//click on Tasks link
	public TaskPage clickOnTask()
	{
		taskLink.click();
		return new TaskPage();
	}
	//click on calender page 
	public CalenderPage clickOnCalender()
	{
		calenderLink.click();
		return new CalenderPage();
	}
	//click on new contact
	public void clickOnnewcontactLink() throws InterruptedException
	{
		act=new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
	    Thread.sleep(2000);
		newContactLink.click();
		
	}
	
	
	
}
