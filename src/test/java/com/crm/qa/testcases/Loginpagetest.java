package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;

public class Loginpagetest extends Testbase{
	Loginpage loginpage;
    Homepage homepage;
	public Loginpagetest()
	{
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new Loginpage();
		
	}
	@Test(priority=1)
	public void loginpagetitletest()
	{
		
			
		
		String title = loginpage.pagetitle();
		System.out.println("title ================"+title);
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	
		
		
	
		
	}
	@Test(priority=2)
	public void crmlogotest()
	{
		boolean logo =loginpage.validatecrmlogo();
		Assert.assertTrue(logo);
		
	}
	@Test(priority=3)
	public void loginpagetest() throws InterruptedException
	{
		Thread.sleep(4000);
		homepage = loginpage.login(pro.getProperty("username"),pro.getProperty("password") );
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
