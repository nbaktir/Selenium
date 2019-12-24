package com.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabsLogin {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.className("btn_action")).click();
		
		WebElement amblem=driver.findElement(By.className("peek"));
		if(amblem.isDisplayed()) {
			System.out.println("passed");
		}else {
			System.out.println("failed");
		}
		
		Thread.sleep(2000);
		driver.findElement(By.id("item_4_title_link")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'btn_primary btn_inventory')]")).click();
		Thread.sleep(2000);
	
		driver.navigate().to("https://www.saucedemo.com/cart.html");
		
		
		driver.close();
	}

}
