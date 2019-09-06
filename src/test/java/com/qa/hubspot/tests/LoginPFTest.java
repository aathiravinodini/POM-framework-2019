package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.Basepage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.LoginPagePF;

public class LoginPFTest {

	
	Basepage basepage;
	WebDriver driver;
	LoginPagePF loginpagepf;
	Properties prop;
	
	
	
	
	@BeforeMethod
	public void setUp(){
		basepage = new Basepage();
		prop = basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		loginpagepf = new LoginPagePF(driver);
		}
	
	
	@Test
	public void loginTest(){
		loginpagepf.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		basepage.quitBrowser();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
