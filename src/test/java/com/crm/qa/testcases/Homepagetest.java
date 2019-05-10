package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;

public class Homepagetest extends Testbase {
	//HOMEPAGE Constructor
	Loginpage loginpage;
	Homepage homepage;
	Contactspage contactspage;
	TestUtil testutil;
	public Homepagetest()
	{
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		loginpage = new Loginpage();
		contactspage = new Contactspage();
		homepage = new Homepage();
		testutil = new TestUtil();
		Thread.sleep(4000);
		homepage = loginpage.login(pro.getProperty("username"),pro.getProperty("password"));
		
	} 
	
	
	
	
	@Test(priority = 1)
	public void usernamelabletest()
	{
		
		testutil.switchToFrame();
		String username = homepage.verifyusername();
		
		Assert.assertEquals(username, "  User: sneak asdf");
		//Assert.assertTrue(false, "homepage.verifyusername()");
	}
	@Test(priority = 2)
	public void contactslinktest()
	{
		 
		testutil.switchToFrame();
		contactspage = homepage.clickoncontactslink();
		//Assert.assertTrue( homepage.clickoncontactslink());
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		}
	}

