package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.class11.JavaScriptExeuter;

// command + o --> to see all methods within the class

public class CommonMethods {

	public static WebDriver driver;

	/**
	 * Use this method in need of opening browser with target url
	 * @param browser chrome/firefox
	 * @param url
	 */
	
	
	public static void setUp(String browser,String url) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
			driver = new FirefoxDriver();
		}else {
			System.err.println("Browser is not supported");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	/**
	 * This method is used to accept alert
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void acceptAlert() {
		
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}catch(NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
	}
	/**
	 * This method is used to dismiss alert
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}catch(NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
	}
	
	/**
	 * This method gets text from alert
	 * @return text 
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static String getAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
			
		}catch(NoAlertPresentException e) {
			System.out.println("Alert is not present");
			return null;
		}
	}
	/**
	 * This method used to switch to frame
	 * @param nameOrId
	 */
	public static void switchFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
			
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
	/**
	 * This method used to switch to frame
	 * @param element
	 */
	
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
			
		}catch(NoSuchFrameException e){
			System.out.println("Frame is not present");
		}
	} 
	
	/**
	 * This method used to switch to frame
	 * @param index
	 */
	
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
			
		}catch(NoSuchFrameException e){
			System.out.println("Frame is not present");
		}
	} 
	
	/** 
	 * This method click on specific element on the page
	 * @param WebElement
	 */
	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor='Red'",element);
	}
	
	/** 
	 * This method scrolls down the page
	 * @param pixel
	 */
	public static void scrollDown(int pixel){
		JavaScriptExeuter js = (JavaScriptExeuter) driver;
		js.scrollDown(pixel);
	}	
	
	/** 
	 * This method scrolls Up the page
	 * @param pixel
	 */
	public static void scrollUp(int pixel){
		JavaScriptExeuter js = (JavaScriptExeuter) driver;
		js.scrollUp(pixel);
	}
	
	
// creating setUp method with return type WebDriver
	
//	public static WebDriver setUp(String browser) {
//
//		if (browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//			driver = new ChromeDriver();
//
//		} else if (browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
//			driver = new FirefoxDriver();
//		}
//
//		return driver;
//	}

}
