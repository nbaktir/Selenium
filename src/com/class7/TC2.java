package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class TC2 extends CommonMethods {

	public static void main(String[] args) {
		setUp("chrome", "https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message")));

		String removeMsg = driver.findElement(By.cssSelector("p#message")).getText();

		if (removeMsg.equals("It's gone!")) {
			System.out.println("\"It's gone!\" Message is displayed");
		} else {
			System.err.println("Failed");
		}

		driver.findElement(By.xpath("//button[text()='Add']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'back!')]")));

		String addMsg = driver.findElement(By.xpath("//p[contains(text(),'back!')]")).getText();

		if (addMsg.equals("It's back!")) {
			System.out.println("\"It's back!\" Message is displayed");
		} else {
			System.err.println("Failed");
		}

		driver.close();

	}

}
