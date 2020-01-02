package com.class4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;
import com.utils.Constants;

public class GetOptionsMethodDropDown extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Constants.url);
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Input Forms")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Select Dropdown List")).click();
		
		WebElement weekDropDown = driver.findElement(By.cssSelector("select#select-demo"));
		
		Select select = new Select(weekDropDown);
		
		List<WebElement> option = select.getOptions();
		
		System.out.println("Size of options list: "+option.size());
		
		for(WebElement element : option) {
		
			String dValue = element.getText();
			System.out.println(dValue);
			
			Thread.sleep(1000);
			
			if(dValue.equals("Friday")) {
				element.click();
				Thread.sleep(1000);
			}
		}
		
		driver.close();
	}

}
