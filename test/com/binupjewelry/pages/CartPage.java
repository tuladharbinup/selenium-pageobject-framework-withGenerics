package com.binupjewelry.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import com.binupjewelry.base.BasePage;
import com.binupjewelry.base.DriverContext;
import com.binupjewelry.utilities.HelperUtil;

public class CartPage extends BasePage{
	@FindBy(how=How.ID, using = "basket_purchase_main")
    public WebElement btnCheckOut;
	
	@FindBy(how=How.ID, using = "lblEmptyFeedback")
    public WebElement lblEmptyBasket;
	
	 public CheckOutPage clickCheckOut() throws InterruptedException {
		 HelperUtil.clickElement(btnCheckOut);		
		 CheckOutPage checkOutPage= getInstance(CheckOutPage.class);
		 return checkOutPage;
	    }
	
	 //This function is added as sometimes system does not navigate to checkout page even when checkout button is clicked.
	 public void verifyClickCheckOut() throws InterruptedException {	
		 String currentURL= HelperUtil.getCurrentURL();
		 while (currentURL.contains("cart")) {
			 System.out.println("System is checking page URL: "+currentURL);
			 Thread.sleep(5000);	
			 currentURL= HelperUtil.getCurrentURL();
			 if (currentURL.contains("cart")){
				 HelperUtil.clickElement(btnCheckOut);
				 System.out.println("System successfully prevented Element Not found exception");
			 }
		 }
		 if (currentURL.contains("checkout")){
			 System.out.println("System is navigating to checkout page URL: "+currentURL);
		 }
		 else {
			 System.out.println("System is navigating to page: "+currentURL);
		 }
		 
	    }
	 
	 public String getEmptyBasketMessage() {
		 HelperUtil.waitForElementToBeVisible(lblEmptyBasket);
		 return lblEmptyBasket.getText();
	 	}
}
