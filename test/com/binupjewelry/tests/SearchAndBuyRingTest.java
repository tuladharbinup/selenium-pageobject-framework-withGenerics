package com.binupjewelry.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.binupjewelry.base.BasePage;
import com.binupjewelry.enums.Products;
import com.binupjewelry.pages.CartPage;
import com.binupjewelry.pages.CheckOutPage;
import com.binupjewelry.pages.HomePage;
import com.binupjewelry.pages.LoginPage;
import com.binupjewelry.pages.ProductDetailPage;
import com.binupjewelry.pages.SearchPage;
import com.binupjewelry.pages.SecureCheckOutPage;
import com.binupjewelry.pojo.Authentication;
import com.binupjewelry.pojo.CreditCardInfo;
import com.binupjewelry.pojo.ShippingInfo;
import com.binupjewelry.utilities.HelperUtil;

/**
 * Created by binup on 5/13/2017.
 */
public class SearchAndBuyRingTest extends TestAnnotations {
	
	@Test 		
    public void searchAndBuyRing() throws InterruptedException {    	
    	System.out.println("\n EXECUTING TEST--> Search and Buy Ring");    	
    	
    	Products testProduct=Products.PandoraSilverRoseRing;
    	
    	//Instantiating POJO objects
    	Authentication testUser=new Authentication();
    	ShippingInfo testShippingInfo= new ShippingInfo();
    	CreditCardInfo creditCardInfo=new CreditCardInfo();
    	
    	//Instantiating only first Page object model using BasePage getInstance()
    	HomePage homePage= BasePage.getInstance(HomePage.class);
        
    	LoginPage loginPage = homePage.clickSignIn();        
        loginPage.Login(testUser.getUserName(), testUser.getPassWord());        
        Assert.assertTrue(homePage.isInitialized());
        
        homePage.selectHomeMenu();
        SearchPage searchPage=homePage.searchProduct(testProduct.getProductTitle());        
        System.out.println("\nSearch result number: "+searchPage.getSearchResultNumber());
        ProductDetailPage productDetailPage=searchPage.clickDetails();

        String productTitle= productDetailPage.getProductTitle();
        Assert.assertEquals(testProduct.getProductTitle(), productTitle);
		System.out.println("\nPASSED: Product title verified as: "+productTitle);
        
        CartPage cartPage=productDetailPage.clickBuy();     
        CheckOutPage checkOutPage=cartPage.clickCheckOut();
        cartPage.verifyClickCheckOut();
        
        checkOutPage.clickAddAddress();        
        checkOutPage.createShippingInfo(testShippingInfo.getFirstName(), testShippingInfo.getLastName(), testShippingInfo.getAddressLine1(), testShippingInfo.getCity(), testShippingInfo.getCountry(), testShippingInfo.getState(), testShippingInfo.getZip());
        
        checkOutPage.clickContinueToShippingOptions();        
        SecureCheckOutPage secureCheckOutPage= checkOutPage.clickContinueToPayment();
        
        secureCheckOutPage.completeCreditCardInformation(creditCardInfo.getNameOnCard(), creditCardInfo.getCardNumber(), creditCardInfo.getExpiryMM(), creditCardInfo.getExpiryYYYY(), creditCardInfo.getCVC(), creditCardInfo.getZip());
        
        secureCheckOutPage.clickCompleteOrder();
        secureCheckOutPage.checkRadioTermsAndConditions();
        secureCheckOutPage.clickCompleteOrder();        
                		
        //Take screenshot at the end
        HelperUtil.grabScreenShot("TCsearchAndBuyRing");
       
    }
}
