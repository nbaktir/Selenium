package com.class6;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class WindowRecap extends CommonMethods {

	public static void main(String[] args) {
		setUp("chrome","http://jiravm.centralus.cloudapp.azure.com:8081/window-popup-modal-demo.html");
		// that will return unique session id 
		
		String mainWindow = driver.getWindowHandle();
		
		System.out.println(mainWindow);
		
		driver.findElement(By.linkText("Follow On Instagram")).click();
		// 1 getWindowHandles
		//identify parent child
		//switch
		
		Set<String> allWindows = driver.getWindowHandles();
		
		Iterator<String> it = allWindows.iterator();
		String parent = it.next();
		String child = it.next();
		
		driver.switchTo().window(child);
		String childTitle = driver.getTitle();
		
		driver.switchTo().window(parent);
		System.out.println(driver.getWindowHandle());
		System.out.println("------------------");
		
		String parentTitle = driver.getTitle();
		System.out.println(parentTitle);
		System.out.println(childTitle);
		
		
		driver.quit();
	}

}
