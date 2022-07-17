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

public class WebTablesSorting {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".sort-icon.sort-descending")).click();
		List<WebElement> veggieList = driver.findElements(By.xpath("//tr/td[1]"));
		/*
		 * for(int i=0;i<veggieList.size();i++) { String name =
		 * veggieList.get(i).getText(); System.out.println(name);
		 * 
		 * 
		 * }
		 */
		List<String> originalList = veggieList.stream().map(s -> s.getText()).collect(Collectors.toList());

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));

		List<String> price = veggieList.stream().filter(s -> s.getText().contains("Beans")).map(s -> getPriceVeggie(s))
				.collect(Collectors.toList());
		price.forEach(a -> System.out.println(a));
		driver.quit();

	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		// System.out.println(s.findElement(By.xpath("following-sibling::td[1]")).getText());
		return priceValue;
	}

}
