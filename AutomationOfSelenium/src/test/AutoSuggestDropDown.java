package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.booking.com");
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();

		driver.findElement(
				By.cssSelector(".sb-date-field__icon.sb-date-field__icon-btn.bk-svg-wrapper.calendar-restructure-sb"))
				.click();
		driver.findElement(By.cssSelector(".bui-calendar__date.bui-calendar__date--today")).click();
		Thread.sleep(2000);

		driver.close();

	}

}
