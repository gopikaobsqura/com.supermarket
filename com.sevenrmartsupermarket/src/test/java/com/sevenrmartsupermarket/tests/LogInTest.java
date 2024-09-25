package com.sevenrmartsupermarket.tests;


import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LogInPage;



public class LogInTest extends Base {
	
   LogInPage loginPage;
   HomePage homePage;
   @Test(groups = "Smoke")
	public void VerifyLogin() {
	   loginPage = new LogInPage(driver);
	   homePage=new HomePage(driver);
	   
	   loginPage.Login("Vivekm","demo");
	   String actualProfileName= homePage.getProfileName();
	   String expectedProfileName="Vivekm";
	   Assert.assertEquals(actualProfileName, expectedProfileName);
	   
		
	}

}
