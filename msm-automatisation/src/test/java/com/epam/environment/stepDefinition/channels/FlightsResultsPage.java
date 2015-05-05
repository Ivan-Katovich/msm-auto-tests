package com.epam.environment.stepDefinition.channels;

import org.openqa.selenium.WebDriver;

import com.epam.environment.cucumberTests.TestRunner;
import com.epam.environment.stepDefinition.Hooks;
import com.epam.fw.shop.PageShop;
import com.epam.fw.shop.WebElementsShop;

import cucumber.api.java.en.Then;

public class FlightsResultsPage {
	
	//url items
	protected static final String uri = "/beta/c/flight/results/";
	protected static final String items = "?searchGadgetForm=true";
	
	
	public FlightsResultsPage() {
	}
	
	@Then("^I am taken to the Flights results page$")
	public void AssertOnFlightsResultsPage() {
		PageShop.assertOnPageWithUrl(uri, Hooks.driver);
	}
		
		
	

}
