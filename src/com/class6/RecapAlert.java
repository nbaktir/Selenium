package com.class6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class RecapAlert extends CommonMethods{

	public static void main(String[] args) {
		
		setUp("chrome","http://jiravm.centralus.cloudapp.azure.com:8081/javascript-alert-box-demo.html");

		driver.findElement(By.cssSelector("button[onclick='myAlertFunction()']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	
		driver.close();
	}

}
