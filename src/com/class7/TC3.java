package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TC3  extends CommonMethods{
/*
1. Open chrome browser
2. Go to "https://the-internet.herokuapp.com/"
3. Click on "Click on the "Dynamic Controls" link
4. Click on enable button
5. Enter "Hello" and verify text is entered successfully
6. Close the browser
*/
	public static void main(String[] args){
		
		setUp("chrome", Constants.herokuUrl);
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello");
		boolean enabled = driver.findElement(By.xpath("//input[@type='text']")).isDisplayed();
		
		if(enabled) {
			
			String enteredMsg = driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
			System.out.println(enteredMsg+" is entered");
			System.out.println("Passed");
		
		}else {
			System.err.println("Failed");
		}
	
		driver.close();
	}

}
