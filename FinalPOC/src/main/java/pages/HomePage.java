package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import core.base.PageBase;

public class HomePage extends PageBase
{ 
	// Select Object
	public Select select ; 
	// Initializing driver
	public HomePage(WebDriver driver) {
		super(driver);
 }
	
	// Finding Home page elements 
	@FindBy(css="a.ico-register")
	WebElement registerLink ; 

	@FindBy(linkText="Log in")
	WebElement loginLink; 
	
	@FindBy(css="a.ico-logout")
	WebElement logoutLink;
	
	@FindBy(linkText="Contact us")
	WebElement contactUsLink ; 
	
	@FindBy(id="customerCurrency")
	WebElement currencyDropDownList; 
	
	@FindBy(linkText="Computers")
	WebElement computerMenu; 
	
	@FindBy(linkText="Notebooks")
	WebElement notbooksMenu; 
	

	// Defining UI functionalities
	public void openRegistrationPage() 
	{
		clickButton(registerLink);
	}
	
	public void openLoginPage() 
	{
		clickButton(loginLink);
	}
	
	public void openContactUsPage() 
	
	{
		scrollToBottom();
		clickButton(contactUsLink);
	}
	
	public void changeCurrency() 
	{
		select = new Select(currencyDropDownList); 
		select.selectByVisibleText("Euro");
	}
	
	public void selectNotebooksMenu() 
	{
		action
		.moveToElement(computerMenu) // to hover on the menu
		.moveToElement(notbooksMenu)
		.click()
		.build()
		.perform();
	}
	
	public void userLogout() 
	{
		clickButton(logoutLink);
	}
	
	public boolean isLogOutVisible() {
		return logoutLink.isDisplayed();
	}
}