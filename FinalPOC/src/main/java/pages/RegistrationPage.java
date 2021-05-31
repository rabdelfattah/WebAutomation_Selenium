package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.base.PageBase;

public class RegistrationPage extends PageBase 
{
	// Initializing driver
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	// Finding Login page elements 
	@FindBy(id="gender-male")
	WebElement genderMaleRadioBtn ; 
	
	@FindBy(id="FirstName")
	WebElement firstNameTxtBox; 
	
	@FindBy(id="LastName")
	WebElement lastNameTxtBox ; 
	
	@FindBy(id="Email")
	WebElement emailTxtBox ; 
	
	@FindBy(id="Password")
	WebElement passwordTxtBox ; 
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTxtBox ; 
	
	@FindBy(id="register-button")
	WebElement registerBtn ; 
	
	@FindBy(css="div.result")
	public WebElement successMessage ; 
	
	@FindBy(css="a.ico-logout")
	public WebElement logoutLink; 
	
	@FindBy(linkText="My account")
	WebElement myAccountLink; 
	
	// Defining UI functionalities
	public void userRegistration(String firstName , String lastName , String email , String password) 
	{
		clickButton(genderMaleRadioBtn);
		setTextElementText(firstNameTxtBox, firstName);
		setTextElementText(lastNameTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		clickButton(registerBtn);
	}
	
	public String getSuccessMessage()
	{
		return successMessage.getText();
	}
	
	public void userLogout() 
	{
		clickButton(logoutLink);
	}
	
	public void openMyAccountPage() 
	{
		clickButton(myAccountLink);
	}
	
}
