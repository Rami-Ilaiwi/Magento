package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class SharedActions extends BaseTest {
	public void waitLoadingMaskToNotBeVisible() {
		WebElement loadingMask = driver.findElement(By.className("loading-mask"));
		wait.until(ExpectedConditions.invisibilityOf(loadingMask));
	}
}
