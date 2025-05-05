package com.qa.opencart.pages;

import static com.qa.opencart.constants.AppConstants.DEFAUALT_TIMEOUT;
import static com.qa.opencart.constants.AppConstants.HOME_PAGE_TITLE;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	
	private WebDriver driver;
	
private	ElementUtil eleUtil;




private final By headers=By.cssSelector("div#content>h2");
private final By searchIcon=By.cssSelector("div");


public AccountsPage(WebDriver driver) {
	this.driver=driver;
	eleUtil= new ElementUtil(driver);
	
}



public String getAccPageTitle() {
	String title=	eleUtil.waitFotTitleIs(HOME_PAGE_TITLE, DEFAUALT_TIMEOUT);
	
	
	//String title=	driver.getTitle();
	System.out.println("login page title:" +title);
		return title;
	
}


//public void getAccPageHeaders(){
//List<WebElement> headerList=	eleUtil.getElements(headers);
//
//List<String>headerValList=new ArrayList();
//
//for(WebElement e:headerList) {
//	
//	String 
//	
//}
//
//
//public SearchResultPage doSearch(String searchKey) {
//	eleUtil.doSendKey(search, searchKey);
//	eleUtil.doClick(searchIcon);
//	return new SearchResultPage(driver);
	














}
