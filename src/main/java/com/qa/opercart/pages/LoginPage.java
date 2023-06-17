package com.qa.opercart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	ElementUtil eleutil;
	//1.constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtil(this.driver);
	}
	
	//2.private by locators
  private  By  emailId=By.id("input-email");
  private  By  password=By.id("input-password");
  private  By  newCostumerText=By.xpath("//h2[text()='New Customer']");
  private  By  returncustomerText=By.xpath("//h2[text()='Returning Customer']");
  private  By  loginBtn = By.xpath("//input[@value='Login']");
  private  By  forgotPwdlink = By.linkText("Forgotten Password");
  private  By  footerLinks = By.xpath("//footer//a");
  private  By  unSuccessfulWarningMessage=By.cssSelector("div.alert.alert-danger.alert-dismissible");
  private  By  registrationLink=By.linkText("Register");
 
  //3.public page actions/methods
  
  public String getPageTittle() {
        return eleutil.waitForTitleIsAndCapture(AppConstants.LOGIN_PAGE_TITLE_VALUE, AppConstants.MEDIUM_DEFAULT_WAIT);
//	    String tittle=driver.getTitle();
//	    System.out.println("The tittle is" +tittle);
//	     return tittle 
  }
  public String getLoginPageURL() {
//	    String URL=driver.getCurrentUrl();
//	    System.out.println("The URL is" +URL);
//	     return URL ;
	  return eleutil.waitForURLContainsAndCapture(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE, AppConstants.SHORT_DEFAULT_WAIT);
	  
}
  //1
  public boolean isForgotPwdLinkDisplayed() {
	  //return driver.findElement(forgotPwdlink).isDisplayed();
	  return eleutil.IsElementDisplayed(footerLinks);
  }
  //2
  public boolean isNewCustomerTextDisplayed() {
	  //return driver.findElement(newCostumerText).isDisplayed();
	  
	  eleutil.waitForElementsVisible(returncustomerText, 10);
	  return eleutil.IsElementDisplayed(newCostumerText);
  }
  //3
  public boolean isReturnCustomerTextDisplayed() {
	return driver.findElement(returncustomerText).isDisplayed();
	 // return eleutil.IsElementDisplayed(returncustomerText);
  }
  //Can we have one method for all the above 3 methods
  //generic method for 1,2 and 3
  //public boolean isTextORLinkDisplayed(By locator) {
	//  return eleuti;
 // }
  
  public List<String>  getFooterLinkList() {
	   //  List<WebElement> footerLinkList=driver.findElements(footerLinks);
	  List<WebElement> footerLinkList=eleutil.waitForElementsVisible(footerLinks, 10);
	     List<String>  footerTextList=new ArrayList<String>()  ;   
	     for(WebElement e:footerLinkList)
	     {
	    	  String text=e.getText();
	    	  footerTextList.add(text);
	      }
		return footerTextList;
  }
  
  public  AccountsPage doLogin(String username,String pwd) {
//	  driver.findElement(emailId).sendKeys("jimmy@gmail.com");
//	  driver.findElement(password).sendKeys("jimmy");
//	  driver.findElement(loginBtn).click();
	  
	  eleutil.waitForElementVisible(emailId,AppConstants.SHORT_DEFAULT_WAIT).sendKeys(username);
	  eleutil.doSendKeys(password, pwd);
	  eleutil.doClick(loginBtn);
	  return new AccountsPage(driver);
  }
  public  boolean doLoginWithWrongCredentials(String username,String pwd) {
//	  driver.findElement(emailId).sendKeys("jimmy@gmail.com");
//	  driver.findElement(password).sendKeys("jimmy");
//	  driver.findElement(loginBtn).click();
	  
//	  eleutil.waitForElementVisible(emailId,AppConstants.SHORT_DEFAULT_WAIT);
//	  eleutil.doSendKeys(emailId, username);
//	  eleutil.doSendKeys(password, pwd);
//	  eleutil.doClick(loginBtn);
//	  String warnMsg=eleutil.doGetElementText(unSuccessfulWarningMessage);
//	  if(warnMsg.contains(AppConstants.LOGIN_WARNING_MESSAGE)) {
//		  return true;
//		  }
//		  else
//			  return false;
	  System.out.println("wrong creds are : " + username + ":" + pwd);
		eleutil.waitForElementVisible(emailId, AppConstants.MEDIUM_DEFAULT_WAIT);
		eleutil.doSendKeys(emailId, username);
		eleutil.doSendKeys(password, pwd);
		eleutil.doClick(loginBtn);
		String errorMessg = eleutil.doGetElementText(unSuccessfulWarningMessage);
		System.out.println(errorMessg);
		if (errorMessg.contains(AppConstants.LOGIN_ERROR_MESSAGE)) {
			return true;
		}
		return false;
//	   
	 
  }

	public RegistrationPage doRegistation() {
		
		 eleutil.doClick(registrationLink, AppConstants.SHORT_DEFAULT_WAIT);
		 return new RegistrationPage(driver);
	}
		 
}
