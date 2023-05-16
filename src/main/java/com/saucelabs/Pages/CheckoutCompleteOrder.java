package com.saucelabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.Base.BaseClass;
import com.saucelabs.Drivers.Action;

public class CheckoutCompleteOrder extends BaseClass{
Action action=new Action();
	
	@FindBy(xpath="//span[@class='title']")
	private WebElement checkoutTitle;
	
	@FindBy(xpath="//h2[@class='complete-header']")
	private WebElement completeordermsg;
	
	@FindBy(xpath="//button[@id='back-to-products']")
	private WebElement backtohome;
	
	public  CheckoutCompleteOrder() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public String title() {
		String title=checkoutTitle.getText();
		return title;
	}
	
	public String orderconfirmation() {
		String confirmorder=completeordermsg.getText();
		return confirmorder;
	}
	
	public ProductsPage backToHome() {
		action.click(getDriver(), backtohome);
		return new ProductsPage();
	}

}
