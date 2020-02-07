package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class ExplicitWaitDemo2 extends CommonMethods{

/*
 * navigate to google 
 * search for wegmans
 * click on link "Wegmans Grocery Delivery | Powered By Instacart
 * then click on sign in
 * */	
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://google.com/");
		driver.findElement(By.name("q")).sendKeys("Wegmans", Keys.ENTER);
		driver.findElement(By.xpath("//h3[text()='Wegmans Food Markets - Fresh Groceries & Delicious Meals']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in")));
		
		driver.findElement(By.cssSelector("#sign-in")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}

}
