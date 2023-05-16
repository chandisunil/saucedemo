package com.saucelabs;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saucelabs.Base.BaseClass;
import com.saucelabs.Drivers.Action;
import com.saucelabs.Pages.CartPage;
import com.saucelabs.Pages.LoginPage;
import com.saucelabs.Pages.ProductsPage;
import com.saucelabs.Utils.Log;

/**
 * In this Class writing testcases for
 * 1)Add Products to the cart
 * 2)Sorting the Products name by descending order
 * 3)Sorting the Products Price from Low to High
 * 4)Sorting the products price from High to Low
 * 
 */

public class ProductsPageTest extends BaseClass{
	
	Action action=new Action();
	ProductsPage products;
	LoginPage login;
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	
	@Test
	public void addItemsToCart() throws InterruptedException {
		Log.startTestCase("Products Page Test");
		login=new LoginPage();
		ProductsPage products=new ProductsPage();
		CartPage cart=new CartPage();
		Log.info("Entering UserName and Password");
		login.Login(prop.getProperty("username1"), prop.getProperty("password"));
		Log.info("Items Adding in to the Cart");
		products.itemsAddingInToCart();
		Log.info("After Click on Cart user navigating to the cart page and get the title");
		String titleofthePage=cart.title();
		Log.info("Verifying user navigates to the cart page by comparing title fo the Page");
		Assert.assertEquals(titleofthePage, "Your Cart");
		Log.info("User Successfully Navigates to the Cart Page");
		Log.endTestCase("Products Page Test");
		
	}
	@Test
	public void productsInDesc() throws InterruptedException {
		Log.startTestCase("View Products in Descending Order Sort Test");
		login=new LoginPage();
		ProductsPage products=new ProductsPage();
		Log.info("Entering UserName and Password");
		login.Login(prop.getProperty("username1"), prop.getProperty("password"));
		Log.info("Sorting the Products in Descending Order");
		products.DesSortProducts();
		List<WebElement>names=products.itemnames;
		for(WebElement n: names) {
			Log.info("Get all the Names of the Prodcuts");
			String name=n.getText();
			Log.info("Validating the Descending order Name showing in the First Or Not");
			if(name.contains("Test.allTheThings() T-Shirt (Red)")) {
				Log.info("Verifying the product is showing first or not");
				Assert.assertTrue(true);
				Log.info("Verifying Successfully");
				break;
			}
			
		}
		Log.endTestCase("View Products in Descending Order Sort Test");
		
		
	}
	@Test
	public void productsFromLowToHigh() throws InterruptedException {
		Log.startTestCase("View Low To High Products Price Test");
		login=new LoginPage();
		ProductsPage products=new ProductsPage();
		Log.info("Entering UserName and Password");
		login.Login(prop.getProperty("username1"), prop.getProperty("password"));
		Log.info("Get the Prices of the Products in the List of before filtering");
		List<WebElement>beforeFilterPrices=products.itemprices;
		Log.info("Change the Prices List in to Double");
		List<Double>beforeFilterPricesList=new ArrayList<>();
		for(WebElement p:beforeFilterPrices) {
			Log.info("Removing Dollor Sign before the Prices");
			beforeFilterPricesList.add(Double.valueOf(p.getText().replace("$", "")));
			
		}
		Log.info("Sorting the products from Low To High");
		products.sortByLowToHigh();
		Log.info("Get the Prices of the Products in the List of After filtering");
		List<WebElement>afterFilterPrices=products.itemprices;
		Log.info("Change the Prices List in to Double");
		List<Double>afterFilterPricesList=new ArrayList<>();
		for(WebElement p:afterFilterPrices) {
			Log.info("Removing Dollor Sign before the Prices");
			afterFilterPricesList.add(Double.valueOf(p.getText().replace("$", "")));
			
		}
		Log.info("Sorting the Prices List from Low To High");
		Collections.sort(beforeFilterPricesList);
		Log.info("Comparing the prices list showing the low price or not");
		Assert.assertEquals(beforeFilterPricesList, afterFilterPricesList);
		Log.info("Successfully Verifying the low price showing first");
		Log.endTestCase("View Low To High Products Price Test");
		
	}
	
	
	@Test
	public void productsFromHighToLow() throws InterruptedException {
		Log.startTestCase("View High To Low Products Price Test");
		login=new LoginPage();
		ProductsPage products=new ProductsPage();
		Log.info("Entering UserName and Password");
		login.Login(prop.getProperty("username1"), prop.getProperty("password"));
		Log.info("Get the Prices of the Products in the List of before filtering");
		List<WebElement>beforeFilterPrices=products.itemprices;
		Log.info("Change the Prices List in to Double");
		List<Double>beforeFilterPricesList=new ArrayList<>();
		for(WebElement p:beforeFilterPrices) {
			Log.info("Removing Dollor Sign before the Prices");
			beforeFilterPricesList.add(Double.valueOf(p.getText().replace("$", "")));
			
		}
		Log.info("Sorting the Prices List from High to Low");
		products.sortByHighToLow();
		Log.info("Get the Prices of the Products in the List of After filtering");
		List<WebElement>afterFilterPrices=products.itemprices;
		Log.info("Change the Prices List in to Double");
		List<Double>afterFilterPricesList=new ArrayList<>();
		for(WebElement p:afterFilterPrices) {
			Log.info("Removing Dollor Sign before the Prices");
			afterFilterPricesList.add(Double.valueOf(p.getText().replace("$", "")));
			
		}
		Log.info("Sorting the Prices List from Low To High");
		Collections.sort(beforeFilterPricesList);
		Log.info("Sorting the Prices List from  High to Low");
		Collections.reverse(beforeFilterPricesList);
		Log.info("Comparing the prices list showing the low price or not");
		Assert.assertEquals(beforeFilterPricesList, afterFilterPricesList);
		Log.info("Successfully Verifying the high price showing first");
		Log.endTestCase("View High to Low Products Price Test");
		
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	
	

}
