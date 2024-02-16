package rahulShettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulShettyAcademy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{
	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li[@class='totalRow']/button")
	WebElement checkOutEle;
	//driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
	@FindBy(css="tr td:nth-child(3)")
	List <WebElement> productNames;
	//List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
	
	public boolean verifyOrderDisplay(String productName)
	{
		Boolean match=productNames.stream().anyMatch(cartProduct->cartProduct.getText().equals(productName));
		return match;
		
	}
	
	

}
