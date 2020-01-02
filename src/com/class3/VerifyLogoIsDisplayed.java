package com.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLogoIsDisplayed {

	public static final String URL = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get(URL);
		driver.findElement(By.cssSelector("input[id='txtUsername']")).sendKeys("sohilaryan");
		driver.findElement(By.id("txtPassword")).sendKeys("Syntax@12");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		WebElement logo = driver.findElement(By.cssSelector("img[alt='OrangeHRM']"));
		
		if(logo.isDisplayed()) {
			System.out.println("You entered sucessfully");
		}else {
			System.err.println("Couldn't login the page");
		}
		driver.close();
	}

}
