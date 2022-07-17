package assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement valueOfDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select selectValue = new Select(valueOfDropdown);
		selectValue.selectByIndex(0);
		driver.findElement(By.id("terms")).click();

		driver.findElement(By.id("signInBtn")).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='nav-link btn btn-primary']")));
		List<WebElement> itemsToAdd = driver.findElements(By.cssSelector("button[class='btn btn-info']"));
		for (int i = 0; i < itemsToAdd.size(); i++) {

			itemsToAdd.get(i).click();
		}

		driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
	}

}
