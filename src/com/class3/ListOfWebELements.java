package com.class3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListOfWebELements {

	public static final String URL = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get(URL);
		driver.findElement(By.cssSelector("input[id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		WebElement logo = driver.findElement(By.cssSelector("img[alt='OrangeHRM']"));
		
		//findElements returns list of webElement, more than one
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Size of all links = "+links.size());
		
		for(WebElement link :links) {
			String activeLink = link.getText();
			if(!activeLink.isEmpty()) {
				System.out.println(activeLink);
			}
		}
		driver.close();
	}

}
