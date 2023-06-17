package com.qa.opercart.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	ElementUtil eleutil;
	Map<String,String> productInfoMap;
	//Map<String,String> productmetaData=
	
	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtil(this.driver);
	}
	
	
	private By productHeader=By.cssSelector("div#content h1");
	private By productImages=By.cssSelector("ul.thumbnails img");
	private By productMetaData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By productPriceData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
	private By productQuantity=By.name("quantity");
	private By addToCartButtn=By.id("button-cart");
	private By addToCartSuccessText=By.xpath("//div[@id='product-product']/div[@class='alert alert-success alert-dismissible']");
	
	
	public Map<String, String> getProductinfo() {
		//productInfoMap=new HashMap<String,String>(); doesn't maintain any order
		productInfoMap=new LinkedHashMap<String,String>(); //does maintain a order.
		productInfoMap=new TreeMap<String,String>();//sorted map
		getProductMetaData();
		//System.out.println("getProductMetadata()----"+productInfoMap);
		getProductPrice();
		productInfoMap.put("productHeader", getProductHeaderName());
		System.out.println("productInfoMap3---3333333333333333333-"+productInfoMap);
	
		
		return productInfoMap;
	}
	public String getProductHeaderName() {
		 return eleutil.doGetElementText(productHeader);
		
	}
	
	public int getImageCount() {
		return eleutil.waitForElementsVisible(productImages, 10).size();
	}
	
//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: In Stock
	private void getProductMetaData() {
		List<WebElement> metaList=eleutil.waitForElementsVisible(productMetaData, 10);
		//productInfoMap=new HashMap<String,String>();
		productInfoMap=new HashMap<String,String>();
	    for(WebElement e:metaList) {
	    	    String metaText= e.getText();
	    	    System.out.println(e.getText());
	    	      String[] metainfo=metaText.split(":");
	    	      System.out.println(metainfo);
	    	      String key =metainfo[0].trim();
	    	      String value =metainfo[1].trim();
	    	      System.out.println("key---"+key+" Value---"+value);
	    	     productInfoMap.put(key,value);
	    }
	    
	    System.out.println("ProductMap1-11111111111--"+productInfoMap);
	    
	    
	}
		
	private void getProductPrice() {
		List<WebElement> productPriceDataList=eleutil.waitForElementsVisible(productPriceData,10);
		//productInfoMap=new HashMap<String,String>();
	        String  pricevalue=productPriceDataList.get(0).getText();
	        String  extTaxprice=productPriceDataList.get(1).getText() ;
	    	      String exTaxValue= extTaxprice.split(":")[1].trim();
	    	     productInfoMap.put("productPrice",pricevalue );
	    	     productInfoMap.put("extaxPrice",exTaxValue);
	    	     System.out.println("ProductMap2--2222222222-"+productInfoMap);
	    		    
	    	    
	}
	
	public  String addToCart() {
		eleutil.doSendKeys(productQuantity,"2");
		eleutil.doClick(addToCartButtn);
		String successText=eleutil.doGetElementText(addToCartSuccessText);
		System.out.println(successText);
		System.out.println("Add to Cart sucess Text ====>"+successText.split("  "));
		return successText;
	}
}
