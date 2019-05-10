package com.crm.qa.pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Testbase;

public class Contactspage extends Testbase {
	//pagefactory
	@FindBy(xpath="//*[@id='vContactsForm']/table/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement contactslable;
	/*@FindBy(xpath="//*[@id='vContactsForm']/table/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement contactslable;*/
	@FindBy(name="first_name")
	WebElement firstname;
	@FindBy(name="middle_initial")
	WebElement middlename;
	@FindBy(name="surname")
	WebElement lastname;
	@FindBy(name="client_lookup")
	WebElement company;
	@FindBy(xpath="//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement save;
	//initialization
	//create contructor
	
	public Contactspage()
	{
		PageFactory.initElements(driver,this);
	}
	//Actions
	public boolean contactslable()
	{
		return(contactslable.isDisplayed());
	 
	}
	public void selectcontactsbyname(String name)
	{
		driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr[4]/td[1]")).click();
		
	}
	public void createnewcontact(String title,String ftname,String ltname,String com)
	{
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstname.sendKeys(ftname);
		//middlename.sendKeys(midname);
		lastname.sendKeys(ltname);
		company.sendKeys(com);
		save.click();
	}
	

}