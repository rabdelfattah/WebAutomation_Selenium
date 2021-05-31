package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import core.base.PageBase;

public class WishListPage extends PageBase
{
	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "addtocart")
    WebElement addToCartCheckBox;
    
    @FindBy(name = "addtocartbutton")
    WebElement addToCartButton;
  
   
    public void addToWishList() {
    	clickButton(addToCartCheckBox);
    	clickButton(addToCartButton);
    }
    
    public String wishListItemPrice(int row) {
    	String xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[5]";
    	if(row > 1) {
    		xpath = String.format("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr[%d]/td[5]", row);
    	}
    	return this.driver.findElement(By.xpath(xpath)).getText();
    }
}

