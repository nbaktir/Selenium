package com.class10;

import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AmazonBrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
	
		driver.get("https://www.kayak.com/");
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("Syntax@123");
//		driver.findElement(By.id("btnLogin")).click();
//		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println(allLinks.size());
		
		for(int i =0; i<allLinks.size();i++) {
			System.out.println(allLinks.get(i).getAttribute("href"));
		}
		
		
		for(int i =0; i<allLinks.size();i++) {
			String linkURL = allLinks.get(i).getAttribute("href");
			if(linkURL != null ) {
				
				HttpURLConnection connection =(HttpURLConnection) (new URL(linkURL).openConnection());
				
				int rCode = connection.getResponseCode();
				if(rCode == 200) {
					System.out.println(i+" Link is valid "+linkURL);
				}else {
					System.err.println(i+" Link is broken "+linkURL);
				}
			}else {
				System.out.println(allLinks.get(i).getText());
				System.out.println(i+" Link is broken ********" +linkURL);
			}
		}
		
		driver.close();
	}

}
