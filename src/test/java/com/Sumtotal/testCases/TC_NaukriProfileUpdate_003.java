package com.Sumtotal.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Sumtotal.PageObjects.Naukri_Login;

public class TC_NaukriProfileUpdate_003 extends BaseClass 
{
	
	Naukri_Login nl = new Naukri_Login(driver);	
	
@Parameters({"baseUrl","Username","Password"})	 
@BeforeMethod
public void SetupNaukri(String baseUrl,String Username,String Password) 
  {	  
	  driver.get(baseUrl);
	  logger.info(CurrentTime()+" Setting system properties...");
	  nl.setUsername(Username);
	  logger.info(CurrentTime()+" Setting the username...");
	  nl.setPassword(Password);
	  logger.info(CurrentTime()+" Setting the password...");
	  nl.clickLogin();
	  logger.info(CurrentTime()+" Click on the Sign-In button...");
  }

@Test
public void UpdatingNaukriProfile() throws InterruptedException
{
	 String str = "9.5 Years experience in automation testing, manual testing and API testing.";
	 String str_withSpace = "9.5 Years experience in automation testing, manual testing and API testing .";
	 
	 int count=0;
	 while (true)
	 {	 
		 nl.icnResumeHeadlineEdit.click();
		 logger.info(CurrentTime()+" Clicked on the Resume headline edit icon...");
		 nl.txtResumeHeadLine.clear();	
		 logger.info(CurrentTime()+" cleared text in the Resume headline textbox...");
		 
		 if (count%2==0)
		 {
			 nl.txtResumeHeadLine.sendKeys(str);
			 logger.info(CurrentTime()+" Typed text in the Resume headline textbox...");
			 count=0;
		 }
		 else
		 {
			 nl.txtResumeHeadLine.sendKeys(str_withSpace);
			 logger.info(CurrentTime()+" Typed text(with space) in the Resume headline textbox...");
		 }
		 nl.btnResumeTextSave.click();
		 logger.info(CurrentTime()+" clicked on the save button in Resume headline textbox...");
		 Thread.sleep(20000);
		 count++;		 
	 } 
	
}

}
