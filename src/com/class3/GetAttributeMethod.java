package com.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeMethod {

	public static final String URL = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get(URL);
		driver.findElement(By.cssSelector("input[id='txtUsername']")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		
		String attribute = driver.findElement(By.cssSelector("input#btnLogin")).getAttribute("class");
		System.out.println(attribute);

		//why do wee need attribute?
		//if we want to get a value back, I want to get entered value back
		String userNameValue = driver.findElement(By.cssSelector("input[id='txtUsername']")).getAttribute("value");
		System.out.println(userNameValue);
		
		driver.findElement(By.cssSelector("input#btnLogin")).submit();
		//submit --> if we fill a form, we will use submit()
		//it will wait until the page is loaded
		
		driver.close();
	}

}
