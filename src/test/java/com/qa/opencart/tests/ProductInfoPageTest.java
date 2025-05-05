package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {
	
	
	
	
	
	
	@BeforeClass
	
	public void ProductInfoSetup() {
		accPage= loginPage.doLogin(prop.getProperty("username"), null)
	}

	
	
	
	@Test
	
	public void productHeaderTest() {
		searchResultsPage=accPage.doSearch("macbook");
		searchResultPage.selectProduct("MacBook pro");
		String actHeader=productInfoPage.
				
				Assert.assertEquals(ActImageCount,4);
	}
}
