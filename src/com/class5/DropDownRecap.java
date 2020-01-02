package com.class5;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;
import com.utils.Constants;

public class DropDownRecap extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		//this method is opening chrome browser and Syntax practice webpage
		CommonMethods.setUp("chrome", Constants.url);
		
		//find element input form and click on it
		driver.findElement(By.linkText("Input Forms")).click();
		Thread.sleep(1000);

		// find element select dropdown list and click 
		driver.findElement(By.linkText("Select Dropdown List")).click();
		Thread.sleep(1000);
		
		WebElement dd = driver.findElement(By.id("select-demo"));
		// to work with drop down, if it starts with select 
		//then use Select class and create an object of select class
		Select select = new Select(dd);
		select.selectByIndex(2);
		Thread.sleep(2000);
		select.selectByVisibleText("Thursday");
		Thread.sleep(2000);
		select.selectByValue("Friday");
		System.out.println("Does this dropdown support multi select "+select.isMultiple());
		Thread.sleep(1000);
		
		//How to get count of a dropdown items?
		List<WebElement> options = select.getOptions();
		System.out.println(options.size());
		
		Iterator<WebElement> it = options.iterator();
		while(it.hasNext()) {
			it.next().click();
			Thread.sleep(2000);
		}
		
		driver.close();
	}

}
