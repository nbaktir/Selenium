package com.class6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class DropDownRecap extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "https://www.ebay.com/");
		WebElement dd = driver.findElement(By.cssSelector("select#gh-cat"));

		Select obj = new Select((dd));
		List<WebElement> options = obj.getOptions();
		
		for(WebElement option: options) {
			option.click();
			Thread.sleep(1000);
			System.out.println(option.getText());
		}
		System.out.println(options.size());
		
		// validate user can select "Music"
		obj.selectByVisibleText("Music");
		boolean isSelected = false;
		
		for(WebElement option: options) {
			String text = option.getText();
			if(text.equals("Music")) {
				obj.selectByVisibleText(text);
				isSelected = true;
				break;
			}
		}
		
		System.out.println(isSelected);
		
		driver.close();
	}

}
