package test;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HTPPSSL {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/vinitarajak/Downloads/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();

		// To bypass insecure certificate
		chromeOptions.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(chromeOptions);

		// To use extension
		// chromeOptions.addExtensions("Path to the extension");

		// To use proxy, first user proxy class and it's object to set string of value
		// and then pass it as an argument to chromeoptions

		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:8080");
		chromeOptions.setCapability("proxy", proxy);

		driver.get("https://expired.badssl.com/");

		// Chrome options help to set the behaviour
		System.out.println(driver.getTitle());

	}

}
