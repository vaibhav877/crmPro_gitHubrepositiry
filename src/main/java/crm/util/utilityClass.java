package crm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import crm.base.baseClass;

public class utilityClass extends baseClass{

	
	public void switchToFrame()
	{
driver.switchTo().frame("mainpanel");
  
	}
	
	//fetch data from exel Sheet using data provider (sheetname "logincredentials")
 public  static Object[][] getMultiTestDataCredentials(String sheetname) throws EncryptedDocumentException, IOException
 {
	 FileInputStream file=new FileInputStream(testData_PATH);
	Workbook book = WorkbookFactory.create(file);
	Sheet sh = book.getSheet(sheetname);
	//create multi-diamentional array object for storing data
	Object  data[][]=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0;i<sh.getLastRowNum();i++)
	{
		for(int j=0;j<sh.getRow(0).getLastCellNum();j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).toString();//use i+1 because data available in sheet fron 2nd row
		}	
	}
	return data;
	
 }
 
	//capture screenshot
	public static void captureSreenshot(WebDriver driver,int testID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File dest=new File("C:\\Users\\user\\eclipse-workspace\\CRM_PRO\\screenshot_crmpro\\TCID"+testID+System.currentTimeMillis()+".jpeg");
	FileHandler.copy(src, dest);
	}
	
	
	//fetch data from Excel sheet
	public static String getID(int rowindex,int cellindex ) throws EncryptedDocumentException, IOException  
	{
	
		FileInputStream file=new FileInputStream(testData_PATH);
		 Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
				 String value = sh.getRow(rowindex).getCell(cellindex).getStringCellValue();
				 return value;
	}
 
}
