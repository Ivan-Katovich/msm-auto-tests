package com.epam.environment.cucumberTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features"
		,glue="com/epam/environment/stepDefinition"
		,monochrome = true
		,tags = {"@first"}
		,format = {"pretty"
				,"html:reports/first"
				,"junit:reports/xml/firstCucumber.xml"
				,"json:reports/json/firstCucumber.json"
				}
//		,dryRun = true
		)
 
public class FirstTestRunner {
	
	
	
 
}
