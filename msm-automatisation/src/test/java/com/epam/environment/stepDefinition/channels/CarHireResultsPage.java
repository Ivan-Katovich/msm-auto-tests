package com.epam.environment.stepDefinition.channels;

import com.epam.environment.cucumberTests.TestRunner;
import com.epam.fw.shop.PageShop;

import cucumber.api.java.en.Then;

public class CarHireResultsPage extends TestRunner{
	
	//url items
	protected static final String uri = "/beta/c/carhire/results/";
	protected static final String items = "?searchGadgetForm=true";
	
	@Then("^I am taken to the Car hire results page$")
	public void assertOnCarHirePage() {
		PageShop.assertOnPageWithUrl(uri, driver);
	}
		
		
	

}