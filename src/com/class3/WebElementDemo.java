package com.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementDemo {
	
	public static final String URL = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get(URL);
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		userName.sendKeys("Admin");
		Thread.sleep(2000);
		
		//it will clear the textbox, text area
		userName.clear();
		
		Thread.sleep(2000);
		
		userName.sendKeys("helen");

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("helen@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//storing the error message element
		WebElement errorMessage = driver.findElement(By.xpath("//span[@id='spanMessage']"));
		//will return t/f
		System.out.println(errorMessage.isDisplayed());
		
		
	//	System.out.println(errorMsg);
		
		if(errorMessage.isDisplayed()) {
			String errorMsg = errorMessage.getText();
			if(errorMsg.equals("Invalid credentials")) {
				System.out.println("Correct error message is displayed");
			}else {
				System.err.println("Incorrect error message is displayed");
			}
		}
		
		driver.close();
	}

}
