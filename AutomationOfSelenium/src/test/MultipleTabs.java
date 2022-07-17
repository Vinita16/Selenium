package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabs {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// opening tab does not mean that the driver is in the new tab. You have to give
		// control to the driver
		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> windowSet = driver.getWindowHandles();
		Iterator<String> it = windowSet.iterator();
		String parentHandle = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com");

	}

}
