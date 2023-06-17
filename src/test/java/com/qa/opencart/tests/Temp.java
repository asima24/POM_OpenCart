package com.qa.opencart.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.qa.opencart.utils.ElementUtil;

public class Temp {
	
	@Test()
	public void test() {
		 System.setProperty("webdriver.gecko.driver", "C:\\Tools\\TestingTools\\drivers\\geckodriver.exe");

		WebDriver driver=new FirefoxDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		   By  newCostumerText=By.xpath("//h2[text()='New Customer']");
		  By  returncustomerText=By.xpath("//h2[text()='Returning Customer']");
		  ElementUtil eleutil=new ElementUtil(driver);
		  List<WebElement> eleList = driver.findElements(returncustomerText);
		  System.out.println("Return customer actualText on Page======"+driver.findElement(returncustomerText).getText());
		  System.out.println("Return customer size======"+eleList.size());
		   boolean bol=eleutil.IsElementDisplayed(returncustomerText);
		   System.out.println("Return result from the function is "+ bol);
		
	}

}
