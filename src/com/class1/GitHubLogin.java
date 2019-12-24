package com.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GitHubLogin {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://github.com/login");
		
		driver.findElement(By.id("login_field")).sendKeys("nbaktir");
		driver.findElement(By.id("password")).sendKeys("Nurgul01*");
		driver.findElement(By.name("commit")).click();
		
		String title = driver.getTitle();
	
		Thread.sleep(3000);
		
		driver.close();

	}

}
