package driverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import constants.Constants;
import driverManager.DriverManager.BrowserType;

public class DriverFactory {
	private static final Logger logger=LogManager.getLogger(DriverFactory.class);

	 public static WebDriver getDriver(BrowserType browserType) {
	        WebDriver driver = null;
	        switch (browserType) {
			case EDGE:
				logger.info("Launching edge Browser");
		        EdgeOptions options = new EdgeOptions();
				driver=new EdgeDriver(options);
				break;
			case CHROME:
				logger.info("Launching Chrome Browser");
				//capabilities.setBrowserName("chrome");
				ChromeOptions chromeOptions=new ChromeOptions();
				driver=new ChromeDriver(chromeOptions);
				//driver=new RemoteWebDriver(gridUrl, capabilities);
				break;
			case FIREFOX:
				logger.info("Launching firefox Browser");
				//capabilities.setBrowserName("chrome");
				driver=new FirefoxDriver();
				//driver=new RemoteWebDriver(gridUrl, capabilities);
				break;
			default:
				ChromeOptions chromeOptionsdef=new ChromeOptions();
				driver=new ChromeDriver(chromeOptionsdef);
			}
	        return driver;
	 }

}
