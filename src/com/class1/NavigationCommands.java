package com.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationCommands {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
	
		driver.get("https://www.google.com/");
		
		// what is the difference between navigate and get method
        
		// driver.navigate() will keep the browser history, you can 
		//use back and forward methods with navigate. but does not wait to page to load fully
		
		// driver.get() only gets the page. No back and forward 
		// it wait till page load, you should be able to get title, web elements, etc
		
		driver.close();
		
		System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
		WebDriver driver1 = new FirefoxDriver();
		
		driver1.get("https://www.facebook.com/");
		driver1.close();
	}

}
