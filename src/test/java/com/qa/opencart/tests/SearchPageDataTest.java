package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataprovider.ProductDataProvider;
import com.qa.opencart.pojo.Product;

public class SearchPageDataTest extends BaseTest {
	@BeforeClass
	public void searchSetup() {
	accPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
//	@DataProvider(name="productData")
//	public Object[][] getProductData() {
//		return new Object[][] {
//			
//			{new Product("Macbook","MacBook Pro",4)},
//			{new Product("imac", "iMac",3)},
//			{new Product("samsung","Samsung Galaxy Tab 10.1",7)},
//			{new Product("samsung","Samsung SyncMaster 941BW",1)},
//			
//		};
//	}
	
	@Test(dataProvider="productData",dataProviderClass=ProductDataProvider.class)
	public void searchProductTest(Product prod) {
		searchResPage= accPage.doSearch(prod.getSearchKey());
		Assert.assertTrue(searchResPage.getProductResultsCount()>0);
	}
	
	@Test(dataProvider="productData",dataProviderClass=ProductDataProvider.class)
	public void searchPageTitleTest(Product prod) {
		searchResPage= accPage.doSearch(prod.getSearchKey());
		String actualSearchTitle=searchResPage.getSearchResultPageTitle(prod.getSearchKey());
		Assert.assertEquals(actualSearchTitle,"Search - "+prod.getSearchKey());
	}

	
	
	@Test(dataProvider="productData",dataProviderClass=ProductDataProvider.class)
	public void selectProducTest(Product prod) {
		searchResPage= accPage.doSearch(prod.getSearchKey());
		prodInfoPage=searchResPage.selectProduct(prod.getProductName());
		String actualProdHeader=prodInfoPage.getProductHeaderName();
		Assert.assertEquals(actualProdHeader, prod.getProductName());
	}
	

	@Test(dataProvider="productData",dataProviderClass=ProductDataProvider.class)
	public void countProductImageTest(Product prod) {
		searchResPage= accPage.doSearch(prod.getSearchKey());
		prodInfoPage=searchResPage.selectProduct(prod.getProductName());
		int acualImageCount=prodInfoPage.getImageCount();
		Assert.assertEquals(acualImageCount,prod.getProductImage());
	}

}
