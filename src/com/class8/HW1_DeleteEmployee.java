package com.class8;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

/*TC 1: Delete Employee
Open chrome browser
Go to "http://166.62.36.207/humanresources/symfony/web/index.php/auth"
Login into the application
Add Employee
Verify Employee has been added
Go to Employee List
Delete added Employee
Quit the browser
*/

//username: Syntax password: Syntax123!

public class HW1_DeleteEmployee extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", Constants.HRMS_URL);

		// login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Syntax@123");
		driver.findElement(By.id("btnLogin")).click();

		// click PIM and Add Employee
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Add Employee")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Add Employee']")));

		// add employee
		driver.findElement(By.id("firstName")).sendKeys("Ahmet");
		driver.findElement(By.id("lastName")).sendKeys("Hasan");
		String id = driver.findElement(By.id("employeeId")).getAttribute("value");

		driver.findElement(By.id("btnSave")).click();

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
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();

		// wait until table appears
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));

		// boolean flag = true;

		// find rows in table
		boolean flag = true;
		while(flag) {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id ='resultTable']/tbody/tr"));
			
			for (int i = 1; i <= rows.size(); i++) {
				
				String rowText = rows.get(i - 1).getText();
	
				if (rowText.contains(id)) {
					
					driver.findElement(By.xpath("//table[@class='table hover']/tbody/tr["+i+"]/td[1]")).click();
					Thread.sleep(3000);
	
					driver.findElement(By.id("btnDelete")).click();
					// wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
	
					Thread.sleep(3000);
					// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class
					// = 'modal-header']/h3[text()='OrangeHRM - Confirmation Required']")));
	
					driver.findElement(By.id("dialogDeleteBtn")).click();
					
					System.out.println("Record is successfully deleted");
				
					flag = false;
					break;
				}
			}
			// if couldn't find in current page, go to next page
			driver.findElement(By.linkText("Next")).click();
			Thread.sleep(2000);
			
		}
		driver.close();
	}
}
