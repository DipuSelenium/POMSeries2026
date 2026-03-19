package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTests extends BaseTest {
	@Test
	public void loginPageTitleTest() {
		String titleString=loginPage.getLoginPageTitle();
		Assert.assertEquals(titleString, "Demo","Incorrect Page Title");
	}
}
