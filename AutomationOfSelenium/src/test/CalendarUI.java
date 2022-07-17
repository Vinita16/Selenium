package test;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarUI {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.booking.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		driver.findElement(By.cssSelector(".sb-date-field.b-datepicker")).click();
		System.out.println(driver.findElements(By.className("bui-calendar__date")).size());
		int datesCount = driver.findElements(By.className("bui-calendar__date")).size();
		while (!driver.findElement(By.cssSelector("[class='bui-calendar__month']")).getText().contains("September")) {

			driver.findElement(By.cssSelector("[class='bui-calendar__control bui-calendar__control--next']")).click();

		}

		List<WebElement> count = driver.findElements(By.className("bui-calendar__date"));
		for (int i = 0; i < datesCount; i++) {

			String text = driver.findElements(By.className("bui-calendar__date")).get(i).getText();
			if (text.equalsIgnoreCase("25")) {

				driver.findElements(By.className("bui-calendar__date")).get(i).click();
				break;
			}

		}

	}

}
