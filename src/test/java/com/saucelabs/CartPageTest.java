package com.saucelabs;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saucelabs.Base.BaseClass;
import com.saucelabs.Drivers.Action;
import com.saucelabs.Pages.CartPage;
import com.saucelabs.Pages.CheckoutPage;
import com.saucelabs.Pages.LoginPage;
import com.saucelabs.Pages.ProductsPage;
import com.saucelabs.Utils.Log;

/**
 * In this Class writing testcases for
 * 1)Login in to the Application
 * 2)Add Products to the cart
 * 3)Navigate to the Cart Page
 * 4)Add more items by continue shopping button
 * 5)Remove items by Remove Button
 * 
 */

public class CartPageTest extends BaseClass{
	Action action=new Action();
	ProductsPage products;
	LoginPage login;
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	
	@Test
	public void cartPage() throws InterruptedException {
		Log.startTestCase("Cart Page Test");
		login=new LoginPage();
		ProductsPage products=new ProductsPage();
		CartPage cart=new CartPage();
		CheckoutPage check=new CheckoutPage();
		Log.info("Entering UserName and Password");
		login.Login(prop.getProperty("username1"), prop.getProperty("password"));
		Log.info("Items Adding in to the Cart");
		products.itemsAddingInToCart();
		Log.info("After Click on Cart user navigating to the cart page and get the title");
		String titleofthePage=cart.title();
		Log.info("Verifying user navigates to the cart page by comparing title fo the Page");
		Assert.assertEquals(titleofthePage, "Your Cart");
		Log.info("User Successfully Navigates to the Cart Page");
		Log.info("Count the Number of Items in the Cart");
		String count=cart.itemsInTheCart();
		Log.info("Verifying Count is same or not");
		Assert.assertEquals(count, "2");
		Log.info("Verifying Successfully");
		Log.info("Click on Cart button");
		cart.checkout();
		String checkouttitle=check.title();
		Log.info("Verifying user navigates to the checkout Page by comparing title fo the Page");
		Assert.assertEquals(checkouttitle, "Checkout: Your Information");
		Log.info("User Successfully Navigates to the Page");
		Log.endTestCase("Cart Page Test");
		
	}
	
	@Test
	public void continueShopping() throws InterruptedException {
		Log.startTestCase("Continue Shopping Test");
		login=new LoginPage();
		ProductsPage products=new ProductsPage();
		CartPage cart=new CartPage();
		CheckoutPage check=new CheckoutPage();
		Log.info("Entering UserName and Password");
		login.Login(prop.getProperty("username1"), prop.getProperty("password"));
		Log.info("Items Adding in to the Cart");
		products.itemsAddingInToCart();
		Log.info("After Click on Cart user navigating to the cart page and get the title");
		String titleofthePage=cart.title();
		Log.info("Verifying user navigates to the cart page by comparing title fo the Page");
		Assert.assertEquals(titleofthePage, "Your Cart");
		Log.info("User Successfully Navigates to the Cart Page");
		Log.info("Count the Number of Items in the Cart");
		String count=cart.itemsInTheCart();
		Log.info("Verifying Count is same or not");
		Assert.assertEquals(count, "2");
		Log.info("Verifying Successfully");
		Log.info("Click on Continue Shopping button");
		cart.continueShopping();
		Log.info("Adding one more item in to the cart");
		products.addonemoreitem();
		String countagain=cart.itemsInTheCart();
		Log.info("Verifying Count is same or not");
		Assert.assertEquals(countagain, "3");
		Log.info("Verifying Successfully");
		Log.endTestCase("Continue Shopping Test");
		
	}
	
	@Test
	public void removeItem() throws InterruptedException {
		Log.startTestCase("Remove Item Test");
		login=new LoginPage();
		ProductsPage products=new ProductsPage();
		CartPage cart=new CartPage();
		CheckoutPage check=new CheckoutPage();
		Log.info("Entering UserName and Password");
		login.Login(prop.getProperty("username1"), prop.getProperty("password"));
		Log.info("Items Adding in to the Cart");
		products.itemsAddingInToCart();
		Log.info("After Click on Cart user navigating to the cart page and get the title");
		String titleofthePage=cart.title();
		Log.info("Verifying user navigates to the cart page by comparing title fo the Page");
		Assert.assertEquals(titleofthePage, "Your Cart");
		Log.info("User Successfully Navigates to the Cart Page");
		String beforeRemoveitemcount=cart.itemsInTheCart();
		Log.info("Verifying the Count in the cart before removing the Item");
		Assert.assertEquals(beforeRemoveitemcount, "2");
		Log.info("Verified Successfully");
		Log.info("Remove one item");
		cart.removeItem();
		String afterRemoveitemcount=cart.itemsInTheCart();
		Log.info("Verifying the Count in the cart After removing the Item");
		Assert.assertEquals(afterRemoveitemcount, "1");
		Log.info("Verified Successfully");
		Log.endTestCase("Remove Item Test");
		
		
	}
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
