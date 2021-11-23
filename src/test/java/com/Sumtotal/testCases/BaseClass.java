package com.Sumtotal.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Sumtotal.Utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class BaseClass 
{	
	
	ReadConfig rc = new ReadConfig();
	String baseUrl = rc.getBaseUrl();
	String Username = rc.getUsername();
	String Password = rc.getPassword();
	WebDriver driver;
	Logger logger;
 
  @BeforeClass
  @Parameters("browser")
  public void SetUp(String browser) 
  {  
	  logger = Logger.getLogger("Sumtotal");
	  PropertyConfigurator.configure("log4j.properties");
	  if(browser.equalsIgnoreCase("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		  logger.info(CurrentTime()+" Setting system properties...");
		  driver = new ChromeDriver();
		  logger.info(CurrentTime()+" Initiated the "+ browser+" browser...");
	  }
	  else  if(browser.equalsIgnoreCase("firefox"))
	  {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		  logger.info(CurrentTime()+" Setting system properties...");
		  driver = new ChromeDriver();
		  logger.info(CurrentTime()+" Initiated the "+ browser+" browser...");
	  }
	  
	  driver.get(baseUrl);
	  logger.info(CurrentTime()+" Opened the "+baseUrl+" in the browser...");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  logger.info(CurrentTime()+" Set the implicit wait to 30 secs ...");	  
  }

  @AfterClass
  public void TearDown() throws InterruptedException 
  {
	  Thread.sleep(5000);
	  logger.info(CurrentTime()+" Waited for 5 secs ...");
	  driver.close();
	  logger.info(CurrentTime()+" Closed the browser ...");
	  
  }
  
  public void TakeScreenshot()
  {
	  //Taking the screen shot
	  TakesScreenshot tss = ((TakesScreenshot)driver);
	  File src = tss.getScreenshotAs(OutputType.FILE);
	  
	  //Finding the current time
	  SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_HHmmss");  
	  Date date = new Date();  
	  File dest = new File(System.getProperty("user.dir")+"//ScreenShots//test"+formatter.format(date)+".png");
	  try 
	  {
		FileUtils.copyFile(src, dest);
	  }
	  catch (IOException e) 
	  {
		e.printStackTrace();
	  }
  }
  
  public String CurrentTime()
  {
	  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	  Date date = new Date();
	  return formatter.format(date)+" : " ;	  
  }
}
