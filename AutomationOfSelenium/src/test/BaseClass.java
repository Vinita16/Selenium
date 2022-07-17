package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class BaseClass {

	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemsToAdd = { "Cucumber", "Brocolli" };
		addVegetablesToCart(driver, itemsToAdd);
		driver.findElement(By.cssSelector(".cart-icon")).click();

		driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.quit();
	}

	public static void addVegetablesToCart(WebDriver driver, String[] itemsToAdd) {

		List<WebElement> addToCart = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < addToCart.size(); i++) {
			String[] vegetableName = addToCart.get(i).getText().split("-");

			String vegetableNameOnly = vegetableName[0].trim();
			List addItems = Arrays.asList(itemsToAdd);
			int j = 0;
			if (addItems.contains(vegetableNameOnly)) {

				// If you do not use Elements, you cannot use get(i) and also if you directly
				// write click instead of geti, it will take the first element

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if (j == itemsToAdd.length)
					break;
			}

		}

	}

}
