package com.class1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LunchChromeBrowser {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("specify driver","location");
	//	WebDriver deriver = new FirefoxDriver();
		
	// System is a class, setProperty() is a static method 
		
	//  ChromeDriver, FireFoxDriver, IEDriver implement WebDriver interface
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
	
		driver.get("https://www.google.com/");
		
		
		Thread.sleep(1000);
			
		
		//browser navigate commands
		//navigate to url 
		driver.navigate().to("http://www.facebook.com");
		//navigate back
		driver.navigate().back();
		//navigate one step back
		driver.navigate().forward();
		// refresh current page
		driver.navigate().refresh();
		
		driver.close();	
		
//		System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
//		WebDriver driver1 = new FirefoxDriver();
//		
//		driver1.get("https://github.com/");
//		String title1 = driver1.getTitle();
//		System.out.println(title1);
//		driver1.close();
		
	}

}
