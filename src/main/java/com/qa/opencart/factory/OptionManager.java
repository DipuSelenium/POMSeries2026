package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {
	private Properties properties;
	private ChromeOptions chromeOptions;
	private FirefoxOptions firefoxOptions;

	public OptionManager(Properties properties) {
		this.properties = properties;
	}

	public ChromeOptions getChromeOptions() {
		chromeOptions = new ChromeOptions();
		if (Boolean.parseBoolean(properties.getProperty("headless"))) {
			chromeOptions.addArguments("--headless");
		}
		if (Boolean.parseBoolean(properties.getProperty("incognito"))) {
			chromeOptions.addArguments("--incognito");
		}
		return chromeOptions;
	}

	public FirefoxOptions getFirefoxOptions() {
		firefoxOptions = new FirefoxOptions();
		if (Boolean.parseBoolean(properties.getProperty("headless"))) {
			firefoxOptions.addArguments("--headless");
		}
		if (Boolean.parseBoolean(properties.getProperty("incognito"))) {
			firefoxOptions.addArguments("--incognito");
		}
		return firefoxOptions;
	}

}
