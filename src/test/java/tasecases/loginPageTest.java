package tasecases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.base.baseClass;
import crm.pages.HomePage;
import crm.pages.LoginPage;
import crm.util.utilityClass;

public class loginPageTest extends baseClass {

	LoginPage loginpage;
	HomePage homepage;
	int TCID;
	public loginPageTest()
	{
		
	}
	
	
	
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		browserInitialization();
		 loginpage=new LoginPage();
	}
	@Test(priority=1)
	public void verifyloginPageTitleTest() throws InterruptedException
	{ TCID=101;
	
		Thread.sleep(3000);
		String actualtitle = loginpage.getTitleOfLoginPage();
		System.out.println(actualtitle);
		String expectedtitle ="CRMPRO - CRM software for customer relationship management, sales, and support.";
		Assert.assertEquals(actualtitle, expectedtitle);
	}
	@Test(priority=2)
	public void crmLogoTest()
	{
		
		TCID=102;
		boolean result = loginpage.validateCRMImageLogo();
		Assert.assertTrue(result);
	}
	
	@Test(priority=3)
	public void verifyloginTest() throws IOException
	{
		TCID=102;
	homepage=loginpage.login(getDataFromPropertiedfile("username"),getDataFromPropertiedfile("password"));
	
	}
	

	@AfterMethod
	public void logOut(ITestResult result) throws IOException, InterruptedException 
	{
		
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			utilityClass.captureSreenshot(driver,TCID);
			Thread.sleep(3000);
			
		}
		
		driver.close();
		}

	
@AfterClass
public void tearDown()
{
	driver.quit();
}
}
