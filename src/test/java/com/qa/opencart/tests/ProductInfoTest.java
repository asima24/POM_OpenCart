package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opercart.pages.AccountsPage;

public class ProductInfoTest extends BaseTest {
	
AccountsPage accPage;
	
	@BeforeClass
	public void login() {
		accPage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	//{Brand=Apple, Availability=In Stock, productHeader=MacBook Pro, extaxPrice=$2,000.00, Product Code=Product 18, Reward Points=800, productPrice=$2,000.00}
	
	@Test
	public void productInfoTest() {
		searchResPage=accPage.doSearch("Macbook");
		prodInfoPage=searchResPage.selectProduct("MacBook Pro");
		Map<String,String> productInfoMap=prodInfoPage.getProductinfo();
		System.out.println(productInfoMap);
		softAssert.assertEquals(productInfoMap.get("Brand"), "Apple");
		softAssert.assertEquals(productInfoMap.get("Availability"), "In Stock");
		softAssert.assertEquals(productInfoMap.get("productHeader"), "MacBook Pro");
		softAssert.assertEquals(productInfoMap.get("extaxPrice"), "$2,000.00");
		softAssert.assertEquals(productInfoMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(productInfoMap.get("Reward Points"), "800");
		softAssert.assertEquals(productInfoMap.get("productPrice"), "$2,000.00");
		softAssert.assertAll();
	}
	
	@Test
	public void productAddedToCartTest() {
		searchResPage=accPage.doSearch("Macbook");
		prodInfoPage=searchResPage.selectProduct("MacBook Pro");
		String actualSucessText=prodInfoPage.addToCart();
		System.out.println(" Actual Success Test====>"+actualSucessText);
		Assert.assertTrue(actualSucessText.contains("MacBook Pro"));
		
	}

}
