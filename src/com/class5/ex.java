package com.class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver d = new ChromeDriver();
		d.get("http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		d.findElement(By.linkText("Home")).click();
		Thread.sleep(2000);
		d.findElement(By.linkText("Progress Bars")).click();
		Thread.sleep(2000);
		d.findElement(By.linkText("Bootstrap Progress bar")).click();
		Thread.sleep(2000);
		d.navigate().back();
		Thread.sleep(2000);
		d.findElement(By.linkText("Date pickers")).click();
		Thread.sleep(2000);
		
		d.close();
		
	}

}
