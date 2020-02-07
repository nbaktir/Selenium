package com.class10;

import org.openqa.selenium.By;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Task1 extends CommonMethods{

	public static void main(String[] args) {
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.xpath("//div[@id='divUsername']/input")).sendKeys("Admin");
		driver.findElement(By.xpath("//div[@id='divPassword']/input")).sendKeys("Hum@nhrm123");
		
		driver.findElement(By.xpath("//div[@id='divLoginButton']/input")).click();
		
		driver.close();
	}

}
