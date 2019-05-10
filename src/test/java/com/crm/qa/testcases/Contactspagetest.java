package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.Contactspage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;

public class Contactspagetest extends Testbase{
	public String sheetname= "contacts";
	Loginpage loginpage;
	Homepage homepage;
	Contactspage contactspage;
	TestUtil testutil;
	//create contructor
	public Contactspagetest()
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
		testutil.switchToFrame();
		contactspage = homepage.clickoncontactslink();
		
	}
	@Test(priority=1)
	public void contactslabletest()
	{
		
		Assert.assertTrue(contactspage.contactslable(),"contactlable missing on the table");
	}
	@Test(priority = 2)
	public void selectcontactbynametest()
	{
		contactspage.selectcontactsbyname("sneak asdf");
		
	}
	@DataProvider(name = "dataprovider2" )
	public Object[][] dataprovider2()
	{
		System.out.println("--------------------123123------------------------");
		Object data[][] = TestUtil.getTestData(sheetname);
		System.out.println("--------------------------------------------"+data);
		return data;
		
	}
	@Test(priority=3,dataProvider = "dataprovider2")
	
	public void validatecreatenewcontact(String title,String firstname,String lastname,String company )
	{
		//Thread.sleep(2000);
		homepage.moveoncontactlink();
		//contactspage.createnewcontact("Mr.", "cat", "dog", "rat", "cashew");
		contactspage.createnewcontact(title,firstname,lastname,company);
	}
	
	@AfterMethod
public void teardown()
	{
		driver.quit();
	}
}
