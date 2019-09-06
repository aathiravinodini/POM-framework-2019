package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Util.Constants;
import com.qa.hubspot.Util.ElementUtil;
import com.qa.hubspot.base.Basepage;

public class ContactsPage extends Basepage {

	
	WebDriver driver;
	ElementUtil elementutil;
	
	
	By createContactButton = By.xpath("//span[text()='Create contact']");
	By createContactFormButton = By.xpath("//li//span[text()='Create contact']");
	By email = By.id("uid-ctrl-1");
	By firstName = By.id("uid-ctrl-2");
	By lastName = By.id("uid-ctrl-3");
	By jobTitle = By.id("uid-ctrl-5");
	
	
	
	public ContactsPage(WebDriver driver){
		this.driver = driver;
		 elementutil = new ElementUtil(driver);
	}
	
	
	public String getContactPageTitle(){
		return elementutil.waitForPageTitle(Constants.CONTACTS_PAGE_TITLE);
	}
	
	public void createNewContact(String emailid,String FN,String LN,String jobtitlevalue){
		elementutil.doClick(createContactButton);
		elementutil.doSendKeys(email, emailid);
		elementutil.doSendKeys(firstName, FN);
		elementutil.doSendKeys(lastName, LN);
		elementutil.doSendKeys(jobTitle, jobtitlevalue);
		
		elementutil.doClick(createContactFormButton);

		
		
		
	}
	
	
	
	
	
	
}
