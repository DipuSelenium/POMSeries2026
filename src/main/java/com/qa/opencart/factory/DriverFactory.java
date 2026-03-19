package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.apache.commons.io.FileUtils;

public class DriverFactory {
	// This method initializes the WebDriver instance based on the provided browser
	// name
	public WebDriver driver;
	public Properties properties;
	public OptionManager optionManager;
	private FileInputStream fileInputStream;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(Properties prop) {
		optionManager = new OptionManager(properties);
		String browser = prop.getProperty("browser").trim();
		System.out.println("Running the tests on " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			tlDriver.set(new ChromeDriver(optionManager.getChromeOptions()));
//			driver = new ChromeDriver(optionManager.getChromeOptions());
		} else if (browser.equalsIgnoreCase("ff")) {
//			driver = new FirefoxDriver(optionManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionManager.getFirefoxOptions()));
		} else if (browser.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
			tlDriver.set(new EdgeDriver());
		} else {
			System.out.println("Enter correct browser name");
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url").trim());
		return getDriver();
	}
	
	public synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties initProp() {

		properties = new Properties();
		String env = System.getProperty("env");
		if (env == null) {
			try {
				fileInputStream = new FileInputStream("./resources/configs/config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Running on environment::" + env);
			try {
				switch (env.toLowerCase()) {
				case "qa":
					fileInputStream = new FileInputStream("./resources/configs/qa.config.properties");
					break;
				case "stage":
					fileInputStream = new FileInputStream("./resources/configs/stage.config.properties");
					break;
				case "uat":
					fileInputStream = new FileInputStream("./resources/configs/uat.config.properties");
					break;
				case "prod":
					fileInputStream = new FileInputStream("./resources/configs/prod.config.properties");
					break;
				case "dev":
					fileInputStream = new FileInputStream("./resources/configs/dev.config.properties");
					break;
				default:
					System.out.println("Pass correct environment");
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	
	public String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
