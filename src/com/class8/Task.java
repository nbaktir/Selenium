package com.class8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

/*Table headers and rows verification
1. Open chrome browser
2. Go to
"http://secure.smartbearsoftware.com/samples/testcomplete11
/WebOrders/login.aspx"
3. Login to the application / username: Tester /  Password:test
4. Verify customer "Bob Feather" is present in the table
5. Click Chexbox near Bob Feather
8. Close browser*/
public class Task extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome","http://secure.smartbearsoftware.com/samples/testcomplete11\n" + 
				"/WebOrders/login.aspx");
		
		driver.findElement(By.xpath("//input[@class='txt'][1]")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@class='txt'][2]")).sendKeys("test");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Search for Bob Feather
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));
		
		for(int i =1; i<rows.size();i++){
			String rowText = rows.get(i).getText();
			System.out.println(rowText);
			if(rowText.equals("Bob Feather")) {
				driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr["+(i+1)+"]/td[1]")).click();
			}
		}
		
		driver.close();
	}

}
