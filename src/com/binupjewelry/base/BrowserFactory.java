package com.binupjewelry.base;
/**
 * Created by binup on 5/25/2017.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
			
	public static WebDriver getDriver(String browser){
		WebDriver driver;
		
		switch (browser.toLowerCase()) {
        	case "firefox":
        		driver= new FirefoxDriver();
        		break;
        	case "ie":
        		driver = new InternetExplorerDriver();
        		break;
        	case "safari":
        		driver = new SafariDriver();
        		break;
        	case "chrome":
        		driver = new ChromeDriver();
        		break;
        	case "htmlunit":
        		driver=new HtmlUnitDriver();
        		break;
        	default:
        		driver = new FirefoxDriver();
		} 
		
		DriverContext.setDriver(driver);
		return driver;
	}

}
