package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failed.txt",glue = {"stepdefinitions"},monochrome = true)
public class ReRunnerClass {
	

}
