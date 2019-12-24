package com.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToRedfin {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.redfin.com/");
		
		driver.quit();
	}

}
