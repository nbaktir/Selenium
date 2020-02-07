package com.class8;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HW1 extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.HRMS_URL);

		// login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Syntax@123");
		driver.findElement(By.id("btnLogin")).click();

		// click PIM and Add Employee
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Add Employee")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Add Employee']")));

		// add employee
		driver.findElement(By.id("firstName")).sendKeys("A");
		driver.findElement(By.id("lastName")).sendKeys("B");
		String id = driver.findElement(By.xpath("//input[@name='employeeId']")).getAttribute("value");

		driver.findElement(By.id("btnSave")).click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screen, new File("screenshots/HRMS/AddEmployee.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// verify employee has been added
		boolean isDisplayed = driver.findElement(By.xpath("//h1[text()='Personal Details']")).isDisplayed();

		if (isDisplayed) {

			String name = driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value");
			String lastName = driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value");

			System.out.println(name + " " + lastName + " " + " with id " + id + " added to Employee list successfully");

		} else {
			System.err.println("Failed to add employee");
		}

		// go to employee list
		driver.findElement(By.linkText("Employee List")).click();

		Thread.sleep(2000);
		
		boolean found = false;
		
		while(!found) {
			
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id ='resultTable']/tbody/tr"));

			for (int i = 1; i <= rows.size(); i++) {
				String rowText = rows.get(i - 1).getText();
				
				if (rowText.contains(id)) {
					driver.findElement(By.xpath("//table[@id ='resultTable']/tbody/tr[" + i + "]/td[1]")).click();
					Thread.sleep(3000);
					driver.findElement(By.id("btnDelete")).click();
					driver.findElement(By.id("dialogDeleteBtn")).click();
					
					File screen1 = ts.getScreenshotAs(OutputType.FILE);
					try {
						FileUtils.copyFile(screen1, new File("screenshots/HRMS/DeleteEmployee.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					System.out.println("Employee with "+id+" is deleted successfully");
					Thread.sleep(3000);
					found = true;
					break;
				}
			}
			// if couldn't find in current page, go to next page
			driver.findElement(By.xpath("//a[text()='Next']")).click();
		}
		
		driver.close();
	}

}
