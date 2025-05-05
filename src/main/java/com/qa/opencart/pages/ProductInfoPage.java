package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.qa.opencart.constants.AppConstants.*;

import java.util.List;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	
private	ElementUtil eleUtil;
private productMap;

private final By ProductImages= By.cssSelector("ul.thumbnails.img");
private final By productHeade=By.tagName("h1");
private final By productMetaData=By.xpath("(//div[])");

private final By productpriceData=By.xpath(HOME_PAGE_TITLE)
public ProductInfoPage(WebDriver driver) {
	this.driver=driver;
	eleUtil= new ElementUtil(driver);
	
}

public String getProductHeader() {
	
	String header=eleUtil.waitForElementVisible(productHeade, AppConstants.DEFAUALT_TIMEOUT);
System.out.println("product heade"+header);

return header;


}

public void  getProductMetaData() {
	
	productMap=new HashMap<String,String>();
List<WebElement>MetaList=	eleUtil.waitForAllElementsVisible(productMetaData, DEFAUALT_TIMEOUT);

for(WebElement e: MetaList) {
	
	String metadata= e.getText();
	
	String mata[]=metadata.split(":");
	String metaKey=meta[0];
	String metaValue=meta[1];
	
	ProductMap.put(metaKey,metaValue);
	
}




}

//2,0000
Ex tax:$2,0000

public void getProductPriceData() {
	List<WebElement> priceList-eleUtil.waitForAllElementsVisible(productpriceData, DEFAUALT_TIMEOUT);

String productPrice=priceList.get(0).getText();
String exTaxPrice=priceList.get(1).getext();
productMap.put("")


}

}