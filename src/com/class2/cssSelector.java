package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssSelector {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		
		//input#txtUsername   # --> id 
		//input.button        . --> class, if there is space in the class, then it does not work
		// input[name^='value']  ^ --> starts-with
		// input[name$='value']   $ --> ends-with
		
		//input[id*='btnL']   * --> contains 
	}

}
