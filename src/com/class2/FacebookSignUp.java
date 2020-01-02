package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignUp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.cssSelector("input[name^='first']")).sendKeys("Amanda");
		driver.findElement(By.cssSelector("input[name*='last']")).sendKeys("Honey");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("amandahny@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("amandahny@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@name,'reg_pass')]")).sendKeys("facebookamanda");
		
		Select birthMonth = new Select(driver.findElement(By.id("month")));
		birthMonth.selectByVisibleText("Apr");
		
		Select birthDay = new Select(driver.findElement(By.id("day")));
		birthDay.selectByVisibleText("1");
		
		Select birthYear = new Select(driver.findElement(By.id("year")));
		birthYear.selectByVisibleText("1995");
		
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		driver.findElement(By.cssSelector("button[name='websubmit']")).click();
		
		Thread.sleep(2000);
		
		if(driver.getCurrentUrl().contains("https://www.facebook.com/recover/")) {
			System.out.println("passed");
		}else {
			System.err.println("FAILED");
		}
		
		
		driver.close();
	
	}

}
