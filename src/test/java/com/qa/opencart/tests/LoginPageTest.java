package com.qa.opencart.tests;

import static org.testng.Assert.assertEquals;
import static  com.qa.opencart.constants.AppConstants.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
		String actTitle= loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle,LOGIN_PAGE_TITLE);
	}
	
	
	@Test(priority=1)
	
	public void loginPageUrlTest() {
		String actTitle= loginPage.getLoginPageUrl();
		Assert.assertTrue(actTitle.contains(LOGIN_PAGE_FRACTION_URL));
		
	}
	
		@Test
	public void isForgotLinkExistTest() {

Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	
	
		}
		
		@Test(priority=Short.MAX_VALUE)
		public void LoginTest() {
		accPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage,HOME_PAGE_TITLE);
		
		
		}
	
	
	
}
