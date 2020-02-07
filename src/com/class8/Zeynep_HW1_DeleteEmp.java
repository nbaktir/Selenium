package com.class8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class Zeynep_HW1_DeleteEmp extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth");
		//Login into the application
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.findElement(By.xpath("//*[text()='PIM']")).click();
		Thread.sleep(2000);
		//Add Employee
		driver.findElement(By.linkText("Add Employee")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@name='firstName']")));
	
		driver.findElement(By.xpath("//*[@name='firstName']")).sendKeys("Zeynep");
		driver.findElement(By.xpath("//*[@name='lastName']")).sendKeys("steel");
	
		String id=driver.findElement(By.xpath("//input[@name='employeeId']")).getAttribute("value");
		
		System.out.println(id);
	
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		String id2="1246";
		
		boolean foundId=false;
		
		while(!foundId) {
		   ////clicking employee list
		   driver.findElement(By.xpath("//*[text()='PIM']")).click();
		   driver.findElement(By.linkText("Employee List")).click();
		   //list of cells
		   List<WebElement> rows=driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr/td"));
		 
		   for(int i=1; i<rows.size(); i++) {
			   String rowText=rows.get(i-1).getText();
			   
			   if(rowText.contains(id)) {
				  
				
					driver.findElement(By.xpath("//table[@class='table hover']/tbody/tr["+ i +"]/td[1]")).click();
					   
					//delete the employee
					 
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@class='delete']")));
				
					driver.findElement(By.xpath("//input[@class='delete']")).click();
					
					//clicking delete button
					driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
				    System.out.println(id+" employee is deleted");
				    foundId=true;
				    break;
			   }
		   }
		   
		   //clicking next page
		   driver.findElement(By.xpath("//a[text()='Next']")).click();   
		}
		
		Thread.sleep(2000);	
		
	}
} 

