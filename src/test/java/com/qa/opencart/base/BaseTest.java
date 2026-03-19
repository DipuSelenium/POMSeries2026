package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public DriverFactory dFactory;
	public LoginPage loginPage;
	public Properties prop;

	@BeforeMethod
	public void setUp() {
		dFactory = new DriverFactory();
		prop = dFactory.initProp();
		driver = dFactory.initDriver(prop);
		loginPage = new LoginPage(driver);
	}

//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}

}
