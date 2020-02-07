package com.Review;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HRMSRecruitementTable extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome",Constants.HRMS_URL);
		
		String userName = "Admin";
		String password = "Hum@nhrm123";
		
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu_recruitment_viewRecruitmentModule']")));
		driver.findElement(By.xpath("//*[@id='menu_recruitment_viewRecruitmentModule']")).click();
		
		String firstHalfXPath = "//table[@id='resultTable']/tbody/tr[";
		String secondHalfXPath = "]/td[3]/a";
		
		Thread.sleep(5000);
	//	wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//table[@id='resultTable']")));
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		System.out.println(rows.size());
	
		for(int i= 1; i<=rows.size();i++) {
			String namePresent = driver.findElement(By.xpath(firstHalfXPath+ i+ secondHalfXPath)).getText();
			System.out.println(namePresent);
		}
		
		driver.close();
	}

}
