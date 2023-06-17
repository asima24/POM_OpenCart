package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.frameworkException.FrameworkException;


public class DriverFactory {
	protected WebDriver driver;
	
	//public WebDriver initDriver(String browserName) 
	public WebDriver initDriver(Properties prop) 
	{
		String browserName=prop.getProperty("browser").trim();
		System.out.println(" Browser is ===="+browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			
		}else if(prop.getProperty("browser").equalsIgnoreCase("mozilla")) {
			driver=new FirefoxDriver();
		}else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else if(prop.getProperty("browser").equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
		}else {
			System.out.println(" Please provide proper browser");
			throw new FrameworkException("NOBROWSEREXCEPTION");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.get(prop.getProperty("url"));
		return driver;
		
	}
	
	public Properties initProp() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=null;
//		String envName=System.getProperty("env");
//		System.out.println("Running test cases on environment is "+ envName);
//		fis=new FileInputStream(".\\src\\main\\resources\\config\\default_config.properties");		
//		prop.load(fis);
		
		String envName=System.getProperty("env");
		System.out.println("Running test cases on environment  "+ envName);
		
		
		try {
		if(envName==null) {
			System.out.println("No env given so runnning on QA environment");
			System.out.println(" Properties file path"+".\\src\\main\\resources\\config\\default_config.properties");
			fis=new FileInputStream(".\\src\\main\\resources\\config\\default_config.properties");
		}
		else {
		System.out.println("Running test cases on env: " + envName);
		String  trimEnvName=envName.toLowerCase().trim();
		if (trimEnvName.equals("qa") ){
           fis = new FileInputStream(".\\src\\main\\resources\\config\\default_config.properties");
		}
           else if(trimEnvName.equals("dev")){
		  fis = new FileInputStream(".\\src\\main\\resources\\config\\dev_config.properties");
           }
           else if(trimEnvName.equals("stage")){
			fis = new FileInputStream("./src/main/resources/config/stage.config.properties");
           }
           else if(trimEnvName.equals("uat")){
			fis = new FileInputStream("./src/main/resources/config/uat.config.properties");
           }
           else if(trimEnvName.equals("prod")){
			fis = new FileInputStream("./src/main/resources/config/config.properties");
           }

		else{
			System.out.println("plz pass the right env name...." + envName);
			throw new FrameworkException("NOVALIDENVGIVEN");
		}
	}
}

catch (FileNotFoundException e) {
	e.printStackTrace();
}
try {
	prop.load(fis);
} catch (IOException e) {
	e.printStackTrace();
}
return prop;

}

}