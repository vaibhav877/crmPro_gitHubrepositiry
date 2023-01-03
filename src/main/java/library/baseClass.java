package library;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseClass {
	WebDriver driver;
	public void initializeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\CRM_PRO\\browsers\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.get(url);	 
	}

}
