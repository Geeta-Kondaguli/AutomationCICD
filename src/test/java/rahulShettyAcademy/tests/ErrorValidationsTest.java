package rahulShettyAcademy.tests;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import rahulShettyAcademy.TestComponents.BaseTest;
import rahulShettyAcademy.pageobjects.CartPage;
import rahulShettyAcademy.pageobjects.ProductCatalogue;


public class ErrorValidationsTest extends BaseTest{

	@Test(groups= {"ErrorHandling"},retryAnalyzer=rahulShettyAcademy.TestComponents.Retry.class)
	public void loginErrorValidation() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		String productName="ZARA COAT 3";
		
	landingpage.loginApplication("geeta.kondagli@gmail.com", "Geeta887");
		
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
		
	
	}
	@Test
	public void productErrorValidation() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		String productName="ZARA COAT 3";
		
		ProductCatalogue productCatalogue= landingpage.loginApplication("geeta.kondaguli@gmail.com", "Geeta8897");
		
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartpage=productCatalogue.goToCartPage();
		
		Boolean match=cartpage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	
	}

}
