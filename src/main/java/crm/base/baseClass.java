package crm.base;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.html.HTMLUListElement;

public class baseClass {
	
	public static WebDriver driver;
	public static Properties prop;

		public static String testData_PATH="C:\\Users\\user\\eclipse-workspace\\CRM_PRO\\src\\main\\java\\crm\\testData\\CRM pro.xlsx";
		//data from properties file
		public static String getDataFromPropertiedfile(String Key) throws IOException
		{
		try {	FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\CRM_PRO\\src\\main\\java\\crm\\config\\crrmProProperties.properties");
		  prop=new Properties();  //Properties prop=new Properties();
			prop.load(file);}
			catch(Throwable e) {e.printStackTrace();}
			String value = prop.getProperty(Key);
			return value;
		}
	
		//brower initialization
		public static void browserInitialization() throws IOException 
		{
		  String browsername = baseClass.getDataFromPropertiedfile("browser");
		  
//		//code for headless browser  
//		    ChromeOptions options= new ChromeOptions(); 
//			options.addArguments("window-size=1400,800");
//			options.addArguments("headless");
//			
			//---pass options object in chromedriver consructor 
			if(browsername.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\CRM_PRO\\browsers\\chromedriver.exe");
				 driver=new ChromeDriver();
				 
			}
			else if(browsername.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\eclipse-workspace\\CRM_PRO\\browsers\\geckodriver.exe");
				 driver=new FirefoxDriver();
				 
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			driver.get(baseClass.getDataFromPropertiedfile("url"));
			}
		
		
	      
	
		
	     
			
		}
		

		
		
		



