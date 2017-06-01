package com.binupjewelry.base;

import org.openqa.selenium.WebDriver;

import com.binupjewelry.config.ConfigReader;
import com.binupjewelry.config.Settings;

public class InitializeFrameworkResource {
	private WebDriver driver=DriverContext.getDriver();	
	private static InitializeFrameworkResource instance = null;
	
	private InitializeFrameworkResource(){
		 	ConfigReader.PopulateSettings();
	        System.setProperty("webdriver.gecko.driver",Settings.geekoDriverPath);        
	        driver = BrowserFactory.getDriver(Settings.browser);
	        System.out.println("Navigating to test URL: " +Settings.AUT);
	        driver.get(Settings.AUT);
	        driver.manage().window().maximize(); 
	}
	
	//  This is our singleton ensuring we only have one primary InitializeFrameworkResource for all pages.
	public static InitializeFrameworkResource getInstance() {
		if(instance == null){
			instance = new InitializeFrameworkResource();
		}
		return instance;
	} 
}
