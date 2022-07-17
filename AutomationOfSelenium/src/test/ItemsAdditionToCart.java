package test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemsAdditionToCart {

	public void addVegetablesToCart(WebDriver driver) {

		String[] itemsToAdd = { "Cucumber", "Brocolli" };
		List<WebElement> addToCart = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < addToCart.size(); i++) {
			String[] vegetableName = addToCart.get(i).getText().split("-");

			String vegetableNameOnly = vegetableName[0].trim();
			List addItems = Arrays.asList(itemsToAdd);
			int j = 0;
			if (addItems.contains(vegetableNameOnly)) {

				// If you do not use Elements, you cannot use get(i) and also if you directly
				// write click instead of geti, it will take the first element

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if (j == itemsToAdd.length)
					break;
			}

		}

		driver.quit();
	}

}
