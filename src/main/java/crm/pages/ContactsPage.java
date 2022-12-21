package crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import crm.base.baseClass;

public class ContactsPage extends baseClass {
	
	@FindBy (xpath="//td[contains(text(),'Contacts')]") private WebElement contactslabel;
	@FindBy (xpath="//select[@name='title']") private WebElement titleDD;
	@FindBy(xpath="//input[@name='first_name']") private WebElement firstN;
	@FindBy(xpath="//input[@id='surname']") private WebElement lastN;
	@FindBy(xpath="//input[@name='client_lookup']") private WebElement companyN;
	@FindBy (xpath="//input[@type='submit' and @value='Save']") private WebElement saveBtn;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateContactsPagelabel()
	{
		return contactslabel.isDisplayed();
	}
	//get title of contacts page
	public String getTitleOFContactsPage()
	{
		return driver.getTitle();
	}

	
	// select contacts from contact list
	
	public void setectContactFromListByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void creatNewContact(String title,String firstname,String lastname,String company )
	{
		Select select=new Select(titleDD);
		select.selectByVisibleText(title);
		firstN.sendKeys(firstname);
		lastN.sendKeys(lastname);
		companyN.sendKeys(company);
		saveBtn.click();
	
	}
}
