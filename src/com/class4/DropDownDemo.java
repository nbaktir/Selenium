package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;
import com.utils.Constants;

public class DropDownDemo extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Constants.url);
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Input Forms")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Select Dropdown List")).click();
		
		WebElement weekDropDown = driver.findElement(By.cssSelector("select#select-demo"));
		
		Select select = new Select(weekDropDown);
		
		// we cannot diselect an element from single select dropdown list 
		
		select.selectByIndex(4);
		Thread.sleep(2000);
		
		select.selectByVisibleText("Monday");
		Thread.sleep(2000);
		
		select.selectByValue("Sunday");
		Thread.sleep(1000);
		
		
		
		
		System.out.println("Is thid DD Multi Select= "+select.isMultiple());
		
		
		System.out.println("------------------");
		// we can select and diselect a value from dropdown menu in multiple dropdown 
		
		WebElement multiDD = driver.findElement(By.id("multi-select"));
		
		Select select2 = new Select(multiDD);
		
		for(int i = 0; i<7;i++) {
			select2.selectByIndex(i);
		}
		Thread.sleep(2000);
		
		select2.deselectByIndex(4);
		
		Thread.sleep(2000);
		
		
		driver.close();
		
	}

}
