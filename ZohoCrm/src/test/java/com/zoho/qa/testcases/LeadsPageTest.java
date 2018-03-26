package com.zoho.qa.testcases;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoho.qa.base.TestBase;
import com.zoho.qa.pages.Homepage;
import com.zoho.qa.pages.LeadsPage;
import com.zoho.qa.pages.LoginPage;

public class LeadsPageTest extends TestBase {

	LoginPage loginpage;
	Homepage homepage;
	LeadsPage leadspage;
	ChromeOptions options;
	
	public LeadsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		intilization();
		loginpage=new LoginPage();
		leadspage= new LeadsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickOnLeadsLink();
	}
	
	@Test(priority=1)
	public void verifyLeadsPageTitleTest(){
		String leadsPageTitle=leadspage.verifyLeadsPageTitle();
		Assert.assertEquals(leadsPageTitle, "Zoho CRM - Leads","LeadsPage Title not matched");
		}
	
	@Test(priority=2)
		public void selectLeadNameTest(){
		leadspage.selectLeadByName("Binay Mall");
		leadspage.selectLeadByName("Sri Sharma");
		
	}
		
	@AfterMethod
	public void tearDown() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}
}
