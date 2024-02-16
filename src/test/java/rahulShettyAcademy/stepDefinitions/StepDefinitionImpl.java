package rahulShettyAcademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulShettyAcademy.TestComponents.BaseTest;
import rahulShettyAcademy.pageobjects.CartPage;
import rahulShettyAcademy.pageobjects.CheckOutPage;
import rahulShettyAcademy.pageobjects.ConfirmationPage;
import rahulShettyAcademy.pageobjects.LandingPage;
import rahulShettyAcademy.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {
	public LandingPage landingpage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	public CheckOutPage checkoutPage;
	public CartPage cartpage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingpage=launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username, String password)
	{
	 productCatalogue= landingpage.loginApplication(username,password);
	}
	
	@When("^I add product (.+) to cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException 
	{
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		
	}
	@And("^Checkout (.+) and submit the order$")
	public void checkout_product_and_submit_the_order(String productName)
	{
 cartpage=productCatalogue.goToCartPage();
		
		Boolean match=cartpage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		 checkoutPage= cartpage.goToCheckOut();
		checkoutPage.selectCountry("india");
		 confirmationPage=checkoutPage.submitOrder();
	}
	@Then("{string} is displayed on Confirmation page")
	public void message_displayed_confirmation_page(String string)
	{
		String confirmMessage=confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then("{string} message is displayed")
	public void message_displayed(String string)
	{
		Assert.assertEquals(string, landingpage.getErrorMessage());
		driver.close();
	}

	

}
