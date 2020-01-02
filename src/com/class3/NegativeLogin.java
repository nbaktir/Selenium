package com.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NegativeLogin {

	public static final String URL = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get(URL);
		driver.findElement(By.cssSelector("input[id='txtUsername']")).sendKeys("sohilaryan");
		Thread.sleep(2000);
		driver.findElement(By.id("txtPassword")).sendKeys("");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		Thread.sleep(2000);
		WebElement errorMessage = driver.findElement(By.cssSelector("span#spanMessage"));
		String message = errorMessage.getText();
		
		if(errorMessage.isDisplayed()) {
			if(message.equals("Password cannot be empty")) {
				System.out.println("Correct message displayed");
			}else {
				System.err.println("Wrong message is displayed");
			}
		}
		driver.close();
	}

}
