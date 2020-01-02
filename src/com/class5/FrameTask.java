package com.class5;

import org.openqa.selenium.By;

import com.utils.CommonMethods;
import com.utils.Constants;

/*TC 1: Syntax Frame verification
Open chrome browser
Go to "http://jiravm.centralus.cloudapp.azure.com:8081/index.html"
Click on "Others" link
Click on "Iframe" link
Click on the "Home" link inside the frame 1
Verify "Syntax logo" is displayed in another frame
Quit browser
*/

public class FrameTask extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Constants.url);
		driver.findElement(By.linkText("Others")).click();
		driver.findElement(By.linkText("Iframe")).click();
		Thread.sleep(2000);
		
		driver.switchTo().frame("FrameOne");
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Home")).click();
		
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
	
		Thread.sleep(2000);
		
		driver.switchTo().frame("FrameTwo");
		
		Thread.sleep(2000);
		
		boolean isLogoDisplayed = driver.findElement(By.xpath("//img[@alt='Syntax Technologies']")).isDisplayed();
		
		System.out.println("Logo is displayed: "+isLogoDisplayed);
		
		driver.switchTo().defaultContent();
		
		driver.close();
	}

}
