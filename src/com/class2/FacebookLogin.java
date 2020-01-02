package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("enter email");
		driver.findElement(By.id("pass")).sendKeys("enter password");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		
		WebElement profile = driver.findElement(By.cssSelector("a[title='Profile']"));
		
		if(profile.isDisplayed()) {
			System.out.println("You are succesfully loged in");
		//  System.out.println("Passed");
		}else {
			System.err.println("Failed");
		}
		
		driver.navigate().refresh();
	
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Marketplace")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input[placeholder='Search Marketplace']")).sendKeys("Upright deep freezer");
		
		Thread.sleep(2000);
	
		WebElement seeAll = driver.findElement(By.linkText("See All"));
		
		if(seeAll.isDisplayed()) {
			System.out.println("Passed");
		}else {
			System.err.println("Failed");
		}
		driver.close();
		
	}

}
