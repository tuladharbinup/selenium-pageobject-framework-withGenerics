package com.binupjewelry.base;
/**
 * Created by binup on 5/25/2017.
 */

import org.openqa.selenium.WebDriver;

public class DriverContext {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		DriverContext.driver = driver;
	}

	public static void closeWebDriver(){
		if (driver!= null)
			driver.quit();
    }
	 
}
