package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.Util.ElementUtil;
import com.qa.hubspot.base.Basepage;

public class LoginPage extends Basepage {

	WebDriver driver;
	ElementUtil elementutil;
	
	//define locator OR withBy locator(NPF)
	
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	
	
	
	//constructor of pageclass
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		 elementutil = new ElementUtil(driver);
	}
	
	
//page actions
	
	
	public String getLoginPageTitle(){
		return elementutil.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
	
	}
	
	public HomePage doLogin(String username,String pwd){
	
		elementutil.doSendKeys(emailId, username);
		elementutil.doSendKeys(password, pwd);
		elementutil.doClick(loginButton);
	//driver.findElement(emailId).sendKeys(username);
	//driver.findElement(password).sendKeys(pwd);
	//driver.findElement(loginButton).click();
	
	return new HomePage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
