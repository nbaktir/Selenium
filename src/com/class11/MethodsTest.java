package com.class11;

import com.utils.CommonMethods;
import com.utils.Constants;

public class MethodsTest  extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", Constants.herokuUrl);
		
		Thread.sleep(3000);
		scrollDown(1000);
		Thread.sleep(3000);
		scrollUp(500);
		Thread.sleep(3000);
		driver.quit();
	}

}
