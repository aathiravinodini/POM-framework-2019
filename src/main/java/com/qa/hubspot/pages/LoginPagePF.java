package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.Basepage;

public class LoginPagePF extends Basepage {

WebDriver driver;

//PF pattern with the help of @findBy	
@FindBy(id = "username")
WebElement emailId;

@FindBy(id = "password")
WebElement password;

@FindBy(id = "loginBtn")
WebElement loginButton;

	
	public LoginPagePF(WebDriver driver){
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	}
	
	
	public void doLogin(String username,String pwd){
		emailId.sendKeys(username);
		password.sendKeys(pwd);
		loginButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
