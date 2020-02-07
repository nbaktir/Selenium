package com.class9;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utils.CommonMethods;
import com.utils.Constants;

public class TakeScreenShot extends CommonMethods{

	public static void main(String[] args) {
		
		setUp("chrome",Constants.HRMS_URL);
		
		String userName = "Admin";
		String password = "Hum@nhrm123";
		
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		
		//validate user logged in
		String welcomeText = driver.findElement(By.id("welcome")).getText();
		
		if(welcomeText.contains(userName)) {
			System.out.println("Test passed");
		}else {
			System.err.println("Test failed");
		}
		//How to take screenshot using selenium?
		//We can use TakesScreenshot interface
		//step1: downcast webdriver to the type of TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		//call method getScreenshotAs and specify output type
		File screen = ts.getScreenshotAs(OutputType.FILE);
		
		// throws checked exception
		try {
			//copy file to specified destination and give name and 
			FileUtils.copyFile(screen, new File("screenshots/HRMS/AdminLogin.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		driver.close();
	}

}
