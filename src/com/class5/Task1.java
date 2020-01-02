package com.class5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class Task1 extends CommonMethods {

	public static final String SYNTAX_PRACTICE_URL="http://jiravm.centralus.cloudapp.azure.com:8081/index.html";
	
	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome",SYNTAX_PRACTICE_URL);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@href='#' and text()='Alerts & Modals']" )).click();
		driver.findElement(By.linkText("Javascript Alerts")).click();
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		
		Alert alert=driver.switchTo().alert();
        alert.sendKeys("I am an alert box!");
        Thread.sleep(1000);
      
        alert.accept();
        driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
      
        Alert alert1=driver.switchTo().alert();
        alert1.sendKeys("Press a button!");
        alert1.dismiss();
        Thread.sleep(2000);
       
        driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
      
        Alert alert2=driver.switchTo().alert();
        alert2.sendKeys("Finish!");
        alert2.accept();
       
        driver.close();
	}


}
