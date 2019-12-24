package com.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SyntaxPAgeURL {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.syntaxtechs.com");
		driver.navigate().to("https://www.google.com/");
		driver.navigate().back();
		driver.navigate().refresh();
		String currentUrl = driver.getCurrentUrl();
		
		if(currentUrl.contains("syntax")) {
			System.out.println("The URL contains \"syntax\" ");
		}else {
			System.err.println("The URL does not contain \"syntax\" ");
		}
		driver.close();
	}

}
