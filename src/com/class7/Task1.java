package com.class7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class Task1 extends CommonMethods {

	public static void main(String[] args) {
		setUp("chrome", "https://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Dynamic Loading")).click();
		
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		WebElement hello = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
		
		wait.until(ExpectedConditions.visibilityOf(hello));
		
		boolean isDisplayed = driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed();
		
		if(isDisplayed) {
			
			System.out.println("passed");
		}
		else{
			System.err.println("Failed");
		}
		
		driver.quit();
	}

}
