package com.class8;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class WebTableDemo extends CommonMethods{

	public static void main(String[] args) {
		setUp("chrome",Constants.url);
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();
		
		//find how many rows of data table has
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		System.out.println("Number of rows in the table: "+rows.size());
	
		System.out.println("-----Printing row data------");
		
		for(WebElement row: rows) {
			System.out.println(row.getText());
		}
		System.out.println();
		
		//Number of columns
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
		System.out.println("Number of columns in table: "+cols.size());
	
		System.out.println("-----Printing columns headers-------");
		
		Iterator<WebElement> it = cols.iterator();
		 while(it.hasNext()) {
			 System.out.println(it.next().getText());
		 }
		
		driver.close();
	}

}
