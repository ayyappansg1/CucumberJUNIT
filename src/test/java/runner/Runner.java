package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumberReporting.Reporting;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * This is a Runner Class
 * Execution starts from here.Additional runner classes also can be Maintained 
 */

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false,features = "src\\test\\resources\\FeatureFiles",
glue = {"stepdefinitions"},monochrome = true,
plugin = {"rerun:target/failed.txt",
		"json:target/forReporting.json",
		"html:target/sangar.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
}
//tags = "not @smoke"
)
public class Runner {
	
	@AfterClass
	public static void generateReporting() {
		Reporting.generateReport(System.getProperty("user.dir")+File.separator+"target"+File.separator+"forReporting.json");
	}
	
}
