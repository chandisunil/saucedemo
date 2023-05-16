package com.saucelabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.Base.BaseClass;
import com.saucelabs.Drivers.Action;

public class CheckoutOverviewPage extends BaseClass {
	
	Action action=new Action();
	
	@FindBy(xpath="//span[@class='title']")
	private WebElement checkoutTitle;
	
	@FindBy(xpath="//button[@id='finish']")
	private WebElement finishbtn;
	
	@FindBy(xpath="//button[@id='cancel']")
	private WebElement cancel;
	
	public CheckoutOverviewPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String title() {
		String title=checkoutTitle.getText();
		return title;
	}
	
	public void finish() {
		action.click(getDriver(), finishbtn);
		
	}

}
