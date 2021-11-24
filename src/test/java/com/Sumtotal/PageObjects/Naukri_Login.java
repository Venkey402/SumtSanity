package com.Sumtotal.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Naukri_Login 
{
	public Naukri_Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID , using = "usernameField")
	public WebElement txtUsername;
	@FindBy(how=How.ID , using = "passwordField")
	public WebElement txtPassword;
	@FindBy(how=How.XPATH , using = "//button[text()='Login']")
	public WebElement btnLogin;
	@FindBy(how=How.XPATH,using="//div[@class='resumeHeadline']/div/div/div/span[text()='Resume Headline']/../span[@class='edit icon']")
	public WebElement icnResumeHeadlineEdit;	
	@FindBy(how=How.ID , using = "resumeHeadlineTxt")
	public WebElement txtResumeHeadLine;
	@FindBy(how=How.XPATH , using = "//div[@class='action s12']/button[text()='Save']")
	public WebElement btnResumeTextSave;
		
	
	public void setUsername(String username)
	{
		txtUsername.clear();
		txtUsername.sendKeys(username);
	}
	public void setPassword(String password)
	{
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	public void clickLogin()
	{
		btnLogin.click();
	}
}
