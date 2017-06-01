package com.binupjewelry.tests;

/**
 * Created by binup on 5/13/2017.
 */

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.binupjewelry.base.DriverContext;
import com.binupjewelry.base.InitializeFrameworkResource;

public class TestAnnotations {
		
	@BeforeSuite(alwaysRun = true)
    public void setupTestSuite() {
			
		System.out.println("Beginning Test initialization.....");		
		InitializeFrameworkResource.getInstance(); 
        System.out.println("Test initialization Completed");

    }
	
	@AfterSuite
    public void TearDownTestSuite() {	        
        // close application
		DriverContext.closeWebDriver(); 		 
        }
}
