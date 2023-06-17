package com.qa.opencart.dataprovider;

import org.testng.annotations.DataProvider;

import com.qa.opencart.pojo.Product;

public class ProductDataProvider {
	
	@DataProvider(name="productData")
	public Object[][] getProductData() {
		return new Object[][] {
			
			{new Product("Macbook","MacBook Pro",4)},
			{new Product("imac", "iMac",3)},
			{new Product("samsung","Samsung Galaxy Tab 10.1",7)},
			{new Product("samsung","Samsung SyncMaster 941BW",1)},
			
		};
	}
	
	
	@DataProvider
	public Object[][] getProductImagesData() {
		return new Object[][] {
			
			{"Macbook","MacBook Pro",4},
			{"imac", "iMac",3},
			{"samsung","Samsung Galaxy Tab 10.1",7},
			{"samsung","Samsung SyncMaster 941BW",1}
			
		};
	}

	@DataProvider
	public Object[][] getProductSearchKey() {
		return new Object[][] {
			
			{"Macbook"},
			{"iMac"},
			{"samsung"}
			
		};
	}

}
