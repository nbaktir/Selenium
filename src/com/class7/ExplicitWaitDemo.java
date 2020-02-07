package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class ExplicitWaitDemo extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.url);
		driver.findElement(By.linkText("Others")).click();
		driver.findElement(By.linkText("Dynamic Data Loading")).click();;
		driver.findElement(By.id("save")).click();
		
		//webdriver wait or explicit wait 
		// wait for specific element to appear on the page
		// it will wait till expected condition is met in specified time
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
	//	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("First-Name")));
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[starts-with(text(), 'First Name')]")));

		
		boolean displayed = driver.findElement(By.xpath("//p[starts-with(text(), 'First Name')]")).isDisplayed();
		
		if(displayed) {
			System.out.println("Pass");
		}else {
			System.out.println("Failed");
		}
		
		// we put this thread.sleep to just see the page
		Thread.sleep(2000);
		driver.quit();
	}

}
