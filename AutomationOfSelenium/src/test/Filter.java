package test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Filter {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggieList = driver.findElements(By.xpath("//tr/td[1]"));

		// Check Rice is present with filter
		// Collect the elements with collector which has rice

		List<WebElement> filterList = veggieList.stream().filter(veggie -> veggie.getText().contains("Rice"))
				.collect(Collectors.toList());
		Assert.assertEquals(veggieList.size(), filterList.size());
		driver.quit();
	}

}
