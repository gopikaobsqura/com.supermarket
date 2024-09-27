package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.DataProviders;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LogInPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.ScreenShotCapture;

public class LogInTest extends Base {
	LogInPage loginpage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();

	@Test
	public void verifyLogin() {
		loginpage = new LogInPage(driver);
		homepage = new HomePage(driver);
		
		/**excel file data fetch**/
		excelreader.setExcelFile("LoginCredential", "Sheet1");

		/**to login application using data from excel file**/

	    loginpage.Login(excelreader.getCellData(2, 0), excelreader.getCellData(2, 1));
		String name = GeneralUtility.getRandomFirstName();
		System.out.println(name);
	}

	@Test
	public void verifySignIn() {
		loginpage = new LogInPage(driver);
		loginpage.ClickOnSignInButton();
	}

	@Test
	public void verifyInvalidcredentials() {
		loginpage = new LogInPage(driver);
		loginpage.Login("admin", "123");
		loginpage.verifyInvalidCredentials();		
	}

	/**login using data provider**/
	@Test(dataProvider ="logindetails",dataProviderClass = DataProviders.class)
	public void verifyLoginDataprovider(String Username, String password) {
		loginpage = new LogInPage(driver);
		loginpage.Login(Username, password);
	}
}