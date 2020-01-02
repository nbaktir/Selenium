package com.class4;

import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByClassName;

import com.utils.CommonMethods;
import com.utils.Constants;

public class MultipleCheckBox extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Constants.url);
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Checkbox Demo")).click();
		
		WebElement ageCheckBox = driver.findElement(By.id("isAgeSelected"));

		if(!ageCheckBox.isSelected()) {
			ageCheckBox.click();
		}
		
		System.out.println("--------Group of CheckBox--------");
		
		List<WebElement> groupCheckBox = driver.findElements(By.className("cb1-element"));
		
		if(!groupCheckBox.isEmpty()) {
			Iterator<WebElement> it = groupCheckBox.iterator();
			while(it.hasNext()) {
				it.next().click();
				Thread.sleep(1000);
			}
		
		}else {
			System.err.println("List is empty");
		}
		
		Thread.sleep(1000);

		driver.close();
	}

}
