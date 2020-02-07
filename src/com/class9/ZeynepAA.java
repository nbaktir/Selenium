package com.class9;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class ZeynepAA extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {// TODO Auto-generated method stub
		setUp("chrome", "https://www.aa.com/homePage.do");

		// driver.findElement(By.xpath("//input[@name='tripType'][@value='roundTrip']")).click();
		// selecting airport from
		driver.findElement(By.xpath("//input[@name='originAirport'][@value='DFW']")).sendKeys("Dallas");
		driver.findElement(By.xpath("//*[@id='reservationFlightSearchForm']/div[3]/div[1]/div/a/span[1]")).click();

		WebElement select = driver.findElement(By.xpath("//select[@id='countryCode']"));
		select.click();
		Select listofcountry = new Select(select);
		
		List<WebElement> dropdownofCount = listofcountry.getOptions();
	
		for (WebElement drop : dropdownofCount) {
		//	System.out.println(drop.getText());
			if (drop.getText().equals("Turkey")) {
				drop.click();
				driver.findElement(By.xpath("//span[@class='airport-code' and text()='ADA']")).click();
				System.out.println("you  will fly from Adana in Turkey");
			}
		}
		// selecting airport to
		driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.destinationAirport']"))
				.sendKeys("Dallas");
		driver.findElement(By.xpath("//*[@id=\"reservationFlightSearchForm\"]/div[3]/div[2]/div/a/span[1]")).click();

		WebElement selectto = driver.findElement(By.xpath("//select[@id='countryCode']"));
		selectto.click();
		
		Select listofcountryofTo = new Select(selectto);
		List<WebElement> dropdownofCountofTo = listofcountryofTo.getOptions();
		
		for (WebElement drop : dropdownofCountofTo) {

			if (drop.getText().equals("Canada")) {
				drop.click();
				WebElement province = driver.findElement(By.xpath("//select[@id='stateCode']"));
				Select listpro = new Select(province);
				List<WebElement> listprovince = listpro.getOptions();
				for (WebElement p : listprovince) {

					if (p.getText().equals("Manitoba")) {
						p.click();
						driver.findElement(By.xpath("//*[@id='airport_YBT']/span[1]")).click();
					}
				}
			}
		}
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		
		// selecting number of passenger
		WebElement selectPassenger = driver.findElement(By.xpath("//select[@id='flightSearchForm.adultOrSeniorPassengerCount']"));
		Select selectOfPassenger = new Select(selectPassenger);
		
		selectOfPassenger.selectByVisibleText("2");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		// depart
		driver.findElement(By.xpath("//input[@name='departDate']")).click();
		
		boolean mountIsFound = false;
	
		while(!mountIsFound){

			String monthName = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			if (monthName.contains("May")) {
				List<WebElement> cells = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
				int sizeOfDay = cells.size();
			
				for (int j = 1; j <= sizeOfDay; j++) {
					String day = cells.get(j - 1).getText();
					if (day.equals("14")) {
						cells.get(j - 1).click();
						mountIsFound = true;
						break;
					}	
				}
			}else {
				driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
			}
		}
		// Return
		driver.findElement(By.xpath("//input[@id='aa-returningFrom']")).click();

		mountIsFound = false;
		
		while(!mountIsFound) {

			String monthName = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			// navigating expected month
			if (monthName.equals("October")) {
				List<WebElement> cells = driver
						.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
				int sizeOfDay = cells.size();
				System.out.println(sizeOfDay);
				for (int j = 1; j <= sizeOfDay; j++) {
					String day = cells.get(j - 1).getText();
					// navigating expected day
					if (day.equals("8")) {
						cells.get(j - 1).click();
						
						mountIsFound = true;
						break;
					}
				}
			}
			else {
				driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
				
			}

		}
		
		screen = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File("screenshots/AAIRLINE/result.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']")).click();

		String expectedText = "Choose Flight";
		/*
		 * String
		 * chooseFlight=driver.findElement(By.xpath("//h1[@id='aa-pageTitle']")).getText
		 * (); if(expectedText.equals(chooseFlight)) { System.out.println("Passed");
		 * }else { System.out.println("Failed"); }
		 */
		Thread.sleep(2000);
		driver.quit();

	}

}
