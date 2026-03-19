package com.qa.opencart.pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//page class implements encapsulation making By page locator private and page actions method public
public class LoginPage {
	private WebDriver driver;
	//	1. By locator - PO - OR 
	private By email = By.id("input-email");
	private By pasword = By.id("input-password");
	private By forgotPassword = By.linkText("Forgot your password?");
	private By loginButton = By.xpath("//button[text()=\"Login\"][1]");
	private By register=By.linkText("Register");

	// 2. page constructor:It should be public otherwise we can not create object of this class 
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isForgotPwdLinkExist(){
		return driver.findElement(forgotPassword).isDisplayed();
		
	}
	
	public void doLogin(String un, String pwd) {
		driver.findElement(email).sendKeys(un);
		driver.findElement(pasword).sendKeys(pwd);
	}
	
	public boolean name() {
		return driver.findElement(register).isDisplayed();
	}

}
