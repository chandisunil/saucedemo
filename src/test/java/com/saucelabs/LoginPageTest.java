
package com.saucelabs;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saucelabs.Base.*;
import com.saucelabs.DataProvider.*;
import com.saucelabs.Drivers.*;
import com.saucelabs.Pages.*;
import com.saucelabs.Utils.*;


/**
 * In This Class writing testcases for login function getting testdata from Excel file for getting multiple login credentials
 * 
 */
public class LoginPageTest extends BaseClass {
	Action action=new Action();
	LoginPage login;
	 ProductsPage products;
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginPage(String uname,String pwd) throws InterruptedException {
		Log.startTestCase("Login Page");
		LoginPage login=new LoginPage();
		//User login with username and password
		Log.info("Entering UserName and Password");
		products=login.Login(uname,pwd);
		//Navigates to the Products page and verify text present in the products page
		Log.info("User Navigating to the Products Page");
		String pagetitle=products.title();
		//comparing the two tiles
		Log.info("Verifying wheater user is successfully login");
		Assert.assertEquals(pagetitle, "Products");
		Log.info("User Login Successfully");
		Log.endTestCase("LoginPage");
			
		}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	

}
