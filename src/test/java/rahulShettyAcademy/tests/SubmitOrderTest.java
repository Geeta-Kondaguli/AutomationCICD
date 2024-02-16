package rahulShettyAcademy.tests;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulShettyAcademy.TestComponents.BaseTest;
import rahulShettyAcademy.pageobjects.CartPage;
import rahulShettyAcademy.pageobjects.CheckOutPage;
import rahulShettyAcademy.pageobjects.ConfirmationPage;
import rahulShettyAcademy.pageobjects.LandingPage;
import rahulShettyAcademy.pageobjects.OrderPage;
import rahulShettyAcademy.pageobjects.ProductCatalogue;


public class SubmitOrderTest extends BaseTest{
	String productName="ZARA COAT 3";

	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		
		
		ProductCatalogue productCatalogue= landingpage.loginApplication(input.get("email"),input.get("password"));
		
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartpage=productCatalogue.goToCartPage();
		
		Boolean match=cartpage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckOutPage checkoutPage= cartpage.goToCheckOut();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();
		String confirmMessage=confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	}
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		ProductCatalogue productCatalogue= landingpage.loginApplication("geeta.kondaguli@gmail.com", "Geeta8897");
		OrderPage orderpage=productCatalogue.goToOrderPage();
		Assert.assertTrue(orderpage.verifyOrderDisplay(productName));
	}
	

	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulShettyAcademy\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
	
	/*	HashMap<String,String> map=new HashMap<String,String>();
	map.put("email","geeta.kondaguli@gmail.com");
	map.put("password", "Geeta8897");
	map.put("product", "ZARA COAT 3");
	
	HashMap<String,String> map1=new HashMap<String,String>();
	map1.put("email","shetty@gmail.com");
	map1.put("password", "Iamking@000");
	map1.put("product", "ADIDAS ORIGINAL");*/
	
	//@DataProvider
	//public Object[][] getData()
	//{
		//return new Object[][]{{"geeta.kondaguli@gmail.com","Geeta8897","ZARA COAT 3"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
     //}
}
