package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import core.base.PageBase;

public class SearchPage extends PageBase 
{
	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="small-searchterms")
	WebElement searchTextBox ; 

	@FindBy(css="button.button-1.search-box-button")
	WebElement searchBtn ; 

	@FindBy(id="ui-id-1")
	List<WebElement> productList ; 

	public void productSearch(String productName) 
	{
		setTextElementText(searchTextBox, productName);
		
		//Force sleep so that all the elements are visible
		sleep(1000);
		
		productList.get(0).click();
	}

}
