package com.kumaran;

import java.util.List;
import java.util.stream.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamsApi {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//tr/th[1]")).click();

		// capture all webelements into list
		List<WebElement> Elementslist = driver.findElements(By.xpath("//tr/td[1]"));

		// capture the text of all webelements into new original list
		List<String> originallist = Elementslist.stream().map(s -> s.getText()).collect(Collectors.toList());

		// sorting the original list
		List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());

		// comparing the 2 lists
		Assert.assertTrue(originallist.equals(sortedlist));
		
		//scan the name of the column and if it is rice bring the price of the rice.
		List<String> pricelist = Elementslist.stream().filter(s->s.getText().contains("Beans"))
				.map(s->getPriceVeggie(s)).collect(Collectors.toList());
		
		pricelist.forEach(a->System.out.println(a));

	}

	private static String getPriceVeggie(WebElement s) {
		String text = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return text;
	}

}
