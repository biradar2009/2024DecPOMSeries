package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;

public enum OptionsManager {
	
	private Properties prop;
public	OptionsManager(Properties prop) {
	this.prop=prop;
}
	
	
	public  void getChromeOptions() {
		ChromeOptions co = new ChromeOptions();
	if(Boolean.parseBoolean(prop.getProperty("headless""))){"
		co.addArguments("---headless");
		
	}
	if(Boolean.parseBoolean(prop.getProperty("incognito"))){"
			co.addArguments("---incognito");
	}
	return co;
	
	
	
	}
	
	

}
