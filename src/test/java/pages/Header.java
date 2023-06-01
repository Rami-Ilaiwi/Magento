package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class Header extends BaseTest {
	public void enterSearchValueInSearchInputField(String value) {
		WebElement search = driver.findElement(By.id("search"));
		search.clear();
		search.sendKeys(value);
		search.submit();
	}

	public void clickCartButton() {
		driver.findElement(By.cssSelector("a[href*='/checkout/cart/'")).click();
		waitUntilDropdownDialogForCartAppear();
	}

	public void waitUntilLoaderIconToNotBeVisible() {
		WebElement loader = driver.findElement(By.className("loader"));
		wait.until(ExpectedConditions.invisibilityOf(loader));
	}

	public void waitUntilDropdownDialogForCartAppear() {
		WebElement cartDialog = driver.findElement(By.xpath("//*[@data-role='dropdownDialog']"));
		wait.until(ExpectedConditions.visibilityOf(cartDialog));
	}

	public void clickProceedToCheckoutButton() {
		driver.findElement(By.className("checkout")).click();
	}

}
