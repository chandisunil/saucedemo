package com.saucelabs;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saucelabs.Base.BaseClass;
import com.saucelabs.Drivers.Action;
import com.saucelabs.Pages.CartPage;
import com.saucelabs.Pages.CheckoutCompleteOrder;
import com.saucelabs.Pages.CheckoutOverviewPage;
import com.saucelabs.Pages.CheckoutPage;
import com.saucelabs.Pages.LoginPage;
import com.saucelabs.Pages.ProductsPage;
import com.saucelabs.Utils.Log;

/**
 * In this Class writing testcases for
 * 1)Login in to the Application
 * 2)Add Products to the cart
 * 3)Add User Details in the Checkout Page
 * 4)Complete the Order
 * 5)Logout from the Application
 * 
 */
public class EndtoEndTest extends BaseClass{
	Action action=new Action();
	ProductsPage products;
	LoginPage login;
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	@Test
	public void completeEndToEndTest() throws InterruptedException {
		Log.startTestCase("End to End Test");
		login=new LoginPage();
		ProductsPage products=new ProductsPage();
		CartPage cart=new CartPage();
		CheckoutPage check=new CheckoutPage();
		CheckoutOverviewPage co=new CheckoutOverviewPage();
		CheckoutCompleteOrder complete=new CheckoutCompleteOrder();
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
		Log.info("Entering FirstName, Last Name, Zip Code");
		check.details(prop.getProperty("firstName"), prop.getProperty("lastName"),prop.getProperty("ZipCode"));
		Log.info("Click on Continue Button");
		check.continuebtn();
		String checkoutTitle=co.title();
		Log.info("Verifying user navigates to the checkoutoverview page by comparing title fo the Page");
		Assert.assertEquals(checkoutTitle, "Checkout: Overview");
		Log.info("Verifying Successfully");
		Log.info("Click on Finish Button");
		co.finish();
		String gettitle=complete.title();
		Log.info("Verifying user navigates to the checkout Complete Order page by comparing title fo the Page");
		Assert.assertEquals(gettitle, "Checkout: Complete!");
		Log.info("Verifying Successfully");
		String ordermsg=complete.orderconfirmation();
		Log.info("Verifying order message in the complete Page");
		Assert.assertEquals(ordermsg, "Thank you for your order!");
		Log.info("Verifying Successfully");
		Log.info("Click on Back To Home Button");
		complete.backToHome();
		String productstitle=products.title();
		Log.info("Verifying user navigates to the products Order page by comparing title fo the Page");
		Assert.assertEquals(productstitle, "Products");
		Log.info("Verifying Successfully");
		Log.info("Click on Menu");
		products.menu();
		Log.info("Click on Log out Button");
		products.logOut();
		String currentURL=action.getCurrentURL(getDriver());
		Log.info("Verifying user is navigates to the Login page and get the URL");
		Assert.assertEquals(currentURL, "https://www.saucedemo.com/");
		Log.info("Verifying Successfully");
		Log.endTestCase("End to End Test");
		
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

}
