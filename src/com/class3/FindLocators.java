package com.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;

public class FindLocators {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.zillow.com/");
		
		driver.findElement(By.id("search-box-input"));
		
		WebElement search = driver.findElement(By.xpath("//input[@id='search-box-input']"));
		
		search.sendKeys("75044");
		
		search.clear();
		//.sendKeys("75044");
		
		driver.findElement(By.cssSelector("input[id='search-box-input']")).sendKeys("Dallas");
		driver.findElement(By.cssSelector("input#search-box-input")).sendKeys("");
		Thread.sleep(2000);
		
		
		
		driver.close();
	}

}
