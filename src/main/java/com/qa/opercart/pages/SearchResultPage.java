package com.qa.opercart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage {

	  WebDriver driver;
	  private ElementUtil eleutil;
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtil(this.driver);
	}
	
	
	private By resultsProduct=By.cssSelector("div.product-thumb");
	
	//PageAction
	public String getSearchResultPageTitle(String searchKey) {
		return eleutil.waitForTitleIsAndCapture(searchKey, 5);
	}
	
	public int getProductResultsCount() {
		int resultCount= eleutil.waitForElementsVisible(resultsProduct, 10).size();
		System.out.println("product search result count===>"+ resultCount);
		return resultCount;
	}

	public ProductInfoPage selectProduct(String productName) {
		By poductNameLocator=By.linkText(productName);
		eleutil.doClick(poductNameLocator, 10);
		return new ProductInfoPage(driver);
		
	}
	
	
}
