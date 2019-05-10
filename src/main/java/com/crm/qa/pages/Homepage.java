package com.crm.qa.pages;

import javax.swing.Spring;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class Homepage extends Testbase {
	//pagefactory objectrepository
	@FindBy(xpath="/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement usernamelable;
	@FindBy(xpath ="//*[@id='navmenu']/ul/li[4]/a")
	WebElement contactlink;
	@FindBy(xpath="//*[@id='navmenu']/ul/li[5]/a")
	WebElement dealslink;
	@FindBy(xpath="//*[@id='navmenu']/ul/li[6]/a")
    WebElement tastlink;
	@FindBy(xpath="//*[@id='navmenu']/ul/li[4]/ul/li[1]/a")
	WebElement newcontact;
	
	//creating homepage constructor
	public Homepage()
	{
	PageFactory.initElements(driver,this);
	}
	//actions 
	public String verifyusername()
	{
		
		String name = usernamelable.getText();
		return name;
	}
	public Contactspage clickoncontactslink()
	{
		contactlink.click();
		return new Contactspage();
		
	}
	public Dealspage clickondealslink()
	{
		dealslink.click();
		return new Dealspage();
	}
	public Tasklinkpage clickontasklink()
	{
		tastlink.click();
		return new Tasklinkpage();
	}
	public void moveoncontactlink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactlink).build().perform();
		
	
		newcontact.click();
		
	}
}
