package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;

public class MercuryToursRegistration {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("Anna");
		driver.findElement(By.name("lastName")).sendKeys("White");
		driver.findElement(By.name("phone")).sendKeys("1112345678");
		driver.findElement(By.id("userName")).sendKeys("annawhite@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("123 Test Dr");
		driver.findElement(By.name("city")).sendKeys("New York");
		driver.findElement(By.name("state")).sendKeys("NY");
		driver.findElement(By.name("postalCode")).sendKeys("34678");
		driver.findElement(By.id("email")).sendKeys("annawhite@gmail.com");
		driver.findElement(By.name("password")).sendKeys("1234567");
		driver.findElement(By.name("confirmPassword")).sendKeys("1234567");
		driver.findElement(By.name("register")).click();
		
		Thread.sleep(2000);
		
		WebElement signOff = driver.findElement(By.linkText("SIGN-OFF"));
		
		Thread.sleep(3000);
		
		if(signOff.isDisplayed()) {
			System.out.println("You are successfully registered");
		}else {
			System.out.println("Failed");
		}
		
		Thread.sleep(3000);
		
		WebElement dear = driver.findElement(By.xpath("//b[contains(text(),'Dear')]"));
		if(dear.isDisplayed()) {
			System.out.println("Account is successfully created");
		}else {
			System.err.println("Failed");
		}
		
		driver.close();
	}

}
