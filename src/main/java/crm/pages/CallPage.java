package crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.base.baseClass;

public class CallPage extends baseClass {
	@FindBy (xpath="//legend[text()='Call Information']") private WebElement CallInformationLabel;
	@FindBy (xpath="//input[@name='prospect_lookup']") private WebElement dealTxtBox ;
	@FindBy (xpath="//input[@name='task_lookup']") private WebElement taskTxtBox;
	@FindBy (xpath="//input[@name='case_lookup']") private WebElement caseTxtBox;
	@FindBy(xpath="//input[@name='create_new' and @value='prospect']") private WebElement creatNewDealCheckBox;
	@FindBy(xpath="//input[@name='create_new' and @value='task']") private WebElement creatNewTaskCheckBox;
	@FindBy(xpath="//input[@name='create_new' and @value='case']") private WebElement creatNewCaseCheckBox;
	@FindBy (xpath="//textarea[@name='notes']") private WebElement noteMsg ;
	@FindBy (xpath="//input[@name='save'and @value='Save']")private WebElement saveBtn ;
	
	public CallPage()
	{
		PageFactory.initElements(driver, this);
	}
	//get title of call page 
	public String getTitleOfCallPage()
	{
		return driver.getTitle();
		
	}
	//validate label on call page
	public boolean validatecallPageLabel()
	{
		return CallInformationLabel.isDisplayed();
	}
	
	//enter information to save
	public void addInformationAndSave(String dealinput,String taskinput,String caseinput,String note)
	{
		dealTxtBox.sendKeys(dealinput);
		taskTxtBox.sendKeys(taskinput);
		caseTxtBox.sendKeys(caseinput);
		creatNewTaskCheckBox.click();
		creatNewCaseCheckBox.click();
		creatNewDealCheckBox.click();
		noteMsg.sendKeys(note);
		saveBtn.click();
		
	}
	
} 
