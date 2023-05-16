package com.saucelabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.Base.BaseClass;
import com.saucelabs.Drivers.Action;

public class CartPage extends BaseClass{
	
	Action action=new Action();
	
	@FindBy(xpath="//span[@class='title']")
	private WebElement cartTitle;
	
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement checkoutbtn;
	
	@FindBy(xpath="//button[@id='continue-shopping']")
	private WebElement continueShopppingBtn;
	
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")
	private WebElement removesaucelabsbackpack;
	
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']")
	private WebElement removesaucelabsbikelight;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	private WebElement itemsinthecart;
	
	public CartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String title() {
		String title=cartTitle.getText();
		return title;
	}
	
	public String itemsInTheCart() {
		String items=itemsinthecart.getText();
		return items;
	}
	
	public void removeItem() {
		action.click(getDriver(), removesaucelabsbackpack);
		
	}
	
	public ProductsPage continueShopping() {
		action.click(getDriver(), continueShopppingBtn);
		return new ProductsPage();
	}
	
	public CheckoutPage checkout() {
		action.click(getDriver(), checkoutbtn);
		return new CheckoutPage();
	}
	
	

}
