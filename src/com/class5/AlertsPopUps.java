package com.class5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;
import com.utils.Constants;

public class AlertsPopUps extends CommonMethods {

	//Interview Question: how do you handle alerts?
	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Constants.url);
		
		driver.findElement(By.xpath("//a[@href='#' and text()='Alerts & Modals']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Javascript Alerts")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		Thread.sleep(2000);
		//when a pop up opens, by just clicking it gives error.
		//unexpected alert open --> should use switchTo() method
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
		//get text from ui or main window
	    String text = driver.findElement(By.xpath("//p[@text()='Click the button to display an alert box:'")).getText();
	    System.out.println(text);
		
	    driver.close();
	
	}

}
