	package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class HomePageTest {

	
	Basepage basepage;
	WebDriver driver;
	LoginPage loginpage;
	Properties prop;
	HomePage homepage;
	
	
	
	@BeforeMethod
	public void setUp(){
		basepage = new Basepage();
		prop = basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		loginpage = new LoginPage(driver);
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
		}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title = homepage.getHomePageTitle();	
		System.out.println("home page title is: "+title);
		Assert.assertEquals(title,Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyHomePageHeaderTest(){
		String header = homepage.getHomePageHeader();
		System.out.println("the home page header is:"+header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}
	
@Test(priority=3)
public void verifyLoggedInUserAccountTest(){
	String accountName = homepage.getLoggedInAccountName();
	System.out.println("loggedin account name is: "+accountName);
	Assert.assertTrue(homepage.verifyLoggedInAccountName());
	Assert.assertEquals(accountName,prop.getProperty("accountname"));
}
	

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

	
}
