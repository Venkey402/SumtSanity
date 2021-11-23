package com.Sumtotal.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how=How.ID,using="BodyContent_MainContent_MainContentPlaceHolder_UserName")
	WebElement txtUsername;
	
	@FindBy(how=How.ID,using="BodyContent_MainContent_MainContentPlaceHolder_Password")
	WebElement txtPassword;
	
	@FindBy(how=How.ID,using="BodyContent_MainContent_MainContentPlaceHolder_LoginButton")
	WebElement btnSignIn;
	
	
	public void setUsername(String username)
	{
		txtUsername.sendKeys(username);
	}
	
	public void setPassword(String Password)
	{
		txtPassword.sendKeys(Password);
	}
	
	public void click()
	{
		btnSignIn.click();
	}
	
}
