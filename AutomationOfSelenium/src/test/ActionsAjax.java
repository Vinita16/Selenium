package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionsAjax {

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		String text = "Vinita";
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).contextClick().build()
				.perform();
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
				.sendKeys("Vinita").doubleClick().build().perform();

		// driver.quit();
	}

}
