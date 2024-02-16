package rahulShettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulShettyAcademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li[@class='totalRow']/button")
	WebElement checkOutEle;
	//driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
	@FindBy(css=".cartSection h3")
	List <WebElement> cartProducts;
	//List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
	
	public boolean verifyProductDisplay(String productName)
	{
		Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equals(productName));
		return match;
		
	}
	
	public CheckOutPage goToCheckOut()
	{
		checkOutEle.click();
		return new CheckOutPage(driver);
	}

}
