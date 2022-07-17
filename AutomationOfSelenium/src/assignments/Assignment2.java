package assignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Assignment2 {

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Vinita");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("vinitarajak@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("yayyay");
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.id("exampleCheck1")).isSelected();
		WebElement genderDropdown = driver.findElement(By.id("exampleFormControlSelect1"));

		Select selectGender = new Select(genderDropdown);
		selectGender.selectByIndex(1);
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.xpath("//input[@type= 'submit']")).click();

		Thread.sleep(2000);
		// driver.findElement(By.name("bday")).click();
		driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		driver.quit();
	}

}
