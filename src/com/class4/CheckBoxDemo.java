package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class CheckBoxDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("firefox", Constants.HRMS_URL);
		driver.manage().window().fullscreen();
		
		WebElement loginBtn = driver.findElement(By.cssSelector("input#btnLogin"));
		
		System.out.println(loginBtn.isEnabled());
		
	}

}
