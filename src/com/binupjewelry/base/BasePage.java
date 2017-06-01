package com.binupjewelry.base;
/**
 * Created by binup on 5/25/2017.
 */
import org.openqa.selenium.support.PageFactory;

//all page model classes should inherit this base class
public abstract class BasePage {
	    
 /**create a generic method GetInstance, to hold only BasePage objects.( element type BasePage or subtype of BasePage).
    We are passing class of type BasePage as method parameter and also returning BasePage (TPage)
	BasePage.getInstance() will provide a way to create page model objects by class name rather than having to “new them up” 
     */
    public static <TPage extends BasePage> TPage getInstance (Class<TPage> pageClass) {
    	TPage page= PageFactory.initElements(DriverContext.getDriver(), pageClass);
        return page;
    }
}