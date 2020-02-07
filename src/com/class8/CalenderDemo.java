package com.class8;

import org.openqa.selenium.By;

import com.utils.CommonMethods;
import com.utils.Constants;

public class CalenderDemo extends CommonMethods{

	public static void main(String[] args) {
		setUp("chrome", Constants.HRMS_URL);
		
		//login to HRMS
		driver.findElement(By.id("txtUsername")).sendKeys("");
		
		
		driver.close();
	}
	
}
