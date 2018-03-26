package com.zoho.qa.pages;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.zoho.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	@FindBy(xpath="//input[@class='newwhitebtn customPlusBtn ']")
	WebElement addNewBtn;
	
	
	@FindBy(id="Crm_Contacts_FIRSTNAME")
	WebElement firstName;
	
	@FindBy(id="Crm_Contacts_LASTNAME")
	WebElement lastName;
	
	@FindBy(id="Crm_Contacts_EMAIL")
	WebElement emails;
	
	//input[@id='saveContactsBtn']
	
	@FindBy(id="saveContactsBtn")
	WebElement saveBtn;
	
	

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void addNewContact( String ftName,String ltName,String email){
		addNewBtn.click();
//		Select select =new Select(driver.findElement(By.xpath("//select[@data-module='Contacts' and @id='Crm_Contacts_FIRSTNAME_SALUTATION']")));
//		select.selectByValue(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		emails.sendKeys(email);
		saveBtn.click();
		
	}
	
	
	

}
