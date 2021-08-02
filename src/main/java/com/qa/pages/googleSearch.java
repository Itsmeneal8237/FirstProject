package com.qa.pages;

import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class googleSearch extends TestBase{
	
	
	
	@FindBy(xpath = "//input[@title='Search']")

	WebElement googleSearchbox;

	
	@FindBy(xpath = "//span[text()=' › wiki › Selenium_(software)']//ancestor::div//h3[contains(text(),'Selenium (software) - Wikipedia')]")

	 List<WebElement> searchresuls;
	
	
	
	@FindBy(xpath = "//h3[contains(text(),'Selenium (software) - Wikipedia')]//ancestor::div//div[contains(text(),'Selenium is a portable framework for testing web applications. Selenium provides a playback ... github.com/SeleniumHQ/ · Edit this at Wikidata.')]")
	WebElement searchresulttext;
	
	// Initializing the Page Objects:
	public googleSearch() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterTextinGoogleSearchBox(String Text){
		
		googleSearchbox.sendKeys(Text,Keys.ENTER);
		
	}
	
	public boolean searchResults() {
		
		boolean flag=false;
		 try {
			int size = driver.findElements(By.cssSelector("[valign='top'] > td")).size();
			   outer :for(int j = 1 ; j < size ; j++) {
			       if (j > 1) {// we don't need to navigate to the first page
			           driver.findElement(By.cssSelector("[aria-label='Page " + j + "']")).click(); // navigate to page number j
			       }

			       String pagesearch = driver.getCurrentUrl();

			       List<WebElement> findElements = searchresuls;
			       //System.out.println(findElements.size());

			       
			       for(int i=0;i<findElements.size();i++){
			    	   searchresulttext.isDisplayed();      
			           String text=searchresulttext.getText(); 
                       System.out.println("text is : "+text);
			           driver.navigate().to(pagesearch);
			           JavascriptExecutor jse = (JavascriptExecutor) driver;
			           //Scroll vertically downward by 250 pixels
			           jse.executeScript("window.scrollBy(0,250)", "");
			           flag=true;
			           break outer;
			       }
			   
			   }
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			  flag= false;
		}
		return flag;
		
		
	}
	
	
	
}
