package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.base.PageBase;

public class LoginPage extends PageBase
{
	// Initializing driver
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Finding Login page elements 
	@FindBy(css="input.email")
	WebElement emailTxtBox ; 

	@FindBy(css="input.password")
	WebElement passwordTxtBox ; 

	@FindBy(css="button.button-1.login-button")
	WebElement loginBtn ; 
	
	// Defining UI functionalities
	public void UserLogin(String email , String password) 
	{
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		clickButton(loginBtn);
	}

}


