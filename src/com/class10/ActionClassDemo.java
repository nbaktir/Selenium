package com.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;

import com.utils.CommonMethods;
import com.utils.Constants;

public class ActionClassDemo extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome",Constants.HRMS_URL);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Hum@nhrm123");
		
		//to perform mouse or keyboard operations we need to have an Object of Action class
		Actions act = new Actions(driver);
		//identify element on which to perform mouse click
		WebElement loginBtn = driver.findElement(By.cssSelector("input#btnLogin"));
		//do right click - right click --> contextClick
		act.moveToElement(loginBtn).contextClick().perform();
		
		act.moveToElement(loginBtn).click().perform();
		
		//to perform double click 
		//act.moveToElement(loginBtn).doubleClick().perform();
		
		Thread.sleep(2000);
		//hover over element --> specify element, move to element, perform
		WebElement pimLink = driver.findElement(By.linkText("PIM"));
		act.moveToElement(pimLink).click().perform();
		//need to finish with perform
		
		//click add employee
		WebElement addEmp= driver.findElement(By.linkText("Add Employee"));
		act.moveToElement(addEmp).click().perform();
		//we can just use click rather than moving to element 
		//click(WebElement) overloaded method
		act.click(addEmp).perform();
		
	//	act.keyUp(Keys.SHIFT).sendKeys("hello") --> if you perform this 
		// on text box it will hold shift key and type hello in upper case
		driver.close();
		
		//when our button is not clickable manually, we can perform click by Action class
		
	}

}
