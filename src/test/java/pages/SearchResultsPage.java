package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class SearchResultsPage extends BaseTest{
	public void clickOnRandomProduct() {
		WebElement productItems = driver.findElement(By.className("product-items"));
		List<WebElement> products = productItems.findElements(By.tagName("li"));
		Random random = new Random();
		int randomProductIndex = random.nextInt(products.size());
		products.get(randomProductIndex).click();
	}
}
