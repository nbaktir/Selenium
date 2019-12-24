package com.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonPageTitle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
	    String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
	    
	    if(expectedTitle.equals(actualTitle)) {
	    	System.out.println("Titles matched");
	    }else {
	    	System.err.println("Actual and expected did not match");
	    }
	    
		Thread.sleep(1000);
		
	    WebElement logo = driver.findElement(By.cssSelector("span[class='nav-sprite nav-logo-base']"));
	    
	    if(logo.isDisplayed()) {
	    	System.out.println("Passed");
	    }else {
	    	System.err.println("Failed");
	    }
	    
	    Thread.sleep(1000);
	   
	    //tagName can be used with Group elements like, Select and
	    // checkboxes/dropdowns
	   
	    WebElement selectElement = driver.findElement(By.tagName("select"));
	   
	    Select select = new Select(selectElement);
	    select.selectByVisibleText("Deals");
	    
	    Thread.sleep(3000);
	    
		driver.close();
	}

}
