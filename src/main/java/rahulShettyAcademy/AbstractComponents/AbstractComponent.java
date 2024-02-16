package rahulShettyAcademy.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulShettyAcademy.pageobjects.CartPage;
import rahulShettyAcademy.pageobjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement  cartHeader;
	
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement  orderHeader;

	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public OrderPage goToOrderPage()
	{
		orderHeader.click();
		OrderPage orderpage=new OrderPage(driver);
		return orderpage;
	}
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(2000);
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}

}
