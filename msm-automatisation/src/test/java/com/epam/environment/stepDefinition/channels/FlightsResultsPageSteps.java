package com.epam.environment.stepDefinition.channels;

import org.openqa.selenium.WebDriver;

import com.epam.environment.cucumberTests.FirstTestRunner;
import com.epam.environment.pageObjects.channels.FlightsResultsPage;
import com.epam.environment.stepDefinition.Hooks;
import com.epam.fw.shop.PageShop;
import com.epam.fw.shop.WebElementsShop;

import cucumber.api.java.en.Then;

public class FlightsResultsPageSteps {
	
	
	public FlightsResultsPageSteps() {}
	
	@Then("^I am taken to the Flights results page$")
	public void AssertOnFlightsResultsPage() {
		FlightsResultsPage.AssertOnFlightsResultsPage();
	}
		
		
	

}
