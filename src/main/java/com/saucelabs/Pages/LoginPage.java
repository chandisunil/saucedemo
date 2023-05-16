package com.saucelabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.Base.BaseClass;
import com.saucelabs.Drivers.Action;

/**
 * @author Sunil
 *  
 *  In this class we are going to add the Weblocators and Actions performed in the Login Page
 */

public class LoginPage extends BaseClass {
	
	Action action=new Action();
	
	@FindBy(xpath="//input[@id='user-name']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='login-button']")
	private WebElement loginbtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ProductsPage Login(String user_name, String Pass) throws InterruptedException {
		action.type(username, user_name);
		action.type(password, Pass);
		action.click(getDriver(), loginbtn);
		return new ProductsPage();
	}
	

}
