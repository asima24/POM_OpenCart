package com.qa.fb.test;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectAProduct {
	
  public  static void  main(String argss[]) throws InterruptedException {
	
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.fivebelow.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("search-input")).sendKeys("Beach Towel");
		Thread.sleep(1000);
		Actions al=new Actions(driver);
		al.sendKeys(Keys.ENTER).build().perform();
		
		String searchResultItemNumber=driver.findElement(By.xpath("//div[@class='c01360']/h1")).getText();
		System.out.println(searchResultItemNumber);
		
	
	}	
	}


