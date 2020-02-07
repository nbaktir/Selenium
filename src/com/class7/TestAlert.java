package com.class7;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class TestAlert extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://166.62.36.207/syntaxpractice/javascript-alert-box-demo.html");

		driver.findElement(By.cssSelector("button[onclick='myAlertFunction()']")).click();
		Thread.sleep(2000);
		acceptAlert();
		
		Thread.sleep(2000);
		
		driver.close();
		
	}

}
