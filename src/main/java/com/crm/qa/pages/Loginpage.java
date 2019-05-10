package com.crm.qa.pages;

import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class Loginpage extends Testbase{
	//pagefactory Object repository
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//*[@id='loginForm']/div/div")
	WebElement loginbutton;
	@FindBy(xpath="//*[@id='navbar-collapse']/ul/li[2]/a")
	WebElement signupbutton;
	@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
	WebElement crmlogo;
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	//Actions
	public boolean validatecrmlogo()
	{
		return crmlogo.isDisplayed();
	}
	public boolean validatesignupbutton()
	{
		return signupbutton.isDisplayed();
	}
	public String pagetitle()
	{
		return driver.getTitle();
	}
	public Homepage login(String un,String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		loginbutton.click();
		return new Homepage();
	}
	
}
