package com.Review;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;
/*Using the toolsqa Website, write code to accept an alert when 
 * clicking on 'Alert Box' button and write code that 
 * accepts an alert when clicking on 'Timing Alert'
 * button - DO NOT USE Thread.Sleep();*/
public class Alert extends CommonMethods{

	public static void main(String[] args) {
		
		setUp("chrome", Constants.toolsqaUrl);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("timingAlert")));

		driver.findElement(By.id("timingAlert")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		
		acceptAlert();

	}

}
