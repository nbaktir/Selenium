package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxGoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("Selenium in firefox");;
	
		Thread.sleep(2000);
		
		driver.close();
	}

}
