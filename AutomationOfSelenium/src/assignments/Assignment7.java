package assignments;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);

		// Print number of rows

		int valueOfRow = 0;
		String secondRowValue = "";
		List<WebElement> tableRow = driver.findElements(By.cssSelector(".table-display tr"));
		for (int i = 0; i < driver.findElements(By.cssSelector(".table-display tr")).size(); i++) {
			valueOfRow = tableRow.size();
			secondRowValue = driver.findElements(By.cssSelector(".table-display tr")).get(2).getText();

		}

		System.out.println(valueOfRow);
		System.out.println(secondRowValue);

		// print number of column

		int valueOfColumn = 0;
		List<WebElement> tableColumn = driver.findElements(By.cssSelector(".table-display th"));
		for (int i = 0; i < driver.findElements(By.cssSelector(".table-display th")).size(); i++) {
			valueOfColumn = tableColumn.size();

		}

		System.out.println(valueOfColumn);

		driver.quit();

	}

}
