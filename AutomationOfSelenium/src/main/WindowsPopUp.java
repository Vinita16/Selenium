package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsPopUp {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");
		
				
				WebDriver driver = new ChromeDriver();
				driver.get("https://admin:admin@the-internet.herokuapp.com/");
				driver.findElement(By.linkText("Basic Auth")).click();
				
				
		

	}

}
