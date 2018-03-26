package com.zoho.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zoho.qa.base.TestBase;
import com.zoho.qa.pages.ContactsPage;
import com.zoho.qa.pages.Homepage;
import com.zoho.qa.pages.LeadsPage;
import com.zoho.qa.pages.LoginPage;
import com.zoho.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	Homepage homepage;
	LeadsPage leadspage;
	ContactsPage contactspage;
	String sheetName="contacts";
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		intilization();
		loginpage=new LoginPage();
		leadspage= new LeadsPage();
		contactspage=new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickOnContactsLink();
	}
	
	@DataProvider
	public Object[][] getZohoCrmData(){
		Object [][] arrayData=TestUtil.getTestData(sheetName);
		return arrayData;
	}
	
	
	@Test(priority=1,dataProvider="getZohoCrmData")//arguments should be same as coloumn names in sheet
	public void validateNewContactCreationTest(String fstName,String LstName,String email){
//		contactspage.addNewContact( "Mr.","Naresh", "Sharma", "nit@gmail.com");
//		contactspage.addNewContact( "Mr.","Suresh", "Das", "nit12@gmail.com");
//		contactspage.addNewContact( "Mr.","Ramesh", "Kumar", "nit99@gmail.com");
//		contactspage.addNewContact( "Mr.","Mahesh", "Sharma", "nit00@gmail.com");
		contactspage.addNewContact(fstName,LstName,email);
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}
	
	

}
