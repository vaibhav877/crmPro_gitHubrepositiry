package tasecases;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import crm.base.baseClass;
import crm.pages.ContactsPage;
import crm.pages.HomePage;
import crm.pages.LoginPage;
import crm.util.utilityClass;


public class contactsPageTest extends baseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	utilityClass testUtil;
	ContactsPage contactpage;
	int TCID;
	@BeforeMethod
	public void setUp() throws IOException
	{
		browserInitialization();
		loginpage=new LoginPage();
		 testUtil=new utilityClass();
		  contactpage=new ContactsPage();
		homepage=loginpage.login(baseClass.getDataFromPropertiedfile("username"),baseClass.getDataFromPropertiedfile("password"));
		
		testUtil.switchToFrame();  // contacts button link is present on frame
		
			
	}
	
	
	@Test(priority=1)
	public void verifyTitleOfContactPageTest()
	{TCID=104;
		contactpage=homepage.clickOnContacts();
		String actualtitle = contactpage.getTitleOFContactsPage();
	Assert.assertEquals(actualtitle, "CRMPRO","title of contact page not matched");
	}
	
	@Test(priority=2)
	public void verifyContactsPageLabelTest()
	{TCID=105;
		contactpage=homepage.clickOnContacts();
		boolean flag = contactpage.validateContactsPagelabel();
		Assert.assertTrue(flag,"contact label is missing on page");
	}
	@Test(priority=3)
	public void selectContextTest() 
	{TCID=106;
		contactpage=homepage.clickOnContacts();
		contactpage.setectContactFromListByName("vaibhav thorat");
		
	}
	@Test(priority=4)
	public void selectMultipleContactTest() throws InterruptedException
	{TCID=107;
		contactpage=homepage.clickOnContacts();
		contactpage.setectContactFromListByName("rahul more");
		contactpage.setectContactFromListByName("vinod more");
		Thread.sleep(3000);
	}
	
	
	//data provider for cantacts sheet
	@DataProvider
	public Object[][] getTastDatafromExcell() throws EncryptedDocumentException, IOException
	{
		Object data[][]=utilityClass.getMultiTestDataCredentials("contacts");
		return data;
	}
	
	
	@Test(priority=5,dataProvider = "getTastDatafromExcell")
	public void validateCreateNewContact(String Title,String FName,String LName,String compnyName) throws InterruptedException
	{  TCID=108;
		homepage.clickOnnewcontactLink();
		contactpage.creatNewContact(Title, FName, LName, compnyName);
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
