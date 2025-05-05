package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import static com.qa.opencart.constants.AppConstants.*;

public class AccountPageTest extends BaseTest {

	//BT--BC
	@BeforeClass
public void accPageSetup() {
		
		accPage=	loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	
}

	
	@Test
	
	public void accPageTitleTest() {
		
		Assert.assertEquals(accPage.getAccPageTitle(),HOME_PAGE_TITLE );
		
		
		
	}
	
	
	
	
	
}
