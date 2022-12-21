package crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.base.baseClass;

public class LoginPage extends baseClass {

	@FindBy(xpath="//input[@name='username']") private WebElement username;
	
@FindBy (xpath="//input[@name='password']") private WebElement password ;
@FindBy (xpath="//input[@type='submit']") private WebElement LoginBtn;

@FindBy(xpath="//a[text()='Sign Up']") private WebElement signUpBtn;
@FindBy(xpath="//img[@class='img-responsive']")private WebElement crmlogo;


//initialize web Objects
public LoginPage()
{  
	PageFactory.initElements(driver,this );
}

//
public String getTitleOfLoginPage()
{
	return driver.getTitle();
	}

public boolean validateCRMImageLogo()
{ 
	return crmlogo.isDisplayed();
	
	}

public HomePage login(String un, String pwd)
{
	username.sendKeys(un);
	password.sendKeys(pwd);
	LoginBtn.click();
	
	return new HomePage();
	}



}