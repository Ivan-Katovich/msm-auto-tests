package com.epam.environment.stepDefinition.channels;

import org.openqa.selenium.WebDriver;

import com.epam.environment.cucumberTests.TestRunner;
import com.epam.environment.stepDefinition.Hooks;
import com.epam.fw.shop.PageShop;

import cucumber.api.java.en.Then;

public class CarHireResultsPage {
	
	//url items
	protected static final String uri = "/beta/c/carhire/results/";
	protected static final String items = "?searchGadgetForm=true";
	
	
	public CarHireResultsPage() {
	}
	
	@Then("^I am taken to the Car hire results page$")
	public void assertOnCarHirePage() {
		PageShop.assertOnPageWithUrl(uri, Hooks.driver);
	}
		
		
	

}