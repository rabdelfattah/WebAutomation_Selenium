package tests;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import core.baseClasses.TestBase;
import core.utilities.CSVReaderUtility;
import core.utilities.JSONReaderUtility;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;


public class UserRegistrationTest extends TestBase
{
	HomePage homePage ; 
	RegistrationPage registerPage ; 
	LoginPage loginPage ; 
	
	// User registration test case
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() throws CsvValidationException, IOException 
	{
		// Reading the registration data CSV file
		CSVReaderUtility csvReader = new CSVReaderUtility();
		csvReader.readCSVWithName("RegistrationData.csv");
		
		String[] csvCell ; 
		
		// Check for the next cell of the CSV file and stop when it's null "Finished"
		while((csvCell = csvReader.nextRecord()) != null) 
		{
			// CSV Data
			String firstname = csvCell[0]; 
			String lastName = csvCell[1]; 
			String email = csvCell[2]; 
			String password = csvCell[3]; 
			
			homePage = new HomePage(driver); 
			homePage.openRegistrationPage();
		
			registerPage = new RegistrationPage(driver); 
			//Force sleep so that all the elements are visible
			sleep(1000);
			
			registerPage.userRegistration(firstname, lastName, email, password);
			Assert.assertTrue(registerPage.getSuccessMessage().contains("Your registration completed"));			
			//Force sleep so that all the elements are visible
			sleep(1000);
			
			// Logout to test the next record in the CSV file if it's found
			homePage.userLogout();
			
			//Force sleep so that all the elements are visible
			sleep(1000);
		}
	}
	
	
	// User login test case
	@Test(priority=2, dependsOnMethods= {"UserCanRegisterSuccssfully"})
	public void RegisteredUserCanLogin() throws IOException, ParseException 
	{
		// Reading the login data JSON file
		JSONReaderUtility jsonReader = new JSONReaderUtility();
		JSONArray jsonArray = jsonReader.readJSONWithName("LoginData.json");		

		for(Object jsonObj : jsonArray) 
		{
			// Casting each object to Json object
			JSONObject user = (JSONObject) jsonObj ; 
			String email = (String) user.get("email");
			String password = (String) user.get("password");
			
			homePage.openLoginPage();
			//Force sleep so that all the elements are visible
			sleep(1000);
			
			loginPage = new LoginPage(driver); 
			//Force sleep so that all the elements are visible
			sleep(1000);
			
			loginPage.UserLogin(email, password);
			Assert.assertTrue(homePage.isLogOutVisible());
			
			// Logout to test the next record in the JSON file if it's found
			homePage.userLogout();
			
			//Force sleep so that all the elements are visible
			sleep(1000);
			
		}
	}
}


