package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;






import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;;

public class Testbase {
	

public static WebDriver driver;
public static Properties pro;
public Testbase()
{
	try{
		pro = new Properties();
		FileInputStream ip = new FileInputStream("G:\\Testing\\SeleniumWS\\FreeCRM2\\src\\main\\java\\com\\crm\\qa\\configuration\\config.properties");
		pro.load(ip);
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
	
}
public static void initialization()
{
	String browsername = pro.getProperty("browser");
	if(browsername.equals("chrome"))
	{
		
		System.setProperty("webdriver.chrome.driver","G:\\Testing\\Selenium Jars\\chromedriver.exe");
		
		 driver = new ChromeDriver();
	}
	else if(browsername.equals("FF"))
	{
		
		System.setProperty("webdriver.gecko.driver", "G:\\Testing\\Selenium Jars\\Latest\\geckodriver.exe");
		 driver = new FirefoxDriver();
	}
	 driver.manage().window().maximize();
	 driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_wait, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.implicitly_wait,TimeUnit.SECONDS);
	driver.get(pro.getProperty("url"));
	
}

}
