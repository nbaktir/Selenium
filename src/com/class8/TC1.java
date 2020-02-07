package com.class8;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

/*
 *  Table headers and rows verification
Open chrome browser
Go to "http://166.62.36.207/syntaxpractice/"
Click on "Table" link
Click on "ITable Data Search" link
Verify second table consist of 4 rows and 5 columns
Print name of all column headers 
Print data of all rows
Quit Browser
*/
public class TC1  extends CommonMethods{

	public static void main(String[] args) {
		setUp("chrome",Constants.url);
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();
		
		//find columns
		List<WebElement> columns = driver.findElements(By.xpath("//table[@class='table']/thead[2]/tr/th"));
		
		int actualCols = columns.size();
		System.out.println("Number of columns: "+actualCols);
		
		System.out.println("---------Printing columns -------");
		
		Iterator<WebElement> it = columns.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getText());
		}
		
		//verify number of columns
		if(actualCols==4) {
			System.out.println("Passed");
		}else{
			System.err.println("Failed");
		}
		
		//find rows 
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		
		int actualRows = rows.size();
		System.out.println("Number of rows: "+actualRows);
		
		System.out.println("-------Printing rows----------");
		
		Iterator<WebElement> rowIt = rows.iterator();
		while(rowIt.hasNext()) {
			System.out.println(rowIt.next().getText());
		}
		
		//verify number of rows
		if(actualRows==5) {
			System.out.println("Passed");
		}else {
			System.err.println("Failed");
		}
		
		// writing cell by cell all table data inside table body
		/* 1. //table[@class='table'] - table element 
		 * 2. /tbody - goes inside the table body
		 * 3. /tr  - from tbody going into rows
		 * 4. /td - going into table data = cell
		 * */
		
		
		List<WebElement> cells = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td"));
		
		for(WebElement c: cells) {
			System.out.println(c.getText());
		}
		System.out.println();
		
		System.out.println("------Printing data cell by using for loop-------");
		
		for (int i = 1; i <= rows.size(); i++) {   //controlling rows
			for(int y = 1; y<=columns.size(); y++) { //controlling columns
				driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+i+"]/td["+y+"]")).getText();
			}
		}
		
		driver.close();
	}

}

