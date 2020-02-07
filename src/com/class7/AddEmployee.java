package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;
import com.utils.Constants;
//Admin
//Hum@nhrm123
/*
 * 1. Open chrome browser
 2.Go to "http://166.62.36.207/humanresources/symfony/web/index.php/auth"
 3.Login into the application
 4.Add Employee
 5.Log out
 6.Quit the browser
 */

public class AddEmployee extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		
		driver.findElement(By.linkText("Add Employee")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Anna");
		driver.findElement(By.name("lastName")).sendKeys("White");
		driver.findElement(By.name("employeeId")).sendKeys("7653");
		
//		driver.findElement(By.id("chkLogin")).click();
//		driver.findElement(By.id("user_name")).sendKeys("annawhite");
//		driver.findElement(By.id("user_password")).sendKeys("A@Hrms");
//		driver.findElement(By.id("re_password")).sendKeys("A@Hrms");
		
		WebElement dd = driver.findElement(By.id("status"));
		
		Select select = new Select(dd);
		select.selectByValue("Enabled");
		
		driver.findElement(By.id("btnSave")).click();
		
		Thread.sleep(2000);
		driver.close();
	}

}
