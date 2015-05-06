package com.epam.environment.stepDefinition.channels;

import org.openqa.selenium.WebDriver;

import com.epam.environment.cucumberTests.FirstTestRunner;
import com.epam.environment.pageObjects.channels.CarHireResultsPage;
import com.epam.environment.stepDefinition.Hooks;
import com.epam.fw.shop.PageShop;

import cucumber.api.java.en.Then;

public class CarHireResultsPageSteps {
	
	
	
	public CarHireResultsPageSteps() {}
	
	@Then("^I am taken to the Car hire results page$")
	public void assertOnCarHirePage() {
		CarHireResultsPage.assertOnCarHirePage();
	}
		
		
	

}