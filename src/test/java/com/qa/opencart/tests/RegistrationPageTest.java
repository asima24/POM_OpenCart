package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

public class RegistrationPageTest extends BaseTest {
	
	@BeforeClass
	public void registrationSetup() {
		regPage=loginPage.doRegistation();
	}
	
	@DataProvider(name="getRegistationData")
	public  Object[][] doGetRegistrationData() {
		return new Object[][]{
			{"Taylor","swift","123456789","swiftie","Yes" },
			{"Justin","Beiber","1234509999","pass@123","No" },
			{"Lisa","Mishra","12345678960","pass@123","No" },
			{"Preeti","sagar","1234567849","@preeti","Yes" }
			
		};
	}
	
	public String randomEmail() {
		return "test"+System.currentTimeMillis()+"@gmail.com";
	}
	
	@Test(dataProvider="getRegistationData")
	public void doRegistrationTest(String firstname,String lastname,String telephone,String password,String subscribe) {
		String actRegSuccMessg =regPage.doRegisterUser(firstname, lastname, randomEmail(), telephone, password, subscribe);
	    Assert.assertEquals(actRegSuccMessg, AppConstants.USER_RESG_SUCCESS_MESSG);
	    
	}

}
