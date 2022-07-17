package test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());

		WebElement firstHalf = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(firstHalf.findElements(By.tagName("a")).size());

		for (int i = 1; i < firstHalf.findElements(By.tagName("a")).size(); i++) {

			String clickLink = Keys.chord(Keys.COMMAND, Keys.ENTER);
			firstHalf.findElements(By.tagName("a")).get(i).sendKeys(clickLink);
			Thread.sleep(4000);
		}

		Set<String> childLink = driver.getWindowHandles();
		Iterator<String> it = childLink.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

		driver.quit();

	}

}
