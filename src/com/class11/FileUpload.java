package com.class11;

import org.openqa.selenium.By;

import com.utils.CommonMethods;
import com.utils.Constants;

public class FileUpload extends CommonMethods{

	public static void main(String[] args) {
		setUp("chrome","https://the-internet.herokuapp.com/upload");
		//to upload file we can use sendKeys method and provide
		//full path to the file
		// for mac use / 
		//for windows \\ or //
		driver.findElement(By.id("file-upload")).sendKeys("/Users/NY/Desktop/download.png");
		driver.findElement(By.id("file-submit")).click();
		String message = driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
	
		if (message.equals("File Uploaded!")) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
	}

}
