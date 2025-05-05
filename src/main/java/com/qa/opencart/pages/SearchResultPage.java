package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage {
	
	private WebDriver driver;
	
	private ElementUtil eleUtil;
	
	
	private final By resultsProduct= By.cssSelector("div.product-thumb");
	
	public SearchResultPage(WebDriver driver) {
		
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		
	}
	
	public int getResultsProductCount() {
		
		
		
	}
	
	
	
	
	public ProductInfoPage selectProduct(String productName) {
		
		System.out.println("Product name"+productNmae);
		
		eleUtil.doClick(By.linkText(productName));
		return new ProductInfoPage(driver);
		
		
		
	}
	

}
