package com.zoho.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoho.qa.base.TestBase;
import com.zoho.qa.util.TestUtil;

public class Homepage extends TestBase {
	
	@FindBy(xpath="//span[@class='trimName dIB']")
	WebElement usernameLabel;
	
	
	@FindBy(xpath="//a[@id='tab_Leads']")
	WebElement leadsPageLink;
	
	@FindBy(xpath="//a[@id='tab_Contacts']")
	WebElement contactsPageLink;
	
	@FindBy(xpath="//a[@id='tab_Accounts']")
	WebElement accountsPageLink;
	
	@FindBy(xpath="//a[@id='tab_Potentials']")
	WebElement dealsPageLink;
	
	public Homepage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomepageTitle(){
		 return driver.getTitle();
	}
	
	
	public LeadsPage clickOnLeadsLink(){
		TestUtil.clickOn(driver, leadsPageLink, TestUtil.Timeouts);
		return new LeadsPage();
				
	}
	
	public Accountspage clickOnAccountsLink(){
		accountsPageLink.click();
		return new Accountspage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsPageLink.click();
		return new DealsPage();
	}
	
	public boolean verifyCorrectUserNameLabel(){
		boolean flag=usernameLabel.isDisplayed();
		return flag;
	}
	
	public ContactsPage clickOnContactsLink(){
		TestUtil.clickOn(driver, contactsPageLink, TestUtil.Timeouts);
		return new ContactsPage();
	}
	
	
	
}
