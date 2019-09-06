package com.qa.hubspot.pages;

import org.openqa.selenium.By;
/**
 * 
 */
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.Util.ElementUtil;
import com.qa.hubspot.base.Basepage;

public class HomePage extends Basepage {

	WebDriver driver;
	ElementUtil elementutil;
	
	By header = By.cssSelector("h1.private-header__heading>i18n-string");
	By accountname = By.cssSelector("a#account-menu>span.account-name ");
	
	//for contactpage
	By contactsMainTab = By.id("nav-primary-contacts-branch");
	By contactsChildTab = By.id("nav-secondary-contacts");
	
	
	
public HomePage(WebDriver driver){
	this.driver = driver;
	 elementutil = new ElementUtil(driver);

}
	
public String getHomePageTitle(){
	return elementutil.waitForPageTitle(Constants.HOME_PAGE_TITLE);
}

public String getHomePageHeader(){
	return elementutil.doGetText(header);

}


public boolean verifyLoggedInAccountName(){
   return elementutil.isElementDisplayed(accountname); 
}

	
public String getLoggedInAccountName(){
	return elementutil.doGetText(accountname);
}
	
//for contactpage action

private void clickOnContacts(){
	elementutil.doClick(contactsMainTab);
	elementutil.doClick(contactsChildTab);
}

public ContactsPage gotoContactsPage(){
	clickOnContacts();
	return new ContactsPage(driver);
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
