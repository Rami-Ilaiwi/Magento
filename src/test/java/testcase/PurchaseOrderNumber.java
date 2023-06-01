package testcase;

import java.time.Duration;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutPage;
import pages.Header;
import pages.ProductPage;
import pages.PurchasePage;
import pages.SearchResultsPage;
import utilities.SharedActions;

public class PurchaseOrderNumber extends BaseTest {
	static Header header = new Header();
	static SearchResultsPage searchResultsPage = new SearchResultsPage();
	static ProductPage productPage = new ProductPage();
	static SharedActions sharedActions = new SharedActions();
	static CheckoutPage checkoutPage = new CheckoutPage();
	static PurchasePage purchasePage = new PurchasePage();

	@Test
	public static void Task1() throws InterruptedException {
		String title = null;
		String addedProductMessage = null;
		String purchaseSuccessMessage = "Thank you for your purchase!";
		String orderNumber = null;

		header.enterSearchValueInSearchInputField("Shirt");

		searchResultsPage.clickOnRandomProduct();
		title = productPage.getProductName();

		productPage.selectRandomColor();
		productPage.selectRandomSize();
		productPage.clickAddToCartButton();
		productPage.waitUntilSuccessMessageAppear();

		addedProductMessage = String.format("You added %s to your shopping cart.", title);
		productPage.assertSuccessMessageEqualsValue(addedProductMessage);
		log.info("The product has been added successfully.");

		Thread.sleep(Duration.ofSeconds(5));
		header.clickCartButton();
		header.clickProceedToCheckoutButton();
		sharedActions.waitLoadingMaskToNotBeVisible();

		checkoutPage.typeInEmailAddressInputField(utils.getRandomEmail());
		checkoutPage.typeInFirstNameInputField("FirstName");
		checkoutPage.typeInLastNameInputField("LastName");
		checkoutPage.typeInAddressInputField("Address");
		checkoutPage.typeInCityInputField("City");
		checkoutPage.selectCountryInputField("United States");
		checkoutPage.selectStateInputField("California");
		checkoutPage.typeInZipCodeInputField("12345");
		checkoutPage.typeInPhoneNumberInputField("0512345678");
		checkoutPage.selectFirstShippingMethod();
		checkoutPage.clickNextButton();
		sharedActions.waitLoadingMaskToNotBeVisible();
		checkoutPage.clickPlaceOrderButton();

		purchasePage.assertSuccessMessageEqualsValue(purchaseSuccessMessage);
		orderNumber = purchasePage.getPurchaseOrderNumber();
		log.info("The order number is: " + orderNumber);
		System.out.println("Order Number: " + orderNumber);
	}
}
