package com.kumaran;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdownselections {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

		//selecting current date in ui
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		
	}
	


}
