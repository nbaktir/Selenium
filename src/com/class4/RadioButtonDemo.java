package com.class4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class RadioButtonDemo extends CommonMethods {

	public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";
	
	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		Thread.sleep(1000);
	//	driver.findElement(By.xpath("//a[text()='Input Forms']/following::a[3]")).click();
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		
		Thread.sleep(1000);
		
		WebElement maleRadioB = driver.findElement(By.xpath("//input[@value='Male' and @name='optradio']"));
		
		System.out.println(maleRadioB.isSelected());
	
		maleRadioB.click();
		Thread.sleep(1000);
		System.out.println(maleRadioB.isSelected());
		
		System.out.println("--------------------");
		
		List<WebElement> radioButtons = driver.findElements(By.name("optradio"));
		
		// we are using this to check if all the radio buttons are clickable
		for(int i = 0; i<radioButtons.size();i++) {
		
			boolean isSelected = radioButtons.get(i).isSelected(); // lets look are they clickable
			System.out.println(isSelected);
			
			if(!isSelected) {
				radioButtons.get(i).click();
				Thread.sleep(1000);
			}
		}
		
		driver.close();
	}

}
