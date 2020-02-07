package com.class8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

/*Table headers and rows verification
1. Open chrome browser
2. Go to
"http://secure.smartbearsoftware.com/samples/testcomplete11
/WebOrders/login.aspx"
3. Login to the application / username: Tester /  Password:test
4. Verify customer "Susan McLaren" is present in the table
5. Click on customer details
6. Update customers last name
7. Verify updated customers name is displayed in table
8. Close browser*/
public class Task2 extends CommonMethods{

	public static void main(String[] args) {
		setUp("chrome","http://secure.smartbearsoftware.com/samples/testcomplete11\n" + 
				"/WebOrders/login.aspx");
		
		driver.findElement(By.xpath("//input[@class='txt'][1]")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@class='txt'][2]")).sendKeys("test");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Search for Susan McLaren
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));
		//driver.navigate().refresh();
	
		for(int i = 1; i< rows.size(); i++) {
	    	
			String rowText = rows.get(i-1).getText();
		   
			if(rowText.contains("Susan McLaren")) {
				driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr["+i+"]/td[13]")).click();
				System.out.println("Edit Susan McLaren's information");
				break;
			}
		}
		driver.close();
	}
}
