package com.kumaran;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumPractice {

	public static void main(String[] args) throws InterruptedException {
		// give me the count of the links on the page
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());

		// Limiting the webdriver scope for particular webelement.
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		// subcoulms links count
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());

		// Clicking on the sublinks on the columns in the footer section and open in
		// seperate tag.
		for (int i = 0; i < columndriver.findElements(By.tagName("a")).size(); i++) {
			String clickontabs = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickontabs);
		}

		// Getting the titles of the child tabs with optimized while loop
		for (int i = 0; i < columndriver.findElements(By.tagName("a")).size(); i++) {
			String clickontabs = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickontabs);
			Thread.sleep(5000);
		}//opens all the links in new seperate tabs.
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
