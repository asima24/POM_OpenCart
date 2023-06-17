package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest{
		
	@Test
	public void loginPageTittleTest() {
		String actualTittle=loginPage.getPageTittle();
		Assert.assertEquals(actualTittle, "Account Login");
		}
	
	@Test
	public void loginPageURLTest() {
		String actualURL=loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains("route=account/login"));
		}
	
	@Test
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkDisplayed());
	}
	
//	@Test
//	public void  newCustomerTextDisplayedTest() {
//		System.out.println(" Boolean value is"+loginPage.isNewCustomerTextDisplayed());
//		Assert.assertTrue(loginPage.isNewCustomerTextDisplayed());
//	}
//	@Test
//	public void  returnCustomerTextDisplayedTest() {
//		System.out.println("Boolean value of return customer===== "+loginPage.isReturnCustomerTextDisplayed());
//		Assert.assertTrue(loginPage.isReturnCustomerTextDisplayed());
//	}
	
	
	@Test
	public void loginTest() {
		 accPage =loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		 Assert.assertTrue(accPage.isLogoutLinkDisplayed());
}
}