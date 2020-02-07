package com.class8;

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

/*TC 1: Leave List Search Validation

Open chrome browser
Go to "http://166.62.36.207/humanresources/symfony/web/index.php/auth"
Login into the application
Select Leave List
Select from December 1, 2019 until January 31, 2020
Check only Pending approval
Click on Search
Validate "No Records Found" is displayed
Quit the browser*/
public class HW3_LeaveListSearchValidation extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome",Constants.HRMS_URL);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Leave")));
		driver.findElement(By.linkText("Leave")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Leave List")));
		driver.findElement(By.linkText("Leave List")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='>']")));
		driver.findElement(By.id("calFromDate")).click();
		
		WebElement month = driver.findElement(By.className("ui-datepicker-month"));
		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText("Dec");
		
		WebElement year = driver.findElement(By.className("ui-datepicker-year"));
		Select selectYear = new Select(year);
		selectYear.selectByVisibleText("2019");
		
		List<WebElement> cells = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
		
		for(WebElement cell: cells) {
			
			if(cell.getText().contains("1")) {
				cell.click();
				break;
			}
		}
		
		String selectedDate1 = driver.findElement(By.id("calFromDate")).getAttribute("value");
		System.out.println(selectedDate1);
		
		driver.findElement(By.xpath("//input[@id='calToDate']/following-sibling::img")).click();
		
		month = driver.findElement(By.className("ui-datepicker-month"));
		selectMonth = new Select(month);
		selectMonth.selectByVisibleText("Jan");
		
		year = driver.findElement(By.className("ui-datepicker-year"));
		selectYear = new Select(year);
		selectYear.selectByVisibleText("2020");
		
		cells = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
		
		for(WebElement cell: cells) {
			if(cell.getText().contains("31")) {
				cell.click();
				break;
			}
		}
		
		String selectedDate2 = driver.findElement(By.id("calToDate")).getAttribute("value");
		System.out.println(selectedDate2);
		
		WebElement pendingCB = driver.findElement(By.xpath("//div[@id='leaveList_chkSearchFilter_checkboxgroup']/label[4]"));
		
		
		if(!pendingCB.isSelected()) {
			pendingCB.click();
			System.out.println("Pending Approval checkbox is selected");
		}
		
		driver.findElement(By.id("btnSearch")).click();
		
		WebElement record = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td"));
		
		if(record.getText().contains("No Records")) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screen = ts.getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(screen,new File("screenshots/HRMS/NoRecordFound.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
			System.out.println(record.getText()+" is displayed");
		}
		
		driver.close();
	}

}
