package com.Review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

/*As an analyst, I want to be able to click on an element
 *  inside any frame displayed on the homepage 
 *  that will take me to the
respective page. Verify the landing page.*/
public class AmazonFrame extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUp("chrome",Constants.amazonUrl);
		WebElement frame =driver.findElement(By.xpath("//div[@id='ape_Gateway_right-2_desktop_placement']/iframe"));
		switchToFrame(frame);
		
		//get text from frame
		
		//switch to default content
		
		
		driver.close();
	}

}
