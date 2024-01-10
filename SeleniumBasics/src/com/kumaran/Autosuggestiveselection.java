package com.kumaran;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestiveselection {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement element:options) {
			if(element.getText().equalsIgnoreCase("india")) {
				element.click();
				break;
			}
		}

	}

}
