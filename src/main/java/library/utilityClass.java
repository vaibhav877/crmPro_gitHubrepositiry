package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class utilityClass {
	public static String getID(int rowindex,int cellindex ) throws EncryptedDocumentException, IOException  
	{
		//fetch data from Excel sheet
		FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\ZERODHA\\testData\\zerodhaPOMwith_pagefactory_DDF.xlsx");
		 Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
				 String value = sh.getRow(rowindex).getCell(cellindex).getStringCellValue();
				 return value;
	}
	//capture screenshot
	public static void captureSreenshot(WebDriver driver,int testID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File dest=new File("C:\\Users\\user\\eclipse-workspace\\Upstox_Framework_Maven_Final\\Screenshot\\TCID"+testID+".jpeg");
	FileHandler.copy(src, dest);
	}
	
	//data from properties file
	public static String getDataFromPropertiedfile(String Key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\ZERODHA\\propertiesFileZerodha.properties");
		Properties p=new Properties();
		p.load(file);
		String value = p.getProperty(Key);
		return value;
	}

	//fetch data from exel Sheet using data provider (sheetname "logincredentials")
 public  static Object[][] getMultiloginCredentials(String sheetname) throws EncryptedDocumentException, IOException
 {
	 FileInputStream file=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\Upstox_Framework_Maven_Final\\TestData\\upstoxPOMwith_pagefactory_DDF.xlsx");
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
}
