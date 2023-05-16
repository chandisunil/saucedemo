package com.saucelabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.Base.BaseClass;
import com.saucelabs.Drivers.Action;

public class CheckoutPage extends BaseClass {
	
	Action action=new Action();
	
	@FindBy(xpath="//span[@class='title']")
	private WebElement checkoutTitle;
	
	@FindBy(xpath="//input[@id='first-name']")
	private WebElement first_name;
	
	@FindBy(xpath="//input[@id='last-name']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='postal-code']")
	private WebElement zipCode;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//button[@id='cancel']")
	private WebElement cancelBtn;
	
	public CheckoutPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String title() {
		action.fluentWait(getDriver(), checkoutTitle, 5);
		String title=checkoutTitle.getText();
		return title;
	}
	
	public void details(String fname,String lname,String zipcode) {
		action.type(first_name, fname);
		action.type(lastName, lname);
		action.type(zipCode, zipcode);
		
	}
	
	public CheckoutOverviewPage continuebtn() {
		action.click(getDriver(), continueBtn);
		return new CheckoutOverviewPage();
	}

}
