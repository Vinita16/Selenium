package test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lesson1InvokingTheBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/login");
		driver.findElement(By.id("userName")).sendKeys("yes");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("phew");
		driver.findElement(By.id("login")).click();
		// System.out.println(driver.getTitle());
		// System.out.println(driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String textString = driver.findElement(By.id("name")).getText();
		Assert.assertEquals(textString, "Invalid username or password!");
		driver.findElement(By.id("newUser"));
		driver.navigate().back();

		driver.quit();
	}

}
