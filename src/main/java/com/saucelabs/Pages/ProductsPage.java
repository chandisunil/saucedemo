package com.saucelabs.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.Base.BaseClass;
import com.saucelabs.Drivers.Action;

public class ProductsPage extends BaseClass{
	
	Action action=new Action();
	
	@FindBy(xpath="//span[@class='title']")
	private WebElement productsTitle;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	private WebElement selectFilter;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement sauceLabsbackPack;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")
	private WebElement sauceLabsBikeLight;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	private WebElement saucelabsBoltTShirt;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
	private WebElement sauceLabsFleeceJacket;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']")
	private WebElement sauceLabsOnesie;
	
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
	private WebElement sauceLabsTShirtRed;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement cart;
	
	@FindAll(@FindBy(xpath="//div[@class='inventory_item_name']"))
	public List<WebElement> itemnames;
	
	@FindAll(@FindBy(xpath="//div[@class='inventory_item_price']"))
	public List<WebElement> itemprices;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	private WebElement productsMenu;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	private WebElement logout;
	

	
	public ProductsPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String title() {
		String title=productsTitle.getText();
		return title;
		
	}
	
	public void DesSortProducts() throws InterruptedException {
		action.fluentWait(getDriver(), selectFilter, 5);
		action.click(getDriver(), selectFilter);
		action.selectByVisibleText("Name (Z to A)", selectFilter);
		
		
		
			
	}
	
	public void sortByLowToHigh() {
		action.fluentWait(getDriver(), selectFilter, 5);
		action.click(getDriver(), selectFilter);
		action.selectByVisibleText("Price (low to high)", selectFilter);
	}
	
	public void sortByHighToLow() throws InterruptedException {
		action.fluentWait(getDriver(), selectFilter, 5);
		action.click(getDriver(), selectFilter);
		action.selectByVisibleText("Price (high to low)", selectFilter);
		
	}
	
	public CartPage itemsAddingInToCart() {
		action.click(getDriver(), sauceLabsbackPack);
		action.click(getDriver(), sauceLabsBikeLight);
		action.click(getDriver(), cart);
		return new CartPage();
	}
	public void addonemoreitem() {
		action.click(getDriver(), saucelabsBoltTShirt);
		action.click(getDriver(), cart);
	}
	
	public void menu() {
		action.click(getDriver(), productsMenu);
	}
	
	public void logOut() {
		action.explicitWait(getDriver(), logout, 5);
		action.click(getDriver(), logout);
	}
	

}
