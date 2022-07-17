package wait;

import org.testng.AssertJUnit;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWait {

	public static void main(String args[]) throws InterruptedException {
		String expectedTextOfPromo = "Code applied ..!";

		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemsToAdd = { "Cucumber", "Brocolli" };
		addVegetablesToCart(driver, itemsToAdd);

		driver.findElement(By.cssSelector(".cart-icon")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")));

		driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));

		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoBtn")));

		driver.findElement(By.cssSelector(".promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));

		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

		AssertJUnit.assertEquals(driver.findElement(By.cssSelector(".promoInfo")).getText(), expectedTextOfPromo);
		driver.quit();

	}

	public static void addVegetablesToCart(WebDriver driver, String[] itemsToAdd) throws InterruptedException {

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
