package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabsPositiveLogin {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Nurgul");
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Baktir");
		driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("NurgulBaktir@gmail.com");
		driver.findElement(By.cssSelector("")).sendKeys("1234567");

		driver.close();
	}

}
