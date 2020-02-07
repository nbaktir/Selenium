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

public class AmericanAirlinesSelectFlightDate extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome","https://www.aa.com/homePage.do");
		WebElement rtBtn = driver.findElement(By.xpath("//span[text()='Round trip']"));
		
		//select from 
		WebElement f = driver.findElement(By.xpath("//input[contains(@id,'originAirport')]"));
		f.clear();
		f.sendKeys("Los Angeles");
		driver.findElement(By.xpath("//a[contains(text(),'LAX')]")).click();
		
		//select to
		WebElement t = driver.findElement(By.xpath("//input[contains(@id,'destinationAirport')]"));
		t.clear();
		t.sendKeys("Dallas");
		driver.findElement(By.xpath("//a[contains(text(),'DFW')]"));
		
		//select passenger
		WebElement passengerCount = driver.findElement(By.xpath("//select[contains(@id,'PassengerCount')]"));
		Select select = new Select(passengerCount);
		select.selectByVisibleText("3");
		
		String[] months = {"May", "November"};
		String[] days = {"14","8"};
		String[] calendersId = {"aa-leavingOn","aa-returningFrom"};
		
		
		
		Thread.sleep(2000);
        TakesScreenshot ts=(TakesScreenshot)driver;
        File screen=ts.getScreenshotAs(OutputType.FILE);
        
        try {
            FileUtils.copyFile(screen, new File("screenshots/AmericanAirlines/flightSelect.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Thread.sleep(3000);
        driver.close();
		
	}

}
