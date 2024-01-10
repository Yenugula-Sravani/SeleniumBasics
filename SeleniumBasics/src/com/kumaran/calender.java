package com.kumaran;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class calender {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// clicking on the calender on the web page-aug 23.
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        
		//for selecting the month in the calender.
		while(!driver.findElement(By
				.xpath("//div[@class='ui-datepicker-header ui-widget-header "
						+ "ui-helper-clearfix ui-corner-left']//div[@class='ui-datepicker-title']"))
				.getText().contains("December 2023"))
		{
			
			
		}
		
		// selecting the date on the calender
		List<WebElement> datelist = driver.findElements(By.className("ui-state-default"));
		int count = driver.findElements(By.className("ui-state-default")).size();
		for (int i = 0; i < count; i++) {
			String dateoncalender = driver.findElements(By.className("ui-state-default")).get(i).getText();
			if (dateoncalender.equalsIgnoreCase("23")) {
				driver.findElements(By.className("ui-state-default")).get(i).click();
				break;
			}
		}

	}

}
