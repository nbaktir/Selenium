package com.class1;

import org.openqa.selenium.chrome.ChromeDriver;

public class PageCommands {

	public static void main(String[] args) {
		
		// System is a class, setProperty() is a static method 
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
	
		driver.get("https://www.google.com/");
		
		String actualTitle = driver.getTitle();
	//	System.out.println(actualTitle);

		final String expectedTitle = "Google";
		
		if(actualTitle.equalsIgnoreCase(expectedTitle)){
			System.out.println("--Page title matches---");
		}else {
			System.err.println("The actual and expected Title did not match");
		}
	    
		System.out.println("--------------------");
		
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		String expectedUrl = "https://www.google.com/";
		
		if(expectedUrl.equals(actualUrl)) {
			System.out.println("Both URL matched");
		}else {
			System.err.println("Actual and expected Title did not match");
		}
		
		
		driver.close();

	}

}
