package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesForceLogin {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com/");
	    driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 username']")).sendKeys("nbaktir");
	    driver.findElement(By.cssSelector("input[class = 'input r4 wide mb16 mt8 password']")).sendKeys("123456");
	//	we can not use # for id, . for className if the value has space 
	    driver.findElement(By.cssSelector("input#Login")).click();
	 
	    Thread.sleep(2000);
	    
	    driver.findElement(By.linkText("Try for Free")).click();
	   
	    driver.close();

	}

}
