package com.zoho.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoho.qa.base.TestBase;
import com.zoho.qa.pages.FgtPwdPage;
import com.zoho.qa.pages.Homepage;
import com.zoho.qa.pages.LoginPage;
import com.zoho.qa.pages.SignUpPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	Homepage homepage;
	FgtPwdPage fgtPwdPage;
	SignUpPage signUpPage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intilization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void verifyTitlePageTest() {
		String title = loginpage.verifyLoginPageTitle();
		Assert.assertEquals(title, "Zoho Accounts");
	}

	@Test(priority = 2)
	public void validateLogoTest() {
		boolean flag = loginpage.validateZohoImage();
		Assert.assertTrue(flag);
	}

	

	@Test(priority = 3)
	public void verifySignUpLinkTest() {
		signUpPage = loginpage.signUpLink();

	}

	
	@Test(priority = 4)
	public void verifyFgtPwdTest() throws InterruptedException {
		Thread.sleep(2000);
		fgtPwdPage = loginpage.verifyFgtPwd();
	}

	
	@Test(priority = 5)
	public void keepMeSignedInCheckBoxTest() {
		loginpage.verifyKeepMeSignedInCheckBox();
	}

	@Test(priority = 6)
	public void login() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
