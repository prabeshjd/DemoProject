package com.zoho.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoho.qa.base.TestBase;
import com.zoho.qa.pages.Homepage;
import com.zoho.qa.pages.LeadsPage;
import com.zoho.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	Homepage homepage;
	LeadsPage leadspage;
	
	public HomePageTest(){
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp(){
		intilization();
		loginpage=new LoginPage();
		leadspage= new LeadsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws InterruptedException{
		Thread.sleep(5000);
		String homePageTitle=homepage.verifyHomepageTitle();
		Assert.assertEquals(homePageTitle, "Zoho CRM - Home Page","Homepage title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		boolean flag=homepage.verifyCorrectUserNameLabel();
		Assert.assertTrue(flag);
	}

	
	@Test(priority=3)
	public void verifyLeadsLinkTest(){
		leadspage=homepage.clickOnLeadsLink();
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}
	

}
