package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.Util.ExcelUtil;
import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class ContactsPageTest {

	
	Basepage basepage;
	WebDriver driver;
	LoginPage loginpage;
	Properties prop;
	HomePage homepage;
	ContactsPage contactsPage;
	
	
	
	@BeforeMethod
	public void setUp(){
		basepage = new Basepage();
		prop = basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		loginpage = new LoginPage(driver);
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		contactsPage = homepage.gotoContactsPage();
		}
	
	
	
	@Test(priority= 1)
	public void verifyContactsPageTitleTest(){
		String title = contactsPage.getContactPageTitle();
		System.out.println("contacts page title is: "+title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}
	
	
	
	@DataProvider()
	public Object[][] getContactData(){
		Object data[][] = ExcelUtil.getTestData("Create contact");
		return data;
	}
	
	
	
	
	
	@Test(priority=2,dataProvider="getContactData")
	public void createNewContactTest(String email, String firstname, String lastname, String jobTitle) {
		contactsPage.createNewContact(email, firstname, lastname, jobTitle);	
		
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
}
