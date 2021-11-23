package com.Sumtotal.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Sumtotal.PageObjects.LoginPage;

public class TC_Login_DataDriven_002 extends BaseClass{
	

  @Test(dataProvider="testdata")
  public void loginDD(String Username,String Password) {
LoginPage lp = new LoginPage(driver);
	  lp.txtUsername.clear();
	  logger.info(CurrentTime()+" Clearing the existing text in the username textbox...");
	  lp.setUsername(Username);
	  logger.info(CurrentTime()+" Setting the username...");
	  lp.txtPassword.clear();
	  logger.info(CurrentTime()+" Clearing the existing text in the username textbox...");
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

  @DataProvider(name="testdata")
  public String[][] readExcel()
	{
		String filepath1 = System.getProperty("user.dir")+"\\src\\test\\java\\com\\Sumtotal\\testData\\TC_Login_001_testData.xlsx";
		String sheetName1 = "sheet1";
		File src =  new File(filepath1);
		Workbook wb = null;
		try {
			 wb = WorkbookFactory.create(src);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet s = wb.getSheet(sheetName1);
		int Firstrow = s.getFirstRowNum();
		int Lastrow = s.getLastRowNum()-Firstrow;
		int LastColumn = s.getRow(1).getLastCellNum();
		
		String[][] testdata=new String[Lastrow][LastColumn];
			
		for (int i=1; i <Lastrow;i++)
		{
			for (int j=0; j <LastColumn;j++)
			{
				testdata[i][j]=s.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return testdata;
		
	}	  
	  
  }

