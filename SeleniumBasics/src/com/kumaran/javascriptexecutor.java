package com.kumaran;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class javascriptexecutor {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		int sum=0;
		
		List<WebElement> tableselectors = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        for (int i = 0; i < tableselectors.size(); i++) {
			sum=sum+Integer.parseInt(tableselectors.get(i).getText());
			
		}
        System.out.println(sum);
	}

}
