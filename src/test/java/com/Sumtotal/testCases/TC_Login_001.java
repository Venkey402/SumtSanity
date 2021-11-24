package com.Sumtotal.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Sumtotal.PageObjects.LoginPage;

public class TC_Login_001 extends BaseClass{
	
  @Test
  public void ValidateLogin() 
  {
	  LoginPage lp = new LoginPage(driver);
	  
	  lp.setUsername(Username);
	  logger.info(CurrentTime()+" Setting the username...");
	  lp.setPassword(Password);
	  logger.info(CurrentTime()+" Setting the password...");
	  lp.click();
	  logger.info(CurrentTime()+" Click on the Sign-In button...");
	  String pageTitle =driver.getTitle();
	  logger.info(CurrentTime()+" Getting the title of the page...");
	  if(pageTitle.equals("Home - SumTotal"))
	  {
		  Assert.assertTrue(true);
		  logger.info(CurrentTime()+" Page title is correct...");
	  }
	  else
	  {	 		  
		  logger.info(CurrentTime()+" Page title is not correct...");
		  TakeScreenshot();
		  Assert.assertTrue(false);
	  }
  }
}
