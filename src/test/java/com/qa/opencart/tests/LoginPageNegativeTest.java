package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageNegativeTest  extends BaseTest{
	
	
	@DataProvider
	public Object[][]  doGetLoginCredential() {
		return new Object[][] {
			{"user","Pass123455  "},
			{"world  ", "pass@test"},
			{"12344","1234"},
			{"username","12345"}
			
		};
	}
	
	@Test(dataProvider="doGetLoginCredential")
	public void loginTest(String username,String password) {
	 boolean bool=loginPage.doLoginWithWrongCredentials(username,password );
			 
		 Assert.assertTrue(bool);
}

}
