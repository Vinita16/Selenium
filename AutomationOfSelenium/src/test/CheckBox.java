package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// This is how we make assertions if checkbox is selected or not

		Assert.assertFalse(driver.findElement(By.cssSelector("input[value='option1']")).isSelected());

		driver.findElement(By.cssSelector("input[value='option1']")).click();

		// This is to determine if the checkbox is selected or not

		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='option1']")).isSelected());

		// Let's verify how many check boxes are present with help of size
		driver.findElement(By.cssSelector("input[value='option1']")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[value='option1']")).isSelected());

		Assert.assertEquals(driver.findElements(By.cssSelector("[type='checkbox']")).size(), 3);

		Thread.sleep(2000);
		driver.close();

	}

}
