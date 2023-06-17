package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataprovider.ProductDataProvider;

public class SearchTest extends BaseTest {

	@BeforeClass
	public void searchSetup() {
	accPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(dataProvider="getProductSearchKey",dataProviderClass=ProductDataProvider.class)
	public void searchProductTest(String searchKey) {
		searchResPage= accPage.doSearch(searchKey);
		Assert.assertTrue(searchResPage.getProductResultsCount()>0);
	}
	
	@Test(dataProvider="getProductSearchKey",dataProviderClass=ProductDataProvider.class)
	public void searchPageTitleTest(String searchKey) {
		searchResPage= accPage.doSearch(searchKey);
		String actualSearchTitle=searchResPage.getSearchResultPageTitle(searchKey);
		Assert.assertEquals(actualSearchTitle,"Search - "+searchKey);
	}

	
	@DataProvider
	public Object[][] getProductNameData() {
		return new Object[][] {
			
			{"Macbook","MacBook Pro"},
			{"imac", "iMac"},
			{"samsung","Samsung Galaxy Tab 10.1"},
			{"samsung","Samsung SyncMaster 941BW"},
			
		};
	}
	
	

	@Test(dataProvider="getProductImagesData",dataProviderClass=ProductDataProvider.class)
	public void countProductImageTest(String searchKey,String productName,int imageCount) {
		searchResPage= accPage.doSearch(searchKey);
		prodInfoPage=searchResPage.selectProduct(productName);
		int acualImageCount=prodInfoPage.getImageCount();
		Assert.assertEquals(acualImageCount,imageCount);
	}
}
