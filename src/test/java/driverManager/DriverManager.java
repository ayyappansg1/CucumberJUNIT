package driverManager;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass;
import constants.Constants;
import helper.LocalHelper;

public class DriverManager {
	private static final Logger logger = LogManager.getLogger(DriverManager.class);

	private static WebDriver driver;

	public enum BrowserType {
		CHROME, FIREFOX, EDGE
	}
	public static WebDriver getDriver() {
		if (driver == null) {
			logger.info("Driver is null, launching the browser now.");
			driver = DriverFactory.getDriver(BrowserType.valueOf(Constants.browserName.toUpperCase()));
		}
		return driver;
	}

}
