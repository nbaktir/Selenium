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
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.CommonMethods;

/* TC 1: Table headers and rows verification
Open chrome browser
Go to "https://www.aa.com/homePage.do"
Enter From and To
Select departure as May 14 of 2020
Select arrival as November 8 of 2020
Verify "Choose flights" text is displayed
Take s screenshot of the results
Close browser */

public class HW extends CommonMethods{
   
	public static void main(String[] args) throws InterruptedException {
        
       
        setUp("chrome", "https://www.aa.com/homePage.do");
        WebElement from=driver.findElement(By.id("reservationFlightSearchForm.originAirport"));
        from.clear();
        from.sendKeys("New York");
        
        driver.findElement(By.id("reservationFlightSearchForm.destinationAirport")).sendKeys("Los Angles");     
        
        String[] monthAndYear= {"May 2020", "November 2020" };
        String[] days= {"14", "8"};
        String[] calId= {"aa-leavingOn","aa-returningFrom"};
        
        for(int i=0; i<2; i++) {
            WebDriverWait wait1=new WebDriverWait(driver, 20);
            wait1.until(ExpectedConditions.elementToBeClickable(By.id(calId[i])));
          
            driver.findElement(By.id(calId[i])).click();
            
            boolean flag=false;
          
            while(!flag) {
                WebElement dispCal=driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//div[@class='ui-datepicker-title']"));
                if(dispCal.getText().contains(monthAndYear[i])) {                       
                    List<WebElement> dayCell=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
                    for(WebElement day:dayCell) {
                        if(day.getText().equals(days[i])) {
                            day.click();
                            Thread.sleep(3000);
                            break;
                        }
                    }
                    flag=true;
                    break;
                }else {
//                  WebDriverWait wait=new WebDriverWait(driver, 20);
//                  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")));
                    driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
                }                               
            }           
        }
        
        // take screenshot
        Thread.sleep(2000);
        TakesScreenshot ts=(TakesScreenshot)driver;
        File screen=ts.getScreenshotAs(OutputType.FILE);
        
        try {
            FileUtils.copyFile(screen, new File("C:\\Users\\asd\\eclipse-workspace\\Selenium\\screenshots\\AmericanAirlines\\flightSelect.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Thread.sleep(3000);
        driver.close();
    }
}


