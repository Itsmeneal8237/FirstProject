package com.qa.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class fightTrader extends TestBase {



	@FindBy(xpath="//a[text()=' Arrivals ']")
	WebElement arrivalslink;

	
	//@FindBy(xpath="//tbody/tr/td/div/span[text()='Delhi ' or text()='Nagpur ' or text() ='Bengaluru ' or text()='Goa ' or text()='Chandigarh ' or text()='Hyderabad ' or text()='Dubai ']")
		
	@FindBy(xpath="//tbody/tr/td/div/span[.='Delhi ' or .='Nagpur ' or .='Bengaluru ' or .='Goa ' or .='Chandigarh ' or .='Hyderabad ' or .='Dubai ']")
	List<WebElement> arrivalFlighlist;
	

	//@FindBy(xpath="//tbody/tr/td/div/span[text()='Delhi ' or text()='Nagpur ' or text() ='Bengaluru ' or text()='Goa ' or  text()='Chandigarh ' or text()='Hyderabad ' or text()='Dubai ']//parent::div//parent::td//following-sibling::td[4]/span]")
	@FindBy(xpath="//tbody/tr/td/div/span[.='Delhi ' or .='Nagpur ' or .='Bengaluru ' or .='Goa ' or  .='Chandigarh ' or .='Hyderabad ' or .='Dubai ']//parent::div//parent::td//following-sibling::td[4]")
	List<WebElement> arrivalFlighlistStatus;
	
	//Initializing the Page Objects:
	public fightTrader(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public void clickArrivalsLink(){
		arrivalslink.isDisplayed();
		 arrivalslink.click();;
	}
	
	
	
	
	
	public void gettheStatusOfflights() {
		
		 List<WebElement> flightcity = arrivalFlighlist;
		 List<WebElement> flightstatus = arrivalFlighlistStatus;
		 
//		 System.out.println(flightcity.size());
//		 System.out.println(flightstatus.size());
		 
		 List<String> data= new LinkedList<String>();
		 List<String> data1=new LinkedList<String>();
		 
		 for(int i=0;i<flightcity.size();i++){
			
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", flightcity.get(i));
			 data.add(flightcity.get(i).getText());
			 data1.add(flightstatus.get(i).getText());
			 
		 }
		 
		 for(int i=0;i<data.size();i++){
				
			 System.out.println(data.get(i)+"    -      "+data1.get(i));
		
			
			 
		 }
		 
	}
	
	

}
