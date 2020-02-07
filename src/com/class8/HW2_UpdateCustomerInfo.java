package com.class8;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.class9.TakeScreenShot;
import com.utils.CommonMethods;

/*TC 1:Update Customer Information

Open chrome browser
Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
Login to the application
Verify customer "Susan McLaren" is present in the table
Click on customer details
Update customers last name and credit card info
Verify updated customers name and credit card number is displayed in table
Close browser*/

public class HW2_UpdateCustomerInfo extends CommonMethods {

	public static void main(String[] args) {
		setUp("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

		driver.findElement(By.xpath("//input[@class='txt'][1]")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@class='txt'][2]")).sendKeys("test");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));

		boolean customerPresent = false;
		
		String customer = "Susan McLaren";

		String newCC = "000000000000", newName = "!!!!!!";

		for (int i = 0; i < rows.size(); i++) {

			String rowText = rows.get(i).getText();

			if (rowText.contains(customer)) {
				customerPresent = true;
				System.out.println("Customer present in table: " + customerPresent);
				driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[" + (i + 1) + "]/td[13]")).click();
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).clear();
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Susan Taylor");

				newName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).getAttribute("value");

				driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).clear();
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("999888777000");

				newCC = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).getAttribute("value");

				driver.findElement(By.linkText("Update")).click();
				
				TakesScreenshot ts = (TakesScreenshot) driver;
				File screen = ts.getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(screen, new File("screenshots/WebOrders/EditEmployye.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}

		List<WebElement> rows2 = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));

		//verify name and credit card are updated
		for (WebElement row : rows2) {
			String text = row.getText();
			if (text.contains(newName) & text.contains(newCC)) {
				System.out.println("Name and credit card information updated successfully");
				System.out.println("Name: " + newName + ", CC: " + newCC);
				break;
			}
		}

		if (!customerPresent) {
			System.out.println("Customer is not found in table");
		}

		driver.findElement(By.id("ctl00_logout")).click();

		driver.close();
	}

}
