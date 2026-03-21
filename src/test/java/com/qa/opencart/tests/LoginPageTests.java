package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTests extends BaseTest {
	@Test
	public void loginPageTitleTest() {
		String titleString=loginPage.getLoginPageTitle();
		Assert.assertEquals(titleString, "Account Login","Incorrect Page Title");
	}
//	@Test
//	public void loginPageTitleTest1() {
//		String titleString=loginPage.getLoginPageTitle();
//		Assert.assertEquals(titleString, "Account Login","Incorrect Page Title");
//	}
//	@Test
//	public void loginPageTitleTest2() {
//		String titleString=loginPage.getLoginPageTitle();
//		Assert.assertEquals(titleString, "Account Login","Incorrect Page Title");
//	}
//	@Test
//	public void loginPageTitleTest3() {
//		String titleString=loginPage.getLoginPageTitle();
//		Assert.assertEquals(titleString, "Account Login","Incorrect Page Title");
//	}
//	@Test
//	public void loginPageTitleTest4() {
//		String titleString=loginPage.getLoginPageTitle();
//		Assert.assertEquals(titleString, "Account Login","Incorrect Page Title");
//	}
}
