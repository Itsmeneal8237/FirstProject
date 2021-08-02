package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

import com.qa.pages.fightTrader;
import com.qa.pages.googleSearch;
import com.qa.util.TestUtil;

public class googleSearchTest extends TestBase {
	googleSearch loginPage;
	fightTrader homePage;
	TestUtil testUtil;
	googleSearch googleSearchPage;

	public googleSearchTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.get(prop.getProperty("url"));
		testUtil = new TestUtil();
		googleSearchPage = new googleSearch();
	
	}
	
	
	@Test(priority=1)
	public void enterTextinGoogleSearchBox(){
		googleSearchPage.enterTextinGoogleSearchBox(prop.getProperty("TextToSearch"));
		Assert.assertTrue(googleSearchPage.searchResults());

	}
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
	

	

}
