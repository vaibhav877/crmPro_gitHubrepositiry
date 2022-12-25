package tasecases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.base.baseClass;
import crm.pages.DealsPage;
import crm.pages.HomePage;
import crm.pages.LoginPage;
import crm.util.utilityClass;

public class dealsPageTest extends baseClass {
	LoginPage loginpage;
	HomePage homepage;
	utilityClass util;
	DealsPage dealspage;
	int TCID;
	@BeforeMethod
public void setUp() throws IOException
{
		browserInitialization();
		 loginpage=new LoginPage();
		 
		 dealspage=new DealsPage();
		 util=new utilityClass();
		 homepage=loginpage.login(utilityClass.getDataFromPropertiedfile("username"), utilityClass.getDataFromPropertiedfile("password"));
		 util.switchToFrame();
		 homepage.clickOnDeals();
		}
	
	
	
	@Test
	public void verifyTitleofdealPageTest()
	{
		TCID=301;
		String actualtitle = dealspage.getTitltOfDealsPage();
		String expectedtitle = "CRMPRO";
		Assert.assertEquals(actualtitle, expectedtitle);
	}
	
	@Test
	public void verifyLabelOfdealsPage()
	{
		TCID=302;
		Assert.assertTrue(dealspage.validateDealsLable());
	}
	
	@Test
	public void verifyTextMessageOfTypeHelPTest()
	{
		TCID=303;
		String typepopupmsg = dealspage.getTypePopUptextMessage();
		System.out.println(typepopupmsg);
		String expectedmsg ="Field Sets are customizable data selectors which are used for various records type. For example, the Stage field in a Deal record is a Field Set. Most Field Sets have a default set of values, but all of them can be customized to fit your needs. To customize a Field Set, open the Setup screen, and select the Field Set option.\r\n"
				+ "Choose the Set you would like to change from the list of sets, and modify the values in the form that will open below.";
		Assert.assertEquals(typepopupmsg, expectedmsg);
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
	public void tearDown ()
	{
	driver.quit();	
	}
	
	
}
