package com.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

//JavascriptExecuter is an interface in selenium, very powerful for clicking element
public class JavaScriptExeuter extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome",Constants.HRMS_URL);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Hum@nhrm123");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		//change color of selected button
		js.executeScript("arguments[0].style.backgroundColor='Red'",loginBtn);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", loginBtn);
		//specify how much you want to go down 
		js.executeScript("window.scrollBy(0,2020)");
		
		driver.quit();
	}
}
