package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.fightTrader;
import com.qa.pages.googleSearch;
import com.qa.util.TestUtil;

public class fightTraderTest extends TestBase{
	googleSearch googleSearchPage;
	fightTrader fightTraderPage;
	TestUtil testUtil;
	
	public fightTraderTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		driver.get(prop.getProperty("url1"));
		
		testUtil = new TestUtil();
		fightTraderPage = new fightTrader();
	}
	
	@Test(priority=1)
	public void flighttraderdata(){
		fightTraderPage.clickArrivalsLink();
		fightTraderPage.gettheStatusOfflights();

	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
	
	
	
	

}
