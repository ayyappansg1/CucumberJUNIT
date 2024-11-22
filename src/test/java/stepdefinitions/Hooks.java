package stepdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.observer.entity.MediaEntity;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import driverManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utils.AllureLogger;
import utils.CommonUtils;

/**
 * This @Before @After methods gets invoked automatically and will be execute as
 * per the name
 */
public class Hooks {
	private final static Logger logger = LogManager.getLogger(Hooks.class);
	public ExtentReports reports;
	public ExtentTest test;

	@BeforeAll
	public static void beforeAll() {
		CommonUtils.cleanAllureResults();
	}
	@Before
	public void beforeScenario(Scenario scenario) throws IOException {
		logger.info("Before hook running");
		CommonUtils.loadProperties();
		if (DriverManager.getDriver() == null) {
	        DriverManager.getDriver();  // No need for a separate launchBrowser call
	    }		//	DriverManager.launchBrowser();
		ExtentSparkReporter reporter = new ExtentSparkReporter("HeroKuAppAutomation.html");
		reports = new ExtentReports();
		reporter.config().setReportName("Test Report");
		reporter.config().setDocumentTitle("Automation Results");
		reports.attachReporter(reporter);
		test = reports.createTest(scenario.getName());
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		logger.info("Scenario name is:"+scenario.getName());
		if (scenario.isFailed()) {
			logger.info("Scenario is Failed.So taking Screenshot");
			String screenshot = CommonUtils.screenshot(scenario.getName());
			FileInputStream stream = new FileInputStream(new File(screenshot));
			Allure.addAttachment("Screenshot", stream);
//			byte[] screenshotAsByte = CommonUtils.screenshotAsByte();
//			scenario.attach(screenshotAsByte, "image/png", screenshot);
		} else {
			test.pass("Test passed");
		}
	    AllureLogger.attachLogFile();
	    //Allure.addAttachment("Log", );
		//admin	admin
		//DriverManager.getDriver().close();
		reports.flush();
	}
	@AfterAll
	public static void globalTearDown() {
		logger.info("Inside After Class for Driver Quit");
		DriverManager.getDriver().quit();	}

}
