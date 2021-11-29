package com.Sumtotal.testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Naukri_ProfileUpdate {

	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\Drivers\\Chrome\\chromedriver.exe");  
		 ChromeDriver driver = new ChromeDriver();	
		 driver.navigate().to("https://www.naukri.com/mnjuser/profile?id=&altresid");		 
		 driver.manage().window().maximize(); 
		 Thread.sleep(10000);		
		 driver.findElement(By.id("usernameField")).sendKeys("venkey402@gmail.com");
		 driver.findElement(By.id("passwordField")).sendKeys("9030196907");
		 driver.findElement(By.xpath("//button[text()='Login']")).click();
		 Thread.sleep(5000);
		 String str = "9.5 Years experience in automation testing, manual testing and API testing.";
		 String str_withSpace = "9.5 Years experience in automation testing, manual testing and API testing .";
		 
		 int count=0;
		 while (true)
		 {	 
			 driver.findElement(By.xpath("//div[@class='resumeHeadline']/div/div/div/span[text()='Resume Headline']/../span[@class='edit icon']")).click();
			 Thread.sleep(10000);
			 driver.findElement(By.id("resumeHeadlineTxt")).clear();
			 
			 if (count%2==0)
			 {
				 driver.findElement(By.id("resumeHeadlineTxt")).sendKeys(str);
				 count=0;
			 }
			 else
			 {
				 driver.findElement(By.id("resumeHeadlineTxt")).sendKeys(str_withSpace);
			 }
			 driver.findElement(By.xpath("//div[@class='action s12']/button[text()='Save']")).click();
			 Thread.sleep(20000);
			 count++;		 
		 } 
	}

}
