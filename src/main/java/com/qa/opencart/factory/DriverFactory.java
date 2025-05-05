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

import com.qa.opencart.exceptions.BrowserException;


public class DriverFactory {
	
	 WebDriver driver;
	 
	 Properties prop;
	 
	 OptionsManager OptionsManager;
	 //class proerties coming from java
	 
	 /**
	  * This method is used to init the driver based on browser name
	  * @param browserName
	  */
	
	public WebDriver  initDriver(Properties prop)
	{
	String browsername=	prop.getProperty("browser");
		
		System.out.println("brower name"+ browsername);
		OptionsManager= new OptionsManager(prop);
	switch(browsername.toLowerCase().trim()){
	
	
	case "chrome":
		driver= new ChromeDriver();
		break;
		
	case "edge":
		driver= new EdgeDriver();
		break;
	
		
	case "fireFox":
		driver= new FirefoxDriver();
		break;
		
	case "safari":
		driver= new SafariDriver();
		break;
		
		default:
			System.out.println("plz pass valid browser  name:");
		throw new BrowserException ("====invalid browser");
			
	
	}
	
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	return driver;
	
	}
	
	/**
	 * this is used to init the config properties
	 * @return
	 */
	
	public Properties initProp() {
		prop=new Properties();
		try {
		FileInputStream ip= new FileInputStream("./src/test/resources/config/config.properties");
	prop.load(ip);
		}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
		return prop;
	}
	
	
}
	
	
	



