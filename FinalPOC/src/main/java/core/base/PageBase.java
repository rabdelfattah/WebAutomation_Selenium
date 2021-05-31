package core.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	// Declaring web-driver
	protected WebDriver driver ; 
	// Declaring Java-script executer
	public JavascriptExecutor jse ; 
	// Declaring Actions Object
	public Actions action ; 

	public PageBase(WebDriver driver) 
	{	
		// Initializing driver, Json executer and action
		PageFactory.initElements(driver, this);
		this.driver = driver;
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver);
	}
	
	protected static void clickButton(WebElement button) 
	{
		button.click();
	}
	
	protected static void setTextElementText(WebElement textElement , String value) 
	{
		textElement.sendKeys(value);
	}
	
	public void scrollToBottom() 
	
	{
		jse.executeScript("scrollBy(0,2500)"); 
	}
	
	public void clearText(WebElement element) 
	{
		element.clear();
	}
	
	public void sleep(long millis) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
