package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import core.base.PageBase;

public class ProductDetailsPage extends PageBase
{
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="strong.current-item")
	WebElement productNamebreadCrumb; 

	@FindBy(id="add-to-wishlist-button-7")
	WebElement addToWishlistBtn ; 
	
	@FindBy(linkText="Wishlist")
	WebElement wishListLink; 

	public void addProductToWishlist() 
	{
		clickButton(addToWishlistBtn);
	}
	
	public String getProductBreadcrumbText()
	{
		return productNamebreadCrumb.getText();
	}

	public void openWishListPage() 
	{
		clickButton(wishListLink);
	}

}
