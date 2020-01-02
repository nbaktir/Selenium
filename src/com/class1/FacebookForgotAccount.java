package com.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookForgotAccount {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		String actualTitle = driver.getTitle(); 
		
		String expectedTitle = "Facebook - Log In or Sign Up";
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Actual and Expected Titles match");
		}else{
			System.err.println("Navigated to wrong page");
		}
		
		driver.findElement(By.linkText("Forgot account?")).click();
		
		String currentTitle = driver.getTitle();
		
		if(currentTitle.equals("Forgot Password | Can't Log In | Facebook")) {
			System.out.println("Actual and Expected Titles match");
		}else {
			System.err.println("Titles do not match");
		}
		driver.navigate().back();
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
		String actualTitle1 = driver.getTitle();
		
		if(expectedTitle.equals(actualTitle1)) {
			System.out.println("Actual and Expected Titles match");
		}else{
			System.err.println("Navigated to wrong page");
		}
		
		driver.close();
	}

}
