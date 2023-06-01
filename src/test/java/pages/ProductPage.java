package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;
import org.junit.Assert;

public class ProductPage extends BaseTest{
	public String getProductName() {
		String title = driver.findElement(By.className("page-title")).getText();
		return title;
	}

	public void selectRandomColor() {
		Random random = new Random();
		WebElement color = driver.findElement(By.className("color"));
		if (color.isDisplayed()) {
			// Select a random color
			List<WebElement> colorOptions = color.findElements(By.xpath(".//*[@role='option']"));
			int randomColorIndex = random.nextInt(colorOptions.size());
			colorOptions.get(randomColorIndex).click();
		}
	}

	public void selectRandomSize() {
		Random random = new Random();
		WebElement size = driver.findElement(By.className("size"));
		if (size.isDisplayed()) {
			// Select a random size
			List<WebElement> sizeOptions = size.findElements(By.xpath(".//*[@role='option']"));
			int randomSizeIndex = random.nextInt(sizeOptions.size());
			sizeOptions.get(randomSizeIndex).click();
		}
	}

	public void clickAddToCartButton() {
		driver.findElement(By.id("product-addtocart-button")).click();
	}

	public void waitUntilSuccessMessageAppear() {
		WebElement addedProductMessage = driver.findElement(By.className("message-success"));
		wait.until(ExpectedConditions.visibilityOf(addedProductMessage));
	}

	public String getSuccessMessage() {
		WebElement addedProductMessage = driver.findElement(By.className("message-success"));
		return addedProductMessage.getText();
	}

	public void assertSuccessMessageEqualsValue(String value) {
		Assert.assertEquals(value, getSuccessMessage());
	}

}
