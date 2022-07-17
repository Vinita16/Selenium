package assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("a[href='/windows']")).click();
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		Set<String> windowID = driver.getWindowHandles();
		Iterator<String> it = windowID.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		String newWindowText = driver.findElement(By.cssSelector(".example")).getText();
		System.out.println(newWindowText);
		driver.switchTo().window(parentID);
		String parentWindowText = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		System.out.println(parentWindowText);
		driver.quit();

	}

}
