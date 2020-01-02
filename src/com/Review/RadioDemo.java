package com.Review;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class RadioDemo extends CommonMethods{

	public static final String url = "http://www.uitestpractice.com/Students/Form";
	public static void main(String[] args) throws InterruptedException {
	
		// create a list of web elements and store options in
		// in list and use name or class name to findElement
		// this way you can use something common for all

		CommonMethods.setUp("chrome", url);
		
		List<WebElement> radios = driver.findElements(By.name("optradio"));
		
		for(WebElement r:radios) {
			System.out.println(r);
			r.click();
			Thread.sleep(1000);
		}
		
		WebElement dd  = driver.findElement(By.cssSelector("select#sel1"));
		Select obj = new Select(dd);
		
		List<WebElement> options = obj.getOptions();

		Iterator<WebElement> it = options.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getText());
			Thread.sleep(1000);
		}
		
		System.out.println("There are "+options.size()+" options");
		
		if(options.size()==70) {
			System.out.println("Test is passed");
		}else {
			System.err.println("Test is failed");
		}
		
		obj.selectByIndex(1);
		Thread.sleep(2000);
		obj.selectByVisibleText("India");;
		Thread.sleep(2000);
		
				
		driver.close();
	}

}
