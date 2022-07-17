package test;

import org.apache.logging.log4j.*;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Log4J {

	// Entire path of Class

	private static Logger log = LogManager.getLogger(Log4J.class.getName());

	public static void main(String[] args) throws InterruptedException {

		// System.setProperty("org.apache.logging.log4j.simplelog.StatusLogger.level",
		// "TRACE");
		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		log.debug("This is debug");

		log.info("This is info");
		log.error("This is error");
		log.fatal("This is fatal");

		driver.quit();

	}

}
