package com.class10;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;

public class HW_DragAndDrop extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome","https://jqueryui.com/");
		WebElement dLink = driver.findElement(By.linkText("Droppable"));
		
		Actions action = new Actions(driver);
		action.click(dLink).perform();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		switchToFrame(frame);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).perform();
	
		Thread.sleep(2000);
		
		if(target.getText().equals("Dropped!")) {
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screen, new File("screenshots/JQueryui/DragAndDrop.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.close();
		
		
	}

}
