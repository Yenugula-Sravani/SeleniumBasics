package com.kumaran;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxesSelections {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//checkboxs
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		//For clicking the checkboxes
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		//To check weather checkboxes are selected or not -return t or f.
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		//count of the checkboxex in the page
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		Assert.assertEquals(6, 6);
					

	}

}
