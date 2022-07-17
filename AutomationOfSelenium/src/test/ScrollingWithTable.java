package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingWithTable {

	public static void main(String args[]) throws InterruptedException

	{
		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		jsExecutor.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		Thread.sleep(3000);
		List<WebElement> valueOfTable = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for (int i = 0; i < valueOfTable.size(); i++) {

			int value = Integer.parseInt(valueOfTable.get(i).getText());
			sum = sum + value;

		}
		System.out.println(sum);
		int totalAmount = Integer
				.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		System.out.println(totalAmount);
		Assert.assertEquals(sum, totalAmount);
		driver.quit();

	}

}
