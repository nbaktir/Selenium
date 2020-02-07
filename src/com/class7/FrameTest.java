package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class FrameTest extends CommonMethods{

	public static void main(String[] args) {
		setUp("chrome", "http://166.62.36.207/syntaxpractice/bootstrap-iframe.html");
		// this method coming from CommonMethods class inside utils package
		switchFrame("FrameOne");
		
		WebElement logo = driver.findElement(By.xpath("//img[@id='hide']"));
		
		System.out.println(logo.isDisplayed());
		driver.switchTo().defaultContent();
		
		driver.close();
	}

}
