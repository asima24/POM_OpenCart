package com.qa.opercart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class RegistrationPage {
	
	private WebDriver driver;
	ElementUtil eleutil;
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtil(driver);
		}
	
	private By firstname=By.name("firstname");
	private By lastname=By.name("lastname");
	private By email=By.name("email");
	private By telephone=By.name("telephone");
	private By password=By.name("password");
	private By confirmPassword=By.name("confirm");
	private By subscribeYes=By.xpath("(//label[@class='radio-inline']/input)[1]");
	private By subscribeNo=By.xpath("(//label[@class='radio-inline']/input)[2]");
	private By privacyPolicycheckbox=By.xpath("//input[@name='agree']");
	private By continueBttn=By.xpath("//input[@type='submit']");
	private By userRegSuccMessg=By.xpath("//h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	public String doRegisterUser(String firstname,String lastname,String email,String telephone,String password,String subscribe) {
		eleutil.waitForElementsVisible(this.firstname,AppConstants.MEDIUM_DEFAULT_WAIT);
		eleutil.doSendKeys(this.firstname, subscribe);
        eleutil.doSendKeys(this.lastname, lastname);
		eleutil.doSendKeys(this.email, email);
		eleutil.doSendKeys(this.telephone, telephone);
		eleutil.doSendKeys(this.password,password);
		eleutil.doSendKeys(confirmPassword, password);
		doSubscribe(subscribe);
		
		eleutil.doClick(privacyPolicycheckbox);
		eleutil.doClick(continueBttn);
		
		String userRegSuccessMesg = 
				eleutil.waitForElementVisible(userRegSuccMessg, AppConstants.MEDIUM_DEFAULT_WAIT).getText();
		System.out.println(userRegSuccessMesg);
		
		eleutil.doClick(logoutLink);
		eleutil.doClick(registerLink);

		
		return userRegSuccessMesg;
	}
	
	
	
	private void doSubscribe(String subscribe) {
		if(subscribe.equalsIgnoreCase("yes")) {
			eleutil.doClick(subscribeYes);
		}
		else {
			eleutil.doClick(subscribeNo);
		}
	
	
	}

	
}



