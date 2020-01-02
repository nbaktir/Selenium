package com.class5;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

//getwindowHandles() method

public class MultiWindowsDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", "https://accounts.google.com/signup");

		Thread.sleep(2000);
		
		System.out.println("Title of the main Window: "+driver.getTitle());
		
		driver.findElement(By.linkText("Help")).click();
		
		Set<String> allwindowsID = driver.getWindowHandles();
		
		System.out.println("How many Windows currently open? "+allwindowsID.size());
		
		Iterator<String> it= allwindowsID.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		System.out.println("Parent ID: "+parentWindow);
		System.out.println("Child Window: "+childWindow);
		
		
		driver.switchTo().window(childWindow);
		System.out.println("Title of the Child Window: "+driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id=\"search-form\"]/input[1]")).sendKeys("Window Practice");
		Thread.sleep(2000);
		
		driver.close();
	}

}
