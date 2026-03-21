package com.qa.opencart.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {
	private Properties properties;
	private ChromeOptions chromeOptions;
	private FirefoxOptions firefoxOptions;
	private EdgeOptions edgefoxOptions;

	public OptionManager(Properties properties) {
		this.properties = properties;
	}

	public ChromeOptions getChromeOptions() {
		chromeOptions = new ChromeOptions();

		if (Boolean.parseBoolean(properties.getProperty("headless"))) {
			System.out.println("====Running tests in headless======");
			chromeOptions.addArguments("--headless");

		}
		if (Boolean.parseBoolean(properties.getProperty("incognito"))) {
			chromeOptions.addArguments("--incognito");
		}

		if (Boolean.parseBoolean(properties.getProperty("remote"))) {
			chromeOptions.setCapability("browserName", "chrome");
			String browserVersion = properties.getProperty("browserversion");
			if (browserVersion != null) {
				chromeOptions.setBrowserVersion(browserVersion.trim());
			}

			Map<String, Object> selenoidOptions = new HashMap<>();
			selenoidOptions.put("screenResolution", "1280x1024x24");
			selenoidOptions.put("enableVNC", true);
			String testName = properties.getProperty("testname");
			if (testName != null) {
				selenoidOptions.put("name", testName);
			}
			chromeOptions.setCapability("selenoid:options", selenoidOptions);
		}
		return chromeOptions;
	}

	public FirefoxOptions getFirefoxOptions() {
		firefoxOptions = new FirefoxOptions();

		if (Boolean.parseBoolean(properties.getProperty("headless"))) {
			System.out.println("====Running tests in headless======");
			firefoxOptions.addArguments("--headless");
		}
		if (Boolean.parseBoolean(properties.getProperty("incognito"))) {
			firefoxOptions.addArguments("--incognito");
		}
		if (Boolean.parseBoolean(properties.getProperty("remote"))) {
			firefoxOptions.setCapability("browserName", "firefox");
			String browserVersion = properties.getProperty("browserversion");
			if (browserVersion != null) {
				firefoxOptions.setBrowserVersion(browserVersion.trim());
			}

			Map<String, Object> selenoidOptions = new HashMap<>();
			selenoidOptions.put("screenResolution", "1280x1024x24");
			selenoidOptions.put("enableVNC", true);
			String testName = properties.getProperty("testname");
			if (testName != null) {
				selenoidOptions.put("name", testName);
			}
			firefoxOptions.setCapability("selenoid:options", selenoidOptions);		}

		return firefoxOptions;
	}

	public EdgeOptions getEdgeOptions() {
		edgefoxOptions = new EdgeOptions();

		if (Boolean.parseBoolean(properties.getProperty("headless"))) {
			System.out.println("====Running tests in headless======");
			edgefoxOptions.addArguments("--headless");
		}
		if (Boolean.parseBoolean(properties.getProperty("incognito"))) {
			edgefoxOptions.addArguments("--inPrivate");
		}

		if (Boolean.parseBoolean(properties.getProperty("remote"))) {
			edgefoxOptions.setCapability("browserName", "edge");
			// eo.setCapability("enableVNC", true);
		}

		return edgefoxOptions;
	}

	public Properties getProperties() {
		return properties;
	}


}
