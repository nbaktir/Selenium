package com.class4;

import org.openqa.selenium.By;

import com.utils.CommonMethods;
import com.utils.Constants;

public class RadioButtonDemo2 extends CommonMethods{

	public static void main(String[] args) {
		CommonMethods.setUp("chrome", Constants.url);
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Checkbox Demo")).click();
		
		
		// complete the code
	}

}
