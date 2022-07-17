package assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String textOption = driver.findElement(By.xpath("//label[@for='bmw']")).getText();
		System.out.println(textOption);

		driver.findElement(By.id("checkBoxOption1")).click();

		WebElement selectValue = driver.findElement(By.id("dropdown-class-example"));
		Select selectDropdown = new Select(selectValue);
		selectDropdown.selectByVisibleText(textOption);
		driver.findElement(By.id("name")).sendKeys(textOption);
		driver.findElement(By.id("confirmbtn")).click();
		String[] popUpText = driver.switchTo().alert().getText().split(",");
		String firstHalf = popUpText[0];
		String[] secondHalf = firstHalf.split(" ");
		String option = secondHalf[1];
		if (option.contains(textOption)) {

			System.out.println("Correct value is displayed");

		} else
			System.out.println("Something went wrong");

		driver.quit();

	}

}
