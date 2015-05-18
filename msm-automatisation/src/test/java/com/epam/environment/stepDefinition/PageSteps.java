package com.epam.environment.stepDefinition;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.sikuli.script.Pattern;

import com.epam.environment.cucumberTests.FirstTestRunner;
import com.epam.environment.pageObjects.Page;
import com.epam.fw.object.MyElement;
import com.epam.fw.object.MyImage;
import com.epam.fw.shop.PageShop;

import cucumber.api.java.en.When;

public class PageSteps {
	
	
	@When("^I wait for page absolutely load$")
	public void waitForPageAbsolutelyLoad() {
		Page.waitForPageAbsolutelyLoad();
	}

}
