package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import core.baseClasses.TestBase;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;


public class WishListTest extends TestBase 
{
	SearchPage searchPage;
	ProductDetailsPage productDetails;
	WishListPage wishListPage;
	String productName = "HP Spectre XT Pro UltraBook";

	@Test(priority=3)
	public void searchProduct() throws InterruptedException {
		searchPage = new SearchPage(driver);
		
		//Force sleep so that all the elements are visible
		sleep(1000);
		
		searchPage.productSearch(productName);
		productDetails = new ProductDetailsPage(driver);
		
		//Force sleep so that all the elements are visible
		sleep(1000);
		
		Assert.assertTrue(productDetails.getProductBreadcrumbText().contains(productName));
	}

	@Test(priority=4)
	public void addToWishList() throws InterruptedException {
		productDetails = new ProductDetailsPage(driver);
		productDetails.addProductToWishlist();
		Thread.sleep(1000);
		productDetails.openWishListPage();
		wishListPage = new WishListPage(driver);
		Thread.sleep(1000);
		Assert.assertTrue(wishListPage.wishListItemPrice(1).equalsIgnoreCase("$1,350.00"));
	}

}
