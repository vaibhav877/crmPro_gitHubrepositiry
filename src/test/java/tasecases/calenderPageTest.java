package tasecases;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.base.baseClass;
import crm.pages.CalenderPage;
import crm.pages.HomePage;
import crm.pages.LoginPage;
import crm.util.utilityClass;

public class calenderPageTest extends baseClass {
	LoginPage loginpage;
	utilityClass testUtil;
	HomePage homepage;
	CalenderPage calender;
	int TCID;
	@BeforeMethod
	public void setUP() throws IOException
	{
		browserInitialization();
		loginpage=new LoginPage();
		 testUtil=new utilityClass();
		 calender=new CalenderPage();
		 homepage=loginpage.login(utilityClass.getDataFromPropertiedfile("username"), utilityClass.getDataFromPropertiedfile("password"));
		 testUtil.switchToFrame();  // calender button link is present on frame 
	}
	
	
	@Test
	public void validateDateSelection()
	{   TCID=201;  
	homepage.clickOnCalender();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	calender.selectDDMMYYYY("10", "March", "2022");
	
	
		
	}
	

	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	



}
