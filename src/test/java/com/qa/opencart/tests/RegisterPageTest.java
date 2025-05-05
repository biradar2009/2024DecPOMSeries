package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class RegisterPageTest extends BaseTest {







@Before

public void registerSetup() {
	loginPage.navigatetoRegisterPage();
	
}

@DataProvider
public void getUserTestData() {
	
	return new Object[][] {
		{vishal","reddy","vishal@gmail.com","vishal234","vishal1234"},"
				 "{visha122","reddy22",\"vishal@gmail.com\",\"vishal234\",\"vishal1234\"}
		
	}
	
	
}

@Test(dataProvider= getUserTestData)

public void userReterTest() {
//atAssert.assertTrue(	registerPage.userRegisteration("vishal","reddy","vishal@gmail.com","vishal234","vishal1234"));
Assert.assertTrue(	regist


}




}
