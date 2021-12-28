package com.Sumtotal.testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.jsoup.select.Collector;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedIn {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");		
		WebDriver  driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com");
		driver.findElement(By.id("session_key")).sendKeys("venkey402@gmail.com");
		driver.findElement(By.id("session_password")).sendKeys("9030196907");
		driver.findElement(By.xpath("//button[@class='sign-in-form__submit-button']")).click();
		
		ArrayList<String> links = new ArrayList<String>();
		ArrayList<String> CompanyName = new ArrayList<String>();
		List<String> CompanyName_Sorted = new ArrayList<String>();		
		
		for(int i=1;i<2;i++)
		{
			driver.get("https://www.linkedin.com/search/results/people/?network=%5B%22F%22%5D&origin=MEMBER_PROFILE_CANNED_SEARCH&page="+i);		
			List<WebElement> Pageconnections= driver.findElements(By.xpath("//div[@class='entity-result__item']/div/div/div/div/span/span/a"));
					
			for(WebElement e:Pageconnections)
			{
				String url = e.getAttribute("href");
				links.add(url);
			}			
		}		
		
		for(String u:links)
		{
			driver.get(u);
			List<WebElement> Company_p = new ArrayList<WebElement>();
			List<WebElement> Company_span = new ArrayList<WebElement>();
			List<WebElement> Company_Elements = new ArrayList<WebElement>();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,900)", "");
			Thread.sleep(5000);
			Company_p=driver.findElements(By.xpath("//*[text()='Company Name']/following-sibling::p"));
			Company_span=driver.findElements(By.xpath("//*[text()='Company Name']/following-sibling::span"));	
			Company_Elements.addAll(Company_p);
			Company_Elements.addAll(Company_span);			
			
			for(WebElement c:Company_Elements)
			{
				CompanyName.add(c.getText());
			}						
		}
		
		CompanyName_Sorted=CompanyName.stream().sorted().toList();
		for(String cn:CompanyName_Sorted)
		{
			System.out.println(cn);
		}
	}

}
