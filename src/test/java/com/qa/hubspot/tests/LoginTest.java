package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.pages.LoginPage;

public class LoginTest {

	Basepage basepage;
	WebDriver driver;
	LoginPage loginpage;
	Properties prop;
	
	
	
	
	@BeforeMethod
	public void setUp(){
		basepage = new Basepage();
		prop = basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		loginpage = new LoginPage(driver);
		}
	
	
	@Test(priority=1,description = "login test with correct usename and password...")
	public void loginTest(){
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		}
	
	@Test(priority=2,description= "login page title test...")
	public void loginPageTitleTest(){
	String title =loginpage.getLoginPageTitle(); 
	System.out.println(title);
	Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE,"login page title is in correct....");
	}
	
	@AfterMethod
	public void tearDown(){
		basepage.quitBrowser();
	}
	
	
	
	
}
