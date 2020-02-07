package com.class7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class PageLoadandImplicitWait extends CommonMethods{

	public static void main(String[] args) {
		setUp("chrome","https://google.com/");

		//max wait time for the page to load fully(all elements)
		/*Page load waits until all elements on the page 
		gets fully loaded*/
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		// tell webdriver to wait for the element throwing 
		//NoSuchElement exception
		//we need implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// if it is found less than 10 seconds, then rest of the time will be ignored
		
		driver.findElement(By.name("q")).sendKeys("iPhone");
		driver.quit();
	}

}
