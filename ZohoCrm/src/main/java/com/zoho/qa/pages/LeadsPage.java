package com.zoho.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.zoho.qa.base.TestBase;
import com.zoho.qa.util.TestUtil;

public class LeadsPage extends TestBase {

	public LeadsPage() {
		PageFactory.initElements(driver, this);
	}

	// Its not compulsory to define page factory for all the elements
	// for checkbox we won't use page factory

	public String verifyLeadsPageTitle() {
		return driver.getTitle();

	}

	public void selectLeadByName(String name) {

		WebElement clickCheckbox=driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td[@class='mW100 scrollColun lv_data_textfield']//preceding-sibling::td[@class='lvCB fixedColumnLV LVSecondCol']"));
		//WebElement clickCheckbox = driver.findElement(By.xpath("//*[@class='lvCB fixedColumnLV LVSecondCol']"));
		
		TestUtil.clickOn(driver,clickCheckbox, TestUtil.Timeouts);
	}

}


//a[contains(text(),'Binay Mall')]//parent::td[@class='mW100 scrollColun lv_data_textfield']//preceding-sibling::td[@class='lvCB fixedColumnLV LVSecondCol']