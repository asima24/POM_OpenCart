package com.qa.opercart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	WebDriver driver;
	protected ElementUtil eleutil;
public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtil(this.driver);
	}


	private By headerLinks=By.cssSelector("div#content h2");
	private By logoutLink=By.linkText("Logout");
	private By searchField=By.name("search");
	private By searchFieldButton=By.cssSelector("div#search button");
	
	
	public String getAccountPageTittle() {
//		String accPageTittle=driver.getTitle();
//		System.out.println(accPageTittle);
		return eleutil.waitForTitleIsAndCapture(AppConstants.ACCOUNTS_PAGE_TITLE_VALUE, AppConstants.MEDIUM_DEFAULT_WAIT);
	}
	
	  public String getAccountPageURL() {
//		    String accPageURL=driver.getCurrentUrl();
//		    System.out.println("The URL is " +accPageURL);
		  return eleutil.waitForURLContainsAndCapture(AppConstants.ACCOUNT_PAGE_URL_FRACTION_VALUE, AppConstants.MEDIUM_DEFAULT_WAIT);
		
	}
	  
	  public boolean isLogoutLinkDisplayed() {
		  //return driver.findElement(logoutLink).isDisplayed();
		  return eleutil.checkElementIsDisplayed(logoutLink);
	  }
	  
	  public List<String>  getHeaderLinkList() {
		    // List<WebElement> headerLinkList=driver.findElements(headerLinks);
		  List<WebElement> headerLinkList=eleutil.waitForElementsVisible(headerLinks,AppConstants.LONG_DEFAULT_WAIT);
		     List<String>  headerTextList=new ArrayList<String>()  ;   
		     for(WebElement e:headerLinkList)
		     {
		    	  String text=e.getText();
		    	  headerTextList.add(text);
		      }
			return headerTextList;
	  }
	  
	  public AccountLogoutPage doLogout() {
		  //driver.findElement(logoutLink).click();
		  eleutil.doClick(logoutLink);
		  return new AccountLogoutPage(driver);
	  }
	  
	  public SearchResultPage doSearch(String searchKey) {
//		  driver.findElement(searchField).sendKeys("mac");
//		  driver.findElement(searchFieldButton).click();
		  eleutil.waitForElementVisible(searchField,AppConstants.MEDIUM_DEFAULT_WAIT);
		  eleutil.doSendKeys(searchField, searchKey);
		
		  eleutil.doClick(searchFieldButton);
		  return new SearchResultPage(driver);
	  }

}
