package com.class6;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class MultipleWindows extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome","http://jiravm.centralus.cloudapp.azure.com:8081/window-popup-modal-demo.html");
		
		String mainWindow = driver.getWindowHandle();
		
		driver.findElement(By.linkText("Follow On Instagram")).click();
		driver.findElement(By.linkText("Like us On Facebook")).click();
		driver.findElement(By.linkText("Follow On Instagram")).click();
		driver.findElement(By.linkText("Follow Instagram & Facebook")).click();
	
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows.size());
		Iterator<String> it = allWindows.iterator();
		
		while(it.hasNext()) {
			String child = it.next();
			if(!child.equals(mainWindow)) {
				driver.switchTo().window(child);
				Thread.sleep(2000);
				System.out.println(driver.getTitle());
				driver.close();
				driver.switchTo().window(mainWindow);
			}
		}
	
		driver.quit();
	}

}
