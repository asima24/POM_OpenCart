package com.qa.opencart.base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opercart.pages.AccountsPage;
import com.qa.opercart.pages.LoginPage;
import com.qa.opercart.pages.ProductInfoPage;
import com.qa.opercart.pages.RegistrationPage;
import com.qa.opercart.pages.SearchResultPage;

public class BaseTest {
	WebDriver driver;
	protected LoginPage loginPage;
	 protected DriverFactory  driverFactory;
	protected Properties prop;
	protected AccountsPage accPage;
	protected SearchResultPage searchResPage;
	protected ProductInfoPage prodInfoPage;
	protected RegistrationPage regPage;
	protected SoftAssert softAssert;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUP( @Optional("Chrome")String browserName) {
		//driver=new ChromeDriver();
		//loginPage=new LoginPage(driver);
		
		driverFactory=new DriverFactory();
		try {
			prop=driverFactory.initProp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(browserName!=null) {
			prop.setProperty("browser", browserName);
		}		
		driver=driverFactory.initDriver(prop);

		loginPage=new LoginPage(driver);
		softAssert=new SoftAssert();
		
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
	
}
