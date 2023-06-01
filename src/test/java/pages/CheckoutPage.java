package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BaseTest;
import utilities.SharedActions;

public class CheckoutPage extends BaseTest{
	SharedActions sharedActions = new SharedActions();

	private WebElement shippingAddressSection() {
		WebElement element = driver.findElement(By.id("checkout-step-shipping"));
		return element;
	}

	public void typeInEmailAddressInputField(String value) {
		WebElement email = shippingAddressSection().findElement(By.xpath(".//*[@name='username']"));
		email.clear();
		email.sendKeys(value);
	}

	public void typeInFirstNameInputField(String value) {
		WebElement firstName = shippingAddressSection().findElement(By.xpath(".//*[@name='firstname']"));
		firstName.clear();
		firstName.sendKeys(value);
	}

	public void typeInLastNameInputField(String value) {
		WebElement lastName = shippingAddressSection().findElement(By.xpath(".//*[@name='lastname']"));
		lastName.clear();
		lastName.sendKeys(value);
	}

	public void typeInAddressInputField(String value) {
		WebElement address = shippingAddressSection().findElement(By.xpath(".//*[@name='street[0]']"));
		address.clear();
		address.sendKeys(value);
	}

	public void typeInCityInputField(String value) {
		WebElement city = shippingAddressSection().findElement(By.xpath(".//*[@name='city']"));
		city.clear();
		city.sendKeys(value);
	}

	public void selectStateInputField(String value) {
		WebElement state = shippingAddressSection().findElement(By.xpath(".//*[@name='region_id']"));
		Select stateDropdown = new Select(state);
		stateDropdown.selectByVisibleText(value);
	}

	public void typeInZipCodeInputField(String value) {
		WebElement zip = shippingAddressSection().findElement(By.xpath(".//*[@name='postcode']"));
		zip.clear();
		zip.sendKeys(value);
	}

	public void selectCountryInputField(String value) {
		WebElement country = shippingAddressSection().findElement(By.xpath(".//*[@name='country_id']"));
		Select countryDropdown = new Select(country);
		countryDropdown.selectByVisibleText(value);
	}

	public void typeInPhoneNumberInputField(String value) {
		WebElement phoneNumber = shippingAddressSection().findElement(By.xpath(".//*[@name='telephone']"));
		phoneNumber.clear();
		phoneNumber.sendKeys(value);

	}

	public void selectFirstShippingMethod() {
		WebElement checkoutShippingMethods = driver.findElement(By.className("methods-shipping"));
		List<WebElement> methods = checkoutShippingMethods.findElements(By.cssSelector("input[type='radio']"));
		methods.get(0).click();
	}

	public void clickNextButton() {
		WebElement nextButton = driver.findElement(By.xpath("//button/span[contains(., 'Next')]"));
		nextButton.click();
	}

	public void clickPlaceOrderButton() {
		WebElement placeOrderButton = driver.findElement(By.xpath("//button/span[contains(., 'Place Order')]"));
		placeOrderButton.click();
		sharedActions.waitLoadingMaskToNotBeVisible();
	}
}
