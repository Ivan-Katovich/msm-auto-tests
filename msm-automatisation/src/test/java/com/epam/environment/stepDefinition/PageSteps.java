package com.epam.environment.stepDefinition;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.environment.cucumberTests.FirstTestRunner;
import com.epam.environment.pageObjects.Page;
import com.epam.environment.pageObjects.channels.CarHireResultsPage;
import com.epam.fw.object.MyElement;
import com.epam.fw.shop.PageShop;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PageSteps {
	
	
	@When("^I wait for page absolutely load$")
	public void waitForPageAbsolutelyLoad() {
		Page.waitForPageAbsolutelyLoad();
	}
	
	@When("^I am automaticaly redirected$")
	public void waitForRedirect() {
		Page.waitForUrlChange();
	}
	
	@When("^I switch to another handle$")
	public void switchHandle() {
		Page.switchHandle();
	}
	
	@Then("^I am taken to the page contains URL '(.+)'$")
	public void assertOnPageWithURL(String url) {
		Page.assertOnCarHirePage(url);
	}

}
