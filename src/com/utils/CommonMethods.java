package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
		}
		driver.get(url);

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
