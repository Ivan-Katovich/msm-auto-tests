package com.epam.environment.stepDefinition;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Pattern;

import com.epam.environment.cucumberTests.TestRunner;
import com.epam.fw.object.MyElement;
import com.epam.fw.object.MyImage;
import com.epam.fw.shop.PageShop;

import cucumber.api.java.en.When;

public class Page {
	
	
	@When("^I wait for page absolutely load$")
	public void waitForPageAbsolutelyLoad() {
		PageShop.waitForPage(Hooks.driver);
	}

}
