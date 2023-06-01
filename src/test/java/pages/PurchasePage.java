package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import base.BaseTest;

public class PurchasePage extends BaseTest{
	public String getPurchasePageTitle() {
		String placeOrderMessage = driver.findElement(By.className("page-title")).getText();
		return placeOrderMessage;
	}

	public void assertSuccessMessageEqualsValue(String value) {
		Assert.assertEquals(value, getPurchasePageTitle());
	}

	public String getPurchaseOrderNumber() {
		String orderNumberValue = driver.findElement(By.cssSelector(".checkout-success span")).getText();
		return orderNumberValue;
	}
}
