package com.qa.opencart.pages;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;



import static com.qa.opencart.constants.AppConstants.*;
public class LoginPage {

	private WebDriver driver;
	
	private ElementUtil eleUtil;
	
	
	//1.private By locator
	
	private final By email= By.id("input-email");
	
	private final  By password= By.id("input-password");
	
	private final  By loginBtn=By.xpath("//input[@value='Login']");
	private final  By forgotpwdLink= By.linkText("Forgotten Password");
	
	//2.public page constrFor
	
	public LoginPage(WebDriver driver) {
	
	this.driver=driver;
	
	eleUtil= new ElementUtil(driver);
	}
	
	
	//3.public page action/methods
	
	public String getLoginPageTitle() {
		String title=	eleUtil.waitFotTitleIs(LOGIN_PAGE_TITLE, DEFAUALT_TIMEOUT);
		
		
	//String title=	driver.getTitle();
	System.out.println("login page title:" +title);
		return title;
	}
	
	public String getLoginPageUrl() {
		
		String url=		eleUtil.waitForURLContains(LOGIN_PAGE_FRACTION_URL,DEFAUALT_TIMEOUT );
		
//	String url=	driver.getCurrentUrl();
	
	System.out.println("login url"+url);
	return url;
	}
	
	public boolean isForgotPwdLinkExist() {
		
		
	return 	driver.findElement(forgotpwdLink).isDisplayed();
	}
	
	
	
	public AccountsPage doLogin(String username,String pwd) {
		System.out.println("user credentilas"+username+ ":" +pwd);
		
		
		eleUtil.waitForElementVisible(email,DEFAUALT_TIMEOUT ).sendKeys(username);
		
		eleUtil.doSendKey(password, pwd);
//		driver.findElement(email).sendKeys(username);
//		driver.findElement(password).sendKeys(pwd);
		eleUtil.doClick(loginBtn);
		
		//String title=driver.getTitle();
		
		
		
//		String title=	eleUtil.waitFotTitleIs(HOME_PAGE_TITLE, DEFAUALT_TIMEOUT);
//		System.out.println("account title"+ title);
	return new AccountsPage(driver);
	}
	
	}
	
	

