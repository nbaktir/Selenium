package com.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToZillowPage {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.zillow.com/");
		driver.navigate().to("https://www.google.com/");
		driver.navigate().back();
		driver.navigate().refresh();
		
		String currentUrl = driver.getCurrentUrl();
		
		if(currentUrl.contains("zillow")) {
			System.out.println("Current URL contains \"Zillow\" ");
		}else {
			System.err.println("Test case failed");
		}
		driver.close();
	}

}
