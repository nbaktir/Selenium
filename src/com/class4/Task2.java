package com.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class Task2 extends CommonMethods {

	public static final String url = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";
	
	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", url);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		Thread.sleep(1000);
	//	driver.findElement(By.xpath("//a[text()='Input Forms']/following::a[3]")).click();
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		
		Thread.sleep(1000);
		
		WebElement maleRadioB = driver.findElement(By.xpath("//input[@value='Male' and @name='optradio']"));
		maleRadioB.click();
		if(maleRadioB.isSelected()) {
			System.out.println("Correct check box is selected");
		}else{
			System.err.println("Wrong check box is selected");
		}
			
		WebElement female = driver.findElement(By.xpath("//input[@name='gender' and @value='Female'] "));
	
		female.click();
		
		Thread.sleep(2000);
		
		if(female.isSelected()) {
			System.out.println("Right checkbox is selected");
		}else {
			System.out.println("Wrong checkbox is selected");
		}
		driver.quit();
	}

}
