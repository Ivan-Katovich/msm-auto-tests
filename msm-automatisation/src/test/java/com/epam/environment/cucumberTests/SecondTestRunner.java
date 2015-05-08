package com.epam.environment.cucumberTests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features"
		,glue="com/epam/environment/stepDefinition"
		,monochrome = true
		,tags = {"@second"}
		,format = {"pretty"
				,"html:reports/second"
				,"junit:reports/xml/secondCucumber.xml"
				,"json:reports/json/secondCucumber.json"
				}
//		,dryRun = true
		)

public class SecondTestRunner {

}
